package EjerciciosPráctica.semaforoTocho;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Coche extends Thread {


    private final Semaphore semaforo;
    private final int numeroCoche;

    public boolean bucle = true;

    public Coche(Semaphore semaforo, int numeroCoche) {
        this.semaforo = semaforo;
        this.numeroCoche = numeroCoche;
    }
//nueva subida
    public void run() {
        while (bucle == true) {
            try {

                int aleatorio = (int) (Math.random() * 5000);
                System.out.println("el coche" + numeroCoche + " da vueltas durante" + aleatorio + " segundos");
                Thread.sleep(aleatorio);
                System.out.println("el coche " + numeroCoche + "va a intentar entrar al parking");
                System.out.println("Actualmente hay " + semaforo.availablePermits() + " plazas libres  y " + semaforo.getQueueLength() + " coches esperando en la cola");
                if (semaforo.getQueueLength() <= 5) {
                    semaforo.acquire();
                        int aleatorio2 = (int) (Math.random() * 5000);
                        System.out.println("El coche "+numeroCoche+" ha entrado al semaforo , estará durante "+aleatorio2+" ms");
                        System.out.println("actualmetne quedan "+semaforo.availablePermits()+" plazas de parking");
                        Thread.sleep(aleatorio2);
                        semaforo.release();
                    System.out.println("El coche"+numeroCoche+" sale del parking");

                }else{
                    System.out.println("Hay mucha cola en el parking ,mejor damos otra vuelta");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
