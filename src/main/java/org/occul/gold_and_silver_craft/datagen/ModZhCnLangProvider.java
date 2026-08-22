package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;
import org.occul.gold_and_silver_craft.core.TranslatableManager;
import org.occul.gold_and_silver_craft.core.TranslateComponent;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, GoldAndSilverCraft.MODID,"zh_cn");
    }

    @Override
    protected void addTranslations() {
        for(ResourceLocation id: ModInfRegistry.getItemId()){
            Item item = ForgeRegistries.ITEMS.getValue(id);
            if(item == null) continue;
            String name = ModInfRegistry.getItemInf(id).getZhCnName();
            if(name != null) add(item,name);
        }
        for(ResourceLocation id:ModInfRegistry.getBlockId()){
            Block block = ForgeRegistries.BLOCKS.getValue(id);
            if (block == null) continue;
            String name = ModInfRegistry.getBlockInf(id).getZhCnName();
            if(name != null) add(block,name);
        }
        for(TranslateComponent component: TranslatableManager.components){
            String name = component.getZhCnName();
            if(name != null) add(component.getRegisterName(), name);
        }
        add("tooltip.silver_armor_shift1","§7When wearing a full set of silver armor:");
        add("tooltip.silver_armor_shift2","§7 • Reduce §b50% §7damage from undead mobs");
        add("tooltip.silver_armor_shift3","§7 • §7Grants §bHaste I");
        add("tooltip.press_shift","§7Press [§6Shift§7] for more info");

        add("itemGroup.gold_and_silver_craft","Gold & Silver Craft");
    }
}
