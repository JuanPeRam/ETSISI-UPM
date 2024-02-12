package laberinto;

/**
 * @author Estructuras de Datos
 * @version 1.0
 */
public class Laberinto {

    private final int TAMANIO;
    private char[][] tablero;
    private Coordenada entrada, salida;
    private Pila pilaCaminos;
    private boolean[][] visitados;


    public Laberinto(char[][] tablero, Coordenada entrada, Coordenada salida) {
        this.TAMANIO = tablero.length;
        this.tablero = tablero;
        this.entrada = entrada;
        this.salida = salida;
        this.pilaCaminos = new Pila();
        this.visitados = new boolean[TAMANIO][TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                this.visitados[i][j] = false;
            }
        }
    }

    public void mostrar() {
        for (int i = 0; i <= 2*(TAMANIO+1); i++) {
            System.out.print("-");
        }
        System.out.println();
        for (int i = 0; i < TAMANIO; i++) {
            if (i != entrada.getFila()) {
                System.out.print("|");
            } else {
                System.out.print(" ");
            }
            for (int j = 0; j < TAMANIO; j++) {
                System.out.print(" "+tablero[i][j]);
            }
            if (i != salida.getFila()) {
                System.out.println(" |");
            } else {
                System.out.println("  ");
            }
        }
        for (int i = 0; i <= 2*(TAMANIO+1); i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.println();
    }
    private boolean esValida (Coordenada aux) {
        return aux.getFila()>=0 && aux.getFila()< TAMANIO &&  aux.getColumna()>=0 && aux.getColumna()< TAMANIO;
    }
    private boolean visitada (Coordenada aux) {
        return visitados[aux.getFila()][aux.getColumna()];
    }
    private boolean esCamino (Coordenada aux) {
        return tablero[aux.getFila()][aux.getColumna()]==' ';
    }
    private boolean esCaminoValidoNuevo(Coordenada coordenada) {
        // TODO Implementar este método
        boolean esValido = true;

        if( coordenada.getColumna() > tablero.length-1 || coordenada.getColumna() < 0
        || coordenada.getFila() > tablero[0].length-1 || coordenada.getFila() < 0) esValido = false;
        else if(visitados[coordenada.getColumna()][coordenada.getFila()]) esValido = false;
        else if(tablero[coordenada.getColumna()][coordenada.getFila()] == 'X') esValido = false;

        return esValido;
    }

    public boolean existeCamino() {
        // TODO Implementar este método
        return false; // Eliminar el return al implementar el método
    }


}
