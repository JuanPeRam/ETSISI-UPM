package Diciembre2019;

import java.util.ArrayList;

public class Reparto {

    private static int[][] nombresPesos = {
            { 1, 20 }, { 2, 30 }, { 3, 10 }, { 4, 50 }, { 5, 30 }, { 6, 90 }, { 7, 33 }, { 8, 15 }, { 9, 28 },
            { 10, 12 }
    };

    public static void main(String[] args) {
        ArrayList<Producto> productos = new ArrayList<>();
        for (int i = 0; i < nombresPesos.length; i++) {
            Producto p = new Producto(nombresPesos[i][0], nombresPesos[i][1]);
            productos.add(p);
        }

        ArrayList<Producto> n1 = new ArrayList<>();
        ArrayList<Producto> n2 = new ArrayList<>();
        ArrayList<Producto> n3 = new ArrayList<>();

        distribuyeCarga(productos, n1, n2, n3);

        System.out.println("Contenido de la caja 1:");
        printProductos(n1);
        System.out.println("Contenido de la caja 2:");
        printProductos(n2);
        System.out.println("Contenido de la caja 3:");
        printProductos(n3);

    }

    static void printProductos(ArrayList<Producto> productos) {

        for (Producto producto : productos) {
            System.out.println("Producto " + producto.getNombre() + " con peso " + producto.getPeso());
        }
        System.out.println("Fin del contenido");

    }

    static void distribuyeCarga(ArrayList<Producto> productos, ArrayList<Producto> n1,
            ArrayList<Producto> n2, ArrayList<Producto> n3) {
        int candidato;
        int sumaN1 = 0, sumaN2 = 0, sumaN3 = 0;
        while (productos.size() > 0) {
            candidato = seleccionarCandidato(productos);
            Producto pCandidato = productos.get(candidato);
            productos.remove(candidato);

            int minValor = Math.min(sumaN1, Math.min(sumaN2, sumaN3));
            if (minValor == sumaN1) {
                n1.add(pCandidato);
                sumaN1 += pCandidato.getPeso();
            } else if (minValor == sumaN2) {
                n2.add(pCandidato);
                sumaN2 += pCandidato.getPeso();
            } else {
                n3.add(pCandidato);
                sumaN3 += pCandidato.getPeso();
            }
        }
    }

    static int seleccionarCandidato(ArrayList<Producto> productos) {
        int candidato = 0;
        for (int i = 1; i < productos.size() - 1; i++) {
            if (productos.get(candidato).getPeso() < productos.get(i).getPeso()) {
                candidato = i;
            }
        }
        return candidato;
    }
}
