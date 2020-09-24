package leetcode.editor.en.recursion.BFS;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Lai
 * @version 1.0
 * @date 2020-09-24 01:21
 */
public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {

        //分别代表 北东南西 四个方向的基本单位 方便后面运算
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        // Set of obstacles indexes in the format of : obstacle[0] + " " + obstacle[1]
        Set<String> obstaclesSet = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obstaclesSet.add(obstacle[0] + " " + obstacle[1]);
        }

        int x = 0, y = 0, direction = 0, maxDistSquare = 0;
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) { // Turns left
                direction = (direction + 3) % 4;
            } else if (commands[i] == -1) { // Turns right
                direction = (direction + 1) % 4;
            } else { // Moves forward commands[i] steps
                int step = 0;
                while (step < commands[i]
                        && (!obstaclesSet.contains(
                        (x + directions[direction][0]) + " " + (y + directions[direction][1]))
                )
                ) {
                    x += directions[direction][0];
                    y += directions[direction][1];
                    step++;
                }
            }
            maxDistSquare = Math.max(maxDistSquare, x * x + y * y);
        }

        return maxDistSquare;
    }

}
