package org.occul.gold_and_silver_craft.core;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.ItemLike;

import java.util.ArrayList;
import java.util.Collections;

public class ModInf<T> {

    private String enUsName;
    private String zhCnName;
    private ArrayList<TagKey<T>> tagKeys = new ArrayList<>();
    private ItemModelState itemModelState = ItemModelState.BASIC;
    BlockState blockState = BlockState.SIMPLE;
    BlockModelState blockModelState = BlockModelState.SIMPLE;
    BlockLootTable blockLootTable = BlockLootTable.DROP_SELF;
    public enum ItemModelState {
        BASIC,HANDHELD
    }
    public enum BlockState{
        SIMPLE,CONNECTED
    }
    public enum BlockModelState{
        SIMPLE,SLAB,STAIRS,DOOR,TRAPDOOR,PRESSURE_PLATE,BUTTON
    }
    public enum BlockLootTable {
        DROP_SELF,DROP_ITEM,ORE,NOTHING
    }

    public BlockModelState getBlockModelState(){
        return blockModelState;
    }
    public ModInf<T> setBlockModelState(BlockModelState blockModelState){
        this.blockModelState = blockModelState;
        return this;
    }
    public BlockState getBlockState(){
        return blockState;
    }

    public ModInf<T> setBlockState(BlockState blockState){
        this.blockState = blockState;
        return this;
    }
    public BlockLootTable getBlockLootTable(){
        return blockLootTable;
    }
    public ModInf<T> setBlockLootTable(BlockLootTable blockLootTable){
        this.blockLootTable = blockLootTable;
        return this;
    }

    public String getZhCnName() {
        return zhCnName==null?enUsName:zhCnName;
    }

    public ModInf<T> setZhCnName(String zhCn) {
        zhCnName = zhCn;
        return this;
    }

    public String getEnUsName() {
        return enUsName;
    }

    public ModInf<T> setEnUsName(String enUs) {
        enUsName = enUs;
        return this;
    }

    @SafeVarargs
    public final ModInf<T> addTags(TagKey<T>... tags){
        Collections.addAll(tagKeys,tags);
        return this;
    }

    public ModInf<T> usingBasic(){
        itemModelState = ItemModelState.BASIC;
        return  this;
    }
    public ModInf<T> usingHandheld(){
        itemModelState = ItemModelState.HANDHELD;
        return this;
    }
    public ItemModelState getModelState(){
        return itemModelState;
    }

    public ArrayList<TagKey<T>> getTagKeys() { return tagKeys; }
}
