package org.example.Ejercicios.DivideYVencerás;

public class Enunciado11 {

    public static void main(String[] args) {
        int[] vector = {-10,-2,0,3,7,9,19,28,30,42,55};
        int num = elementoEspecial(vector);
        System.out.println("El numero es: "+num);
    }

    private static int elementoEspecial(int[] vector){
        return elementoEspecialAux(vector,0,vector.length-1);
    }

    private static int elementoEspecialAux(int[] vector, int i0, int iN){
        if(i0==iN) return (vector[i0]==i0? i0: -1);
        else{
            int k = (i0+iN) / 2;

            if(vector[k]==k) return k;
            else if(vector[k]>k) return elementoEspecialAux(vector,i0,k);
            else return elementoEspecialAux(vector,k+1,iN);
        }
    }
}
