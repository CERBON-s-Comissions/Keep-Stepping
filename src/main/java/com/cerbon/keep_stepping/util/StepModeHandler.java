package com.cerbon.keep_stepping.util;

import com.cerbon.keep_stepping.config.KSConfigs;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;

import java.util.UUID;

public final class StepModeHandler {

    private static final AttributeModifier STEPPING_MODIFIER = new AttributeModifier(
            UUID.fromString("51969533-e61b-4262-b0c8-5bfdebd150bc"),
            "Stepping Modifier",
            0.5D,
            AttributeModifier.Operation.ADDITION
    );

    private static final Minecraft client = Minecraft.getInstance();

    private static int stepMode = KSConfigs.INITIAL_MODE.get(); // 0: Disabled, 1: StepUp, 2: AutoJump

    public static void onEndTick() {
        handleKeyPressed();
        handleStepUp();
        handleAutoJump();
    }

    private static void handleKeyPressed() {
        if (KSKeys.TOGGLE_KEY.get().consumeClick()) {
            stepMode = (stepMode + 1) % 3;
            sendModeMessage();

            KSConfigs.INITIAL_MODE.set(stepMode);
        }
    }

    private static void handleStepUp() {
        Player player = client.player;
        if (player == null) return;

        Multimap<Attribute, AttributeModifier> stepModifier = ImmutableMultimap.of(ForgeMod.STEP_HEIGHT_ADDITION.get(), STEPPING_MODIFIER);
        if (stepMode == 1)
            player.getAttributes().addTransientAttributeModifiers(stepModifier);
        else
            player.getAttributes().removeAttributeModifiers(stepModifier);
    }

    private static void handleAutoJump() {
        OptionInstance<Boolean> autoJumpOption = client.options.autoJump();
        boolean isAutoJumpEnabled = autoJumpOption.get();

        if (stepMode < 2 && isAutoJumpEnabled)
            autoJumpOption.set(false);

        else if (stepMode == 2 && !isAutoJumpEnabled)
            autoJumpOption.set(true);
    }

    public static void sendModeMessage() {
        Player player = client.player;
        if (player == null) return;

        String stepModeS = ChatFormatting.GOLD + I18n.get("keep_stepping.mode") + ": ";

        if (stepMode == 0)
            stepModeS = stepModeS + ChatFormatting.RED + I18n.get("keep_stepping.mode.disabled");

        else if (stepMode == 1)
            stepModeS = stepModeS + ChatFormatting.GREEN + I18n.get("keep_stepping.mode.stepup");

        else if (stepMode == 2)
            stepModeS = stepModeS + ChatFormatting.GREEN + I18n.get("keep_stepping.mode.auto_jump");

        player.displayClientMessage(Component.literal(stepModeS), false);
    }

    public static void sendToggleKeyMessage() {
        Player player = client.player;
        if (player == null) return;

        player.displayClientMessage(Component.translatable("keep_stepping.mode.toggle_key", KSKeys.TOGGLE_KEY.get().getKey().getDisplayName()).withStyle(ChatFormatting.DARK_AQUA), false);
    }
}
