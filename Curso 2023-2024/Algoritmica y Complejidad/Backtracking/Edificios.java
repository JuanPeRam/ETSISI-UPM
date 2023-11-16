package Backtracking;

/*
    * Problema del edificio
    * Se debe controlar los accesos a las distintas plantas de un edificio.
    * Para ello se reciben 2 vectores, uno con la solicitud de origen y
    * otro con la solicitud de destino de cada uno de los trabajadores.
    * También se recibirá un número con las plantas.
    * origen = [0,1,3,4,5]
    * destino = [2,0,4,3,3]
     * n = 6
    * res = [F,F,T,T,F]
    * Cada planta está llena, de forma que solo se podrá aprobar aquellas solicitudes que den lugar a un reparto equitativo
    * Ej: [3,4] [4,3]. En este caso ambas solicitudes serán aceptadas
 */
public class Edificios {

    public static void main(String[] args) {
        int n = 6;
        int[] vectorOrigen = { 0, 1, 3, 4, 5 };
        int[] vectorDestino = { 2, 0, 4, 3, 3 };
        boolean[] solicitudes = aprobarSolicitudes(n, vectorOrigen, vectorDestino);
        Impresor.printBooleanArray(solicitudes);
    }

    public static class Entero {
        private int valor;

        public Entero(int valor) {
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }

        public void setValor(int valor) {
            this.valor = valor;
        }
    }

    static boolean[] aprobarSolicitudes(int numEdificios, int[] vectorOrigen, int[] vectorDestino) {
        int[] numPersonas = new int[numEdificios];
        for (int i = 0; i < numPersonas.length; i++)
            numPersonas[i] = 0;
        boolean[] solucion = new boolean[vectorDestino.length];
        boolean[] mejorSolucion = new boolean[vectorDestino.length];
        int solicitudesAprobadas = 0;
        Entero maxSolicitudesAprobadas = new Entero(0);
        int nivel = 0;
        aprobarSolicitudesBack(vectorOrigen, vectorDestino, numPersonas, solucion, mejorSolucion, nivel,
                solicitudesAprobadas, maxSolicitudesAprobadas);
        return mejorSolucion;
    }

    static void aprobarSolicitudesBack(int[] vectorOrigen, int[] vectorDestino, int[] numPersonas, boolean[] solucion,
            boolean[] mejorSolucion, int nivel, int solicitudesAprobadas, Entero maxSolicitudesAprobadas) {
        if (nivel == vectorOrigen.length) {
            if (esSolucion(numPersonas) && solicitudesAprobadas > maxSolicitudesAprobadas.getValor()) {
                maxSolicitudesAprobadas.setValor(solicitudesAprobadas);
                for (int i = 0; i < mejorSolucion.length; i++)
                    mejorSolucion[i] = solucion[i];
            }
        } else {
            int c = 0;
            while (c < 2) {
                solucion[nivel] = (c == 1);
                if (c == 1) {
                    numPersonas[vectorOrigen[nivel]]--;
                    numPersonas[vectorDestino[nivel]]++;
                    solicitudesAprobadas++;
                }
                nivel++;
                aprobarSolicitudesBack(vectorOrigen, vectorDestino, numPersonas, solucion, mejorSolucion, nivel,
                        solicitudesAprobadas, maxSolicitudesAprobadas);
                nivel--;
                solucion[nivel] = false;
                if (c == 1) {
                    numPersonas[vectorOrigen[nivel]]++;
                    numPersonas[vectorDestino[nivel]]--;
                    solicitudesAprobadas--;
                }
                c++;
            }

        }
    }

    static boolean esSolucion(int[] numPersonas) {
        boolean esSolucion = true;
        for (int i = 0; i < numPersonas.length; i++) {
            if (numPersonas[i] != 0)
                esSolucion = false;
        }
        return esSolucion;
    }
}
