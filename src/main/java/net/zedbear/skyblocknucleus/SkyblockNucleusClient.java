package net.zedbear.skyblocknucleus;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.text.Text;
import static net.minecraft.server.command.CommandManager.*;
import static net.zedbear.skyblocknucleus.SkyblockNucleus.MOD_VERSION;

public class SkyblockNucleusClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> dispatcher.register(ClientCommandManager.literal("sbn")
                .then(ClientCommandManager.literal("version")
                        .executes(context -> {
                            context.getSource().sendFeedback(Text.of("SBN Version " + MOD_VERSION));
                            return 1;
                        })
                )
                .executes(context -> {
                    context.getSource().sendFeedback(Text.of("Missing arguments!"));
                    return 1;
                })
        ));
    }
}
