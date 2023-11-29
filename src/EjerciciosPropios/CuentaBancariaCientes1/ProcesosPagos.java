package EjerciciosPropios.CuentaBancariaCientes1;

import java.util.ArrayList;

public class ProcesosPagos {



    public static void  main (String[]args){
        int GASTOTOTAL=100000;
         int CLIENTESTOTAL=10;
         CuentaBancarias cuenta = new CuentaBancarias();
        int GastoIndividual =GASTOTOTAL/CLIENTESTOTAL;  //10000
        ArrayList<Clientes> ListaCLientes = new ArrayList<>();

        for (int i=1;i<=CLIENTESTOTAL;i++){
            Clientes cliente = new Clientes(GastoIndividual,0,cuenta);
            cliente.setName(String.valueOf(i));
            ListaCLientes.add(cliente);
        }
        for(Clientes cliente :ListaCLientes){
            cliente.start();
            try{
                cliente.join();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }

        }
        System.out.println("Se han añadido un total de "+cuenta.getGastos());
    }
}
