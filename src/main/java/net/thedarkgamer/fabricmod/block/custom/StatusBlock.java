package net.thedarkgamer.fabricmod.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StatusBlock extends Block {
    public StatusBlock(Settings settings) {
        super(settings);
    }

    @SuppressWarnings("all")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if(!world.isClient()) {
          if(hand == Hand.MAIN_HAND) {
              BlockPos playerBlockPos = player.getBlockPos();
              player.sendMessage(new LiteralText("\u00A76SERVER: You are " + player.getDisplayName().getString() + " at World Position (" + playerBlockPos.getX() + ", " + playerBlockPos.getY() + ", " + playerBlockPos.getZ() + ")"), false);
          }
        } else {
            if(hand == Hand.MAIN_HAND) {
                if(player.getEquippedStack(EquipmentSlot.MAINHAND).getName() != Blocks.AIR.getName()) {
                    player.sendMessage(new LiteralText("\u00A76CLIENT (MAINHAND): Holding " + player.getEquippedStack(EquipmentSlot.MAINHAND).getName()), false);
                } else {
                    player.sendMessage(new LiteralText("\u00A76CLIENT (MAINHAND): Holding nothing"), false);
                }
            } else {
                if(player.getEquippedStack(EquipmentSlot.OFFHAND).getName() != Blocks.AIR.getName()) {
                    player.sendMessage(new LiteralText("\u00A76CLIENT (OFFHAND): Holding " + player.getEquippedStack(EquipmentSlot.OFFHAND).getName()), false);
                } else {
                    player.sendMessage(new LiteralText("\u00A76CLIENT (OFFHAND): Holding nothing"), false);
                }
            }
        }

        return super.onUse(state, world, pos, player, hand, hit);
    }
}
