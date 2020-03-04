import java.util.Random;

public class RandomFilePathCreator {
    private final String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int MAX_LENGHT = 9;
    String finalPath = "";

    public String pathCreator() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder(MAX_LENGHT);
        for (int i = 0; i < MAX_LENGHT; i++) {
            sb.append(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        finalPath = "src/" + sb.toString() + ".json";
        return finalPath;
    }
}
