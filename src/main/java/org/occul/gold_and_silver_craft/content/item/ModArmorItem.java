package org.occul.gold_and_silver_craft.content.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import org.occul.gold_and_silver_craft.content.item.base.ModArmorMaterials;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    public ModArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }

    private static final Map<ArmorMaterial, List<MobEffectInstance>> EFFECT_MAP =
            new ImmutableMap.Builder<ArmorMaterial, List<MobEffectInstance>>().put(
                    ModArmorMaterials.SILVER,
                    List.of(new MobEffectInstance(MobEffects.DIG_SPEED, 1, 0, false, false, true))
            ).build();                                                  //持续时间tick 等级（0为等级1）  效果是否来源于环境  粒子效果    GUI是否显示

    @Override
    public void inventoryTick(ItemStack pStack, Level pLevel, Entity pEntity, int pSlotId, boolean pIsSelected) {
        if (!pLevel.isClientSide()) {
            if (pEntity instanceof Player player) {
                if (hasFullSuitableArmor(player)) {
                    giveEffects(player);
                }
            }
        }
        super.inventoryTick(pStack, pLevel, pEntity, pSlotId, pIsSelected);
    }

    private void giveEffects(Player player) {
        for (Map.Entry<ArmorMaterial, List<MobEffectInstance>> entry : EFFECT_MAP.entrySet()) {
            ArmorMaterial armorMaterial = entry.getKey();
            List<MobEffectInstance> effectList = entry.getValue();
            if (hasCorrectMaterialArmorOn(armorMaterial, player)) {
                for (MobEffectInstance effectInstance : effectList) {
                    if (!player.hasEffect(effectInstance.getEffect())) {
                        player.addEffect(effectInstance);
                    }
                }
            }
        }
    }

    private boolean hasCorrectMaterialArmorOn(ArmorMaterial armorMaterial, Player player) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem helmet = (ArmorItem) player.getInventory().armor.get(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().armor.get(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().armor.get(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().armor.get(0).getItem();

        return helmet.getMaterial() == armorMaterial &&
                chestplate.getMaterial() == armorMaterial &&
                leggings.getMaterial() == armorMaterial &&
                boots.getMaterial() == armorMaterial;
    }

    private boolean hasFullSuitableArmor(Player player) {
        ItemStack helmet = player.getInventory().armor.get(3);
        ItemStack chestplate = player.getInventory().armor.get(2);
        ItemStack leggings = player.getInventory().armor.get(1);
        ItemStack boots = player.getInventory().armor.get(0);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

}
