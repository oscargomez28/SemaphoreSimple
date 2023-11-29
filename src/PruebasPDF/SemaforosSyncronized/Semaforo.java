package PruebasPDF.SemaforosSyncronized;



    public class Semaforo {
        private int ticketsDisponibles;

        public Semaforo(int totalTickets) {
            this.ticketsDisponibles = totalTickets;
        }

        public synchronized void solicitarTicket() throws InterruptedException {
            // Solicitar un "ticket"
            while (ticketsDisponibles == 0) {
                wait();
            }
            ticketsDisponibles--;
        }

        public synchronized void liberarTicket() {
            // Liberar un "ticket"
            ticketsDisponibles++;
            notify(); // Notificar a cualquier hilo que esté esperando
        }
    }

