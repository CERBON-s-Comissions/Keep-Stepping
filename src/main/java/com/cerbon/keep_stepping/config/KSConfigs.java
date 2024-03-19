package com.cerbon.keep_stepping.config;

import net.minecraftforge.common.ForgeConfigSpec;

public class KSConfigs {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.IntValue INITIAL_MODE;

    static {
        INITIAL_MODE = BUILDER
                .comment("0: Disabled, 1: StepUp, 2: AutoJump")
                .defineInRange("Initial Mode", 1, 0, 2);

        SPEC = BUILDER.build();
    }
}
