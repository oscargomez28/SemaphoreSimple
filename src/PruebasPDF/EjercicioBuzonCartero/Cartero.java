package PruebasPDF.EjercicioBuzonCartero;

import java.util.concurrent.ThreadLocalRandom;

public class Cartero implements Runnable {
    private Buzon buzon;
 
	public Cartero(Buzon data) {
		super();
		this.buzon = data;
	}
    public void run() {
        String cartas[] = {
          "Querido amigo, te echo de menos",
          "HACIENDA. Tiene que pagar",
          "PUBLICIDAD ELECTORAL",
          "FACTURA DE LA LUZ",
          "End"
        };
 
        for (String carta : cartas) {
            mensajeSender("Quiero enviar carta " + carta);

            buzon.ponerCarta(carta);

            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(1000, 2000));
            } catch (InterruptedException e)  {
                Thread.currentThread().interrupt(); 
                System.out.println("Thread interrupted: " +e);
            }
        }
        
        mensajeSender("no tengo más cartas para enviar");
    }
    
    private void mensajeSender(String mensaje) {
		System.out.println(System.currentTimeMillis() + "| Cartero: " + mensaje);
		
	}

}