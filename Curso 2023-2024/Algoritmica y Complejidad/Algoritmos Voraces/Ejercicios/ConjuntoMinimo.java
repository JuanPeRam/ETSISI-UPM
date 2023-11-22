import java.lang.reflect.Array;
import java.util.ArrayList;

public class ConjuntoMinimo {

    public static class Conjunto {
        private int[] contenido;
        public Conjunto(int[] contenido){
            this.contenido = new int[contenido.length];
            for (int i=0; i<contenido.length; i++) this.contenido[i]=contenido[i];
        }
        public int longitud(){ return this.contenido.length; }
        public int get(int posicion){ return contenido[posicion]; }
    }

    public static void main(String[] args) {
        int[] U = {1,2,0,3,4,5};
        ArrayList<Conjunto> subConjuntos = new ArrayList<>();
        int[][] s = {
                {1,2},
                {2,4},
                {0,3,4},
                {4,5}
        };
        for(int i=0;i<s.length;i++){
            Conjunto c = new Conjunto(s[i]);
            subConjuntos.add(c);
        }
        ArrayList<Conjunto> conjuntoMin = conjuntoMinimo(U,subConjuntos);
        for(Conjunto c:conjuntoMin){
            for(int i=0;i<c.longitud();i++){
                System.out.print(c.get(i));
            }
            System.out.println();
        }

    }

    static ArrayList<Conjunto> conjuntoMinimo(int[] U, ArrayList<Conjunto> S){
        ArrayList<Conjunto> conjuntoMin = new ArrayList<>();
        Conjunto candidato;
        while(S.size()>0){
            candidato = S.get(0);
            S.remove(0);
            if(esSubConjunto(U,candidato)){
                conjuntoMin.add(candidato);
            }
        }
        return conjuntoMin;
    }

    static boolean esSubConjunto(int[] U, Conjunto c){
        int coincidente = 0;
        boolean esSubConjunto = true;
        for(int i=0;i<U.length;i++){
            boolean encontrado = false;
            for(int s=0;s<c.longitud();s++){
                if(U[i] == c.get(s)){
                    coincidente++;
                    encontrado = true;
                }
            }
            if(!encontrado && coincidente>0 && coincidente<c.longitud()) esSubConjunto = false;
        }
        if(coincidente==0) esSubConjunto = false;
        return esSubConjunto;
    }
}
