package org.example.Ejercicios.DivideYVencerás;

public class Enunciado14 {

    public static void main(String[] args) {
        int[] vector1 = {1,1,1,1,1,0,1}; // Sol = 5
        int[] vector2 = {0,0,0,0,1,1,1}; // Sol = 3
        int[] vector3 = {1,1,1,1,0,1,1,1,1,1,0}; // Sol = 5
        int[] vector4 = {0,0,0,0}; // Sol = 0
        int[] vector5 = {1,0,1,0,1,0,1,0,1,0,1}; //Sol = 1

        int sol1 = oneSubArray(vector1);
        int sol2 = oneSubArray(vector2);
        int sol3 = oneSubArray(vector3);
        int sol4 = oneSubArray(vector4);
        int sol5 = oneSubArray(vector5);


        System.out.println("Solución de sol1: "+sol1);
        System.out.println("Solución de sol2: "+sol2);
        System.out.println("Solución de sol3: "+sol3);
        System.out.println("Solución de sol4: "+sol4);
        System.out.println("Solución de sol5: "+sol5);
    }

    private static int oneSubArray(int[] vector){
        return oneSubArrayAux(vector,0,vector.length-1);
    }

    private static int oneSubArrayCruzada(int[] vector, int i0, int k, int iN){
        int i = k;
        int len_i = 0;
        int len_j = 0;

        while(i>=i0 && vector[i]==1){
            i--;
            len_i++;
        }

        int j = k+1;

        while(j<=iN && vector[j]==1){
            j++;
            len_j++;
        }

        return len_i+len_j;
    }

    private static int oneSubArrayAux(int[] vector, int i0, int iN){
        if(i0==iN) return vector[i0];

        else {
            int k = (i0+iN) / 2;

            int m1 = oneSubArrayAux(vector,i0,k);
            int m2 = oneSubArrayAux(vector,k+1,iN);
            int m3 = oneSubArrayCruzada(vector,i0,k,iN);

            return Math.max(m1,Math.max(m2,m3));
        }
    }
}
