package net.thedarkgamer.fabricmod.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Position;
import net.thedarkgamer.fabricmod.FabricTest;
import net.thedarkgamer.fabricmod.util.methods.posToXYZ;

public class BoltEnchantment extends Enchantment {
    public BoltEnchantment(Rarity weight, EnchantmentTarget type, EquipmentSlot... slotTypes) {
        super(weight, type, slotTypes);
    }

    @Override
    public void onTargetDamaged(LivingEntity user, Entity target, int level) {
        if(!user.world.isClient()) {
            ServerWorld world = (ServerWorld) user.world;
            PlayerEntity player = (PlayerEntity) user;
            BlockPos pos = target.getBlockPos();

            double X = posToXYZ.posToXYZ((Position) pos)[0];
            double Y = posToXYZ.posToXYZ((Position) pos)[1];
            double Z = posToXYZ.posToXYZ((Position) pos)[2];

            if (level == 1) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos, SpawnReason.TRIGGERED, true, true);
                FabricTest.LOGGER.info("Bolt spawned at (" + X + ", " + Y + ", " + Z + ")");
            } else if (level == 2) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos, SpawnReason.TRIGGERED, true, true);
                FabricTest.LOGGER.info("Bolt spawned at (" + X + ", " + Y + ", " + Z + ")");
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos, SpawnReason.TRIGGERED, true, true);
                FabricTest.LOGGER.info("Bolt spawned at (" + X + ", " + Y + ", " + Z + ")");
            } else if (level == 3) {
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos, SpawnReason.TRIGGERED, true, true);
                FabricTest.LOGGER.info("Bolt spawned at (" + X + ", " + Y + ", " + Z + ")");
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos, SpawnReason.TRIGGERED, true, true);
                FabricTest.LOGGER.info("Bolt spawned at (" + X + ", " + Y + ", " + Z + ")");
                EntityType.LIGHTNING_BOLT.spawn(world, null, null, player, pos, SpawnReason.TRIGGERED, true, true);
                FabricTest.LOGGER.info("Bolt spawned at (" + X + ", " + Y + ", " + Z + ")");
            }
        }

        super.onTargetDamaged(user, target, level);
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
