package org.occul.gold_and_silver_craft.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, GoldAndSilverCraft.MODID);

    public static final RegistryObject<CreativeModeTab> GOLD_AND_SILVER_CRAFT =
            CREATIVE_MODE_TABS.register("gold_and_silver_craft",
                    () -> CreativeModeTab.builder()
                            .title(Component.translatable("itemGroup.gold_and_silver_craft"))
                            .icon(() -> new ItemStack(ModItems.SILVER_INGOT.get()))
                            .displayItems((itemDisplayParameters,output) -> {
                                output.accept(ModItems.SILVER_INGOT.get());
                                output.accept(ModBlocks.SILVER_BLOCK.get());
                            }).build());

    public static void register(IEventBus bus){
        CREATIVE_MODE_TABS.register(bus);
    }
}
