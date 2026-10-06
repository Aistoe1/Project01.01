/**
 * RomanToDecimal takes a roman numeral varifies its valid, and then converts it into decimal
 * Flint session: https://app.flintk12.com/activities/units-1-parts-a-55b1e5/sessions/17391156-ce59-49f5-b56f-5a789f9c41d5
 * @author 27gunscha
 * @version 10/6/26
 */

public class RomanToDecimal {
    private static String romans = "IVXLCDM"; //This is the character set that the input can be, so III will work cause I is in there but like sweet won't cause none of those are in there
    private static int[] values = {1, 5, 10, 50, 100, 500, 1000}; //How to delcare/define an array
    private static String validSubs = "IVIXIXLXCCDCM";

    /**
     * Checks if all the characters in string are in the valid romans field
     * @param numeral a String of letters
     * @return true if valid, and false if not
     */

    public static boolean isValid(String numeral) {
        numeral = numeral.toUpperCase();
        for(int i = 0; i < numeral.length(); i++) {
            if(romans.indexOf(numeral.substring(i, i+1)) == -1)
                return false;
        }
        return true;
    }

    /**
     * Checks if the numeral is a valid numeral, for every set of consecutive numerals
     * @param numeral a string of letters
     * @return true if logical, false if not
     */

    public static boolean isLogical(String numeral) {
        numeral = numeral.toUpperCase();
        for (int i = 0; i < numeral.length() - 1; i++) {
            if (numeral.substring(i, i+1).equals(numeral.substring(i+1, i+2)) && "VLD".indexOf(numeral.substring(i, i+1)) != -1)
                return false;

            if (i + 3 < numeral.length()) {
                if (numeral.substring(i, i+1).equals(numeral.substring(i+1, i+2)) &&
                        numeral.substring(i+1, i+2).equals(numeral.substring(i+2, i+3)) &&
                        numeral.substring(i+2, i+3).equals(numeral.substring(i+3, i+4)))
                    return false;
            }
            if (romans.indexOf(numeral.substring(i, i+1)) < romans.indexOf(numeral.substring(i+1, i+2))) {
                if (validSubs.indexOf(numeral.substring(i, i+2)) == -1)
                    return false;
            }
        }
        return true;
    }

    /**
     * Taking a string of numerals and returning decimal value
     * @param roman a string that might have valid roman numerals
     * @return the decimal value of that roman numeral (or -1)
     */

    public static int romanToDecimal(String roman){
        roman = roman.toUpperCase();
        if(!isValid(roman))
            return -1;
        if(!isLogical(roman))
            return -1;
        //Figure out how to get rTD to return 15 when handed "XV"
        int decimal = 0;
        for(int i = 0; i < roman.length(); i++) {
            int val = values[romans.indexOf(roman.charAt(i))];
            decimal += val;

        }
        // HANDLE INVARIANTS HERE!
        // Invariants are, IV IX XL XC CD CM
        if (roman.indexOf("IV") != -1)
            decimal -= 2;
        if (roman.indexOf("IX") != -1)
            decimal -= 2;
        if (roman.indexOf("XL") != -1)
            decimal -= 20;
        if (roman.indexOf("XC") != -1)
            decimal -= 20;
        if (roman.indexOf("CD") != -1)
            decimal -= 200;
        if (roman.indexOf("CM") != -1)
            decimal -= 200;

        return decimal;
    }


    /**
     * Main entrypoint for class RomanToDecimal
     * @param args Command line arguments, WILL USE
     */

    public static void main(String[] args) {
        for(int i = 0; i < args.length; i++)
            if(isValid(args[i]) && isLogical(args[i]))
                System.out.println(args[i] + " ==> " +romanToDecimal(args[i]));
        else
           if(!isValid(args[i]))
                System.out.println(args[i] + " ==> invalid");
           else
               System.out.println(args[i] + " ==> illogical");
    }
}
