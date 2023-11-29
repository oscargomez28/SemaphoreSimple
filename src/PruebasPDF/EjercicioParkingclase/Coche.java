package PruebasPDF.EjercicioParkingclase;

import java.util.concurrent.Semaphore;

public class Coche extends Thread {
	Semaphore semaforo;
	int numeroCoche;
	boolean expulsado = false;
	
	DatosParking datosParking;
	
	public Coche(Semaphore semaforo, int numero, DatosParking datosParking) {
		super();
		this.semaforo = semaforo;
		this.numeroCoche = numero;
		this.datosParking = datosParking;
	}

	@Override
	public void run() {
		while (true && !expulsado) {
			try {
				int aleatorio = (int) (Math.random() * 5000);
				imprimirMensajeCoche("El coche " + numeroCoche + " recorre la ciudad " + aleatorio + "ms.");
				
				Thread.sleep(aleatorio);
				
				imprimirMensajeCoche("El coche " + numeroCoche + " intenta entrar al parking.");
				
				// queuelength nos dice los hilos esperando a un semaforo
				imprimirMensajeCoche("Hay " + semaforo.getQueueLength() + " coches en la cola del semaforo. Plazas libres en el parking: " +semaforo.availablePermits());
				if (semaforo.getQueueLength() <= 5) {
					// Cogemos el semaforo
					semaforo.acquire();
					aleatorio = (int) (Math.random() * 5000);
					imprimirMensajeCoche("El coche " + numeroCoche + " entra al parking y se queda " + aleatorio + "ms. El número de plazas restantes es: " + semaforo.availablePermits());
					Thread.sleep(aleatorio);
					// Liberamos el semaforo
					imprimirMensajeCoche("El numero total de coches ingresados es: " + this.datosParking.incrementarNumeroTotal());
					semaforo.release();
					imprimirMensajeCoche("El coche " + numeroCoche + " sale del parking ");
				} else {
					imprimirMensajeCoche("El coche " + numeroCoche + " no entra porque ya hay mucha cola esperando.");
				}
				
				

			} catch (InterruptedException e) {
				imprimirMensajeCoche("EL COCHE " + numeroCoche + " ha sido despertado");
				semaforo.release();
			}
		}
		
		imprimirMensajeCoche("EL COCHE " + numeroCoche + " HA SIDO EXPULSADO. FIN DE SU VIDA");

	}
	
	public void imprimirMensajeCoche(String mensaje) {
		System.out.println(numeroCoche + ":" + mensaje);
	}

	public int getNumeroCoche() {
		return numeroCoche;
	}

	public void setNumeroCoche(int numeroCoche) {
		this.numeroCoche = numeroCoche;
	}

	public boolean isExpulsado() {
		return expulsado;
	}

	public void setExpulsado(boolean expulsado) {
		this.expulsado = expulsado;
	}


}
