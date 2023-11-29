package PruebasPDF.SemaforosSyncronized;

 public class Proceso extends Thread {
    private RecursoCompartido recurso;
    private Semaforo semaforo;

    public Proceso(RecursoCompartido recurso, Semaforo semaforo) {
        this.recurso = recurso;
        this.semaforo = semaforo;
    }

    @Override
    public void run() {
        try {
            semaforo.solicitarTicket(); // Solicitar un "ticket" al semáforo

            // Sección crítica: realizar operaciones en el recurso compartido
            recurso.realizarOperacion();

            semaforo.liberarTicket(); // Liberar el "ticket" después de completar la sección crítica
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 }
