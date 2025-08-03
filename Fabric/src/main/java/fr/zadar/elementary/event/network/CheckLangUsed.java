package fr.zadar.elementary.event.network;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.zadar.elementary.ElementaryFabric;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckLangUsed {
    static boolean messageHasBeenSent = false;

    public static void checkTheLangUsed() {
        final String jsonUrl = "https://raw.githubusercontent.com/Zadar-Aquaflame/Elementary/refs/heads/1.20.1/update.json";

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

            ServerTickEvents.START_WORLD_TICK.register(serverWorld -> {
                String langUsed = MinecraftClient.getInstance().getLanguageManager().getLanguage();
                if (!supportedLangList.contains(langUsed) && !messageHasBeenSent) {
                    for (PlayerEntity player : serverWorld.getPlayers()) {
                        messageHasBeenSent = true;

                        player.sendMessage(Text.literal("[")
                                .append(Text.literal("Elementary").setStyle(Style.EMPTY.withColor(TextColor.fromFormatting(Formatting.GOLD))))
                                .append(Text.literal("] "))
                                .append(Text.literal("Your language is not supported. If you want to help to translate the mod, you can go to Curseforge")));
                    }
                }
            });

        } catch (Exception e) {
            ElementaryFabric.LOGGER.warn("Couldn't verified lang used : {}", e.getMessage());
        }
    }
}
