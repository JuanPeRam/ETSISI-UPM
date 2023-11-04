package org.example.Ejercicios.DivideYVencerás;

public class Enunciado13 {
    public static void main(String[] args) {
        int[] vector = {1,1,2,3,3,5,5};
        int num = elementoSolitario(vector);
        System.out.println("Valor de num es: "+num);

    }

    private static int elementoSolitario(int[] vector){
        return elementoSolitarioAux(vector,0,vector.length-1);
    }

    private static int elementoSolitarioAux(int[] vector, int i0, int iN){
        if(i0==iN) return vector[i0];
        else{
            int k = (i0+iN) / 2;

            if(vector[k]==vector[k+1]){
                if((k-1-i0+1) % 2 == 0) return elementoSolitarioAux(vector,k+2,iN);
                else return elementoSolitarioAux(vector,i0,k-1);
            }
            else if(vector[k] == vector[k-1]){
                if((k-2-i0+1) % 2 == 0) return elementoSolitarioAux(vector,k+1,iN);
                else return elementoSolitarioAux(vector,i0,k-2);
            }
            else{
                return vector[k];
            }
        }
    }
}
