package org.example.Ejercicios.Backtracking;

public class RepartoLudovicoCarloMagno {

    public static void main(String[] args) {
        int[] bienes = {4,4,4,1,1,1};
        Impresor.printBoolean(hayRepartoEquitativo(bienes));
    }

    static boolean hayRepartoEquitativo(int[] bienes){
        Booleano exito = new Booleano(false);
        int[] reparto = new int[3];
        for(int i=0;i<reparto.length;i++) reparto[i] = 0;
        int nivel = 0;
        hayRepartoEquitativoBack(bienes,reparto,nivel,exito);
        return exito.isValor();
    }

    static void hayRepartoEquitativoBack(int[] bienes, int[] reparto, int nivel, Booleano exito){
        if(nivel==bienes.length) {
            System.out.println("Reparto parcial: "+reparto[0]+","+reparto[1]+" "+reparto[2]);
            if (reparto[0] == reparto[1] && reparto[1] == reparto[2]){
                exito.setValor(true);
            }
        }
        else{
            int c = 0;
            while(c<3 && !exito.isValor()){
                reparto[c]+=bienes[nivel];
                nivel++;
                hayRepartoEquitativoBack(bienes,reparto,nivel,exito);
                if(!exito.isValor()){
                    nivel--;
                    reparto[c]-=bienes[nivel];
                }
                c++;
            }
        }
    }


}
