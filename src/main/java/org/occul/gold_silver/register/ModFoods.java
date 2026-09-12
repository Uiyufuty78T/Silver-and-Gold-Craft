package org.occul.gold_silver.register;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import org.occul.gold_silver.ModConfigs;

public class ModFoods {
    public static final FoodProperties SILVER_CARROT =
            new FoodProperties.Builder().nutrition(5).saturationMod(1.2F).build();
    public static final FoodProperties SILVER_APPLE =
            new FoodProperties.Builder().nutrition(4).saturationMod(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, ModConfigs.COMMON.silverAppleRegenerationDuration.get(), ModConfigs.COMMON.silverAppleRegenerationLevel.get() - 1), 1.0F)
                    .effect(() -> new MobEffectInstance(ModMobEffects.DIVINE_BLESSING.get(), ModConfigs.COMMON.silverAppleDivineBlessingDuration.get(), ModConfigs.COMMON.silverAppleDivineBlessingLevel.get() - 1), 1.0F)
                    .alwaysEat().build();
    public static final FoodProperties ENCHANTED_SILVER_APPLE =
            new FoodProperties.Builder().nutrition(4).saturationMod(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, ModConfigs.COMMON.enchantedSilverAppleRegenerationDuration.get(), ModConfigs.COMMON.enchantedSilverAppleRegenerationLevel.get() - 1), 1.0F)
                    .effect(() -> new MobEffectInstance(ModMobEffects.DIVINE_BLESSING.get(), ModConfigs.COMMON.enchantedSilverAppleDivineBlessingDuration.get(), ModConfigs.COMMON.enchantedSilverAppleDivineBlessingLevel.get() - 1), 1.0F)
                    .alwaysEat().build();
}
