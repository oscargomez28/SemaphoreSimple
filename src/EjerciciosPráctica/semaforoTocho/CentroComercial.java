package EjerciciosPráctica.semaforoTocho;

import java.util.concurrent.Semaphore;

public class CentroComercial {
public static final int NUMPLAZAS = 2;

public static final int COCHESTOTALES=10;

    public static void main (String[]args){
        Semaphore semaforo = new Semaphore(NUMPLAZAS);

        for(int i=1;i<=COCHESTOTALES;i++){

            Coche coche = new Coche(semaforo,i);
            coche.start();
        }
    }
}
