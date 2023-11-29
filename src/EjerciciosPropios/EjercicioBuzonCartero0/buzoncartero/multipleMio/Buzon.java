package EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio;




public class Buzon {
	private String contenidoBuzon;

	private boolean cartaRecogida = true;       //El buzon esta vacio


	private boolean envioTerminado = false;
	public synchronized void ponerCarta(String cartaAPoner) {
		while (!cartaRecogida) {
			try {
				mensajeBuzon("No han cogido la carta anterior, esperamos.... Transfer: " + cartaRecogida);
				wait();
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted: " +e);
			}
		}
		this.contenidoBuzon = cartaAPoner;
		cartaRecogida = false;
		mensajeBuzon("(Se deja en la puerta la carta " + cartaAPoner + ")");

		notifyAll();
	}

	public synchronized String recogerCorreo() {
		while (cartaRecogida && !envioTerminado) {
			try {
				mensajeBuzon("Auch! No hay cartas, esperamos... Transfer: " + cartaRecogida);
				wait(5000);
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted: " +e);
			}
		}
		cartaRecogida = true;

		notifyAll();
		return contenidoBuzon;
	}

	private void mensajeBuzon(String mensaje) {
		System.out.println(System.currentTimeMillis() + "|  Buzon: " + mensaje);

	}

	public synchronized void envioTerminado() {
		this.envioTerminado = true;
		contenidoBuzon = null;
		notifyAll();
	}

	public synchronized boolean isTerminado() {
		return this.envioTerminado;
	}


}