import org.aspectj.lang.annotation.Before;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import week5.MyFizzBuzz;

import java.util.Arrays;
import java.util.List;

public class FizzBuzzUnitTest {
    private static MyFizzBuzz fizzBuzz;
    private static MyFizzBuzz spyObj;
    private static MyFizzBuzz mockObj;

    @BeforeAll
    public static void init() {
        fizzBuzz = new MyFizzBuzz();
        spyObj = spy(MyFizzBuzz.class);
        mockObj = mock(MyFizzBuzz.class);
    }

    @Test
    //negative values -> throw IllegalArgumentException
    public void testException() {
        assertThrows(IllegalArgumentException.class, () -> fizzBuzz.fizzBuzzHelper(-1));
    }

    @Test
    public void testFizz() {
        assertEquals("fizz", fizzBuzz.fizzBuzzHelper(3));
    }
    @Test
    public void testBuzz() {
        assertEquals("buzz", fizzBuzz.fizzBuzzHelper(5));
    }

    @Test
    public void testFizzBuzz() {
        assertEquals("fizzbuzz", fizzBuzz.fizzBuzzHelper(15));
    }

    @Test
    public void testNumber() {
        assertEquals("1", fizzBuzz.fizzBuzzHelper(1));
    }
    
    @Test
    public void testForLoop() {
        List<Integer> list = Arrays.asList(1, 2, 5);
        spyObj.printFizzBuzz(list);
        verify(spyObj, times(2)).fizzBuzzHelper(5);
//        when(spyObj.fizzBuzzHelper(5)).thenReturn("123123123");
//        when(mockObj.fizzBuzzHelper(5)).thenReturn("123123123");
//        System.out.println(spyObj.fizzBuzzHelper(5));
//        System.out.println(spyObj.fizzBuzzHelper(15));
//        System.out.println(mockObj.fizzBuzzHelper(5));
//        System.out.println(mockObj.fizzBuzzHelper(15));
    }
}

/**
 * mockmvc.perform()...
 *      .expect()..
 *
 * Selenium
 */
