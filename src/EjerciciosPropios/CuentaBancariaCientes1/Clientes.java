package EjerciciosPropios.CuentaBancariaCientes1;

public class Clientes extends Thread{
    private  int numGastos;
    private int  GastosPersonales;
    private  CuentaBancarias cuenta;
    public Clientes(int GastosPersonales,int numGastos, CuentaBancarias cuenta){
         this.GastosPersonales = GastosPersonales;
        this.cuenta=cuenta;
        this.numGastos= numGastos;
     }
    public void run(){
for(int gastos=0;gastos<GastosPersonales;gastos++){

    cuenta.añadirGastos();
    numGastos++;
}
        System.out.println("Hilo "+this.getName()+" añadido con un total de "+numGastos+" Gastos");

    }
}
