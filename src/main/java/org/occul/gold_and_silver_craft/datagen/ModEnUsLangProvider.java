package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.register.ModBlocks;
import org.occul.gold_and_silver_craft.register.ModItems;

public class ModEnUsLangProvider extends LanguageProvider {

    public ModEnUsLangProvider(PackOutput output) {
        super(output, GoldAndSilverCraft.MODID,"en_us");
    }

    @Override
    protected void addTranslations() {
        add(ModItems.SILVER_INGOT.get(),"Silver Ingot");

        add(ModBlocks.SILVER_BLOCK.get(),"Silver Block");

        add("itemGroup.gold_and_silver_craft","Gold & Silver Craft");
    }
}
