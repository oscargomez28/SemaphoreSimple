package EjerciciosDiego.PSPUT3AlumnosProfesor;

public class Alumno extends Thread{
	
	Bienvenida objetoBienvenida;
	int numAlumno;
	
	public Alumno(int numAlumno, Bienvenida bienvenida){
		this.objetoBienvenida = bienvenida;
		this.numAlumno = numAlumno;
	}
	
	@Override
	public void run(){
		System.out.println(numAlumno +": alumno llega al aula.");
		try {
			Thread.sleep(1000);
			System.out.println(numAlumno +": Quiero saludar al profe.");
			objetoBienvenida.saludarProfesor(numAlumno);
		} catch (InterruptedException ex) {
			System.err.println("Thread alumno interrumpido!");
			System.exit(-1);
		}
	}
}