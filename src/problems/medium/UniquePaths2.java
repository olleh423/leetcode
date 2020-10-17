package problems.medium;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class UniquePaths2 {

    public static void main(String[] args) {

        UniquePaths2 obj = new UniquePaths2();

        int[][] obstacleGrid = {{0, 0, 0},{0, 1, 0},{0, 0, 0}};
        System.out.println(obj.uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid == null)
            return 0;

        int n = obstacleGrid.length;
        int m = n != 0 ? obstacleGrid[0].length : 0;

        if(n == 0 || m == 0)
            return 0;

        int[][] paths = new int[n][m];

        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for(int i=1 ; i<n ; i++)
            paths[i][0] = obstacleGrid[i][0] == 1 ? 0 : paths[i-1][0];

        for(int i=1 ; i<m ; i++)
            paths[0][i] = obstacleGrid[0][i] == 1 ? 0 : paths[0][i-1];

        for(int i=1 ; i<n ; i++) {
            for(int j=1 ; j<m ; j++) {
                paths[i][j] = obstacleGrid[i][j] != 1 ? paths[i-1][j] + paths[i][j-1] : 0;
            }
        }

        return paths[n-1][m-1];
    }
}
