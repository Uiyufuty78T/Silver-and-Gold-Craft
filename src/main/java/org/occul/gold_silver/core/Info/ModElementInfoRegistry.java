package org.occul.gold_silver.core.Info;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ModElementInfoRegistry {
    private static final Map<ResourceLocation, ModElementInfo> infoMap = new HashMap<>();
    private static ResourceLocation itemId(Item item) { return ForgeRegistries.ITEMS.getKey(item); }
    private static ResourceLocation blockId(Block block) { return ForgeRegistries.BLOCKS.getKey(block); }

    public static void register(ResourceLocation id, ModElementInfo info){
        infoMap.put(id,info);
    }
    public static Set<ResourceLocation> getId(){
        return infoMap.keySet();
    }
    public static ModElementInfo getInfo(ResourceLocation id){
        return infoMap.get(id);
    }
    public static boolean hasInfo(ResourceLocation id){
        return infoMap.containsKey(id);
    }


    public static ModElementInfo getInfo(Item item){
        return infoMap.get(itemId(item));
    }
    public static ModElementInfo getInfo(Block block){
        return infoMap.get(blockId(block));
    }


    public static void register(Item item, ModTagElementInfo<Item> inf){
        infoMap.put(itemId(item),inf);
    }
    public static void register(Block block, ModTagElementInfo<Block> inf){
        infoMap.put(blockId(block),inf);
    }


    public static boolean hasInfo(Item item){
        return infoMap.containsKey(itemId(item));
    }
    public static boolean hasInfo(Block block){
        return infoMap.containsKey(blockId(block));
    }

}
