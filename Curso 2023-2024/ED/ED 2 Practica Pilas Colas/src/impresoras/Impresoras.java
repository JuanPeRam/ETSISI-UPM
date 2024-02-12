package impresoras;

/**
 * @author Estructuras de Datos
 * @version 1.0
 */
public class Impresoras {
    private int capacidad;
    private Cola [] vector;

    public Impresoras(int capacidad) {
        this.capacidad = capacidad;
        vector = new Cola [capacidad];
        for (int i = 0; i < capacidad; i++)
            vector[i] = new Cola();
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getTrabajos (int i) {
        // TODO Implementar este método
        return 0;
    }
    public void mostrar () {
        // TODO Implementar este método
    }
    public int insertar (String fichero) {
        int posicion = -1;
        // TODO Implementar este método
        return posicion;
    }
    public void insertar (String fichero, int posicion) {
        // TODO Implementar este método
    }
    public void imprimir () {
        // TODO Implementar este método
    }
    public void mostrarCola (int posicion) {
        // TODO Implementar este método
    }
}
