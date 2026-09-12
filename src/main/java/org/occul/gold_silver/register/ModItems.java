package org.occul.gold_silver.register;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.occul.gold_silver.GoldSilver;
import org.occul.gold_silver.content.item.armor.ModArmorItem;
import org.occul.gold_silver.content.item.base.ModArmorMaterials;
import org.occul.gold_silver.content.item.base.ModToolTiers;
import org.occul.gold_silver.content.tags.ModTags;
import org.occul.gold_silver.core.Info.*;

import java.util.function.Supplier;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, GoldSilver.MODID);

    public static final RegistryObject<Item> SILVER_INGOT =
            registerItem("silver_ingot",() -> new Item(new Item.Properties()),
                    ModItemInfo.create().addTags(ItemTags.TRIM_MATERIALS).setName(new LangString("Silver Ingot")));
    public static final RegistryObject<Item> RAW_SILVER =
            registerItem("raw_silver",() -> new Item(new Item.Properties()),
                    ModItemInfo.create().setName(new LangString("Raw Silver")));
    public static final RegistryObject<Item> SILVER_NUGGET =
            registerItem("silver_nugget",() -> new Item(new Item.Properties()),
                    ModItemInfo.create().setName(new LangString("Silver Nugget")));
    public static final RegistryObject<Item> SILVER_COIN =
            registerItem("silver_coin",() -> new Item(new Item.Properties()),
                    ModItemInfo.create().setModelState(ModItemInfo.ItemModelState.SPECIAL)
                            .setName(new LangString("Silver Coin")));

    public static final RegistryObject<Item> SILVER_SWORD =
            registerSword("silver_sword",ModToolTiers.SILVER,ModItemInfo.create()
                    .setName(new LangString("Silver Sword")));
    public static final RegistryObject<Item> SILVER_AXE =
            registerAxe("silver_axe", ModToolTiers.SILVER,ModItemInfo.create().setName(new LangString("Silver Axe")));
    public static final RegistryObject<Item> SILVER_PICKAXE =
            registerPickaxe("silver_pickaxe", ModToolTiers.SILVER,ModItemInfo.create().setName(new LangString("Silver Pickaxe")));
    public static final RegistryObject<Item> SILVER_SHOVEL =
            registerShovel("silver_shovel", ModToolTiers.SILVER,ModItemInfo.create().setName(new LangString("Silver Shovel")));
    public static final RegistryObject<Item> SILVER_HOE =
            registerHoe("silver_hoe", ModToolTiers.SILVER,ModItemInfo.create().setName(new LangString("Silver Hoe")));

    public static final RegistryObject<Item> SILVER_HELMET =
            registerArmor("silver_helmet",ArmorItem.Type.HELMET,ModItemInfo.create()
                    .addTags(ModTags.SILVER_ARMOR)
                    .setName(new LangString("Silver Helmet")));
    public static final RegistryObject<Item> SILVER_CHESTPLATE =
            registerItem("silver_chestplate",() -> new ModArmorItem(ModArmorMaterials.SILVER,
                    ArmorItem.Type.CHESTPLATE,new Item.Properties()),ModItemInfo.create()
                    .usingArmor()
                    .addTags(ModTags.SILVER_ARMOR)
                    .addTags(ItemTags.TRIMMABLE_ARMOR)
                    .setName(new LangString("Silver Chestplate")));
    public static final RegistryObject<Item> SILVER_LEGGINGS =
            registerArmor("silver_leggings",ArmorItem.Type.LEGGINGS,ModItemInfo.create()
                    .addTags(ModTags.SILVER_ARMOR)
                    .setName(new LangString("Silver Leggings")));

    public static final RegistryObject<Item> SILVER_BOOTS =
            registerArmor("silver_boots",ArmorItem.Type.BOOTS,ModItemInfo.create()
                    .addTags(ModTags.SILVER_ARMOR)
                    .setName(new LangString("Silver Boots")));


    public static final RegistryObject<Item> SILVER_CARROT =
            registerItem("silver_carrot",() -> new Item(new Item.Properties().food(ModFoods.SILVER_CARROT)),
                    ModItemInfo.create().setName(new LangString("Silver Carrot")));
    public static final RegistryObject<Item> SILVER_APPLE =
            registerItem("silver_apple",() -> new Item(new Item.Properties().food(ModFoods.SILVER_APPLE).rarity(Rarity.RARE)),
                    ModItemInfo.create().setName(new LangString("Silver Apple")));
    public static final RegistryObject<Item> ENCHANTED_SILVER_APPLE =
            registerItem("enchanted_silver_apple",() -> new SimpleFoiledItem(new Item.Properties().food(ModFoods.ENCHANTED_SILVER_APPLE).rarity(Rarity.EPIC)),
                    ModItemInfo.create().setName(new LangString("Enchanted Silver Apple")));

    public static RegistryObject<Item> registerArmor(String name,ArmorItem.Type type, ModItemInfo info){
        return registerItem(name,() -> new ArmorItem(ModArmorMaterials.SILVER,
                type,new Item.Properties()),info.usingArmor().addTags(ItemTags.TRIMMABLE_ARMOR));
    }
    public static RegistryObject<Item> registerSword(String name, Tier tier, ModItemInfo info){
        return registerItem(name,() -> new SwordItem(tier,3,-2.4F,
                new Item.Properties()),info.addTags(ItemTags.SWORDS).usingHandheld());
    }
    public static RegistryObject<Item> registerAxe(String name, Tier tier, ModItemInfo info){
        return registerItem(name,() -> new AxeItem(tier,6.0F, -3.0F,
                new Item.Properties()),info.addTags(ItemTags.AXES).usingHandheld());
    }
    public static RegistryObject<Item> registerPickaxe(String name, Tier tier, ModItemInfo info){
        return registerItem(name,() -> new PickaxeItem(tier,1, -2.8F,
                new Item.Properties()),info.addTags(ItemTags.PICKAXES).usingHandheld());
    }
    public static RegistryObject<Item> registerShovel(String name, Tier tier, ModItemInfo info){
        return registerItem(name,() -> new ShovelItem(tier,1.5F, -3.0F,
                new Item.Properties()),info.addTags(ItemTags.SHOVELS).usingHandheld());
    }
    public static RegistryObject<Item> registerHoe(String name, Tier tier, ModItemInfo info){
        return registerItem(name,() -> new HoeItem(tier,0, -3.0F,
                new Item.Properties()),info.addTags(ItemTags.HOES).usingHandheld());
    }

    public static <T extends Item> RegistryObject<Item> registerItem(String name, Supplier<T> item, ModItemInfo info){
        info.setLocation(GoldSilver.resourceLocation(name)).build();
        return ITEMS.register(name,item);
    }

    public static void register(IEventBus bus){
        ITEMS.register(bus);
    }
}
