package EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multiple;

public class PruebaSenderReceiverMultiple {

	public static final String MENSAJE_END = "End";
	private static final int TOTAL_DUENIOS = 5;

	public static void main(String[] args) {
		Buzon data = new Buzon();
		Thread sender = new Thread(new Cartero(data));
		sender.start();

		for (int numDuenio = 0; numDuenio < TOTAL_DUENIOS; numDuenio++) {
			new Thread(new DuenioCasa(data,String.valueOf(numDuenio))).start();
		}


	}

}
