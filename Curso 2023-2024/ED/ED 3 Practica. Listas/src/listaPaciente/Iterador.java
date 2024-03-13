/**
 * Nombre:
 * Apellido:
 * Num. Matrícula:
 */

package listaPaciente;

class Iterador {
    private Nodo actual;

    public Iterador(Nodo comienzo) {
        actual = comienzo;
    }

    public boolean hasNext() {
        return actual != null;
    }

    public int next() {
        int resultado = actual.getDato();
        actual = actual.getSiguiente();
        return resultado;
    }
}
