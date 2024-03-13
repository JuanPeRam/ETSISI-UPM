/**
 * Nombre:
 * Apellido:
 * Num. Matrícula:
 */

package colaPaciente;

public class Cola {
    private Nodo principio, fin;
    private int numElementos;

    Cola() {
        principio = null;
        fin = null;
        numElementos = 0;
    }

    public void encolar(int v) {    // Coloca el elemento v al final de la cola
        Nodo nuevo;
        nuevo = new Nodo(v, null);
        if (principio != null) {
            fin.setSiguiente(nuevo);
        } else {
            principio = nuevo;
        }
        fin = nuevo;
        numElementos++;
    }

    public int desencolar() {    //Devuelve el elemento del cabeza de la cola y lo elimina Si la cola está vacía, devuelve como resultado 0 y un mensaje de error
        Nodo nodo;
        int resul = 0;
        if (principio == null) {
            System.out.println("Error, la cola está vacía");
        } else {
            nodo = principio;
            principio = nodo.getSiguiente();
            resul = nodo.getDato();
            if (principio == null)
                fin = null;
            numElementos--;
        }
        return resul;
    }

    public boolean vacia() {   // Comprueba si la cola está vacía
        return principio == null;
    }



    public int getPrimero() {  //Devuelve el elemento del cabeza de la cola Si la cola está vacía, devuelve como resultado -999 y un mensaje de error
        int resul = -999;
        if (!this.vacia()) {
            resul = principio.getDato();
        } else {
            System.out.println("Error, la cola está vacía");
        }
        return resul;

    }

    public void mostrar() {     // Muestra por pantalla el contenido de la cola
        Nodo aux;
        aux = principio;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
    }

    public int getNumElementos() {       // Devuelve el número de elementos de la cola
        return numElementos;
    }
}


