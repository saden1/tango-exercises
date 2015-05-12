package tango.exercises.hamming;

/**
 *
 * @author Sharmarke Aden (saden)
 */
public class HammingWeightCalculator {

    int manual(int input) {
        int count = 0;
        for (double i = 0; i <= 31; i++) {
            Double setbit = Math.pow(2d, i);
            long tmp = input;
            tmp = tmp & setbit.longValue();

            if (tmp != 0) {
                count++;
            }
        }

        return count;
    }

    int jdk(int input) {
        //does it without looping...pretty cool trick.
        return Integer.bitCount(input);
    }
}
