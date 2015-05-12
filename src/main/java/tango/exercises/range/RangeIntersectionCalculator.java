package tango.exercises.range;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Sharmarke Aden (saden)
 */
public class RangeIntersectionCalculator {

    List<Range> calc(List<Range> ranges) {
        checkNotNull(ranges, "range input list can not be null");

        //normaly the list would be provided by a factory collaborator class
        //but for simplicy we'll just create a new list
        List<Range> result = new LinkedList<>();

        //walk through the list
        for (int i = 0; i < ranges.size(); i++) {
            //set the current range
            Range current = ranges.get(i);

            //assumes ranges have a well defined start and end points and that
            //the start of the range can not be greater than the end of the range
            validateRange(current);

            for (int j = i + 1; j < ranges.size(); j++) {
                Range receding = ranges.get(j);
                validateRange(receding);
                //check to see if the current range intersects receeding range
                if (intersects(current, receding)) {
                    //update the current range to be the intersection
                    //of the current range and receeding range
                    current = intersection(current, receding);
                    //move i forward so we don't iterate over the receeding range
                    //just included again
                    i++;
                }
            }

            //add the current range to the resulting range
            result.add(current);
        }

        return result;
    }

    private void validateRange(Range range) {
        checkArgument(range.getStart() <= range.getEnd(),
                "invalid range %s. range start value must be less or equal to range end value",
                range);
    }

    private boolean intersects(Range r1, Range r2) {
        //check if r1 intersect r2 or r2 intersects r1. we need to do this
        //because the ranges list could be unordered.
        return (r1.getEnd() >= r2.getStart() && r1.getEnd() <= r2.getEnd())
                || (r2.getEnd() >= r1.getStart() && r2.getEnd() <= r1.getEnd());
    }

    private Range intersection(Range r1, Range r2) {
        int start = (r2.getStart() <= r1.getStart()) ? r2.getStart() : r1.getStart();
        int end = (r2.getEnd() >= r1.getEnd()) ? r2.getEnd() : r1.getEnd();

        return new Range(start, end);
    }

}
