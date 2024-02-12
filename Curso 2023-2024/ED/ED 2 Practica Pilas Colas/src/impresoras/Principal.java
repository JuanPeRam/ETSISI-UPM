package impresoras;

/**
 * @author Estructuras de Datos
 * @version 1.0
 */
public class Principal {
    public static void main(String[] arg) {
        Impresoras prueba = Utilidades.cargaInicial();
        prueba.mostrar();
        for (int i = 0; i < prueba.getCapacidad(); i++)
            prueba.mostrarCola(i);
        System.out.println("Primero insertamos en la cola más corta: " + prueba.insertar(Utilidades.generarNombre()));
        int aux = (int) (Math.random() * prueba.getCapacidad());
        System.out.println("Y luego insertamos en la cola " + aux + ": ");
        prueba.insertar(Utilidades.generarNombre(), aux);
        prueba.mostrar();
        System.out.println("Imprimimos: ");
        prueba.imprimir();
        prueba.mostrar();
    }
}
