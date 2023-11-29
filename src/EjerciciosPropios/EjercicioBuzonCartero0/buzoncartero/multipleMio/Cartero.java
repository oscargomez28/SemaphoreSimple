package EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio;

import EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio.Buzon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Cartero implements Runnable {
    private Buzon buzon;
 private static final int NUM_CARTAS=3;
	public Cartero(Buzon data) {
		super();
		this.buzon = data;
	}
    public void run() {
        List<String> cartas = new ArrayList<>();

        for(int paquet=1;paquet<NUM_CARTAS;paquet++){
            cartas.add(String.valueOf(paquet));
        }
        cartas.add(PruebaSenderReceiver.MENSAJE_END);


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

        buzon.envioTerminado();
    }
    
    private void mensajeSender(String mensaje) {
		System.out.println(System.currentTimeMillis() + "| Cartero: " + mensaje);
		
	}

}