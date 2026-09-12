package org.occul.gold_silver;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.IConfigSpec;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

public class ModConfigs {
    private static final double MAX_DOUBLE = 1000;

    public static class Client {

        Client(ForgeConfigSpec.Builder builder){
        }

    }

    public static class Common {
        public final ForgeConfigSpec.DoubleValue silverArmorReduceDamage;
        public final ForgeConfigSpec.DoubleValue silverSwordAddDamage;
        public final ForgeConfigSpec.BooleanValue isSilverSwordGiveEffect;
        public final ForgeConfigSpec.IntValue silverSwordEffectLevel;
        public final ForgeConfigSpec.IntValue silverSwordEffectDuration;
        public final ForgeConfigSpec.IntValue silverAppleDivineBlessingLevel;
        public final ForgeConfigSpec.IntValue silverAppleDivineBlessingDuration;
        public final ForgeConfigSpec.IntValue silverAppleRegenerationLevel;
        public final ForgeConfigSpec.IntValue silverAppleRegenerationDuration;
        public final ForgeConfigSpec.IntValue enchantedSilverAppleDivineBlessingLevel;
        public final ForgeConfigSpec.IntValue enchantedSilverAppleDivineBlessingDuration;
        public final ForgeConfigSpec.IntValue enchantedSilverAppleRegenerationLevel;
        public final ForgeConfigSpec.IntValue enchantedSilverAppleRegenerationDuration;
        public final ForgeConfigSpec.DoubleValue divineBlessingAddDamagePerLevel;
        public final ForgeConfigSpec.DoubleValue divineBlessingReduceDamagePerLevel;

        Common(ForgeConfigSpec.Builder builder){
            builder.push("effects");
            //神佑
            divineBlessingAddDamagePerLevel = builder
                    .comment("Divine Blessing: +X% damage to undead per level")
                        .defineInRange("divineBlessingAddDamagePerLevel", 0.5,0,MAX_DOUBLE);
            divineBlessingReduceDamagePerLevel = builder
                    .comment("Divine Blessing: -X% damage taken from undead per level")
                    .defineInRange("divineBlessingReduceDamagePerLevel", 0.5,0,1);
            builder.pop();

            builder.push("armor");
            //银甲
            silverArmorReduceDamage = builder
                    .comment("Silver Armor: -X% damage taken from undead")
                    .defineInRange("silverArmorReduceDamage", 0.5,0,1);
            builder.pop();


            builder.push("tool");
            //银剑
            silverSwordAddDamage = builder
                    .comment("Silver Sword: +X% damage to undead")
                    .defineInRange("silverSwordAddDamage", 0.5,0,MAX_DOUBLE);
            isSilverSwordGiveEffect = builder
                    .define("isSilverSwordGiveEffect", true);
            silverSwordEffectLevel = builder
                    .comment("Effect level applied by Silver Sword")
                    .defineInRange("silverSwordEffectLevel", 1,1,255);
            silverSwordEffectDuration = builder
                    .comment("Effect duration (in ticks) applied by Silver Sword")
                    .defineInRange("silverSwordEffectDuration", 100,0,12000);
            builder.pop();


            builder.push("food");
            //银苹果
            silverAppleRegenerationLevel =
                    builder.defineInRange("silverAppleRegenerationLevel", 1,1,255);
            silverAppleRegenerationDuration =
                    builder.defineInRange("silverAppleRegenerationDuration", 100,0,12000);
            silverAppleDivineBlessingLevel =
                    builder.defineInRange("silverAppleDivineBlessingLevel", 2,1,255);
            silverAppleDivineBlessingDuration =
                    builder.defineInRange("silverAppleDivineBlessingDuration", 100,0,12000);
            //附魔银
            enchantedSilverAppleDivineBlessingLevel =
                    builder.defineInRange("enchantedSilverAppleDivineBlessingLevel", 5,1,255);
            enchantedSilverAppleDivineBlessingDuration =
                    builder.defineInRange("enchantedSilverAppleDivineBlessingDuration", 400,0,12000);
            enchantedSilverAppleRegenerationLevel =
                    builder.defineInRange("enchantedSilverAppleRegenerationLevel", 2,1,255);
            enchantedSilverAppleRegenerationDuration =
                    builder.defineInRange("enchantedSilverAppleRegenerationDuration", 400,0,12000);
            builder.pop();
        }
    }

    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final Client CLIENT;

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;

    static {
        final Pair<Client, ForgeConfigSpec> client = new ForgeConfigSpec.Builder().configure(Client::new);
        CLIENT = client.getLeft();
        CLIENT_SPEC = client.getRight();

        final Pair<Common, ForgeConfigSpec> common = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON = common.getLeft();
        COMMON_SPEC = common.getRight();
    }

    public static void init(){
        register(ModConfig.Type.CLIENT, CLIENT_SPEC);
        register(ModConfig.Type.COMMON, COMMON_SPEC);
    }

    private static void register(ModConfig.Type type, IConfigSpec<?> spec) {
        var mod = ModLoadingContext.get().getContainer().getModId();
        String path = mod + "/" + mod + "-" + type.extension() + ".toml";
        ModLoadingContext.get().registerConfig(type, spec, path);
    }
}
