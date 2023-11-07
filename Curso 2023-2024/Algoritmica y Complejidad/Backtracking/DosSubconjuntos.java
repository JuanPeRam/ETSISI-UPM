package org.example.Ejercicios.Backtracking;


public class DosSubconjuntos {

    public static void main(String[] args) {
        int[] vector = {5,3,2,2};
        int vObjetivo = 10;
        Impresor.printBoolean(dosSubconjuntos(vector,vObjetivo));
    }

    static boolean dosSubconjuntos(int[] v, int vObjetivo){
        Booleano exito = new Booleano(false);
        int nivel = 0;
        Entero soluciones = new Entero(0);
        dosSubconjuntosBack(v,soluciones,exito,nivel,vObjetivo);
        return exito.isValor();
    }

    static void dosSubconjuntosBack(int[] v, Entero soluciones, Booleano exito, int nivel, int falta){
        if(nivel==v.length){
            if(falta==0){
                soluciones.setValor(soluciones.getValor()+1);
                if(soluciones.getValor()==2) exito.setValor(true);
            }
        }
        else{
            int c = 0;
            while(c<2 && !exito.isValor()){
                if(c==0 || (falta-v[nivel])>=0){
                    falta-=v[nivel]*c;
                    nivel++;
                    dosSubconjuntosBack(v,soluciones,exito,nivel,falta);
                    if(!exito.isValor()){
                        nivel--;
                        falta+=v[nivel]*c;
                    }
                }
                c++;
            }
        }
    }
}
