package org.occul.gold_silver.event;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.content.effect.DivineBlessing;
import org.occul.gold_silver.content.item.armor.SilverArmorHandler;
import org.occul.gold_silver.content.item.SilverSword;

@Mod.EventBusSubscriber(modid = GoldSilver.MODID)
public class LivingEntityHurtEvent {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        SilverArmorHandler.applyHurtEvent(event);
        SilverSword.applyHurtEvent(event);
        DivineBlessing.applyHurtEvent(event);
    }
}
