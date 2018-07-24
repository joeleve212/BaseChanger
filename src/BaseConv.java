//import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import java.util.Scanner;
public class BaseConv {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Number to convert: ");
        Number inputNum = new Number();
        inputNum.value = a.next().toUpperCase();
        inputNum.digits = new char[inputNum.value.length()];
        System.out.println("What base is your input value?");
        inputNum.base = a.nextInt();

//TODO: check that input num is that base, ask for return base, convert & return
//TODO: do I need separate files? integration with Spring/firebase

        String valueClone = inputNum.value;
        for (int i = 0; i<inputNum.digits.length; i++) {
            inputNum.digits[i] = valueClone.charAt(0);
            valueClone = valueClone.substring(1);
        }
        long decNum = convertToDec(inputNum);
        System.out.println(decNum);

    }
    static private long convertToDec(Object inNum){
//TODO: make this method do things!
        return 4;
    }
    static private String convertToBase(int newBase, long decNum){
//TODO: make this method do things!
        return "73E";
    }
}

class Number {                 //create blank object for input number
    String value;
    char[] digits;
    int base;
}

