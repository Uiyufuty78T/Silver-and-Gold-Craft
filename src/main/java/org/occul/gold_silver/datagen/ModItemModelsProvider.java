package org.occul.gold_silver.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.PackType;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.content.item.armor.ModTrimMaterials;
import org.occul.gold_silver.core.Info.ModItemInfo;
import org.occul.gold_silver.core.Info.ModElementInfoRegistry;
import org.occul.gold_silver.register.ModBlocks;
import org.occul.gold_silver.register.ModItems;
import org.occul.gold_silver.utils.ItemUtils;

public class ModItemModelsProvider extends ItemModelProvider {

    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GoldSilver.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for (var entry : ModItems.ITEMS.getEntries()) {
            Item item = entry.get();
            if (!(ModElementInfoRegistry.getInfo(item) instanceof ModItemInfo info)) continue;
            switch (info.getModelState()) {
                case BASIC -> basicItem(item);
                case HANDHELD -> handheldItem(entry);
                case ARMOR -> armorItem(entry);
            }
        }
        basicItem(ModBlocks.SILVER_DOOR.get().asItem());
        coinItem(ModItems.SILVER_COIN);
        basicItem(ModBlocks.SILVER_BARS.get().asItem());
        basicItem(ModBlocks.SILVER_CHAIN.get().asItem());
        basicItem(ModBlocks.SILVER_LANTERN.get().asItem());


