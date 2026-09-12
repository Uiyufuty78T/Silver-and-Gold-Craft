package org.occul.gold_silver.datagen;

import net.minecraft.Util;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.core.*;
import org.occul.gold_silver.core.Info.ModBlockInfo;
import org.occul.gold_silver.core.Info.ModElementInfoRegistry;
import org.occul.gold_silver.core.Info.ModItemInfo;
import org.occul.gold_silver.register.ModMobEffects;

public class ModEnUsLangProvider extends LanguageProvider {

    public ModEnUsLangProvider(PackOutput output) {
        super(output, GoldSilver.MODID,"en_us");
    }

    @Override
    protected void addTranslations() {
        for(ResourceLocation id: ModElementInfoRegistry.getId()){
            if(ModElementInfoRegistry.getInfo(id) instanceof ModItemInfo info){
                Item item = ForgeRegistries.ITEMS.getValue(id);
                if(item == null) continue;
                String name = ModElementInfoRegistry.getInfo(id).getName().getEn_us();
                if(name != null) add(item,name);
            }
            else if(ModElementInfoRegistry.getInfo(id) instanceof ModBlockInfo info){
                Block block = ForgeRegistries.BLOCKS.getValue(id);
                if(block == null) continue;
                String name = ModElementInfoRegistry.getInfo(id).getName().getEn_us();
                if(name != null) add(block,name);
            }
        }

        for(TranslateComponent component: TranslatableManager.components){
            String name = component.getEnUsName();
            if(name != null) add(component.getRegisterName(), name);
        }
        add(ModMobEffects.DIVINE_BLESSING.get(), "Divine Blessing");

        add("tooltip.press_shift","§7Press [§6Shift§7] for more info");
        add("tooltip.silver_armor_shift1","§7When wearing a full set of silver armor:");
        add("tooltip.silver_armor_shift2","§7 • - §b50% §7damage from undead mobs");
        add("tooltip.silver_armor_shift3","§7 • §7Grants §bHaste I");
        add("tooltip.silver_sword_shift1","§7When attacking undead mobs:");
        add("tooltip.silver_sword_shift2","§7 • + §b%s §7damage");
        add("tooltip.silver_sword_shift3","§7 • Grants §bStrength I 00:05");

        add(Util.makeDescriptionId("trim_material", GoldSilver.resourceLocation("silver")),"Silver Material");

        add("itemGroup.gold_and_silver_craft","Gold & Silver Craft");
    }
}
