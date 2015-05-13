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
        //Integer.bitCount(input) does it without looping...pretty cool trick.
        input = input - ((input >>> 1) & 0x55555555);
        input = (input & 0x33333333) + ((input >>> 2) & 0x33333333);
        input = (input + (input >>> 4)) & 0x0f0f0f0f;
        input = input + (input >>> 8);
        input = input + (input >>> 16);
        return input & 0x3f;
    }
}
