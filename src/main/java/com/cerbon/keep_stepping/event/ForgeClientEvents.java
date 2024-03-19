package com.cerbon.keep_stepping.event;

import com.cerbon.keep_stepping.KeepStepping;
import com.cerbon.keep_stepping.util.StepModeHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KeepStepping.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvents {

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END)
            StepModeHandler.onEndTick();
    }
}
