import java.util.Random;

public class RandomPick {
    public static void main(String[] args) {
        String[] names = {
                "fan peng", "sidharth", "anitha",
                "venkata", "qingyun", "rahul",
                "an cao", "narangua", "franke", "erkang"
        };
        Random rd = new Random();
        int idx = rd.nextInt(10);
        System.out.println(names[idx]);
    }
}
