package problems.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class SpiralMatrix {

    public static void main(String[] args) {

        SpiralMatrix obj = new SpiralMatrix();

        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(obj.spiralOrder(arr));
    }

    public List<Integer> spiralOrder(int[][] arr) {

        List<Integer> result = new ArrayList<>();
        if(arr == null || arr.length == 0 || arr[0].length == 0)
            return result;

        int row = arr.length;
        int col = arr[0].length;
        int T = 0, B = row-1, L = 0, R = col-1;
        int MOVE = 0;

        while(T <= B && L <= R) {

            switch(MOVE) {

                case 0 : {

                    for(int i=L; i<=R ; i++)
                        result.add(arr[T][i]);
                    T++;
                    break;
                }
                case 1 : {

                    for(int i=T; i<=B ; i++)
                        result.add(arr[i][R]);
                    R--;
                    break;
                }
                case 2 : {

                    for(int i=R; i>=L ; i--)
                        result.add(arr[B][i]);
                    B--;
                    break;
                }
                case 3 : {

                    for(int i=B; i>=T ; i--)
                        result.add(arr[i][L]);
                    L++;
                    break;
                }
            }
            MOVE = (MOVE + 1)%4;
        }

        return result;
    }
}
