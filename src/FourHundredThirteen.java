import java.util.ArrayList;

import static java.lang.Math.pow;

class OneChildNumber {
    ArrayList<Integer> number = new ArrayList<>();
    ArrayList<Integer> substrings;
    int size;
    int numAsInt;

    OneChildNumber(int num) {
        numAsInt = num;
        while(num != 0) {
            number.add(num % 10); // add lowest digit into array
            num = num / 10; // move onto the next digit
        }
        size = number.size();
        findSubstrings();
    }

    void findSubstrings() {
        substrings = new ArrayList<>(number);
        // substrings.add(numAsInt);
        for(int i = 1; i < size; i++) { // loop through substring size
            for(int j = 0; j < size - i; j++) { // loop through each substring; each iteration has 1 less substring and j is the starting position of the substring
                int substring = 0;
                int count = 0;
                for(int digit = j; digit < (j + i + 1); digit++) { // loop through each element on the list; i + 1 = substring size
                    substring += (int) (number.get(digit) * pow(10, count)); // add digit to the substring, with the corresponding decimal place
                    count++;
                }
                substrings.add(substring); // add the new substring to the list of substrings
            }
        }
    }

    boolean isOneChild() {
        boolean foundDivisible = false;
        for(int i = 0; i < substrings.size(); i++) { // go through all the substrings
            if(substrings.get(i) % size == 0) { // if it's divisible
                if(foundDivisible) return false; // if it's not the only divisible, then it's false
                else foundDivisible = true; // if it's the first divisible, mark it
            }
        }
        return foundDivisible; // only true if exactly 1 divisible was found
    }
}

public class FourHundredThirteen {
    static int F(int n) {
        int count = 0;
        for(int i = 1; i < n; i++) { // go through all numbers
            OneChildNumber num = new OneChildNumber(i);
            if(num.isOneChild()) count++; // increment the counter if a one child number is found
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(F(10000000));
    }
}
