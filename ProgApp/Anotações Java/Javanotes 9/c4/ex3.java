import java.util.Scanner;
/*
Exercise 4.3:
Write a function that simulates rolling a pair of dice until the total on the dice comes up to be a given number. The number that you are rolling for is a parameter to the function. The number of times you have to roll the dice is the return value of the function. The parameter should be one of the possible totals: 2, 3, ..., 12. The function should throw an IllegalArgumentException if this is not the case. Use your function in a program that computes and prints the number of rolls it takes to get snake eyes. (Snake eyes means that the total showing on the dice is 2.)
*/

public class Main
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print(rowsTo(2));
    }
    private static int rowsTo(int total) {
        if (total >= 2 && total <= 12) {
            int rows;
            int sum=0;
            for (rows =0; sum != total; rows++) {
                sum = rowDice() + rowDice();
            }
            return rows;
        } else {
            throw new IllegalArgumentException();
        }
    }
    
    private static int rowDice() {
        return (int)(Math.random() * 6 + 1);
    }
}
