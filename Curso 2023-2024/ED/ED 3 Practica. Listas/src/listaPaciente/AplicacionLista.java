/**
 * Nombre:
 * Apellido:
 * Num. Matrícula:
 */
package listaPaciente;

import general.Paciente;

public class AplicacionLista {

    private static final Paciente[] pacientesPrueba = {
            new Paciente("Alberto","Frecuentes mareos"),
            new Paciente("Ana", "Infección resistente"),
            new Paciente("Eva", "Problemas digestivos"),
            new Paciente("Ernesto", "Problemas cardiovasculares")
    };
    public static void main(String[] args) {

        ListaOrdinal listaPacientes = new ListaOrdinal();
        for(Paciente paciente : pacientesPrueba) {
            listaPacientes.insertar(paciente);
        }
        listaPacientes.get(listaPacientes.posicion("Ana")).darAlta();
        listaPacientes.get(listaPacientes.posicion("Eva")).darAlta();
        System.out.println("PACIENTES DEL HOSPITAL: ");
        printListaPacientes(listaPacientes);

    }

    private static void printListaPacientes(ListaOrdinal listaPacientes){
        Iterador iterador = listaPacientes.getIterador();
        Paciente actual;
        while(iterador.hasNext()){
            actual = iterador.next();
            System.out.println(actual.toString());
        }
        System.out.println("----------------------------------");
    }
}