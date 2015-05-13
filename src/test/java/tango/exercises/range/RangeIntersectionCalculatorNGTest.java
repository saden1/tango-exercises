package tango.exercises.range;

import static com.google.common.collect.ImmutableList.of;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 *
 * @author Sharmarke Aden (saden)
 */
public class RangeIntersectionCalculatorNGTest {

    RangeIntersectionCalculator sut;

    @BeforeClass
    public void init() {
        sut = new RangeIntersectionCalculator();
    }

    @DataProvider
    Object[][] invalidInput() {
        return new Object[][]{
            {null},
            {of(new Range(5, 2))},
            {of(new Range(2, 5), new Range(7, 3))}

        };
    }

    @DataProvider
    Object[][] validInput() {
        return new Object[][]{
            {
                of(new Range(2, 5)),
                of(new Range(2, 5))
            },
            {
                of(new Range(7, 7), new Range(7, 7)),
                of(new Range(7, 7))
            },
            {
                of(new Range(2, 5), new Range(5, 7)),
                of(new Range(2, 7))
            },
            {
                of(new Range(5, 7), new Range(2, 5)),
                of(new Range(2, 7))
            },
            {
                of(new Range(2, 5), new Range(2, 7)),
                of(new Range(2, 7))
            },
            {
                of(new Range(2, 7), new Range(3, 7)),
                of(new Range(2, 7))
            },
            {
                of(new Range(2, 5), new Range(6, 8)),
                of(new Range(2, 5), new Range(6, 8))
            },
            {
                of(new Range(6, 8), new Range(2, 5)),
                of(new Range(6, 8), new Range(2, 5))
            },
            {
                of(new Range(2, 5), new Range(3, 8)),
                of(new Range(2, 8))
            },
            {
                of(new Range(3, 8), new Range(2, 5)),
                of(new Range(2, 8))
            },
            {
                of(new Range(2, 5), new Range(5, 7), new Range(5, 10), new Range(11, 14)),
                of(new Range(2, 10), new Range(11, 14))
            },
            {
                of(new Range(2, 5), new Range(5, 7), new Range(7, 10), new Range(11, 14)),
                of(new Range(2, 10), new Range(11, 14))
            },
            {
                of(new Range(2, 7), new Range(5, 10), new Range(7, 10), new Range(11, 14)),
                of(new Range(2, 10), new Range(11, 14))
            },
            {
                of(new Range(2, 7), new Range(3, 8), new Range(6, 12), new Range(10, 14)),
                of(new Range(2, 14))
            },
            {
                of(new Range(-2, 7), new Range(-1, 8), new Range(0, 12), new Range(10, 14)),
                of(new Range(-2, 14))
            }
        };
    }

    @Test(dataProvider = "invalidInput",
            expectedExceptions = {IllegalArgumentException.class, NullPointerException.class})
    public void givenInvalidInputShouldThrowException(List<Range> input) {
        sut.calc(input);
    }

    @Test(dataProvider = "validInput")
    public void givenValidInputShouldReturnRanges(List<Range> input, List<Range> expected) {
        List<Range> result = sut.calc(input);
        assertThat(result).containsOnlyElementsOf(expected);
    }

}
