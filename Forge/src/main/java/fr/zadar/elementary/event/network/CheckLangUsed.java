package fr.zadar.elementary.event.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.zadar.elementary.ElementaryForge;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = ElementaryForge.MOD_ID, value = Dist.CLIENT)
public class CheckLangUsed {
    static boolean messageHasBeenSent = false;

    @SubscribeEvent
    public static void checkTheLangUsed(TickEvent.PlayerTickEvent event) {
        final String jsonUrl = "https://raw.githubusercontent.com/Zadar-Aquaflame/Elementary/refs/heads/1.20.1/update.json";
        final String langUsed = Minecraft.getInstance().options.languageCode;

        try {
            URL url = new URL(jsonUrl);
            HttpURLConnection connection = ((HttpURLConnection) url.openConnection());

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
            reader.close();

            JsonObject jsonObject = JsonParser.parseString(jsonResponse.toString()).getAsJsonObject();
            JsonArray supportedLanguages = jsonObject.getAsJsonArray("supported_languages");

            List<String> supportedLangList = new ArrayList<>();
            for (JsonElement langElement : supportedLanguages) {
                supportedLangList.add(langElement.getAsString());
            }

            if (!supportedLangList.contains(langUsed) && !messageHasBeenSent) {
                Player player = event.player;
                messageHasBeenSent = true;

                player.sendSystemMessage(Component.literal("[")
                        .append(Component.literal("Elementary").withStyle(ChatFormatting.GOLD))
                        .append(Component.literal("] "))
                        .append(Component.literal("Your language is not supported. If you want to help to translate the mod, you can go to Curseforge")));
            }
        } catch (Exception e) {
            ElementaryForge.LOGGER.warn("Couldn't verified lang used : {}", e.getMessage());
        }
    }
}
