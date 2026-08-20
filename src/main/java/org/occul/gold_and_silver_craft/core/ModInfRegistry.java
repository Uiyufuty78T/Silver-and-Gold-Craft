package org.occul.gold_and_silver_craft.core;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModInfRegistry {
    private static final Map<ResourceLocation, ModInf<Item>> itemMap = new HashMap<>();
    private static final Map<ResourceLocation, ModInf<Block>> blockMap = new HashMap<>();
    private static ResourceLocation itemId(Item item) { return ForgeRegistries.ITEMS.getKey(item); }
    private static ResourceLocation blockId(Block block) { return ForgeRegistries.BLOCKS.getKey(block); }

    public static void registerItem(Item item, ModInf<Item> inf){
        itemMap.put(itemId(item),inf);
    }
    public static void registerItemId(ResourceLocation id, ModInf<Item> inf){
        itemMap.put(id,inf);
    }
    public static void registerBlockId(ResourceLocation id, ModInf<Block> inf){
        blockMap.put(id,inf);
    }

    public static ModInf<Item> getItemInf(Item item){
        return itemMap.get(itemId(item));
    }

    public static ModInf<Item> getItemInf(ResourceLocation id){
        return itemMap.get(id);
    }

    public static Set<ResourceLocation> getItemId(){
        return itemMap.keySet();
    }

    public static boolean hasItemInf(Item item){
        return itemMap.containsKey(itemId(item));
    }

    public static void registerBlock(Block block,ModInf<Block> inf){
        blockMap.put(blockId(block),inf);
    }
    public static ModInf<Block> getBlockInf(Block block){
        return blockMap.get(blockId(block));
    }
    public static ModInf<Block> getBlockInf(ResourceLocation id){
        return blockMap.get(id);
    }
    public static Set<ResourceLocation> getBlockId(){
        return blockMap.keySet();
    }

    public static boolean hasBlockInf(Block block){
        return blockMap.containsKey(blockId(block));
    }
}
