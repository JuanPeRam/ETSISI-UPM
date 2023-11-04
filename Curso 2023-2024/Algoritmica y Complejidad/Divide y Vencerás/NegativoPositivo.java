package org.example.Ejercicios.DivideYVencerás;

public class NegativoPositivo {

    public static void main(String[] args) {
        int[] vector = {1,1};
        int pos = negativoPositivo(vector);
        System.out.println("Pos es: "+pos);
    }

    private static int negativoPositivo(int[] vector){
       return negativoPositivoAux(vector,0,vector.length-1);
    }

    private static int negativoPositivoAux(int[] vector, int i0, int iN) {
        if (i0 == iN) return i0;
        else {
            int k = (i0 + iN) / 2;

            if ((k%2)==0 && vector[k]<0 || (k%2)==1 && vector[k]>0){
                return negativoPositivoAux(vector,k+1,iN);
            }
            else return negativoPositivoAux(vector,i0,k);
        }
    }
}
