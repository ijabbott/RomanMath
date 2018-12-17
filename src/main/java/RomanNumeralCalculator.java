import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class RomanNumeralCalculator {

    HashMap<String, String> subtractiveTable = new HashMap<String, String>() {{
        put("IV", "IIII");
        put("IX", "VIIII");
        put("XL", "XXXX");
        put("XC", "LXXXX");
        put("CD", "CCCC");
        put("CM", "DCCCC");
    }};

    HashMap<String, String> compactTable = new HashMap<String, String>() {{
        put("IIIII", "V");
        put("VV", "X");
        put("XXXXX", "L");
        put("LL", "C");
        put("CCCCC", "D");
        put("DD", "M");
    }};

    public String add(String numeral1, String numeral2) {
        HashMap<String, Integer> numeralValues = new HashMap<String, Integer>() {{
            put("I", 1);
            put("IV", 2);
            put("V", 3);
            put("IX", 4);
            put("X", 5);
        }};


        String combined = numeral1 + numeral2;
        String subtractive = "";
        char[] currentLetter = {};
        int currentLetterCounter = 0;
        char[] previousLetter = {};

        /*for (int i = 0; i < combined.length() - 1; i++) {
            previousLetter = currentLetter;
            combined.getChars(i, i, currentLetter, 0);
            currentLetterCounter++;
            if(numeralValues.get(currentLetter) > numeralValues.get(previousLetter)) {
                subtractive = previousLetter.toString() + currentLetter.toString();
                subtractive = subtractiveTable.get(subtractive);
            }

        }*/




        return numeral1 + numeral2;

    }


    public boolean isSubtractive(String romanNumeral) {
        return subtractiveTable.containsKey(romanNumeral);
    }

    public String expandSubtractiveNumerals(String numeral) {
        List<RomanNumeral> list = new ArrayList<>();
        String expandedString = new String();
        stringToNumeralArray(numeral, list);

        if(this.isSubtractive(numeral)) {
            return subtractiveTable.get(numeral);
        }

        if(numeral.length() == 1) {
            return numeral;
        }

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).compareTo(list.get(i + 1)) < 0) {
                expandedString = expandedString + "" + subtractiveTable.get("" + list.get(i).toString() + list.get(i + 1).toString());
                i++;
            } else {
                expandedString = expandedString + "" + list.get(i).toString();
            }

        }

        return expandedString;
    }

    private String numeralListToString(List<RomanNumeral> expandedList) {
        return expandedList.stream().map(RomanNumeral::toString).collect(Collectors.joining());
    }

    public String sortExpandedNumerals(String unsorted) {
        List<RomanNumeral> list = new ArrayList<>();

        stringToNumeralArray(unsorted, list);

        list.sort(Collections.reverseOrder());

        return numeralListToString(list);
    }

    private void stringToNumeralArray(String unsorted, List<RomanNumeral> list) {
        for(char c : unsorted.toCharArray()) {
            list.add(new RomanNumeral(Character.toString(c)));
        }
    }
}

