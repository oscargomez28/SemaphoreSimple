package EjerciciosDiego.PSPUT3AlumnosProfesor;

public class ComienzoClase {
	public static void main(String[] args) throws InterruptedException {
		
		// Objeto compartido
		Bienvenida objetoBienvenida = new Bienvenida();
		int numAlumnos = 10;
		for (int alumno = 0; alumno < numAlumnos; alumno++) {
			new Alumno(alumno+1, objetoBienvenida).start();
		}

		
		Thread.sleep(5000);
		Profesor profesor = new Profesor("Mario Murias", objetoBienvenida);
		profesor.start();
	}
}