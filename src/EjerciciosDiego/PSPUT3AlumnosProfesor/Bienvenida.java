package EjerciciosDiego.PSPUT3AlumnosProfesor;

public class Bienvenida {
	boolean claseComenzada;
	
	public Bienvenida(){
		this.claseComenzada = false;
	}
	// Hasta que el profesor no salude no empieza la clase,
	// por lo que los alumnos esperan con un wait
	public synchronized void saludarProfesor(int numAlumno){
		try {
			while (!claseComenzada){
				System.out.println(numAlumno + ": Oh, el profe no ha venido. Como la clase no ha comenzado, espero");
				wait();
			}
			System.out.println(numAlumno + ": Buenos días, profesor.");
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
			
	}
	// Cuando el profesor saluda avisa a los alumnos con notifyall de su llegada
	public synchronized void llegadaProfesor(String nombre){
		System.out.println("Buenos días a todos. Soy el profesor " + nombre);
		this.claseComenzada = true;
		notifyAll();
	}
}
