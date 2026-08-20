package org.occul.gold_and_silver_craft.register;

import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.content.item.ModToolTiers;
import org.occul.gold_and_silver_craft.core.ModularItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GoldAndSilverCraft.MODID);

    public static final RegistryObject<Item> SILVER_INGOT =
            ITEMS.register("silver_ingot",() -> new ModularItem(new Item.Properties())
                    .enUsLang("Silver Ingot")
                    .usingBasicModel());
    public static final RegistryObject<Item> RAW_SILVER =
            ITEMS.register("raw_silver",() -> new ModularItem(new Item.Properties())
                    .enUsLang("Raw Silver")
                    .usingBasicModel());
    public static final RegistryObject<Item> SILVER_NUGGET =
            ITEMS.register("silver_nugget",() -> new ModularItem(new Item.Properties())
                    .enUsLang("Silver Nugget")
                    .usingBasicModel());
    public static final RegistryObject<Item> SILVER_SWORD =
            ITEMS.register("silver_sword", () -> new SwordItem(ModToolTiers.SILVER, 3,-2.4F, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_SHOVEL = ITEMS.register("silver_shovel", () -> new ShovelItem(ModToolTiers.SILVER, 1.5F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_PICKAXE = ITEMS.register("silver_pickaxe", () -> new PickaxeItem(ModToolTiers.SILVER, 1, -2.8F, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_AXE = ITEMS.register("silver_axe", () -> new AxeItem(ModToolTiers.SILVER, 6.0F, -3.0F, new Item.Properties()));
    public static final RegistryObject<Item> SILVER_HOE = ITEMS.register("silver_hoe", () -> new HoeItem(ModToolTiers.SILVER, 0, -3.0F, new Item.Properties()));

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
