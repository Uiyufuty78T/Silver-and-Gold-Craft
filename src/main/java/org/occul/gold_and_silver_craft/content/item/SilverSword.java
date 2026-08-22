package org.occul.gold_and_silver_craft.content.item;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.register.ModItems;

public class SilverSword {
    public static void applyHurtEvent(LivingHurtEvent event) {
        if(!(event.getSource().getEntity() instanceof Player player)) return;
        if(player.level().isClientSide()) return;

        if(player.getItemInHand(player.getUsedItemHand()).is(ModItems.SILVER_SWORD.get())){
            if(event.getEntity().getMobType() == MobType.UNDEAD){
                event.setAmount(event.getAmount() * 1.5f);
                player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 100, 0));
            }
        }
    }
}
