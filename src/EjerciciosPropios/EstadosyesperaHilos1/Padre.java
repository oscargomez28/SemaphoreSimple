package EjerciciosPropios.EstadosyesperaHilos1;

public class Padre {

    public static void main(String[]args) throws InterruptedException {

        Hijo hilo = new Hijo();

        System.out.println("El estado del hilo es "+hilo.getState());
        hilo.start();
        System.out.println("El estado del hilo empezado es "+hilo.getState());
        hilo.join(2000);
        System.out.println("El estado con join es y 2000 milis es "+hilo.getState());
        if(hilo.getState()== Thread.State.TIMED_WAITING) {hilo.interrupt();
        }
        System.out.println("EL programa ha acabado");
    }
}
