package EjerciciosPropios.SemaforoSimple1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class MainSemaphore {

private static final int NUMHILOS=10;

private static int PLAZASPARKING=3;
public static void main (String[]args){

Semaphore semaforo = new Semaphore(PLAZASPARKING);
List <Hilos> Arrayhilos = new ArrayList<>();

for(int i = 1;i<=NUMHILOS;i++){
    Hilos hilo = new Hilos(semaforo,i);
    hilo.start();
}
    }
}
