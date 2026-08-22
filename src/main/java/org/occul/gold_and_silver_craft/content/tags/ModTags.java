package org.occul.gold_and_silver_craft.content.tags;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;

public class ModTags {
    public static final TagKey<EntityType<?>> UNDEAD =
            TagKey.create(Registries.ENTITY_TYPE,ResourceLocation.fromNamespaceAndPath("minecraft", "undead"));

    public static final TagKey<Item> SILVER_ARMOR =
            TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath( GoldAndSilverCraft.MODID, "silver_armor"));
}
