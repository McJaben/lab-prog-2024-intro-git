package tp1;

public class Envio implements PedidoObserver {
    @Override
    public void actualizar(Pedido pedido) {
        try {
            Thread.sleep(2000); // Simula tiempo de procesamiento
            System.out.println("Preparando envío para pedido: " + pedido.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}