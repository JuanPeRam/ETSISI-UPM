public class Divisores {
    public void visualizarDivisores(int numero){
        System.out.print("Divisores de "+numero+": ");
        for(int divAux = 2;divAux<numero;divAux++){
            if(numero%divAux == 0){
                System.out.print(divAux+" ");
            }
        }
        System.out.println();
    }
}
