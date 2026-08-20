package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModularBlock;
import org.occul.gold_and_silver_craft.register.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GoldAndSilverCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {

        for(var entry:ModBlocks.BLOCKS.getEntries()){
            Block block = entry.get();
            if(block instanceof ModularBlock){
                if(((ModularBlock) block).isBasic())
                    simpleBlockWithItem(block,cubeAll(block));
            }
        }
        //simpleBlockWithItem(ModBlocks.SILVER_BLOCK.get(),cubeAll(ModBlocks.SILVER_BLOCK.get()));
        //simpleBlockWithItem(ModBlocks.RAW_SILVER_BLOCK.get(),cubeAll(ModBlocks.RAW_SILVER_BLOCK.get()));
        //simpleBlockWithItem(ModBlocks.SILVER_ORE.get(),cubeAll(ModBlocks.SILVER_ORE.get()));
        //simpleBlockWithItem(ModBlocks.DEEPSLATE_SILVER_ORE.get(),cubeAll(ModBlocks.DEEPSLATE_SILVER_ORE.get()));
    }
}
