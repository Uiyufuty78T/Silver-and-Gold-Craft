package org.occul.gold_silver.content.item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.occul.gold_silver.ModConfigs;
import org.occul.gold_silver.register.ModItems;

public class SilverSword {
    public static void applyHurtEvent(LivingHurtEvent event) {
        if(!(event.getSource().getEntity() instanceof Player player)) return;
        if(player.level().isClientSide()) return;
        if(player.getItemInHand(player.getUsedItemHand()).is(ModItems.SILVER_SWORD.get())){
            if(event.getEntity().getMobType() == MobType.UNDEAD){
                Double addDamage = ModConfigs.COMMON.silverSwordAddDamage.get();
                int Duration = ModConfigs.COMMON.silverSwordEffectDuration.get();
                int level = ModConfigs.COMMON.silverSwordEffectLevel.get();
                event.setAmount(event.getAmount() * (1.0f + addDamage.floatValue()));
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Duration, level - 1));
            }
        }
    }
}
