/*Given an array of integers and a non-negative integer k, 
your task is to rotate the array to the right by k positions.

Rotation means that elements at the end of the array move to the beginning, 
and the rest of the elements shift to the right.

Input Format:
--------------
Line-1: An integer n, represents size of array
Line-2 to n: An integer array arr of length n.
Line-n+1: A non-negative integer k, representing the number of positions to rotate the array.

Output Format:
---------------
Line-1: Return the array after being rotated by k positions.

Constraints:
-------------
The rotation should be performed in place with O(1) extra space.
The time complexity should be O(n).

Sample Input-1:
---------------
5
1 2 3 4 5
2

Sample Output-1: 
----------------
4 5 1 2 3

Sample Input2:
--------------
5
1 2 3 4 5
5

Sample Output-2:
---------------
1 2 3 4 5

Sample Input-3:
---------------
5
1 2 3 4 5
7

Sample Output-3: 
----------------
4 5 1 2 3
 */

import java.util.Scanner;

public class Rotaterray {

    public static void rotate(int a[], int p, int n) {
        int l = n - p;
        int r = n - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
        l = 0;
        r = n - p - 1;
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;
            l++;
            r--;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int p = sc.nextInt();
        if (p > n) {
            p = p % n;
        }
        if (p == n) {
            for (int i = 0; i < n; i++) {
                System.out.println(a[i] + " ");
            }
        }
        rotate(a, p, n);
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(a[i] + " ");
        }
        sc.close();

    }
}
