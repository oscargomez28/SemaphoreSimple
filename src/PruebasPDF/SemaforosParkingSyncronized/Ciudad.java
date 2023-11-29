package PruebasPDF.SemaforosParkingSyncronized;

public class Ciudad {
    private static int NUMERO_DE_PLAZAS = 1;
    private int cochesEsperando = 0;

    public synchronized void entrarAlParking(String nombreCoche) {
        try {
            System.out.println(nombreCoche + " dando una vuelta por la ciudad.");
            Thread.sleep((long) (Math.random() * 1000));

            System.out.println(nombreCoche + " intentando entrar al parking.");
            while (cochesEsperando > 0 || NUMERO_DE_PLAZAS == 0) {
                cochesEsperando++;
                wait(); // Esperar hasta que haya una plaza disponible
                cochesEsperando--;
            }

            System.out.println(nombreCoche + " ha entrado al parking.");
            NUMERO_DE_PLAZAS--;
            Thread.sleep((long) (Math.random() * 2000));
            NUMERO_DE_PLAZAS++;
            System.out.println(nombreCoche + " ha salido del parking.");
            notify(); // Notificar a cualquier hilo que esté esperando
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}