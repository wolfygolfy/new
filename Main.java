import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(calc(input.nextLine()));

    }


    public static String calc(String input) {
        String[] romanNums = {"I", "II", "III", "VI", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII",
                "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI",
                "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LII", "LIV", "LV", "LVI",
                "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII",
                "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV",
                "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
        String[] arr = input.split(" ");
        if(arr.length == 3) {
            if (isInteger(arr[0]) && isInteger(arr[2])) {
                if ((0 <= Integer.parseInt(arr[0]) && Integer.parseInt(arr[0]) <= 10) &&
                        (0 <= Integer.parseInt(arr[2]) && Integer.parseInt(arr[2]) <= 10)) {
                    switch (arr[1]) {
                        case ("+"):
                            return Integer.toString(Integer.parseInt(arr[0]) + Integer.parseInt(arr[2]));
                        case ("-"):
                            return Integer.toString(Integer.parseInt(arr[0]) - Integer.parseInt(arr[2]));
                        case ("*"):
                            return Integer.toString(Integer.parseInt(arr[0]) * Integer.parseInt(arr[2]));
                        case ("/"):
                            return Integer.toString(Integer.parseInt(arr[0]) / Integer.parseInt(arr[2]));
                    }
                }
            }
            if (!isInteger(arr[0]) && !isInteger(arr[2])) {
                if ((0 < index(arr[0], romanNums) && index(arr[0], romanNums) <= 10) &&
                        (0 < index(arr[2], romanNums) && index(arr[2], romanNums) <= 10)) {
                    switch (arr[1]) {
                        case ("+"):
                            return romanNums[(((index(arr[0], romanNums)) + 1) + ((index(arr[2], romanNums)) + 1)) - 1];
                        case ("-"):
                            if((index(arr[2], romanNums) + 1 >= index(arr[1], romanNums) + 1)){
                                return "throws Exception";
                            }
                            return romanNums[(((index(arr[0], romanNums)) + 1) - ((index(arr[2], romanNums)) + 1)) - 1];
                        case ("*"):
                            return romanNums[(((index(arr[0], romanNums)) + 1) * ((index(arr[2], romanNums)) + 1)) - 1];
                        case ("/"):
                            return romanNums[(((index(arr[0], romanNums)) + 1) / ((index(arr[2], romanNums)) + 1)) - 1];
                    }
                }
            }
        }
        return "throws Exception";
    }

    public static Boolean isInteger(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static Integer index(String inputNum, String[] arr) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i].equals(inputNum)) {
                return i;
            }
        }
        return -1;
    }
}
