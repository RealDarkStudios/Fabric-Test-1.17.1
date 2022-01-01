package net.thedarkgamer.fabricmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.LiteralText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class OreFinderItem extends Item {
    public OreFinderItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos posClicked = context.getBlockPos();
            PlayerEntity player = Objects.requireNonNull(context.getPlayer());
            boolean foundBlock = false;

            for(int i = 0; i <= posClicked.getY(); i++) {
                Block blockBelow = context.getWorld().getBlockState(posClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(blockBelow, posClicked.add(0, -i, 0), player);
                    foundBlock = true;
                    break;
                }
            }
            if(!foundBlock) {
                player.sendMessage(new LiteralText("\u00A76No valuables below"), false);
            }
        }

        context.getStack().damage(1, context.getPlayer(), (player) -> player.sendToolBreakStatus(player.getActiveHand()));

        return super.useOnBlock(context);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    private boolean isValuableBlock(Block block) {
        return block == Blocks.COAL_ORE || block == Blocks.COPPER_ORE || block == Blocks.DIAMOND_ORE || block == Blocks.IRON_ORE || block == Blocks.REDSTONE_ORE || block == Blocks.LAPIS_ORE || block == Blocks.GOLD_ORE || block == Blocks.EMERALD_ORE;
    }

    private void outputValuableCoordinates(Block blockFound, BlockPos pos, PlayerEntity player) {
        player.sendMessage(new LiteralText("\u00A76Found " + blockFound.asItem().getName().getString() + " at (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"), false);
    }
}