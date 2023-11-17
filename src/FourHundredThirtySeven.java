import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.pow;

class PrimeNumber {
    int num;
    boolean isPrime;
    ArrayList<Integer> primitiveRoots = new ArrayList<>();

    PrimeNumber(int num) {
        this.num = num;

        boolean isZero = false; // keep track if any number divides evenly
        if(num % 2 == 1) num++; // count from half
        for(int i = (num / 2); i > 0; i--) { // check all numbers
            if(i % num == 0) { // if a number is divisible, the number is not prime
                isZero = true;
                break;
            }
        }
        isPrime = !isZero;

        if(isPrime) findPrimitiveRoots();
    }

    void findPrimitiveRoots() {
        for(int i = 1; i < num; i++) { // cycle through all smaller numbers
            if(isPrimitiveRoot(i)) primitiveRoots.add(i);
        }
    }

    boolean isPrimitiveRoot(int root) {
        ArrayList<Integer> allNums = new ArrayList<>();
        for(int i = 1; i < num; i++) { // Array from 1 to the number prior to num
            allNums.add(i);
        }

        for(int i = 0; i < num; i++) { // check powers 1 to number prior to num
            int res = (int) (pow(root, i) % num);
            if(allNums.contains(res)) { // check if it's a number that needs to be taken off the list
                allNums.remove(allNums.indexOf(res));
            }
        }
        return allNums.isEmpty(); // if the list is empty, the criteria is met
    }

    boolean hasFibonacci() {
        ArrayList<Integer> roots = new ArrayList<>(primitiveRoots);
        while(!roots.isEmpty()) {
            if(isFibonacci(roots.get(0))) return true;
            else roots.remove(0);
        }
        return false;
    }

    boolean isFibonacci(int val) {
        int first = 1;
        int second = val;
        for(int i = 1; i < 10; i++) {
            int res = (first + second) % num; // do the next step of the sequence
            if(res == 1 && ((second + 1) % num) == val /*&& i == 9*/) return true; // check if cycle has repeated on the 10th cycle

            first = second;
            second = res;
        }
        return false;
    }
}

public class FourHundredThirtySeven {
    public static void main(String[] args) {
        int total = 0;

        for(int i = 2; i < 100000000; i++) {
            PrimeNumber num = new PrimeNumber(i);
            if(num.hasFibonacci()) {total += num.num;}
        }

        System.out.println(total);
    }
}
