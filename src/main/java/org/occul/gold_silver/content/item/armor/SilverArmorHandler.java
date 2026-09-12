package org.occul.gold_silver.content.item.armor;

import com.mojang.logging.LogUtils;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import org.occul.gold_silver.ModConfigs;
import org.occul.gold_silver.content.tags.ModTags;
import org.slf4j.Logger;

public class SilverArmorHandler {
    private static final Logger LOGGER = LogUtils.getLogger();

    public static void applyHurtEvent(LivingHurtEvent event) {
        if(!(event.getEntity() instanceof Player)) return;
        Player player = (Player) event.getEntity();
        if(player.level().isClientSide()) return;
        if (event.getSource().getEntity() instanceof LivingEntity livingEntity && livingEntity.getMobType() == MobType.UNDEAD) {
            if(isFullSilverArmor(player)){
                //LOGGER.debug("Silver armor bonus applied!");
                Double Reduce = ModConfigs.COMMON.silverArmorReduceDamage.get();
                event.setAmount(event.getAmount() * (1.0f - Reduce.floatValue()));
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
