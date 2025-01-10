import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import week5.MyFizzBuzzTestMock;
import week5.MyFizzBuzzTestMockHelper;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class FizzBuzzMockUnitTest {

    private static MyFizzBuzzTestMock instance;
    private static MyFizzBuzzTestMockHelper helperInstance;

    @BeforeAll
    public static void init() {
        helperInstance = mock(MyFizzBuzzTestMockHelper.class);
        instance = new MyFizzBuzzTestMock(helperInstance);
    }

    @Test
    public void testForLoop() {
        when(helperInstance.fizzBuzzHelper(5)).thenReturn("buzz");
        List<Integer> list = Arrays.asList(1, 2, 5, 5);
        instance.printFizzBuzz(list);
        verify(helperInstance, times(2)).fizzBuzzHelper(5);
//        when(spyObj.fizzBuzzHelper(5)).thenReturn("123123123");
//        when(mockObj.fizzBuzzHelper(5)).thenReturn("123123123");
//        System.out.println(spyObj.fizzBuzzHelper(5));
//        System.out.println(spyObj.fizzBuzzHelper(15));
//        System.out.println(mockObj.fizzBuzzHelper(5));
//        System.out.println(mockObj.fizzBuzzHelper(15));
    }
}
