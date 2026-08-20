package org.occul.gold_and_silver_craft.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;
import org.occul.gold_and_silver_craft.core.ModularBlock;
import org.occul.gold_and_silver_craft.register.ModBlocks;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, GoldAndSilverCraft.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        for(ResourceLocation id: ModInfRegistry.getBlockId()){
            Block block = ForgeRegistries.BLOCKS.getValue(id);
            if (block == null) continue;
            switch (ModInfRegistry.getBlockInf(block).getBlockState()) {
                case SIMPLE -> simpleBlockWithItem(block,cubeAll(block));
            }
        }
    }
}
