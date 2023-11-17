import static java.lang.Math.pow;

class ExperienceNumber {
    int num;

    ExperienceNumber(int num) {
        this.num = num;
    }

    boolean d() { // add up the digits of a number individually
        int n = num;
        int total = 0;
        while(n != 0) {
            total += n % 10; // add the last digit of the number
            n = n / 10; // remove that number from the list of numbers to be added
        }
        return total == 23;
    }

    boolean divisibleByTwentyThree() {
        return (num % 23) == 0;
    }

}

public class TwoHundredNinetyFour {
    static int S(int n) { // find all numbers divisible by 23 and for which the digits add up to 23 below 10^n
        int count = 0;
        for(int i = 23; i < pow(10, n); i++) { // 23 is the lowest number divisible by 23
            ExperienceNumber num = new ExperienceNumber(i);
            if(num.d() && num.divisibleByTwentyThree()) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(S((int) pow(11, 12)) % pow(10, 9));
    }
}
