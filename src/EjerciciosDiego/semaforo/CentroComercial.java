package EjerciciosDiego.semaforo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class CentroComercial {

	private static final int NUM_COCHES = 10;
	private static final int PLAZAS_PARKING = 3;
	
	public static void main(String[] args) throws InterruptedException {
		// Creo un semaforo para un parking con 1 plaza disponible
		Semaphore semaforo = new Semaphore(PLAZAS_PARKING);
		DatosParking datosParking = new DatosParking();

		List<Coche> hilosCoches = new ArrayList<>();
		ampliacionExpulsarCoches(hilosCoches);

		for (int numCoche = 1; numCoche <= NUM_COCHES; numCoche++) {
			Coche coche = new Coche(semaforo, numCoche, datosParking);

			if(NUM_COCHES <= 10 ) {
				coche.setPriority(numCoche);
			}
			coche.start();

			hilosCoches.add(coche);

		}

		//Ampliacion
		//ampliacionExpulsarCoches(hilosCoches);
	}

	private static void ampliacionExpulsarCoches(List<Coche> hilosCoches) {
		Scanner teclado = new Scanner(System.in);
		int numeroCocheExpulsar;
		while(hilosCoches.stream().anyMatch(Coche::isAlive)) {
			System.out.println("ESCRIBE NUMERO DE COCHE A MATAR");
			 numeroCocheExpulsar =teclado.nextInt();
			
			for(Coche coche : hilosCoches) {
				if(coche.getNumeroCoche()== numeroCocheExpulsar) {
					coche.interrupt();
					coche.setExpulsado(true);
					break;
				}
			}
			
		}
		System.out.println("TODOS LOS COCHES HAN SIDO EXPULSADOS");
	}


}
