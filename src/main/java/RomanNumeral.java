import java.util.Comparator;

public class RomanNumeral implements Comparable<RomanNumeral> {

    private String numeralString;

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
        if(o.toString().equals("V")) {
            return -1;
        }
        return 1;
    }
}
