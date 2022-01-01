package net.thedarkgamer.fabricmod.util;

import net.fabricmc.fabric.api.tag.TagFactory;
import net.fabricmc.fabric.api.tag.TagRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.thedarkgamer.fabricmod.FabricTest;

public class ModTags {
    public static class Blocks {
        public static final Tag.Identified<Block> VALUABLE_BLOCKS = createTag("valuable_blocks");

        private static Tag.Identified<Block> createTag(String name) {
            return TagFactory.BLOCK.create(new Identifier(FabricTest.MOD_ID, name));
        }

        private static Tag.Identified<Block> createCommonTag(String name) {
            return TagFactory.BLOCK.create(new Identifier("c", name));
        }
    }

    public static class Items {

        public static final Tag.Identified<Item> EXOTICS = createTag("exotics");

        private static Tag.Identified<Item> createTag(String name) {
            return TagFactory.ITEM.create(new Identifier(FabricTest.MOD_ID, name));
        }

        private static Tag.Identified<Item> createCommonTag(String name) {
            return TagFactory.ITEM.create(new Identifier("c", name));
        }
    }
}
