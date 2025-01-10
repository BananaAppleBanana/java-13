package week5;

public class MyFizzBuzzTestMockHelper {
    public String fizzBuzzHelper(int num) {
        if(num < 0) {
            throw new IllegalArgumentException("input cannot be negative");
        }
        if(num % 3 == 0 && num % 5 == 0) {
            return "fizzbuzz";
        } else if (num % 3 == 0){
            return "fizz";
        } else if(num % 5 == 0) {
            return "buzz";
        } else {
            return String.valueOf(num);
        }
    }
}
