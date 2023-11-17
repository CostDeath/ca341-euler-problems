class SequenceNumber {
    int num;
    boolean isPrime;

    SequenceNumber(int n) {
        num = (2 * n * n) - 1; // convert number into the next in the sequence

        boolean isZero = false; // keep track if any number divides evenly
        if(num % 2 == 1) num++; // count from half
        for(int i = (num / 2); i > 0; i--) { // check all numbers
            if(i % num == 0) { // if a number is divisible, the number is not prime
                isZero = true;
                break;
            }
        }
        isPrime = !isZero;
    }
}

public class TwoHundredSixteen {
    public static void main(String[] args) {
        int count = 0;
        for(int i = 2; i <= 50000000; i++) {
            SequenceNumber num = new SequenceNumber(i);
            if(num.isPrime) count++;
        }
        System.out.println(count);
    }
}
