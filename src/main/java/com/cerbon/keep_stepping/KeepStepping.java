package com.cerbon.keep_stepping;

import com.cerbon.keep_stepping.config.KSConfigs;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(KeepStepping.MOD_ID)
public class KeepStepping {

    public static final String MOD_ID = "keep_stepping";

    public KeepStepping() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, KSConfigs.SPEC, MOD_ID + ".toml");
    }
}
