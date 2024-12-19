import java.util.Random;

public class RandomPick {
    public static void main(String[] args) {
        individual();
    }

    private static void individual() {
        String[] names = {
                "fan peng", "sidharth", "anitha",
                "venkata", "qingyun", "rahul",
                "an cao", "narangua", "franke", "erkang"
        };
        Random rd = new Random();
        int idx = rd.nextInt(10);
        System.out.println(names[idx]);
    }

    private static void group() {
        String[] names = {
                "group 1", "group 2", "group 4",
                "group 3", "group 5"
        };
        Random rd = new Random();
        int idx = rd.nextInt(5);
        System.out.println(names[idx]);
    }
}
