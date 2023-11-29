package PruebasPDF.SemaforosSyncronized;


public class Main {
    public static void main(String[] args) {
        int totalTickets = 10; // Número total de "tickets" disponibles
        Semaforo semaforo = new Semaforo(totalTickets);
        RecursoCompartido recurso = new RecursoCompartido(0);

        int totalProcesos = 100; // Número total de procesos
        Proceso[] procesos = new Proceso[totalProcesos];

        for (int i = 0; i < totalProcesos; i++) {
            procesos[i] = new Proceso(recurso, semaforo);
            procesos[i].start();
        }

        // Esperar a que todos los hilos terminen
        for (Proceso proceso : procesos) {
            try {
                proceso.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verificar el valor final del recurso compartido
        System.out.println("Valor final del recurso compartido: " + recurso.getValorCompartido());
    }
}