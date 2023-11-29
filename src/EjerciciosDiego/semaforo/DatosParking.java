package EjerciciosDiego.semaforo;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Esta clase tiene como fin tener un dato en común en el parking para almacenar
 * el número total de coches que han entrado.
 * 
 * @author diego
 *
 */
public class DatosParking {

	private AtomicInteger numeroTotalCoches = new AtomicInteger(0);

	public AtomicInteger getNumeroTotalCoches() {
		return numeroTotalCoches;
	}


	public int incrementarNumeroTotal() {
		return this.numeroTotalCoches.incrementAndGet();
	}

}
