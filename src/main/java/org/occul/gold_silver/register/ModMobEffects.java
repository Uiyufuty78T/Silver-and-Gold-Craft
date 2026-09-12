package org.occul.gold_silver.register;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.content.effect.DivineBlessing;

public class ModMobEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GoldSilver.MODID);

    public static final RegistryObject<MobEffect> DIVINE_BLESSING = MOB_EFFECTS.register("divine_blessing",
            () -> new DivineBlessing(MobEffectCategory.BENEFICIAL, 0xD0EEFF));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
