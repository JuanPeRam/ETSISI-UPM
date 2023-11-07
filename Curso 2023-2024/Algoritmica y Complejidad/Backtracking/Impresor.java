package org.example.Ejercicios.Backtracking;

public class Impresor {

    public static void printBooleanArray(boolean[] array){
        System.out.print("[");
        for(int i=0;i<array.length;i++){
            printBoolean(array[i]);
            if(i<array.length-1) System.out.print(",");
        }
        System.out.print("]");
    }

    public static void printIntegerArray(int[] array){
        System.out.print("[");
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]);
            if(i<array.length-1) System.out.print(",");
        }
        System.out.print("]");
    }

    public static void printBoolean(boolean value){
        System.out.print(value?"V":"F");
    }
}
