package EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio;

import EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio.Buzon;
import EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio.Cartero;
import EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio.DuenioCasa;

public class PruebaSenderReceiver {

	public static final String MENSAJE_END = "End";
private static int NUM_DUENIOS=3;
	public static void main(String[] args) {
		Buzon data = new Buzon();
	    Thread sender = new Thread(new Cartero(data));
		sender.start();
	    for(int i=1;i<=NUM_DUENIOS;i++){
			new Thread(new DuenioCasa(data,String.valueOf(i))).start();
		}


//
	}

}
