package PruebasPDF.EsperaHilos;

public class Hijo extends Thread {


    @Override
    public void run(){
        System.out.println("Hola soy el hilo");

            try{
                Thread.sleep((5000));
                System.out.println("Adios , soy un hilo ");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
