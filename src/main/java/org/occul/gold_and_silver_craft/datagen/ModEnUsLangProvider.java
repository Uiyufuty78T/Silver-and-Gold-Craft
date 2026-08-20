package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.LanguageProvider;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModularBlock;
import org.occul.gold_and_silver_craft.core.ModularItem;
import org.occul.gold_and_silver_craft.register.ModBlocks;
import org.occul.gold_and_silver_craft.register.ModItems;

public class ModEnUsLangProvider extends LanguageProvider {

    public ModEnUsLangProvider(PackOutput output) {
        super(output, GoldAndSilverCraft.MODID,"en_us");
    }

    @Override
    protected void addTranslations() {
        for(var entry:ModItems.ITEMS.getEntries()){
            Item item = entry.get();
            if(item instanceof ModularItem){
                String name = ((ModularItem) item).getEnUsName();
                if(name != null) add(item,name);
            }
        }
        //add(ModItems.SILVER_INGOT.get(),"Silver Ingot");
        //add(ModItems.RAW_SILVER.get(),"Raw Silver");
        add(ModItems.SILVER_SWORD.get(),"Silver Sword");
        add(ModItems.SILVER_AXE.get(),"Silver Axe");
        add(ModItems.SILVER_PICKAXE.get(),"Silver Pickaxe");
        add(ModItems.SILVER_SHOVEL.get(),"Silver Shovel");
        add(ModItems.SILVER_HOE.get(),"Silver Hoe");

        for(var entry:ModBlocks.BLOCKS.getEntries()){
            Block block = entry.get();
            if(block instanceof ModularBlock){
                String name = ((ModularBlock) block).getEnUsName();
                if(name != null) add(block,name);
            }
        }
        //add(ModBlocks.SILVER_BLOCK.get(),"Silver Block");
        //add(ModBlocks.SILVER_ORE.get(),"Silver Ore");
        //add(ModBlocks.DEEPSLATE_SILVER_ORE.get(),"Deepslate Silver Ore");
        //add(ModBlocks.RAW_SILVER_BLOCK.get(),"Raw Silver Block");

        add("itemGroup.gold_and_silver_craft","Gold & Silver Craft");
    }
}
