package org.occul.gold_and_silver_craft.content.item;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.content.tags.ModTags;
import org.slf4j.Logger;

import javax.swing.text.html.parser.Entity;

public class SilverArmorHandler {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void applyHurtEvent(LivingHurtEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if(player.level().isClientSide()) return;
        if (event.getSource().getEntity() instanceof LivingEntity livingEntity && livingEntity.getMobType() == MobType.UNDEAD) {
            if(isFullSilverArmor(player)){
                LOGGER.debug("Silver armor bonus applied!");
                event.setAmount(event.getAmount() * 0.5f);
            }
        }
    }

    public static boolean isFullSilverArmor(Player player) {
        return player.getInventory().armor.get(3).is(ModTags.SILVER_ARMOR) &&
                player.getInventory().armor.get(2).is(ModTags.SILVER_ARMOR) &&
                player.getInventory().armor.get(1).is(ModTags.SILVER_ARMOR) &&
                player.getInventory().armor.get(0).is(ModTags.SILVER_ARMOR);
    }
}
