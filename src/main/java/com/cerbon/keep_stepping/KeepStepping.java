package com.cerbon.keep_stepping;

import com.cerbon.keep_stepping.config.KSConfigs;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.lwjgl.glfw.GLFW;

@Mod(KeepStepping.MOD_ID)
public class KeepStepping {

    public static final String MOD_ID = "keep_stepping";

    public static final Lazy<KeyMapping> TOGGLE_KEY = Lazy.of(() -> new KeyMapping(
            "key.keep_stepping.mode_toggle",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.keep_stepping.keep_stepping"
    ));

    public KeepStepping() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, KSConfigs.SPEC, MOD_ID + ".toml");
    }
}
