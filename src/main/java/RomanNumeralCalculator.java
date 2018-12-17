import java.util.*;
import java.util.stream.Collectors;

public class RomanNumeralCalculator {

    LinkedHashMap<String, String> expandTable = new LinkedHashMap<String, String>() {{
        put("IV", "IIII");
        put("IX", "VIIII");
        put("XL", "XXXX");
        put("XC", "LXXXX");
        put("CD", "CCCC");
        put("CM", "DCCCC");
    }};

    LinkedHashMap<String, String> compactTable = new LinkedHashMap<String, String>() {{
        put("IIIII", "V");
        put("VV", "X");
        put("XXXXX", "L");
        put("LL", "C");
        put("CCCCC", "D");
        put("DD", "M");
        put("IIII", "IV");
        put("VIIII", "IX");
        put("XXXX", "XL");
        put("LXXXX", "XC");
        put("CCCC", "CD");
        put("DCCCC", "CM");
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
        return expandTable.containsKey(romanNumeral);
    }

    public String expandSubtractiveNumerals(String numeral) {
        List<RomanNumeral> list = new ArrayList<>();
        String expandedString = new String();
        stringToNumeralArray(numeral, list);

        if(this.isSubtractive(numeral)) {
            return expandTable.get(numeral);
        }

        if(numeral.length() == 1) {
            return numeral;
        }

        for(int i = 0; i < list.size() - 1; i++) {
            if(list.get(i).compareTo(list.get(i + 1)) < 0) {
                expandedString = expandedString + "" + expandTable.get("" + list.get(i).toString() + list.get(i + 1).toString());
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

    public String simplifyNumeral(String numeral) {
        
        String newNumeral = numeral;

        for(String s : compactTable.keySet()) {
            if(newNumeral.contains(s)) {
                int index = newNumeral.indexOf(s);
                String s1 = newNumeral.substring(0, 0);
                String s2 = newNumeral.substring(index + s.length());
                newNumeral = s1 + compactTable.get(s) + s2;
            }
        }

        return newNumeral;
    }
}

