package org.occul.gold_and_silver_craft.event;

import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.content.effect.DivineBlessing;
import org.occul.gold_and_silver_craft.content.item.SilverArmorHandler;
import org.occul.gold_and_silver_craft.content.item.SilverSword;

@Mod.EventBusSubscriber(modid = GoldAndSilverCraft.MODID)
public class LivingEntityHurtEvent {
    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        SilverArmorHandler.applyHurtEvent(event);
        SilverSword.applyHurtEvent(event);
        DivineBlessing.applyHurtEvent(event);
    }
}
