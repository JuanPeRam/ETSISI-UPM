package org.example.Ejercicios.Backtracking;

/*
* Problema de las galletas
* Tenemos un array con bolsas de galletas //Ej: [10,5,7,8] k=3
* Se deberá repartir entre k niños, de forma que se reparta de la forma más equitativa posible.
* Para ello el valor máximo de galletas correspondientes deberá ser mínimo.
* -----------------------------------------------------------------------------------------------
 */
public class Galleta {
    public static void main(String[] args) {
        int[] vectorGalletas = {10,5,7,8};
        int numNinos = 3;
        int[] reparto = repartirGalletas(vectorGalletas,numNinos);
        for(int i=0;i<reparto.length;i++){
            System.out.print(reparto[i]+" ");
        }
    }

    static int[] repartirGalletas(int[] vectorGalletas, int numNinos){
        int nivel = 0;
        int[] solucion = new int[numNinos];
        int[] mejorSolucion = new int[numNinos];
        for(int i=0;i<mejorSolucion.length;i++){
            mejorSolucion[i] = Integer.MAX_VALUE;
        }
        int max = 0;
        Entero maxMejorSolucion = new Entero(Integer.MAX_VALUE);
        repartirGalletasBack(vectorGalletas,nivel,solucion,mejorSolucion,max,maxMejorSolucion);
        return mejorSolucion;
    }

    static void repartirGalletasBack(int[] vectorGalletas, int nivel, int[] solucion, int[] mejorSolucion, int maxSolucion, Entero maxMejorSolucion){
        if(nivel==vectorGalletas.length){
            if(maxSolucion<maxMejorSolucion.getValor()){
                for(int i=0;i<mejorSolucion.length;i++) mejorSolucion[i] = solucion[i];
                maxMejorSolucion.setValor(maxSolucion);
            }
        }
        else{
            for(int c=0;c<solucion.length;c++){
                if(maxSolucion<maxMejorSolucion.getValor()){
                    solucion[c]+=vectorGalletas[nivel];
                    int ultimoMax = maxSolucion;
                    if(solucion[c]>maxSolucion) maxSolucion = solucion[c];
                    nivel++;
                    repartirGalletasBack(vectorGalletas,nivel,solucion,mejorSolucion,maxSolucion,maxMejorSolucion);
                    nivel--;
                    if(solucion[c]==maxSolucion) maxSolucion = ultimoMax;
                    solucion[c]-=vectorGalletas[nivel];
                }
            }
        }
    }
}
