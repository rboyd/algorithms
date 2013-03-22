import java.util.Arrays;
import java.security.SecureRandom;

public class Shuffler {
    static int[] cards = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};

    /* The Fisher-Yates shuffle (aka the Knuth shuffle, after being
     * popularized in TAoCP vol 2) guarantees a random permutation of
     * the input list in linear time, assuming a uniform distribution
     * of the random number generator.
     */
    public int[] shuffle(int[] list) {
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < list.length; i++) {
            int r = random.nextInt(i+1);
            int tmp = list[r];
            list[r] = list[i];
            list[i] = tmp;
        }
        return list;
    }

    public static void main(String[] args) {
        Shuffler shuffler = new Shuffler();
        System.out.println(Arrays.toString(shuffler.shuffle(cards)));
        return;
    }
}
