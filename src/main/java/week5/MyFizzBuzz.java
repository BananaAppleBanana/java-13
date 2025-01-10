package week5;

import java.util.List;

/**
 *  FizzBuzz
 *  3 -> fizz
 *  5 -> buzz
 *  15 -> fizzbuzz
 *
 *  %3 , %5, %3&&%5
 */
public class MyFizzBuzz {
    public void printFizzBuzz(List<Integer> list) {
        for(int num: list) {
            String res = fizzBuzzHelper(num);
            System.out.println(res);
        }
    }

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
