package EjerciciosPropios.SemaforoComplexParking1;

import java.util.concurrent.Semaphore;

public class Coche extends Thread{
    public  boolean expulsado = false;

    int numeroCoche;

    public boolean isExpulsado() {
        return expulsado;
    }

    public void setExpulsado(boolean expulsado) {
        this.expulsado = expulsado;
    }

    private Semaphore semaforo;

    public Coche(Semaphore semaforo, int numeroCoche) {
        this.semaforo = semaforo;
        this.numeroCoche = numeroCoche;
    }

  public void run() {

        while(true&&expulsado!=true){
            int aleatorio = (int) (Math.random() * 5000);
            System.out.println("El coche "+numeroCoche+" va a dar vueltas "+aleatorio+"ms");
            try {
                Thread.sleep(aleatorio);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Actualmente hay una cola de "+semaforo.getQueueLength()+" Coches y "+ semaforo.availablePermits()+" tickets");
            System.out.println("El coche "+numeroCoche+" Va a intentar entrar al parking");
            if (semaforo.getQueueLength()<5){
                try {
                    semaforo.acquire();
                } catch (InterruptedException e) {
                    System.out.println("EL COCHE "+numeroCoche+" HA SIDO DESPERTADO");
                }
                System.out.println("El coche "+numeroCoche+" Está dentro del parquing , dormirá "+aleatorio);
                try {
                    Thread.sleep(aleatorio);
                } catch (InterruptedException e) {
                    System.out.println("EL COCHE "+numeroCoche+" HA SIDO DESPERTADO");
                }
                System.out.println("Quedan libres "+semaforo.availablePermits()+" tickets de entrada");
                System.out.println("El coche "+numeroCoche+" Sale del parking");
                semaforo.release();
            }else{
                System.out.println("el coche "+numeroCoche +" sigue dando vueltas , la cola del hilo está llena");
            }

        }
      System.out.println("SE HA ACABADO EL SEMAFORO");
  }
}
