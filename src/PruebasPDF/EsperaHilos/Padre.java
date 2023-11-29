package PruebasPDF.EsperaHilos;

public class Padre extends  Thread{


    public static void main (String[]args){
        Hijo hiloespera = new Hijo();



        State estado = hiloespera.getState();
        System.out.println("Estado del hilo inicializado "+estado);

        hiloespera.start();

        State estadoDespues = hiloespera.getState();
        System.out.println("Estado del hilo encendido"+estadoDespues);
        try {
            // Esperar a que el hilo termine con un límite de 2 segundos
            hiloespera.join(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        State estadoDespuesEspera= hiloespera.getState();
        System.out.println("Estado del hilo encendido"+estadoDespuesEspera);

if (estadoDespuesEspera== State.TIMED_WAITING){
    hiloespera.interrupt();
    System.out.println("como en dos segundos que ha estado esperando no ha salido los procesos , lo interrumpimos");
}else{
    System.out.println("el hilo se ha esperado correctamente");
}





        State estadoInterrumpido= hiloespera.getState();
        System.out.println("Estado del hilo Interrumpido"+estadoInterrumpido);



        System.out.println("El hilo ha terminado");

        State estadoFinal= hiloespera.getState();
        System.out.println("Estado del hilo final "+estadoFinal);
    }
}
