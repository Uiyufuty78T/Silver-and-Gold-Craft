package org.occul.gold_silver.content.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.occul.gold_silver.ModConfigs;
import org.occul.gold_silver.register.ModMobEffects;

public class DivineBlessing extends MobEffect {
    public DivineBlessing(MobEffectCategory pCategory, int pColor) {
        super(pCategory, pColor);
    }

    public static void applyHurtEvent(LivingHurtEvent event){
        LivingEntity receiver = event.getEntity();
        if(!(event.getSource().getEntity() instanceof LivingEntity attacker)) return;

        if(receiver.level().isClientSide()) return;

        if(attacker.getMobType() == MobType.UNDEAD && receiver.getMobType() != MobType.UNDEAD && receiver.hasEffect(ModMobEffects.DIVINE_BLESSING.get())){
            int amplifier = receiver.getEffect(ModMobEffects.DIVINE_BLESSING.get()).getAmplifier();
            Double reduce = ModConfigs.COMMON.divineBlessingReduceDamagePerLevel.get();
            event.setAmount(event.getAmount() * (1.0F - Math.max(1.0F , reduce.floatValue() * (amplifier + 1))));
        }else if(attacker.hasEffect(ModMobEffects.DIVINE_BLESSING.get()) && attacker.getMobType() != MobType.UNDEAD && receiver.getMobType() == MobType.UNDEAD){
            int amplifier = attacker.getEffect(ModMobEffects.DIVINE_BLESSING.get()).getAmplifier();
            Double add = ModConfigs.COMMON.divineBlessingAddDamagePerLevel.get();
            event.setAmount(event.getAmount() * (1.0F + add.floatValue() * (amplifier + 1)));
        }

    }

    @Override
    public void applyEffectTick(LivingEntity pLivingEntity, int pAmplifier) {
        if (pLivingEntity.getMobType() == MobType.UNDEAD) {
            pLivingEntity.hurt(pLivingEntity.damageSources().magic(), 2.0F * (pAmplifier + 1));
            pLivingEntity.hurtTime = 0;
            pLivingEntity.hurtDuration = 0;
        }
        super.applyEffectTick(pLivingEntity, pAmplifier);
    }

    @Override
    public boolean isDurationEffectTick(int pDuration, int pAmplifier) {
        int j = 25 >> pAmplifier;
        if (j > 0) {
            return pDuration % j == 0;
        } else {
            return true;
        }
    }



}
