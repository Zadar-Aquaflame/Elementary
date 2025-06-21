package fr.zadar.elementary;

import fr.zadar.elementary.block.ModBlocks;
import fr.zadar.elementary.block.entity.ModBlockEntities;
import fr.zadar.elementary.event.Events;
import fr.zadar.elementary.item.ModItems;
import fr.zadar.elementary.recipe.ModRecipes;
import fr.zadar.elementary.screen.ModScreenHandlers;
import fr.zadar.elementary.sound.ModSounds;
import fr.zadar.elementary.world.gen.WorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.impl.FabricLoaderImpl;
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
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
		ModRecipes.registerRecipes();
		WorldGeneration.generateWorldGen();
		ModSounds.registerSounds();

		Events.register();
	}

	public static String getVersion() {
		return FabricLoaderImpl.INSTANCE.getModContainer(MOD_ID).get().getMetadata().getVersion().toString();
	}
}