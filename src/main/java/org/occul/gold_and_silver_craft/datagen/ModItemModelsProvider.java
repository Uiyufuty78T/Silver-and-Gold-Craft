package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModInf;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;
import org.occul.gold_and_silver_craft.core.ModularItem;
import org.occul.gold_and_silver_craft.register.ModItems;

public class ModItemModelsProvider extends ItemModelProvider {

    public ModItemModelsProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, GoldAndSilverCraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        for(var entry:ModItems.ITEMS.getEntries()){
            Item item = entry.get();
            if(item instanceof ModularItem){
                if(((ModularItem) item).isBasic())
                    basicItem(item);
            }else if(ModInfRegistry.hasItemInf(item)){
                ModInf<Item> inf = ModInfRegistry.getItemInf(item);
                switch (inf.getModelState()){
                    case BASIC -> basicItem(item);
                    case HANDHELD -> handheldItem(entry);
                }
            }

        }
        //basicItem(ModItems.SILVER_INGOT.get());
        //basicItem(ModItems.RAW_SILVER.get());
        //basicItem(ModItems.SILVER_NUGGET.get());
        //handheldItem(ModItems.SILVER_SWORD);
        //handheldItem(ModItems.SILVER_AXE);
        //handheldItem(ModItems.SILVER_PICKAXE);
        //handheldItem(ModItems.SILVER_SHOVEL);
        //handheldItem(ModItems.SILVER_HOE);

    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.withDefaultNamespace("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(GoldAndSilverCraft.MODID,"item/tool/" + item.getId().getPath()));
    }
}