        //使原版支持Silver
        addModTrimsToArmorItem(Items.LEATHER_HELMET, true);
        addModTrimsToArmorItem(Items.LEATHER_CHESTPLATE, true);
        addModTrimsToArmorItem(Items.LEATHER_LEGGINGS, true);
        addModTrimsToArmorItem(Items.LEATHER_BOOTS, true);
        addModTrimsToArmorItem(Items.GOLDEN_HELMET);
        addModTrimsToArmorItem(Items.GOLDEN_CHESTPLATE);
        addModTrimsToArmorItem(Items.GOLDEN_LEGGINGS);
        addModTrimsToArmorItem(Items.GOLDEN_BOOTS);
        addModTrimsToArmorItem(Items.NETHERITE_HELMET);
        addModTrimsToArmorItem(Items.NETHERITE_CHESTPLATE);
        addModTrimsToArmorItem(Items.NETHERITE_LEGGINGS);
        addModTrimsToArmorItem(Items.NETHERITE_BOOTS);
        addModTrimsToArmorItem(Items.DIAMOND_HELMET);
        addModTrimsToArmorItem(Items.DIAMOND_CHESTPLATE);
        addModTrimsToArmorItem(Items.DIAMOND_LEGGINGS);
        addModTrimsToArmorItem(Items.DIAMOND_BOOTS);
        addModTrimsToArmorItem(Items.IRON_HELMET);
        addModTrimsToArmorItem(Items.IRON_CHESTPLATE);
        addModTrimsToArmorItem(Items.IRON_LEGGINGS);
        addModTrimsToArmorItem(Items.IRON_BOOTS);
        addModTrimsToArmorItem(Items.CHAINMAIL_HELMET);
        addModTrimsToArmorItem(Items.CHAINMAIL_CHESTPLATE);
        addModTrimsToArmorItem(Items.CHAINMAIL_LEGGINGS);
        addModTrimsToArmorItem(Items.CHAINMAIL_BOOTS);
    }

    //withExistingParent(输出路径，父类路径)
    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(GoldSilver.MODID,"item/tool/" + item.getId().getPath()));
    }

    private void armorItem(RegistryObject<Item> item){
        ModTrimMaterials.ALL_TRIM_MATERIALS.forEach((trimMaterial, colorIndex)
                -> generateTrimArmorModel(item.get(), trimMaterial, false));
        generateBaseArmorModel(item.get(),false);
    }

    private void coinItem(RegistryObject<Item> item){

        String outPath = item.getId().getPath();
        ResourceLocation parentPath = mcLoc("item/generated");
        var baseCoin = withExistingParent(outPath,parentPath).texture("layer0",modLoc("item/"+outPath+"_1"));
        for(int i=0;i<4;i++){
            withExistingParent(outPath+ "_" + (i+1), parentPath)
                    .texture("layer0",modLoc("item/" + outPath + "_" + (i+1)));
            baseCoin.override()
                    .model(new ModelFile.UncheckedModelFile(modLoc("item/"+outPath + "_" + (i+1))))
                    .predicate(modLoc("amount"),i * 0.1f).end();
        }
    }

    private void addModTrimsToArmorItem(ItemLike item){
        addModTrimsToArmorItem(item,false);
    }

    private void addModTrimsToArmorItem(ItemLike item,boolean hasOverlay){
        ModTrimMaterials.MOD_TRIM_MATERIALS.forEach((trimMaterial, colorIndex)
                -> generateTrimArmorModel(item, trimMaterial, hasOverlay));
        generateBaseArmorModel(item,hasOverlay);
    }

    //生成用于Override的盔甲模型
    private void generateTrimArmorModel(ItemLike item,ResourceKey<TrimMaterial> trimMaterial,boolean hasOverlay){
        if(item.asItem() instanceof ArmorItem armorItem){
            String outPath = ItemUtils.getNamespace(armorItem)+":"+getArmorTrimName(armorItem,trimMaterial);
            ResourceLocation parentPath = mcLoc("item/generated");
            ResourceLocation armorLocation = ItemUtils.getResourceLocation(item);
            String materialName = trimMaterial.location().getPath();
            String texturePath = armorLocation.getNamespace() + ":item/" + armorLocation.getPath();

            String armorType = switch (armorItem.getType()){
                case BOOTS -> "boots";
                case LEGGINGS -> "leggings";
                case CHESTPLATE -> "chestplate";
                case HELMET -> "helmet";
            };

            String trimTexturePath = "trims/items/" + armorType + "_trim_" + materialName;
            if(armorLocation.getPath().contains(materialName)) trimTexturePath += "_darker";
            ResourceLocation trimTextureLoc = mcLoc(trimTexturePath);

            //让数据生成知道该文件会有的
            existingFileHelper.trackGenerated(trimTextureLoc, PackType.CLIENT_RESOURCES,".png","textures");

            var builder = withExistingParent(outPath,parentPath)
                    .texture("layer0",texturePath);

            if(hasOverlay) {
                builder.texture("layer1",texturePath + "_overlay").texture("layer2",trimTextureLoc);
            }else{
                builder.texture("layer1",trimTextureLoc);
            }
        }
    }

    /// 生成基础盔甲模型,无纹理的盔甲+盔甲纹理模型选择器
    /// 使用ItemLike获取兼容性（其实没用，但这是面向接口的规范，需要某种能力时用接口兼容全部有能力者）
    /// 所以一切Item参数都用ItemLike，除非你知道你在做什么
    /// hasOverlay:是否有覆盖层(如皮革染色)
    private void generateBaseArmorModel(ItemLike item,boolean hasOverlay){
        if(item.asItem() instanceof ArmorItem armorItem){
            String outPath = ItemUtils.getNameWithNamespace(armorItem);
            ResourceLocation parentPath = mcLoc("item/generated");
            ResourceLocation armorLocation = ItemUtils.getResourceLocation(item);
            String texturePath = armorLocation.getNamespace() + ":item/" + armorLocation.getPath();

            ModTrimMaterials.ALL_TRIM_MATERIALS.forEach((trimMaterial,colorIndex) -> {
                String addTrimName = getArmorTrimName(item,trimMaterial);
                String trimModelPath = armorLocation.getNamespace() +":item/" + addTrimName;
                var builder = withExistingParent(outPath,parentPath)
                        .override()
                        .model(new ModelFile.UncheckedModelFile(trimModelPath))
                        .predicate(mcLoc("trim_type"), colorIndex).end()
                        .texture("layer0",texturePath);

                if(hasOverlay) builder.texture("layer1",texturePath + "_overlay");
            });
        }
    }

    private String getArmorTrimName(ItemLike armorItem, ResourceKey<TrimMaterial> trimMaterial) {
        String armorName = ItemUtils.getName(armorItem);
        String trimMaterialName = trimMaterial.location().getPath();
        return armorName + "_" + trimMaterialName + (armorName.contains(trimMaterialName) ? "_darker" : "") + "_trim";
    }

}
