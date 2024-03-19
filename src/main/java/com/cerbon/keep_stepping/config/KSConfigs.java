package com.cerbon.keep_stepping.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KSConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue INITIAL_MODE;
    public static final ForgeConfigSpec.BooleanValue SHOW_MESSAGE_ON_JOIN;

    static {
        INITIAL_MODE = BUILDER
                .comment("0: Disabled, 1: StepUp, 2: AutoJump")
                .defineInRange("Initial Mode", 1, 0, 2);

        SHOW_MESSAGE_ON_JOIN = BUILDER
                .define("Show Message on Join", true);

        SPEC = BUILDER.build();
    }
}
