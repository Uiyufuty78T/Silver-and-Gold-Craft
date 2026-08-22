package org.occul.gold_and_silver_craft.register;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_and_silver_craft.GoldAndSilverCraft;
import org.occul.gold_and_silver_craft.content.item.ModArmorItem;
import org.occul.gold_and_silver_craft.content.item.base.ModArmorMaterials;
import org.occul.gold_and_silver_craft.content.item.base.ModToolTiers;
import org.occul.gold_and_silver_craft.content.tags.ModTags;
import org.occul.gold_and_silver_craft.core.ModInf;
import org.occul.gold_and_silver_craft.core.ModInfRegistry;

import java.util.function.Supplier;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GoldAndSilverCraft.MODID);

    public static final RegistryObject<Item> SILVER_INGOT =
            registerItem("silver_ingot",() -> new Item(new Item.Properties()),
                    new ModInf<Item>().setEnUsName("Silver Ingot").setZhCnName("银锭"));
    public static final RegistryObject<Item> RAW_SILVER =
            registerItem("raw_silver",() -> new Item(new Item.Properties()),
                    new ModInf<Item>().setEnUsName("Raw Silver"));
    public static final RegistryObject<Item> SILVER_NUGGET =
            registerItem("silver_nugget",() -> new Item(new Item.Properties()),
                    new ModInf<Item>().setEnUsName("Silver Nugget"));

    public static final RegistryObject<Item> SILVER_SWORD =
            registerSword("silver_sword",ModToolTiers.SILVER,new ModInf<Item>().setEnUsName("Silver Sword"));
    public static final RegistryObject<Item> SILVER_AXE =
            registerAxe("silver_axe", ModToolTiers.SILVER,new ModInf<Item>().setEnUsName("Silver Axe"));
    public static final RegistryObject<Item> SILVER_PICKAXE =
            registerPickaxe("silver_pickaxe", ModToolTiers.SILVER,new ModInf<Item>().setEnUsName("Silver Pickaxe"));
    public static final RegistryObject<Item> SILVER_SHOVEL =
            registerShovel("silver_shovel", ModToolTiers.SILVER,new ModInf<Item>().setEnUsName("Silver Shovel"));
    public static final RegistryObject<Item> SILVER_HOE =
            registerHoe("silver_hoe", ModToolTiers.SILVER,new ModInf<Item>().setEnUsName("Silver Hoe"));

    public static final RegistryObject<Item> SILVER_HELMET =
            registerArmor("silver_helmet",ArmorItem.Type.HELMET,new ModInf<Item>()
                    .setEnUsName("Silver Helmet")
                    .addTags(ModTags.SILVER_ARMOR));
    public static final RegistryObject<Item> SILVER_CHESTPLATE =
            registerItem("silver_chestplate",() -> new ModArmorItem(ModArmorMaterials.SILVER,
                    ArmorItem.Type.CHESTPLATE,new Item.Properties()),new ModInf<Item>()
                    .setEnUsName("Silver Chestplate")
                    .addTags(ModTags.SILVER_ARMOR));
    public static final RegistryObject<Item> SILVER_LEGGINGS =
            registerArmor("silver_leggings",ArmorItem.Type.LEGGINGS,new ModInf<Item>()
                    .setEnUsName("Silver Leggings")
                    .addTags(ModTags.SILVER_ARMOR));
    public static final RegistryObject<Item> SILVER_BOOTS =
            registerArmor("silver_boots",ArmorItem.Type.BOOTS,new ModInf<Item>()
                    .setEnUsName("Silver Boots")
                    .addTags(ModTags.SILVER_ARMOR));

    public static final RegistryObject<Item> SILVER_CARROT =
            registerItem("silver_carrot",() -> new Item(new Item.Properties().food(ModFoods.SILVER_CARROT)),
                    new ModInf<Item>().setEnUsName("Silver Carrot"));
    public static final RegistryObject<Item> SILVER_APPLE =
            registerItem("silver_apple",() -> new Item(new Item.Properties().food(ModFoods.SILVER_APPLE).rarity(Rarity.RARE)),
                    new ModInf<Item>().setEnUsName("Silver Apple"));
    public static final RegistryObject<Item> ENCHANTED_SILVER_APPLE =
            registerItem("enchanted_silver_apple",() -> new Item(new Item.Properties().food(ModFoods.ENCHANTED_SILVER_APPLE).rarity(Rarity.EPIC)),
                    new ModInf<Item>().setEnUsName("Enchanted Silver Apple"));

    public static RegistryObject<Item> registerArmor(String name,ArmorItem.Type type, ModInf<Item> inf){
        return registerItem(name,() -> new ArmorItem(ModArmorMaterials.SILVER,
                type,new Item.Properties()),inf.addTags(ItemTags.TRIMMABLE_ARMOR));
    }
    public static RegistryObject<Item> registerSword(String name, Tier tier, ModInf<Item> inf){
        return registerItem(name,() -> new SwordItem(tier,3,-2.4F,
                new Item.Properties()),inf.addTags(ItemTags.SWORDS).usingHandheld());
    }
    public static RegistryObject<Item> registerAxe(String name, Tier tier, ModInf<Item> inf){
        return registerItem(name,() -> new AxeItem(tier,6.0F, -3.0F,
                new Item.Properties()),inf.addTags(ItemTags.AXES).usingHandheld());
    }
    public static RegistryObject<Item> registerPickaxe(String name, Tier tier, ModInf<Item> inf){
        return registerItem(name,() -> new PickaxeItem(tier,1, -2.8F,
                new Item.Properties()),inf.addTags(ItemTags.PICKAXES).usingHandheld());
    }
    public static RegistryObject<Item> registerShovel(String name, Tier tier, ModInf<Item> inf){
        return registerItem(name,() -> new ShovelItem(tier,1.5F, -3.0F,
                new Item.Properties()),inf.addTags(ItemTags.SHOVELS).usingHandheld());
    }
    public static RegistryObject<Item> registerHoe(String name, Tier tier, ModInf<Item> inf){
        return registerItem(name,() -> new HoeItem(tier,0, -3.0F,
                new Item.Properties()),inf.addTags(ItemTags.HOES).usingHandheld());
    }

    public static <T extends Item> RegistryObject<Item> registerItem(String name, Supplier<T> item, ModInf<Item> inf){
        ModInfRegistry.registerItemId(new ResourceLocation(GoldAndSilverCraft.MODID, name), inf);
        return ITEMS.register(name,() -> {
            Item toReturn = item.get();
            ModInfRegistry.registerItem(toReturn,inf);
            return toReturn;
        });
    }

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
