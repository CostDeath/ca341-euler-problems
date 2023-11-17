import java.util.ArrayList;

import static java.lang.Math.pow;

class Dice {
    int num;
    Dice() {
        num = 1;
    }

    void addOne() {
        if(num == 6) num = 1; // if it's 6, roll the dice back over to 1
        else num++;
    }

    @Override
    public String toString() {
        return Integer.toString(num);
    }
}

public class SixHundredFortyOne {
    public static void main(String[] args) {
        int n = (int) pow(10, 36);
        ArrayList<Dice> die = new ArrayList<>();
        for(int i = 0; i < n; i++) die.add(new Dice()); // create list of dice

        for(int i = 2; i <= n; i++) { // cycle through turns
            for(int j = i; j <= n;) { // cycle through dice
                die.get(j - 1).addOne();
                j += i;
            }
        }

        int total = 0;
        for(int i = 0; i < n; i++) { // count number of dice that are showing a 1
            if(die.get(i).num == 1) total++;
        }

        System.out.println(total);
    }
}
