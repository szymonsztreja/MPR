package pl.edu.pjatk.testy;

public class Calculator {

    public static int power(int a, int b){
        int result = a;
        for (int i = 1; i < b; i++) {
            result = result * a;
//            result *= a;
        }
        return result;
    }

    public static boolean dividable (int a, int b){
        if( a % b == 0) return true;
            return false;
    }
}
