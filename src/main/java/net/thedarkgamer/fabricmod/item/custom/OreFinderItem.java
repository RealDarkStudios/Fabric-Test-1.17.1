package net.thedarkgamer.fabricmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.thedarkgamer.fabricmod.item.ModItems;
import net.thedarkgamer.fabricmod.util.ModTags;
import org.jetbrains.annotations.Nullable;

import java.util.List;
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
            player.getItemCooldownManager().set(this, 20);
            boolean foundBlock = false;

            for(int i = 0; i <= posClicked.getY(); i++) {
                Block blockBelow = context.getWorld().getBlockState(posClicked.down(i)).getBlock();

                if(isValuableBlock(blockBelow)) {
                    outputValuableCoordinates(blockBelow, posClicked.add(0, -i, 0), player);
                    foundBlock = true;

                    if(hasPlayerDataTablet(player)) {
                        addNbtToDataTablet(player, posClicked.add(0, -i, 0), blockBelow);
                    }

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

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {

        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip.fabricmod.ore_finder_shift"));
        } else {
            tooltip.add(new TranslatableText("tooltip.fabricmod.ore_finder"));
        }

        super.appendTooltip(stack, world, tooltip, context);
    }

    private boolean isValuableBlock(Block block) {
        return block.getDefaultState().isIn(ModTags.Blocks.VALUABLE_BLOCKS);
    }

    private void addNbtToDataTablet(PlayerEntity player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet =
                player.getInventory().getStack(getFirstInventoryIndex(player, ModItems.DATA_TABLET));
        NbtCompound nbtData = new NbtCompound();
        nbtData.putString("Last Found Ore", "Found " + blockBelow.asItem().getName().getString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");

        dataTablet.setNbt(nbtData);
    }


    private void outputValuableCoordinates(Block blockFound, BlockPos pos, PlayerEntity player) {
        player.sendMessage(new LiteralText("\u00A76Found " + blockFound.asItem().getName().getString() + " at (" + pos.getX() + ", " + pos.getY() + ", " + pos.getZ() + ")"), false);
    }

    private boolean hasPlayerDataTablet(PlayerEntity player) {
        return hasPlayerStackInInventory(player, ModItems.DATA_TABLET);
    }

    private boolean hasPlayerStackInInventory(PlayerEntity player, Item item) {
        for(int i = 0; i < player.getInventory().size(); i++) {
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty() && currentStack.isItemEqual(new ItemStack(item))) {
                return true;
            }
        }

        return false;
    }

    private int getFirstInventoryIndex(PlayerEntity player, Item item) {
        for(int i = 0; i < player.getInventory().size(); i++) {
            ItemStack currentStack = player.getInventory().getStack(i);
            if (!currentStack.isEmpty() && currentStack.isItemEqual(new ItemStack(item))) {
                return i;
            }
        }

        return -1;
    }
}