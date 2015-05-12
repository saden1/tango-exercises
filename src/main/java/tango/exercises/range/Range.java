package tango.exercises.range;

/**
 *
 * @author Sharmarke Aden (saden)
 */
public class Range {

    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.start;
        hash = 89 * hash + this.end;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Range other = (Range) obj;
        if (this.start != other.start) {
            return false;
        }
        return this.end == other.end;
    }

    @Override
    public String toString() {
        return "[" + "start=" + start + ", end=" + end + ']';
    }

}
