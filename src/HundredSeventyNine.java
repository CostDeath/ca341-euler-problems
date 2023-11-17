import static java.lang.Math.pow;

class DivisorNumber {
    int divisors;

    DivisorNumber(int num) {
        int count = 0;
        for(int i = 1; i <= num; i++) {
            if(num % i == 0) count++;
        }

        divisors = count;
    }

    public int getDivisors() {
        return divisors;
    }
}

public class HundredSeventyNine {
    public static void main(String[] args) {
        int num = ((int) pow(10, 7));

        DivisorNumber last = new DivisorNumber(2);
        int count = 0;
        
        for(int i = 3; i < num; i++) {
            DivisorNumber curr = new DivisorNumber(i);
            if(curr.getDivisors() == last.getDivisors()) {
                count++;
            }
            last = curr;
            System.out.println(i);
        }
        System.out.println(count);
    }
}
