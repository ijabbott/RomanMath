import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class RomanNumeralCalculatorTest {

  private RomanNumeralCalculator calculator;

  @Before
  public void Setup(){
    calculator = new RomanNumeralCalculator();
  }

  @Test
  public void onePlusOneIsTwo() {

    String actualResult = calculator.add("I", "I");
    String expectedResult = "II";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void onePlusTwoIsThree() {

    String actualResult = calculator.add("I", "II");
    String expectedResult = "III";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @Ignore
  public void twoPlusTwoIsFour() {

    String actualResult = calculator.add("II", "II");
    String expectedResult = "IV";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @Ignore
  public void twoPlusThreeIsFive() {

    String actualResult = calculator.add("II", "III");
    String expectedResult = "V";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @Ignore
  public void fivePlusFiveIsTen() {

    String actualResult = calculator.add("V", "V");
    String expectedResult = "X";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @Ignore
  public void onePlusFourIsFive() {

    String actualResult = calculator.add("I", "IV");
    String expectedResult = "V";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  @Ignore
  public void fivePlusFourIsNine() {

    String actualResult = calculator.add("IV", "V");
    String expectedResult = "IX";

    assertEquals(expectedResult, actualResult);
  }

  @Test
  public void IVIsSubtractiveReturnsTrue() {

    boolean isSubtractive = calculator.isSubtractive("IV");

    assertTrue(isSubtractive);
  }

  @Test
  public void VIsSubtractiveReturnsFalse() {

    boolean isSubtractive = calculator.isSubtractive("V");

    assertFalse(isSubtractive);
  }

  @Test
  public void GivenIVReturnsIIII() {

    String simplified = calculator.expandSubtractiveNumerals("IV");

    assertEquals("IIII", simplified);
  }

  @Test
  public void GivenIXReturnsVIIII() {

    String simplified = calculator.expandSubtractiveNumerals("IX");

    assertEquals("VIIII", simplified);
  }

  @Test
  public void GivenXReturnsX() {

    String simplified = calculator.expandSubtractiveNumerals("X");

    assertEquals("X", simplified);
  }


  @Test
  public void GivenVIIIIVIIIISortReturnsVVIIIIIIII() {
    String sorted = calculator.sortExpandedNumerals("VIIIIVIIII");

    assertEquals("VVIIIIIIII", sorted);
  }
}