
import java.util.concurrent.Semaphore;

public class Garcom extends Thread{
    private int IdGarcom;
    private Semaphore semaforo;
    private static int RECEBE_MAXIMO_DE_PEDIDOS = 5;
    private static int ENTREGA_MAXIMO_DE_PEDIDOS = 5;


    public Garcom(int IdGarcom , Semaphore semaforo){
        this.IdGarcom = IdGarcom;
        this.semaforo = semaforo;
        start();
    }
    
    public synchronized void Atendendo(){
        for(int i = 1 ; i <= 5; i++){
            int rodada = 5;
            rodada += rodada;
           System.out.println("O Garcom # " + IdGarcom + " Atendendo ao Cliente " );
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Terminou_De_Atender(){
        System.out.println("O Cliente # " + IdGarcom + " Terminou de Atender" );
    }


    public synchronized void Registra_Pedidos(){
        int distancia = 0;

        while(distancia < RECEBE_MAXIMO_DE_PEDIDOS){
            int rodada = 5;
            distancia += rodada;
            System.out.println("O Garcom # " + IdGarcom + " Registrando Pedido");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void Preparando_Pedido(){
        System.out.println("O Garcom # " + IdGarcom + " Preparando o Pedido");
    }

    public synchronized  void Entregando_Pedido(){
        int contador = 0;

        while(contador < ENTREGA_MAXIMO_DE_PEDIDOS){
            int rodada = 5;
            contador += rodada;
            System.out.println("O Garcom # " + IdGarcom + " Entregando Pedido ");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public synchronized void Entregou_Pedido(){
        System.out.println("O Garcom # " + IdGarcom + " Entregou o Pedido ");
    }

    public void run(){
        try {
            Atendendo();
            Terminou_De_Atender();
            semaforo.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally{
            semaforo.release();
            Registra_Pedidos();
            Preparando_Pedido();
            Entregando_Pedido();
            Entregou_Pedido();
        }
    }
    
}
