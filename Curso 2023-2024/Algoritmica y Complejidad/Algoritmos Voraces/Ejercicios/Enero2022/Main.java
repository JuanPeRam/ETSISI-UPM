package Enero2022;

import java.util.ArrayList;

public class Main {
    private static final int NUMMAXALUMNOS = 3;

    private static String[][] nombres = {
            { "Juan", "Pereira Rama" },
            { "Pepe", "Rodríguez Pérez" },
            { "Jose", "Pérez" },
            { "Luis", "Rodríguez" },
            { "Rodrigo", "Sánchez Sáez" },
            { "Vicente", "Go Zhu" },
            { "Sergio", "García Muñoz" },
            { "Jorge", "Núñez Feijoo" },
            { "Francisco", "Ayuso" },
            { "Ramón", "Ramírez" },
            { "Luisa", "De la Cruz" },
            { "Vicenta", "Rodríguez Pérez" }
    };

    private static double[] notas = { 7, 6, 5, 9, 5, 5, 6, 6, 5, 9, 6, 6 };

    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        for (int i = 0; i < nombres.length; i++) {
            Estudiante estudiante = new Estudiante(nombres[i][0], nombres[i][1], notas[i]);
            estudiantes.add(estudiante);
        }

        ArrayList<Grupo> grupos = mezclaEstudiantes(estudiantes, NUMMAXALUMNOS);
        for (Grupo grupo : grupos) {
            double sumaNotas = 0;
            for (Estudiante estudiante : grupo.getAlumnos()) {
                sumaNotas += estudiante.getNota();
            }
            System.out.println("La nota media es de: " + sumaNotas / grupo.getAlumnos().size());
        }
    }

    private static ArrayList<Grupo> mezclaEstudiantes(ArrayList<Estudiante> estudiantes,
            int numMaxAlumnos) {
        ArrayList<Grupo> grupos = new ArrayList<>();
        Grupo grupoActual = new Grupo(numMaxAlumnos);
        grupos.add(grupoActual);
        boolean obtenerMayor = true;
        int indiceCandidato;
        while (estudiantes.size() > 0) {
            if (obtenerMayor) {
                indiceCandidato = seleccionarCandidatoMayor(estudiantes);
                obtenerMayor = false;
            } else {
                indiceCandidato = seleccionarCandidatoMenor(estudiantes);
                obtenerMayor = true;
            }
            Estudiante candidato = estudiantes.get(indiceCandidato);
            estudiantes.remove(indiceCandidato);
            if (grupoActual.getAlumnosRestantes() == 0) {
                grupoActual = new Grupo(numMaxAlumnos);
                grupos.add(grupoActual);
            }
            grupoActual.aniadeAlumno(candidato);
        }
        return grupos;
    }

    private static int seleccionarCandidatoMayor(ArrayList<Estudiante> estudiantes) {
        int candidato = 0;
        for (int i = 1; i < estudiantes.size() - 1; i++) {
            if (estudiantes.get(candidato).getNota() < estudiantes.get(i).getNota()) {
                candidato = i;
            }
        }
        return candidato;
    }

    private static int seleccionarCandidatoMenor(ArrayList<Estudiante> estudiantes) {
        int candidato = 0;
        for (int i = 1; i < estudiantes.size() - 1; i++) {
            if (estudiantes.get(candidato).getNota() > estudiantes.get(i).getNota()) {
                candidato = i;
            }
        }
        return candidato;
    }
}
