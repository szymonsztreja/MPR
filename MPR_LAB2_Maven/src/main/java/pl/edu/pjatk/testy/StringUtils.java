package pl.edu.pjatk.testy;

public class StringUtils {

    public static String toUpperCaseTest(String string){
//        String result = string.toUpperCase();
        return new StringBuilder(string).toString().toUpperCase();
    }

    public static String reverse(String input){
        return new StringBuilder(input).reverse().toString();
    }

    public static String multiplyString(String string, int multiplier){
        StringBuilder multiplied = new StringBuilder();
        for (int i = 0; i < multiplier; i++) {
            multiplied.append(string).append(" ");
        }
        return multiplied.toString().trim();
    }

//    public static String removeSmallChars(String jan_kowalski) {
//        StringBuilder removedSmallChars = new StringBuilder();
//
//    }
}
