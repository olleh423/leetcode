package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class ContainerWithMostWater {

    public static void main(String[] args) {

        ContainerWithMostWater obj = new ContainerWithMostWater();

        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(obj.maxArea(heights));
    }

    public int maxArea(int[] height) {

        if(height == null || height.length == 0)
            return 0;

        int i = 0;
        int j = height.length - 1;

        int max = Integer.MIN_VALUE;

        while(i < j) {

            int min = Math.min(height[i], height[j]);
            max = Math.max(max, min * (j - i));

            if(height[i] < height[j])
                i++;
            else
                j--;
        }

        return max;
    }
}
