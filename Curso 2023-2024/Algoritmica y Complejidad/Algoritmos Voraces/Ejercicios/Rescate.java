import java.util.ArrayList;

public class Rescate {
    static class Contenedor{
        private int tiempo; // tiempo en minutos que se tarda en recuperar el contenedor
        private int dias; //número de días que proporciona alimento
        public Contenedor(int tiempo, int dias){
            this.tiempo = tiempo;
            this.dias = dias;
        }
        // Métodos get/set de las propiedades de la clase


        public int getDias() {
            return dias;
        }

        public int getTiempo() {
            return tiempo;
        }

        public void setDias(int dias) {
            this.dias = dias;
        }

        public void setTiempo(int tiempo) {
            this.tiempo = tiempo;
        }
    }

    public static void main(String[] args) {
        Contenedor c1 = new Contenedor(15,2);
        Contenedor c2 = new Contenedor(12,9);
        Contenedor c3 = new Contenedor(20,5);
        Contenedor c4 = new Contenedor(33,13);
        Contenedor c5 = new Contenedor(1,1);
        Contenedor c6 = new Contenedor(12,5);
        ArrayList<Contenedor> contenedores = new ArrayList<>();
        contenedores.add(c1);
        contenedores.add(c2);
        contenedores.add(c3);
        contenedores.add(c4);
        contenedores.add(c5);
        contenedores.add(c6);
        int hundir = 20;
        ArrayList<Contenedor> rescatados = rescate(contenedores,hundir);
        for(Contenedor contenedor : rescatados){
            System.out.println("Contenedor con contenido para "+contenedor.getDias()+" días rescatado en "+contenedor.getTiempo()+" minutos");
        }

    }

    private static ArrayList<Contenedor> rescate(ArrayList<Contenedor> contenedores, int hundir){
        ArrayList<Contenedor> rescatados = new ArrayList<>();
        int tiempoGastado = 0;
        int indiceCandidato;
        while(tiempoGastado<hundir && contenedores.size()>0){
            indiceCandidato = seleccionarCandidato(contenedores);
            Contenedor candidato = contenedores.get(indiceCandidato);
            contenedores.remove(indiceCandidato);
            if(candidato.getTiempo()+tiempoGastado <= hundir){
                tiempoGastado+=candidato.getTiempo();
                rescatados.add(candidato);
            }
        }
        return rescatados;
    }

    private static int seleccionarCandidato(ArrayList<Contenedor> contenedores){
        int candidato = 0;
        for(int i=1;i<contenedores.size();i++){
            if(contenedores.get(candidato).getDias()<contenedores.get(i).getDias()){
                candidato = i;
            }
            else if(contenedores.get(candidato).getDias()==contenedores.get(i).getDias()){
                if(contenedores.get(candidato).getTiempo()>contenedores.get(i).getTiempo()){
                    candidato = i;
                }
            }
        }
        return candidato;
    }
}
