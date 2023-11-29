package EjerciciosPropios.EstadosyesperaHilos1;

public class Hijo extends Thread{

    public void run(){
        System.out.println("Hola soy el hilo hijo ");
        System.out.println("Procedo a dormir");
        try{
            Hijo.sleep(5000);
            System.out.println("Adiósss");

        }catch (InterruptedException e){
            System.err.println("El hilo hijo ha sido interrumpido");
        }

    }
}
