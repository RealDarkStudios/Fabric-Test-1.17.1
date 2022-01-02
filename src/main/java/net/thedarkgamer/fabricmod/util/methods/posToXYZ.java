package net.thedarkgamer.fabricmod.util.methods;

import net.minecraft.util.math.Position;

public class posToXYZ {
    public static double[] posToXYZ(Position position) {
        double[] posXYZ = new double[]{position.getX(), position.getY(), position.getZ()};
        return posXYZ;
    }
}
