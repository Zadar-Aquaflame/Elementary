package fr.zadar.elementary.compat.rei;

import fr.zadar.elementary.ElementaryFabric;
import fr.zadar.elementary.block.ModBlocks;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

public class ElementsImprovementCategory implements DisplayCategory<BasicDisplay> {
    public static final Identifier TEXTURE =
            new Identifier(ElementaryFabric.MOD_ID, "textures/gui/rei/elements_improvement_gui_rei.png");
    public static final CategoryIdentifier<ElementsImprovementDisplay> ELEMENTS_IMPROVEMENT =
            CategoryIdentifier.of(ElementaryFabric.MOD_ID, "elements_improvement");


    @Override
    public CategoryIdentifier<? extends BasicDisplay> getCategoryIdentifier() {
        return ELEMENTS_IMPROVEMENT;
    }

    @Override
    public Text getTitle() {
        return Text.translatable("block.elementary.elements_improvement");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocks.ELEMENTS_IMPROVEMENT.asItem().getDefaultStack());
    }

    @Override
    public List<Widget> setupDisplay(BasicDisplay display, Rectangle bounds) {
        Point startPoint = new Point(bounds.getCenterX() - 50, bounds.getCenterY() - 33);
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createTexturedWidget(TEXTURE, new Rectangle(startPoint.x, startPoint.y, 97, 67)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 9, startPoint.y + 8))
                .markInput().entries(display.getInputEntries().get(0)));
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 9, startPoint.y + 44))
                .markInput().entries(display.getInputEntries().get(1)));

        widgets.add(Widgets.createSlot(new Point(startPoint.x + 69, startPoint.y + 26))
                .entries(display.getOutputEntries().get(0)).disableBackground());

        return widgets;
    }
}
