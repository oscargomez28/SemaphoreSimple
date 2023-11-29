package EjerciciosPropios.SemaforoSimple1;

import java.util.concurrent.Semaphore;

public class NuevoSemaforo {

    public static int NUMCOCHES = 5;

    public static void main(String[] args) {

        Semaphore semaforo = new Semaphore(1);

        for (int i=0;NUMCOCHES>i;i++){
           HiloNuevo hilo= new HiloNuevo(i,semaforo);
           hilo.start();
        }

    }

}

