package fibonacci;

import java.util.Scanner;

public class Fibonacci {
  public static void main(String[] args) {
    System.out.println("Fibonacci series:");
    Scanner Scanner = new Scanner(System.in);

    System.out.print("Enter the number of terms: ");
    int fibonacciNo = Scanner.nextInt();
    Scanner.close();

    // fibonattiの計算スタート
    int a = 0, b = 1, c;
    System.out.print(a + " " + b);
    for (int i = 2; i < fibonacciNo; i++) {
      c = a + b;
      System.out.print(" " + c);
      a = b;
      b = c;
    }
  }

}
