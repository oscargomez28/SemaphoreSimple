package EjerciciosDiego.buzoncartero.multiple;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DuenioCasa implements Runnable {

	private Buzon buzon;
	private String nombreRecibidor;
	private String tabuladores = "\t\t\t\t";
	private List<String> mensajesRecibidos = new ArrayList<>();

	// standard constructors

	public DuenioCasa(Buzon gestor, String nombre) {
		super();
		this.buzon = gestor;
		this.nombreRecibidor = nombre;
	}
	public void run() {
		String receivedMessage = "";
		do {
			mensajeReceiver("intento coger una carta");
			receivedMessage = buzon.receive(this);

			if(receivedMessage != null && !esMensajeEnd(receivedMessage)) {
				mensajeReceiver("¡He recibido una carta! Es: " + receivedMessage);
				mensajesRecibidos.add(receivedMessage);
			}

			if(receivedMessage == null || esMensajeEnd(receivedMessage))
				mensajeReceiver("Toca terminar...");

			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 8000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted: " +e);
			}
		}while(receivedMessage!= null && !esMensajeEnd(receivedMessage) && !buzon.isTerminado());

		mensajeReceiver("- No tengo más cartas que recibir -");

		imprimirMensajesRecibidos();

	}

	private static boolean esMensajeEnd(String receivedMessage) {
		return receivedMessage.equalsIgnoreCase(PruebaSenderReceiverMultiple.MENSAJE_END);
	}

	private void mensajeReceiver(String mensaje) {
		String mensajeCompleto = String.format("%d | %s Dueño casa %s: %s",
				System.currentTimeMillis(),
				tabuladores,
				this.nombreRecibidor,
				mensaje);
		System.out.println(mensajeCompleto);

	}
	public void imprimirMensajesRecibidos() {

		this.mensajeReceiver(this.mensajesRecibidos.toString());
	}
	public String getNombreRecibidor() {
		return nombreRecibidor;
	}



}