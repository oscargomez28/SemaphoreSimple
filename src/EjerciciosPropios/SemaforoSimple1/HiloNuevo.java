package EjerciciosPropios.SemaforoSimple1;

import java.util.concurrent.Semaphore;

public class HiloNuevo extends Thread {
    private boolean bucle = true;
    private final int i;
    private final Semaphore semaforo;

    public HiloNuevo(int i, Semaphore semaforo) {
        this.i = i;
        this.semaforo = semaforo;
    }

    public void run() {

       while (bucle==true){
           try{
           int aleatorio = (int) (Math.random() * 1000);
           System.out.println("El coche"+i+" recorre la ciudad "+aleatorio+"ms");
               Thread.sleep(aleatorio);

               System.out.println("El coche "+i+" Intenta entrar en el parking");
               System.out.println("Hay "+semaforo.getQueueLength()+" en la cola del semaforo. Plazas libres en el parking "+semaforo.availablePermits());
               int aleatorio2 = (int) (Math.random() * 1000);
               if (semaforo.tryAcquire()) {
                   System.out.println("El coche " + i + " entra al parking y se queda " + aleatorio2 + "ms .El numero de plazas restantes es " + semaforo.availablePermits());
                   Thread.sleep(aleatorio2);
                   System.out.println(" el coche "+i +" sale del parking");
                   semaforo.release();
               }else{
                   System.out.println("No ha entrado nada");
               }


           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }
    }}

