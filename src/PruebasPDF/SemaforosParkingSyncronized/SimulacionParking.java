package PruebasPDF.SemaforosParkingSyncronized;



public class SimulacionParking {
    public static void main(String[] args) {
        Ciudad ciudad = new Ciudad();

        for (int i = 1; i <= 10; i++) {
            Coche coche = new Coche("Coche " + i, ciudad);
            coche.start();
        }
    }
}