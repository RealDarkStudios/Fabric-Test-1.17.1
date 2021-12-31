package net.thedarkgamer.fabricmod.item;


import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import net.thedarkgamer.fabricmod.FabricTest;
import org.lwjgl.system.CallbackI;

public class ModItems {

    //Exotics
    public static final Item EXOTIC_MATTER = registerItem("overworld_exotic_matter", new Item(new FabricItemSettings().group(ItemGroup.MISC).fireproof().rarity(Rarity.RARE).food(new FoodComponent.Builder().hunger(1).saturationModifier(0.2f).snack().alwaysEdible().build())));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(FabricTest.MOD_ID, name), item);
    }

    public static void registerModItems() {
        FabricTest.LOGGER.info("Registering Mod Items for: " + FabricTest.MOD_DISPLAY_NAME);
    }

}
