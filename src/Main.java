import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) throws IOException {
        File filePath = new File("files");
        filePath.mkdir();
        for (int i = 1; i <= 100; i++) {
            PrintWriter writer = new PrintWriter(filePath.getAbsolutePath() + "\\" + i +".txt", StandardCharsets.UTF_8);
            for(int j = 1; j <= 100_000; j++) {
                writer.print(getDate()
                        + "||" + getLatinCharacters()
                        + "||" + getRussianCharacters()
                        + "||" + getIntNumber()
                        + "||" + getDoubleNumber());
            }
            writer.close();
        }


    }

    public static String getDoubleNumber() {
        double a = (Math.random() * 20) + 1;
        return String.format("%.8f%n", a);
    }

    public static String getIntNumber() {
        int a = (int) (Math.random() * 100_000_000) + 1;
        return String.valueOf(a);
    }

    public static String getDate() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime then = now.minusYears(5);

        Date d1 = java.sql.Timestamp.valueOf(then);
        Date d2 = java.sql.Timestamp.valueOf(now);

        Date randomDate = new Date(ThreadLocalRandom.current()
                .nextLong(d1.getTime(), d2.getTime()));

        SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

        return formatter.format(randomDate);
    }

    public static String getLatinCharacters() {
        String latinAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        Random r = new Random();
        char[] arr = new char[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = latinAlphabet.charAt(r.nextInt(latinAlphabet.length()));
        }

        return String.valueOf(arr);
    }

    public static String getRussianCharacters() {
        String russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";

        Random r = new Random();
        char[] arr = new char[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = russianAlphabet.charAt(r.nextInt(russianAlphabet.length()));
        }

        return String.valueOf(arr);
    }
}
