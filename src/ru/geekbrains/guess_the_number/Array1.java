package ru.geekbrains.guess_the_number;

import java.lang.reflect.Array;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Array1 {
public static boolean i;

    public static void main(String[] args) throws Exception {
int[] arr = new int[]{2,2,2,2,2,2,2,2};
        i = checkArray(arr);
        System.out.println(i);

        int[] a = shiftArray(-2,2,3,4,5,6);
        System.out.println(Arrays.toString(a));
    }

    static int[] shiftArray(int shift, int... numbers) throws Exception {
        if (shift > numbers.length || shift < (0 - numbers.length)){
            throw new Exception("Вне диапозона");
        }


        int[] a = new int[numbers.length];
        if (shift >= 0) {
            int b = 0;
            for (int i = numbers.length - shift; i < numbers.length; i++) {
                a[b] = numbers[i];
                b++;
            }
            for (int i = 0; i < numbers.length - shift; i++) {
                a[b] = numbers[i];
                b++;
            }
        }
        if (shift <= 0) {
            int b = 0;
            for (int i = shift*(-1); i < numbers.length; i++) {
                a[b] = numbers[i];
                b++;
            }
            for (int i = 0; i < shift*(-1); i++) {
                a[b] = numbers[i];
                b++;
            }
        }

        return a;
    }

    static boolean checkArray(int... i) {
        int one = 0;
        int two = 0;
        for (int j = 0; j < i.length; j++) {
            two = two + i[j];
        }
        for (int j = 0; j < i.length; j++) {
            one = one + i[j];


            two = two - i[j];


            if (one == two) {
                return true;
            }
        }
        return false;
    }
}