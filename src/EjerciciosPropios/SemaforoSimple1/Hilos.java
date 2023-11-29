package EjerciciosPropios.SemaforoSimple1;

import java.util.concurrent.Semaphore;

public class Hilos extends Thread{


    private final int numeroCoche;
    boolean bucle =true;


    private final Semaphore semaforo;

    public Hilos(Semaphore semaforo, int numeroCoche){
        this.semaforo = semaforo;
        this.numeroCoche = numeroCoche;
    }
public void run() {
    while (bucle == true) {
        int randomNumber = 1000;
        try {
            int aleatorio = (int) (Math.random() * 1000);
            System.out.println("El coche " + numeroCoche + " recorre la ciudad " + aleatorio + "ms.");

            Thread.sleep(aleatorio);

            System.out.println("El coche " + numeroCoche + " intenta entrar al parking.");

            // queuelength nos dice los hilos esperando a un semaforo
            System.out.println("Hay " + semaforo.getQueueLength() + " coches en la cola del semaforo. Plazas libres en el parking: " +semaforo.availablePermits());
                // Cogemos el semaforo
                semaforo.acquire();
                aleatorio = (int) (Math.random() * 1000);
                System.out.println("El coche " + numeroCoche + " entra al parking y se queda " + aleatorio + "ms. El número de plazas restantes es: " + semaforo.availablePermits());
                Thread.sleep(aleatorio);
                // Liberamos el semaforo
                semaforo.release();
                System.out.println("El coche " + numeroCoche + " sale del parking ");


} catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
}



