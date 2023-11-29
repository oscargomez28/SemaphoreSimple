package PruebasPDF.CuentabancariaSyncronized;

class Cliente extends Thread {
    private CuentaBancaria cuenta;
    private int gastosIndividuales;

    public Cliente(CuentaBancaria cuenta, int gastosIndividuales) {
        this.cuenta = cuenta;
        this.gastosIndividuales = gastosIndividuales;
    }

    @Override
    public void run() {
        for (int i = 0; i < gastosIndividuales; i++) {
            cuenta.realizarGasto(1);
        }
    }
}