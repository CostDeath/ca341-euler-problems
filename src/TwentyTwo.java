import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class Name {
    static String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZ"; // map for points
    String name;
    int wordScore;
    int position;
    int totalScore;

    Name(String name, int position) {
        this.name = name.replaceAll("\"", ""); // remove quotations from name
        this.position = position;
        calcTotalScore();
    }

    void calcTotalScore() {
        calcWordScore();
        totalScore = position * wordScore; // multiply the score of the letters by the name's position
    }

    void calcWordScore() {
        int total = 0;
        for(int i = 0; i < name.length(); i++) { // iterate through all letters
            total += Name.alphabet.indexOf(name.charAt(i)); // check the position of the corresponding letter on the map
        }
        wordScore = total;
    }
}

public class TwentyTwo {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "names.txt")); // grab names
        String[] names = scanner.nextLine().split(","); // split names into an array
        Arrays.sort(names); // sort them alphabetically

        int total = 0;
        for(int i = 0; i < names.length; i++) { // go through every name
            Name name = new Name(names[i], i + 1); // create an object that remembers its name and position
            total += name.totalScore; // add the score of the name to the total scores
        }
        System.out.println(total);
    }
}
