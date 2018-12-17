import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RomanNumeralTest {

    RomanNumeral I = new RomanNumeral("I");
    RomanNumeral V = new RomanNumeral("V");
    RomanNumeral X = new RomanNumeral("X");
    @Test
    public void NumeralXToStringIsX() {
        assertEquals("X", X.toString());
    }

    @Test
    public void IsVGreaterThanIReturnsOne() {
        assertEquals(1, V.compareTo(I));
    }

    @Test
    public void IsILessThanVReturnsNegativeOne() {
        assertEquals(-1, I.compareTo(V));
    }

    @Test
    public void IsIEqualToIReturnsZero() {
        assertEquals(0, I.compareTo(I));
    }

    @Test
    public void IsVEqualToVReturnsZero() {
        assertEquals(0, V.compareTo(V));
    }

    @Test
    public void IsILessThanXReturnsNegativeOne() {
        assertEquals(-1, I.compareTo(X));
    }
}
