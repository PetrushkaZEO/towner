package gg.towner.terraingenerator;

import java.util.Random;

public class Noise {


    //Это честно петрушка написал

    public double[][] generateNoise() {
        int width = 513;
        int height = 513;
        double seed = 513;
        double s = 8192;
        double[][] data = new double[width][height];
        data[0][0] = seed;
        data[width - 1][0] = seed;
        data[0][height - 1] = seed;
        data[width - 1][height - 1] = seed;
        Random random = new Random();
        for(int side = width - 1; side >= 2; side /= 2, s /= 2.0){
            int halfX = side / 2;
                for(int x = 0; x < width - 1; x += side) {
                    for (int y = 0; y < height - 1; y += side) {
                        double average = (data[x][y] + data[x + side][y] + data[x][y + side] + data[x + side][y + side]) / 4;
                        data[x + halfX][y + halfX] = average + (random.nextDouble() * 2 * s) - s;
                    }
                }
                for(int i = 0; i < width - 1; i += halfX){
                    for(int j =  (i + halfX) % side; j < height - 1; j += side){
                        double average = data[(i - halfX + width - 1)
                                % (width - 1)][j]
                                +
                                data[(i + halfX) % (width - 1)][j] +

                                data[i][(j + halfX) % (height - 1)] +

                                data[i][(j - halfX + height - 1)
                                        % (height - 1)];
                        average /= 4;
                        average = average + (random.nextDouble() * 2 * s) - s;
                        data[i][j] = average;
                        if (i == 0) {
                            data[width - 1][j] = average;
                        }
                        if (j == 0) {
                            data[i][height - 1] = average;
                        }
                    }
                }
        }
        return data;
    }

}
