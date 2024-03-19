package com.cerbon.keep_stepping.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.common.util.Lazy;
import org.lwjgl.glfw.GLFW;

public class StepModeHandler {

    public static final Lazy<KeyMapping> TOGGLE_KEY = Lazy.of(() -> new KeyMapping(
            "key.keep_stepping.mode_toggle",
            KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_G,
            "key.categories.keep_stepping.keep_stepping"
    ));
}
