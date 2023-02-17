package org.example;

import java.util.Scanner;

/*
 * This is
 * okay
 */
public class Solution {

    /*
     * This is
     * okay
     */
    public static long fibonacci(long n) {
        //fibonacci
        if (n < 0) {
            return -1;
        } else {
            if (n == 0 || n == 1) {
                return n;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }

    /*
     * This is
     * okay
     */
    public static void main(String[] args) {
        //main
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        System.out.println(fibonacci(a));
    }
}