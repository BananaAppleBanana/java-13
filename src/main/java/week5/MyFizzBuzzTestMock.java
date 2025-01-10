package week5;

import java.util.List;

public class MyFizzBuzzTestMock {
    private final MyFizzBuzzTestMockHelper helper;

    public MyFizzBuzzTestMock(MyFizzBuzzTestMockHelper helper) {
        this.helper = helper;
    }

    public void printFizzBuzz(List<Integer> list) {
        for(int num: list) {
            String res = helper.fizzBuzzHelper(num);
            System.out.println(res);
        }
    }
}
