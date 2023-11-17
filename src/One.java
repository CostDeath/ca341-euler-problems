import java.util.LinkedList;

class Number {
    boolean divisibleByThree;
    boolean divisibleByFive;
    int amount;

    Number(int amount) {
        divisibleByThree = (amount % 3) == 0; // sets if the number is divisible by 3
        divisibleByFive = (amount % 5) == 0; // sets if the number is divisible by 5
        this.amount = amount;
    }
}

public class One {
    public static void main(String[] args) {
        int max = 1000;
        LinkedList<Number> numbers = new LinkedList<>(); // create a list to store the numbers
        for(int i = 0; i < max; i++) {
            numbers.add(new Number(i+1)); // create number objects to add to the list
        }

        int total = 0;
        for(int i = 0; i < numbers.size(); i++) { // iterate through all items in the list
            Number number = numbers.get(i);
            if(number.divisibleByThree || number.divisibleByFive) { // if either property is met..
                total += number.amount; // add them to the total
            }
        }

        System.out.println(total);
    }
}
