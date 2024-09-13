/**
 * Exercise 4.4:
This exercise builds on Exercise 4.3. Every time you roll the dice repeatedly, trying to get a given total, 
* number of rolls it takes can be different. The question naturally arises, what's the average number of 
* rolls to get a given total? Write a function that performs the experiment of rolling to get a given total 
* 10000 times. The desired total is a parameter to the subroutine. The average number of rolls is the return 
* value. Each individual experiment should be done by calling the function you wrote for Exercise 4.3. Now, 
* write a main program that will call your function once for each of the possible totals (2, 3, ..., 12). 
* It should make a table of the results, something like:

Total On Dice     Average Number of Rolls
-------------     -----------------------
       2               35.8382
       3               18.0607
       .                .
       .                .

 */

public class ex4 {
    public static void main(String args[]) {
        System.out.println("Total on dice | Avg. number of rows");
        for(int t=2; t <= 12; t++) {
            int c;
            double soma;
            
            for(c=0, soma=0; c < 10000; c++) {
                soma += rowsToTotal(t);
            }
            
            double media= soma / c;
            System.out.printf("%2d\t%.2f\n", t, media);
        }
    }
    
    private static int rowsToTotal(final int total) {
        int rows, sum;
        
        if (total >= 2 && total <= 12) {
            for(rows=0, sum=0; sum != total; rows++) {
                sum = rowDice() + rowDice();
            }
        } else {
            throw new IllegalArgumentException();
        }
        return rows;
    }
    
    private static int rowDice() {
        return (int)(Math.random() * 6 + 1);
        
    }
}
