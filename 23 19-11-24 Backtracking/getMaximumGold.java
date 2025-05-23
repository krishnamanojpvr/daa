// Max Gold
// The Kolar Gold Fields (KGF) is in the form of a m*n grid,
// Each field, contains some amount of Gold in it.
 
// You can mine the gold in the KGF in the following way.
// 	- You can start at any position in the grid, never visit a cell with no gold.
// 	- each time you visit a cell, you will grab all the gold in it.
// 	- You can move one step to the left, right, up or down.
// 	- You can't visit the same cell more than once.
// 	- You can stop at any cell.
	
// Your task is to find the maximum amount of gold you can collect.

// Input Format:
// -------------
// Line-1: Two integers M and N size of the KGF grid.
// Next M lines: N space separated integers, gold in each row of the grid.

// Output Format:
// --------------
// Print an integer, maximum amount of gold.


// Sample Input-1:
// ---------------
// 3 3
// 3 6 0
// 5 8 7
// 0 9 0

// Sample Output-1:
// ----------------
// 24

// Explanation:
// -------------
// You can grab the gold in KGF grid as follows:
// You can obtain like as follows: 9 -> 8 -> 7.

// Sample Input-2:
// ---------------
// 5 3
// 1 0 7
// 2 0 6
// 3 4 5
// 0 3 0
// 9 0 20

// Sample Output-2:
// ----------------
// 28

// Explanation:
// -------------
// You can grab the gold in KGF grid as follows:
// You can obtain like as follows: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7

import java.util.*;

public class getMaximumGold{
    public static int getGold(int[][] grid, int n, int m, int currGold){
        if(n<0 || n>=grid.length || m<0 || m>=grid[0].length || grid[n][m] == 0){
            return currGold;
        }
        currGold += grid[n][m];
        int temp = grid[n][m];
        grid[n][m] = 0;
        int max = currGold;
        max = Math.max(max,getGold(grid,n+1,m,currGold));
        max = Math.max(max,getGold(grid,n-1,m,currGold));
        max = Math.max(max,getGold(grid,n,m+1,currGold));
        max = Math.max(max,getGold(grid,n,m-1,currGold));
        grid[n][m] = temp;
        return max;
    }
    public static int getMaxGold(int[][] grid, int n, int m){
        int max = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] != 0){
                    max = Math.max(max,getGold(grid,i,j,0));
                }
            }
        }
        return max;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(getMaxGold(grid,n,m));
        sc.close();
    }
}