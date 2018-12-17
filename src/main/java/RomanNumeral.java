import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RomanNumeral implements Comparable<RomanNumeral> {

    private String numeralString;

    private enum Numerals {
        I,
        V,
        X,
        L,
        C,
        D,
        M;
    }

    public RomanNumeral(String numeralString) {
        this.numeralString = numeralString;
    }

    @Override
    public String toString() {
        return numeralString;
    }

    @Override
    public int compareTo(RomanNumeral o) {

        if(o.toString().equals(numeralString)) {
            return 0;
        }
        if(Numerals.valueOf(numeralString).ordinal() < Numerals.valueOf(o.toString()).ordinal()) {
            return -1;
        }
        return 1;
    }
}
