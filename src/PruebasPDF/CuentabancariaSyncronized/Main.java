package PruebasPDF.CuentabancariaSyncronized;

public class Main {
    public static void main(String[] args) {
        // Crear una cuenta bancaria compartida
        CuentaBancaria cuentaBancaria = new CuentaBancaria();

        // Definir el total de gastos y la cantidad de clientes
        int totalGastos = 100000;
        int numClientes = 4;

        // Calcular los gastos individuales para cada cliente
        int gastosIndividuales = totalGastos / numClientes;

        // Crear e iniciar los clientes en hilos separados
        Cliente[] clientes = new Cliente[numClientes];
        for (int i = 0; i < numClientes; i++) {
            clientes[i] = new Cliente(cuentaBancaria, gastosIndividuales);
            clientes[i].start();
        }

        // Esperar a que todos los clientes terminen
        for (Cliente cliente : clientes) {
            try {
                cliente.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Imprimir el saldo final de la cuenta
        System.out.println("Saldo final en la cuenta bancaria: " + cuentaBancaria.getSaldo());
    }
}
