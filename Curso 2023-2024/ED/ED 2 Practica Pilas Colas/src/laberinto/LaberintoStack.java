package laberinto;

/**
 * @author Estructuras de Datos
 * @version 1.0
 */
import java.util.EmptyStackException;
import java.util.Stack;

public class LaberintoStack {
    private final int TAMANIO;
    private char[][] tablero;
    private Coordenada entrada, salida;
    private boolean[][] visitados;
    private Stack<Coordenada> pilaCaminos;


    public LaberintoStack(char[][] tablero, Coordenada entrada, Coordenada salida) {
        this.TAMANIO = tablero.length;
        this.tablero = tablero;
        this.entrada = entrada;
        this.salida = salida;
        this.visitados = new boolean[TAMANIO][TAMANIO];
        for (int i = 0; i < TAMANIO; i++) {
            for (int j = 0; j < TAMANIO; j++) {
                this.visitados[i][j] = false;
            }
        }
        this.pilaCaminos = new Stack<>();

    }

    public void mostrar() {
        for (int i = 0; i <= 2*(TAMANIO + 1); i++) {
            System.out.print("_");
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
        for (int i = 0; i <= 2*(TAMANIO + 1); i++) {
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
        boolean esValido = true;

        if( !esValida(coordenada)) esValido = false;
        else if(visitada(coordenada)) esValido = false;
        else if(!esCamino(coordenada)) esValido = false;

        return esValido;
    }

    public boolean existeCamino() {
        Coordenada actual = entrada;
        boolean hayCamino = false;
        visitados[actual.getFila()][actual.getColumna()] = true;
        while(actual!=null && !hayCamino){
            if(actual.iguales(salida)) {
                hayCamino = true;
                continue;
            };
            Coordenada izquierda = actual.izquierda();
            Coordenada arriba = actual.arriba();
            Coordenada abajo = actual.abajo();
            Coordenada derecha = actual.derecha();

            if(esCaminoValidoNuevo(izquierda)) {
                pilaCaminos.push(izquierda);
                visitados[izquierda.getFila()][izquierda.getColumna()] = true;
            };
            if(esCaminoValidoNuevo(arriba)) {
                pilaCaminos.push(arriba);
                visitados[arriba.getFila()][arriba.getColumna()] = true;
            };
            if(esCaminoValidoNuevo(abajo)) {
                pilaCaminos.push(abajo);
                visitados[abajo.getFila()][abajo.getColumna()] = true;
            };
            if(esCaminoValidoNuevo(derecha)) {
                pilaCaminos.push(derecha);
                visitados[derecha.getFila()][derecha.getColumna()] = true;
            };
            try{
                actual = pilaCaminos.pop();
            } catch(EmptyStackException exception){
                actual = null;
            }
        }
        return hayCamino;
    }





}