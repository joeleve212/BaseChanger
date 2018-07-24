//import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

import kotlin.MathKt;

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
        for (int i = inputNum.digits.length - 1; i>=0; i--) {
            inputNum.digits[i] = valueClone.charAt(0);
            valueClone = valueClone.substring(1);
        }
        long decNum = convertToDec(inputNum);
        System.out.println(convertToDec(inputNum));

    }
    static long convertToDec(Object inNum){
        long total = 0;
        for(int i = 0; i < inNum.digits.length; i++){
    //TODO: check for and convert letters. convert all to nums instead of chars
            total += Math.pow(inNum.base, i) * inNum.digits[i];
        }
        return total;
//TODO: make this method do things!

    }
    static String convertToBase(int newBase, long decNum){
//TODO: make this method do things!
        return "73E";
    }
    static String fullConvert(Object inNum){
        return inputNum.value;
    }
}

class Number {                 //create blank object for input number
    String value;
    char[] digits;
    int base;
}

