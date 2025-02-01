package fr.zadar.elementary;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ElementaryFabric implements ModInitializer {
	public static final String MOD_ID = "elementary";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Mod Elementary started successfully");

		ModItems.registerModItems();
		ModBlocks.registerModBlock();
	}
}