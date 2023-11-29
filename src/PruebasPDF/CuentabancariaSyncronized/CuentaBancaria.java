package PruebasPDF.CuentabancariaSyncronized;

class CuentaBancaria {
    private int saldo = 0;

    public synchronized void realizarGasto(int cantidad) {
        saldo += cantidad;
    }

    public int getSaldo() {
        return saldo;
    }
}
