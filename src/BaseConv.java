//import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;

//import kotlin.MathKt;

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
    //TODO: try/catch for legit old and new bases
//TODO: check that input num is that base, ask for return base, convert & return
//TODO: do I need separate files? integration with Spring/firebase

        String valueClone = inputNum.value;
        for (int i = inputNum.digits.length - 1; i>=0; i--) {
            inputNum.digits[i] = valueClone.charAt(0);
            valueClone = valueClone.substring(1);
        }
        convertDown(inputNum);

    }


    static long convertToDec(Number inNum){
        long total = 0;

        for(int j = 0; j < inNum.digits.length; j++){
            total += Math.pow(inNum.base, j) * Character.getNumericValue(inNum.digits[j]);
        }
        return total;
    }


    static String decToBase(int newBase, long decNum){
//TODO: make this method do things!
        return "73E";
    }


    static void convertDown(Number inNum){
/*TODO: add one to 'tens' digit everytime base is subtracted from total dec value of
 TODO: leftover -> ones digit, check that each digit is under newBase
 need more efficient idea than this, but it should work
*/
        for(int i = 0; i<inNum.digits.length; i++){
    //TODO: assign another array [i] = decimal versions of digits
    //if otherarray [i] >= newBase, subtract newBase & add 1 to 'tens' digit
        }
        //long inValue = inNum.value;
        long[] newDigs = new long[3];
        newDigs[0] = 32;
//        while(inValue>=inNum.base){
//
//        }
        for(int i = 0; i < newDigs.length; i++){   //make this printArray method?
            System.out.print(newDigs[i]);
        }
    }


}



class Number {                 //create blank object for input number
    String value;
    char[] digits;

    int base;
}

