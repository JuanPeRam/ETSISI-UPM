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
        return vector[i].getNumElementos();
    }
    public void mostrar () {
        System.out.println("Estado de las colas:");
        for (int i = 0; i < vector.length; i++) {
            System.out.printf("Impresora: %d. Trabajos: %d\n",i,vector[i].getNumElementos());
        }
    }
    public int insertar (String fichero) {
        int posicion = -1;
        for (int i = 0; i < capacidad; i++) {
            if(posicion<0 || getTrabajos(i)<getTrabajos(posicion)) posicion = i;
        }
        vector[posicion].encolar(fichero);
        return posicion;
    }
    public void insertar (String fichero, int posicion) {
        if(posicion>=0 && posicion<capacidad){
            vector[posicion].encolar(fichero);
        }
        else System.err.println("La posición de la cola es incorrecta");
    }
    public void imprimir () {
        for (int i = 0; i < capacidad; i++) {
            String fichero = vector[i].desencolar();
            if(fichero!=null) System.out.println("Se imprime el fichero "+fichero+" en la cola "+i);
        }
    }
    public void mostrarCola (int posicion) {
        if(posicion>=0 && posicion<capacidad){
            vector[posicion].mostrar();
        }
        else System.err.println("La posición de la cola es incorrecta");
    }
}
