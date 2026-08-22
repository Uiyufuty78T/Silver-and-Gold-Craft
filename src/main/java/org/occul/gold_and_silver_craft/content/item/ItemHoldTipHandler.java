package org.occul.gold_and_silver_craft.content.item;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.content.item.base.ModArmorMaterials;
import org.occul.gold_and_silver_craft.register.ModItems;

import java.util.List;

@Mod.EventBusSubscriber(modid = GoldAndSilverCraft.MODID,value = Dist.CLIENT)
public class ItemHoldTipHandler {
    @SubscribeEvent
    public static void onHoldItemTip(ItemTooltipEvent event){
        ItemStack itemStack = event.getItemStack();
        Item item = itemStack.getItem();
        if(!itemStack.isEmpty()){
            if(item instanceof ArmorItem){
                if(((ArmorItem) item).getMaterial() == ModArmorMaterials.SILVER){
                    if(Screen.hasShiftDown()){
                        event.getToolTip().add(1,Component.translatable("tooltip.silver_armor_shift3"));
                        event.getToolTip().add(1,Component.translatable("tooltip.silver_armor_shift2"));
                        event.getToolTip().add(1,Component.translatable("tooltip.silver_armor_shift1"));
                    }else {
                        event.getToolTip().add(1,Component.translatable("tooltip.press_shift"));
                    }
                }
            }
            if(itemStack.is(ModItems.SILVER_SWORD.get())) {
                addShiftTooltip(1,event.getToolTip(),
                        Component.translatable("tooltip.silver_sword_shift1"),
                        Component.translatable("tooltip.silver_sword_shift2"),
                        Component.translatable("tooltip.silver_sword_shift3")
                );
            }
        }
    }
    public static void addShiftTooltip(int index, List<Component> tooltip, MutableComponent...components){
        if(Screen.hasShiftDown()){
            tooltip.addAll(index,List.of(components));
        }else{
            tooltip.add(index,Component.translatable("tooltip.press_shift"));
        }
    }
}
