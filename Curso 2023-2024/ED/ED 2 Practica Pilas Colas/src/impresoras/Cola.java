package impresoras;

/**
 * @author Estructuras de Datos
 * @version 1.0
 */
public class Cola {
    private Nodo principio, fin;
    private int numElementos;

    public Cola() {
        principio = null;
        fin = null;
        numElementos = 0;
    }

    public boolean vacia() {   // Comprueba si la cola está vacía

        return principio == null;
    }


    public void encolar(int dato) {    // Coloca el elemento dato al final de la cola
        Nodo nuevo;
        nuevo = new Nodo(dato, null);
        if (principio != null)
            fin.setSiguiente(nuevo);
        else principio = nuevo;
        fin = nuevo;
        numElementos++;
    }

    public int desencolar() {    //Devuelve el elemento del primero de la cola y lo elimina Si la cola está vacía, devuelve como resultado 0 y un mensaje de error
        Nodo nodo;
        int resultado = -9999;
        if (principio == null)
            System.out.println("Error, la cola está vacía");
        else {
            nodo = principio;
            principio = nodo.getSiguiente();
            resultado = nodo.getDato();
            if (principio == null)
                fin = null;
            numElementos--;
        }
        return resultado;
    }

    public void mostrar() {
        Nodo auxiliar;
        System.out.println("Contenido de la cola: ");
        auxiliar = principio;
        while (auxiliar != null) {
            System.out.print(auxiliar.getDato() + "  ");
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println();
    }

    public int getNumElementos() {       // Devuelve el número de elementos de la cola
        return numElementos;
    }

}
