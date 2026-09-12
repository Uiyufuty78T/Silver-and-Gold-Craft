package org.occul.gold_silver.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.registries.ForgeRegistries;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.core.Info.ModBlockInfo;
import org.occul.gold_silver.core.Info.ModElementInfoRegistry;
import org.occul.gold_silver.core.Info.ModItemInfo;
import org.occul.gold_silver.core.TranslatableManager;
import org.occul.gold_silver.core.TranslateComponent;

public class ModZhCnLangProvider extends LanguageProvider {
    public ModZhCnLangProvider(PackOutput output) {
        super(output, GoldSilver.MODID,"zh_cn");
    }

    @Override
    protected void addTranslations() {
        for(ResourceLocation id: ModElementInfoRegistry.getId()){
            if(ModElementInfoRegistry.getInfo(id) instanceof ModItemInfo info){
                Item item = ForgeRegistries.ITEMS.getValue(id);
                if(item == null) continue;
                String name = ModElementInfoRegistry.getInfo(id).getName().getZh_cn();
                if(name != null) add(item,name);
            }
            else if(ModElementInfoRegistry.getInfo(id) instanceof ModBlockInfo info){
                Block block = ForgeRegistries.BLOCKS.getValue(id);
                if(block == null) continue;
                String name = ModElementInfoRegistry.getInfo(id).getName().getZh_cn();
                if(name != null) add(block,name);
            }
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
