package EjerciciosPropios.SemaforoComplexParking1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class CentroComercial {

    public static  int  NUM_COCHES=10;

        public static  int PLAZAS_PARKING=3;



    public static void main (String []args) throws InterruptedException {
    Semaphore semaforo = new Semaphore(PLAZAS_PARKING);
        List<Coche> listaCoches = new ArrayList<>();

        for (int numeroCoche=1;numeroCoche<=NUM_COCHES;numeroCoche++){

            Coche coche = new Coche(semaforo,numeroCoche);
            coche.start();
            listaCoches.add(coche);
        }




    }
}
