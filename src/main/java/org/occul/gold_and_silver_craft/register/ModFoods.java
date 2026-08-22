package org.occul.gold_and_silver_craft.register;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties SILVER_CARROT =
            new FoodProperties.Builder().nutrition(5).saturationMod(1.2F).build();
    public static final FoodProperties SILVER_APPLE =
            new FoodProperties.Builder().nutrition(4).saturationMod(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F)
                    .effect(() -> new MobEffectInstance(ModMobEffects.DIVINE_BLESSING.get(), 100, 1), 1.0F)
                    .alwaysEat().build();
    public static final FoodProperties ENCHANTED_SILVER_APPLE =
            new FoodProperties.Builder().nutrition(4).saturationMod(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 1), 1.0F)
                    .effect(() -> new MobEffectInstance(ModMobEffects.DIVINE_BLESSING.get(), 200, 4), 1.0F)
                    .alwaysEat().build();
}
