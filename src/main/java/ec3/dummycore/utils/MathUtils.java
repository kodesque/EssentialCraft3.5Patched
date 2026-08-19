package ec3.dummycore.utils;

import DummyCore.Utils.Coord2D;

import java.util.Random;

public class MathUtils {
    public MathUtils() {
    }

    public static int pixelatedTextureSize(int current, int max, int textureSize) {
        if (current > max) {
            current = max;
        }

        float m = (float)current / (float)max * 100.0F;
        float n = m / 100.0F * (float)textureSize;
        return (int)n;
    }

    public static int getPercentage(int current, int max) {
        float m = (float)current / (float)max * 100.0F;
        return (int)m;
    }

    public static DummyCore.Utils.Coord2D polarOffset(DummyCore.Utils.Coord2D position, float angle, float distance) {
        float d0 = (float)((double)position.x + Math.cos((double)angle * Math.PI / (double)180.0F) * (double)distance);
        float d1 = (float)((double)position.z + Math.sin((double)angle * Math.PI / (double)180.0F) * (double)distance);
        return new Coord2D(d0, d1);
    }

    public static double randomDouble(Random rand) {
        return rand.nextDouble() - rand.nextDouble();
    }

    public static float randomFloat(Random rand) {
        return rand.nextFloat() - rand.nextFloat();
    }

    public static float getDifference(float pos1, float pos2) {
        float diff = pos1 - pos2;
        return (float)module((double)diff);
    }

    /** @deprecated */
    @Deprecated
    public static int[] swap(int a, int b) {
        return new int[]{b, a};
    }

    public static int convertToHex(int a) {
        return Integer.parseInt(Integer.toString(a), 16);
    }

    public static double module(double a) {
        if (a < (double)0.0F) {
            a = -a;
        }

        return a;
    }

    public static boolean arrayContains(Object[] array, Object searched) {
        for(int i = 0; i < array.length; ++i) {
            if (array[i].equals(searched)) {
                return true;
            }
        }

        return false;
    }

    public static boolean arrayContains(int[] array, int searched) {
        for(int i = 0; i < array.length; ++i) {
            if (array[i] == searched) {
                return true;
            }
        }

        return false;
    }

    public static int getIntInArray(int[] array, int searched) {
        for(int i = 0; i < array.length; ++i) {
            if (array[i] == searched) {
                return i;
            }
        }

        return -1;
    }

    public static boolean isArrayTheSame(boolean[] array) {
        boolean previous = array[0];

        for(int i = 0; i < array.length; ++i) {
            if (array[i] != previous) {
                return false;
            }

            previous = array[i];
        }

        return true;
    }
}
