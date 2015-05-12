package tango.exercises.hamming;

import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden (saden)
 */
public class HammingWeightCalculatorNGTest {

    HammingWeightCalculator sut;

    @BeforeClass
    public void init() {
        sut = new HammingWeightCalculator();
    }

    @DataProvider
    Object[][] input() {
        return new Object[][]{
            {0, 0}, //zero should return zero
            {57, 4}, //57 should return 4
            {-57, 29}, //-57 should return 29
            {Integer.MAX_VALUE, 31},
            {Integer.MIN_VALUE, 1}
        };
    }

    @Test(dataProvider = "input")
    public void givenValidInputManualShouldReturnWeight(int input, int expected) {
        assertThat(sut.manual(input))
                .isEqualTo(expected)
                .as("check hemming weight of %d is %d", input, expected);
    }

    @Test(dataProvider = "input")
    public void givenValidInputJdkCaclShouldReturnWeight(int input, int expected) {
        assertThat(sut.jdk(input))
                .isEqualTo(expected)
                .as("check hemming weight of %d is %d", input, expected);
    }

}
