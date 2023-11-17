class SquaredNumber {
    int amount;

    SquaredNumber(int amount) {
        this.amount = amount * amount;
    }
}

public class Six {
    public static void main(String[] args) {
        int max = 100;
        int totalSquares = 0;
        int totalNums = 0;

        for(int i = 1; i <= max; i++) {
            totalNums += i;
            totalSquares += new SquaredNumber(i).amount;
        }

        totalNums = totalNums * totalNums;
        int difference = totalNums - totalSquares;
        System.out.println(difference);
    }
}