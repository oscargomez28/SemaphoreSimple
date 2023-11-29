package EjerciciosPropios.Carreras1;

import java.util.Scanner;

public class CoordinadorCarrera {
    public static void main(String[]args) throws InterruptedException {
        Scanner entrada= new Scanner(System.in);

        int totalCarrera=0;
        String nombreGanador ;
Corredor[] ArrayCorredores= new Corredor[3];
        String[] Arraynombres= new String[3];

        for (int i=0;i<Arraynombres.length;i++){
           int num= i+1;
            System.out.println("Introduce el corredor "+num);
            Arraynombres[i]= entrada.nextLine();
            Corredor corredor = new Corredor(Arraynombres[i]);
            ArrayCorredores[i]=corredor;
        }

       for(Corredor corre : ArrayCorredores){
           corre.start();
           corre.join();
           System.out.println("El tiempo total de la carrera de "+ corre.getNombre()+" es de "+corre.getTotal());
        totalCarrera=corre.getTotal()+totalCarrera;
       }

       Corredor corredorGanador = ArrayCorredores[0];
       for (int i=0;i<ArrayCorredores.length;i++){
           if(ArrayCorredores[i].getTotal()>corredorGanador.getTotal()){
            corredorGanador= ArrayCorredores[i];
             nombreGanador=corredorGanador.getName();
               System.out.println("El corredor ganador es "+nombreGanador);
           }

       }
        System.out.println("el tiempo de todos los corredores es de "+totalCarrera);

        System.out.println("Fin de la carrera");
    }
}
