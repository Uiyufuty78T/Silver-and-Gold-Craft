package org.occul.gold_silver.utils;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ItemUtils {
    public static ResourceLocation getResourceLocation(ItemLike item){
        return Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(item.asItem()));
    }

    public static String getName(ItemLike item){
        return getResourceLocation(item).getPath();
    }

    public static String getNamespace(ItemLike item){
        return getResourceLocation(item).getNamespace();
    }

    public static String getNameWithNamespace(ItemLike item){
        return getNamespace(item)+":"+getName(item);
    }
}
