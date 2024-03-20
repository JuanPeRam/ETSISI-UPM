/**
 * Nombre:
 * Apellido:
 * Num. Matrícula:
 */
package listaPaciente;

import general.Paciente;

public class AplicacionLista {
    public static void main(String[] args) {

        ListaOrdinal listaPacientes = new ListaOrdinal();

        Paciente pacienteAlberto = new Paciente("Alberto","Frecuentes mareos");
        Paciente pacienteAna = new Paciente("Ana", "Infección resistente");
        Paciente pacienteEva = new Paciente("Eva", "Problemas digestivos");
        Paciente pacienteErnesto = new Paciente("Ernesto", "Problemas cardiovasculares");

        listaPacientes.insertar(pacienteAlberto);
        listaPacientes.insertar(pacienteAna);
        listaPacientes.insertar(pacienteEva);
        listaPacientes.insertar(pacienteErnesto);

        listaPacientes.get(listaPacientes.posicion("Ana")).darAlta();
        listaPacientes.get(listaPacientes.posicion("Eva")).darAlta();
        System.out.println("PACIENTES DEL HOSPITAL: ");
        printListaPacientes(listaPacientes);

        listaPacientes.borrarAltas();
        printListaPacientes(listaPacientes);

        listaPacientes.insertar(pacienteEva);
        listaPacientes.insertar(pacienteAna);
        verAltas(listaPacientes);

        String sintoma = "mareo";
        ListaOrdinal pacientesConMareo = pacientesSintoma(listaPacientes,sintoma);
        printListaPacientes(pacientesConMareo);


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

    private static void verAltas(ListaOrdinal listaPacientes){
        Iterador iterador = listaPacientes.getIterador();
        Paciente actual;
        while(iterador.hasNext()){
            actual = iterador.next();
            if(actual.estaAlta()) System.out.println(actual);
        }
        System.out.println("----------------------------------");
    }

    private static ListaOrdinal pacientesSintoma(ListaOrdinal lista, String sintoma){
        Iterador iterador = lista.getIterador();
        Paciente actual;
        ListaOrdinal nuevaLista = new ListaOrdinal();
        while(iterador.hasNext()){
            actual = iterador.next();
            if(actual.getSintomas().contains(sintoma)) nuevaLista.insertar(actual);
        }
        return nuevaLista;
    }
}