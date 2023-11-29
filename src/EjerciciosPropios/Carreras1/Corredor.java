package EjerciciosPropios.Carreras1;


public class Corredor extends Thread{
private String nombre ;
private int tiempototal=0;

    public int getTotal() {
        return tiempototal;
    }

    public String getNombre() {
        return nombre;
    }



    public Corredor (String nombre ){
        this.nombre = nombre;
    }

    @Override
    public void run(){

        for (int i =0;i<4;i++){
            int valorAleat = ((int)Math.floor(Math.random()*10+1)*1000)+3000;
            try {
                Thread.sleep(valorAleat);
                System.out.println("Ha terminado la vuelta "+i+" en "+valorAleat+" Milisegundos el corredor "+nombre);
               tiempototal =tiempototal+valorAleat;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
