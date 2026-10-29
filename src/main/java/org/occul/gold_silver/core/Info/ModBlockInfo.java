package org.occul.gold_silver.core.Info;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class ModBlockInfo extends ModTagElementInfo<Block> {
    private BlockState blockState = BlockState.SIMPLE;
    private BlockLootTable blockLootTable = BlockLootTable.DROP_SELF;
    private Supplier<Block> baseBlock;

    @Override
    @SafeVarargs
    public final ModBlockInfo addTags(TagKey<Block>... tags) {
        super.addTags(tags);
        return this;
    }

    public enum BlockState{
        SIMPLE,SPECIAL, STAIRS,SLAB,DOOR,TRAPDOOR,PRESSURE_PLATE,BUTTON,PANE;
    }

    public enum BlockLootTable {
        DROP_SELF,DROP_ITEM,ORE,DROP_SLAB,DROP_DOOR,NOTHING
    }
    public static ModBlockInfo create(){
        return new ModBlockInfo();
    }

    public BlockState getBlockState(){
        return blockState;
    }

    public ModBlockInfo setBlockState(BlockState blockState){
        this.blockState = blockState;
        return this;
    }
    public BlockLootTable getBlockLootTable(){
        return blockLootTable;
    }
    public ModBlockInfo setBlockLootTable(BlockLootTable blockLootTable){
        this.blockLootTable = blockLootTable;
        return this;
    }
    public ModBlockInfo setBaseBlock(Supplier<Block> baseBlock){
        this.baseBlock = baseBlock;
        return this;
    }
    public Block getBaseBlock(){
        return baseBlock.get();
    }

}
