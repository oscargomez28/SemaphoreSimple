package PruebasPDF.SemaforosSyncronized;

class RecursoCompartido {
    private int valorCompartido;

    public RecursoCompartido(int valorInicial) {
        this.valorCompartido = valorInicial;
    }

    public int getValorCompartido() {
        return valorCompartido;
    }

    public void realizarOperacion() {
        synchronized (this) {
            // Sección crítica: operaciones sobre el recurso compartido
            valorCompartido++;
        }
    }
}