package EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio;

import EjerciciosDiego.buzoncartero.multiple.PruebaSenderReceiverMultiple;
import EjerciciosPropios.EjercicioBuzonCartero0.buzoncartero.multipleMio.Buzon;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class DuenioCasa implements Runnable {
	
	private Buzon buzon;
	private String nombreDuenio;
	private String tabuladores = "\t\t\t\t";
	List<String> listaNotas = new ArrayList<>();

	public DuenioCasa(Buzon gestor,String nombreDuenio) {
		super();
		this.buzon = gestor;
		this.nombreDuenio=nombreDuenio;
	}
	public void run() {
		String receivedMessage = "";
		do {
			mensajeReceiver("intento coger una carta");
			receivedMessage = buzon.recogerCorreo();

			if(receivedMessage!=null && !esMensajeEnd(receivedMessage)) {
				mensajeReceiver("¡Carta recibida! Es: " + receivedMessage);
				listaNotas.add(receivedMessage);
			}
			if(receivedMessage==null || esMensajeEnd(receivedMessage))
				mensajeReceiver("Toca terminar...");

			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(3000, 8000));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
				System.out.println("Thread interrupted: " +e);
			}
		}while(receivedMessage!=null && !esMensajeEnd(receivedMessage)&& buzon.isTerminado());
		
		mensajeReceiver("- No tengo m�s cartas que recibir -");
		imprimirMensajesRecibidos();
	}
	private static boolean esMensajeEnd(String receivedMessage) {
		return receivedMessage.equalsIgnoreCase(PruebaSenderReceiverMultiple.MENSAJE_END);
	}
	private void mensajeReceiver(String mensaje) {
		System.out.println(System.currentTimeMillis() + "|" + tabuladores +" Dueño casa: "+nombreDuenio+" "+ mensaje);

	}
	public void imprimirMensajesRecibidos() {

		this.mensajeReceiver(this.listaNotas.toString());
	}
	public String getNombreRecibidor() {
		return nombreDuenio;
	}

}