package fr.zadar.elementary.event;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import fr.zadar.elementary.ElementaryForge;
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
import java.util.Arrays;
import java.util.List;

@Mod.EventBusSubscriber(modid = ElementaryForge.MOD_ID, value = Dist.CLIENT)
public class UpdateChecker {
    static boolean messageHasBeenSent = false;

    @SubscribeEvent
    public static void checkForUpdate(TickEvent.PlayerTickEvent event) {
        final String jsonUrl = "https://raw.githubusercontent.com/Zadar-Aquaflame/Elementary/refs/heads/1.20.1/update.json";
        final String currentVersion = ElementaryForge.getVersion();

        try {
            URL url = new URL(jsonUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder jsonResponse = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                jsonResponse.append(line);
            }
            reader.close();

            JsonObject jsonObject = (JsonObject) JsonParser.parseString(jsonResponse.toString());
            String latestVersion = jsonObject.get("latest_version").getAsString();

            if (isNewerVersion(latestVersion, currentVersion) && !messageHasBeenSent) {
                Player player = event.player;
                messageHasBeenSent = true;

                player.sendSystemMessage(Component.translatable("message.elementary.new_version"));
                ElementaryForge.LOGGER.info("A new version of the mod Elementary is available");
            }
        } catch (Exception e) {
            ElementaryForge.LOGGER.warn("Last version's verification failed : " + e.getMessage());
        }
    }

    //Inspired by https://medium.com/@sh131171/comparing-semantic-versions-in-java-a-quick-guide-fd8c913e913c
    private static boolean isNewerVersion(String remote, String current) {
        int result = compareVersion(remote, current);

        return result > 0;
    }

    private static int compareVersion(String remote, String current) {
        List<Integer> remoteComponents = Arrays.stream(remote.split("\\.")).map(Integer::parseInt).toList();
        List<Integer> currentComponents = Arrays.stream(current.split("\\.")).map(Integer::parseInt).toList();

        int maxLength = Math.max(remoteComponents.size(), currentComponents.size());

        for (int i = 0; i < maxLength; i++) {
            int rComponent = i < remoteComponents.size() ? remoteComponents.get(i) : 0;
            int cComponent = i < currentComponents.size() ? currentComponents.get(i) : 0;

            if (rComponent > cComponent) {
                return 1;
            } else if (rComponent < cComponent) {
                return -1;
            }
        }
        return 0;
    }
}
