package PruebasPDF.SemaforosParkingSyncronized;


class Coche extends Thread {
    private String nombre;
    private Ciudad ciudad;

    public Coche(String nombre, Ciudad ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
    }

    @Override
    public void run() {
        while (true) {
            ciudad.entrarAlParking(nombre);
            try {
                Thread.sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
