public class Alumno {

    private static final int MAX_NUM_ASIGNATURAS = 5;
    private String nombre;
    private String matricula;
    private double calificacion;
    private  String[] asignaturas;
    private  int numAsignaturas;

    public Alumno(){
        calificacion = 0;
        numAsignaturas = 0;
        asignaturas = new String[MAX_NUM_ASIGNATURAS];
        nombre = null;
        matricula = null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalificacion() {
        return calificacion;
    }
    public int getNumAsignaturas() {
        return numAsignaturas;
    }
    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }
    public void matricularAsignatura(String asignatura){
        if(numAsignaturas+1==MAX_NUM_ASIGNATURAS){
            System.out.println("No es posible añadir más asignaturas");
        }
        else {
            asignaturas[numAsignaturas] = asignatura;
            numAsignaturas++;
        }
    }

    public void mostrarAsignaturas(){
        if(numAsignaturas==0){
            System.out.println("No está matriculado en ninguna asignatura");
        }
        else {
            System.out.printf("%d asignaturas:",numAsignaturas);
            for(int i=0;i<numAsignaturas;i++){
                System.out.println("/t- "+asignaturas[i]);
            }
        }
    }

    public void mostrarAlumno(){
        System.out.printf("%s. Matr:%s (%f)",nombre,matricula,calificacion);
        mostrarAsignaturas();
    }

}
