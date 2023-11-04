package org.example.Ejercicios.DivideYVencerás;

public class Enunciado12 {
    public static void main(String[] args) {
        int[] vector = {-13,2};
        int num = primerPositivoEnPolarizado(vector);
        System.out.println("Num es: "+num);
    }

    private static int primerPositivoEnPolarizado(int[] vector) {
        if(vector[0]>0) return 0;
        else if(vector[vector.length-1]<0) return -1;
        return primerPositivoEnPolarizadoAux(vector,0,vector.length-1);
    }

    private static int primerPositivoEnPolarizadoAux(int[] vector, int i0, int iN){
        if(i0==iN){
            return i0;
        }
        else{
            int k = (i0+iN) / 2;
            if(vector[k]>0) return primerPositivoEnPolarizadoAux(vector,i0,k);
            else return primerPositivoEnPolarizadoAux(vector,k+1,iN);
        }
    }
}
