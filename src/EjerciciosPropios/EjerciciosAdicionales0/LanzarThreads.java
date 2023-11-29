package EjerciciosPropios.EjerciciosAdicionales0;

public class LanzarThreads {

    public static void main ( String []args){
        System.out.println("Soy el hilo principal");
        HiloThread hiloconThread=new HiloThread();
        hiloconThread.start();
        System.out.println("Proceso Creado");
    }
}
