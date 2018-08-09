/*
    Purpose: convert numbers between bases, then adapt to use as backend of a web app
    Author: Joe Leveille
 */

//import kotlin.MathKt;                        //kotlin imports here by default, but don't seem to be helpful
//import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType;
//import java.util.Arrays;            //This import is unnecessary now that I use arrayLists in decToBase()

import java.util.*;
import java.util.List;
import java.util.Scanner;
public class BaseConv {
    public static void main(String[] args) {
        Scanner a = new Scanner(System.in);
        System.out.print("Number to convert: ");                    //Prompts and collects data for conversion
        Number inputNum = new Number();                             //initialize object to store input data
        inputNum.value = a.next().toUpperCase();
        inputNum.digits = new char[inputNum.value.length()];                    //assigns empty digits[] length equal to # of input digits
        System.out.println("What base is your input value? (2-36 is all valid) ");
        inputNum.base = a.nextInt();
        if(inputNum.base < 2 || inputNum.base>36){                  //check that all bases are limited to decimal digits + letters
            throw new IllegalArgumentException
                    ("Illegal base!");
        }
        System.out.println("What is the desired output base? (2-36 is all valid) ");
        inputNum.newBase = a.nextInt();
        if(inputNum.newBase < 2 || inputNum.newBase>36){
            throw new IllegalArgumentException
                    ("Illegal base!");
        }
    //TODO: try/catch for legit old and new bases
//TODO: check that input num is that base, ask for return base, convert & return
//TODO: do I need separate files? integration with Spring/firebase
//TODO: allow for larger nums by using longs?
//possible TODO: allow roman numerals (could handle in front end?)
        String valueClone = inputNum.value;
        for (int i = inputNum.digits.length - 1; i>=0; i--) {                   //populate digits[]
            inputNum.digits[i] = valueClone.charAt(0);
            valueClone = valueClone.substring(1);
            if(inputNum.digits[i] >= inputNum.base){
                throw new IllegalArgumentException
                        ("The input number does not match the input base");
            }
        }

        System.out.println(convertToDec(inputNum));                             //print decimal as midpoint check
        System.out.println(decToBase(inputNum.newBase, convertToDec(inputNum)));//print final converted num
    }

    static long convertToDec(Number inNum){
        long total = 0;
        for(int j = 0; j < inNum.digits.length; j++){
            total += Math.pow(inNum.base, j) * Character.getNumericValue(inNum.digits[j]);
        }
        return total;
    }

    static String decToBase(int newBase, long decNum){
/*
ArrayList used instead of Array b/c constant error that numerous Array
methods did not exist, despite the use of importing java.util.Arrays && java.util.*
*/
        List<Integer> newDigs = new ArrayList<Integer>();
        int mod;                                        //initialized outside of loop to avoid redundancy
        while(decNum >= newBase){
            mod = (int) (decNum % newBase);
            newDigs.add(mod);
            decNum /= newBase;
        }
        newDigs.add((int) decNum);
        String out = "";
        for(int i = newDigs.size() - 1; i>=0; i--){     //loop to transfer arrayList digits to string output
            if(newDigs.get(i)>9){                       //check for digits that are unused in decimal
                out += (char) (newDigs.get(i) + 54);    //int can be casted to char using ASCII keycodes
            }
            else {
                out += newDigs.get(i).toString();
            }
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

