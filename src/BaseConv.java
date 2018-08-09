//import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

//import kotlin.MathKt;
import java.util.*;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
public class BaseConv {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Number to convert: ");
        Number inputNum = new Number();
        inputNum.value = a.next().toUpperCase();
        inputNum.digits = new char[inputNum.value.length()];
        System.out.println("What base is your input value? (2-36 is all valid) ");
        inputNum.base = a.nextInt();
        System.out.println("What is the desired output base? (2-36 is all valid) ");
        inputNum.newBase = a.nextInt();
    //TODO: try/catch for legit old and new bases
//TODO: check that input num is that base, ask for return base, convert & return
//TODO: do I need separate files? integration with Spring/firebase

        String valueClone = inputNum.value;
        for (int i = inputNum.digits.length - 1; i>=0; i--) {
            inputNum.digits[i] = valueClone.charAt(0);
            valueClone = valueClone.substring(1);
        }
        System.out.println(convertToDec(inputNum));
        System.out.println(decToBase(inputNum.newBase, convertToDec(inputNum)));
    }


    static long convertToDec(Number inNum){
        long total = 0;

        for(int j = 0; j < inNum.digits.length; j++){
            total += Math.pow(inNum.base, j) * Character.getNumericValue(inNum.digits[j]);
        }
        return total;
    }


    static String decToBase(int newBase, long decNum){
        List<Integer> newDigs = new ArrayList<Integer>();
        int mod;
        while(decNum >= newBase){
            mod = (int) (decNum % newBase);
            newDigs.add(mod);
            decNum /= newBase;
        }
//TODO: flip direction of array and make into string
        String out = "";
        for(int i = newDigs.size() - 1; i>=0; i--){
            //TODO: fill in loop to give string
            out += newDigs.get(i).toString();
        }
        return out;
    }

}



class Number {                 //create blank object for input number
    String value;
    char[] digits;
    int newBase;
    int base;
}

