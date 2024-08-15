package tp1;

public class NotificacionCliente implements PedidoObserver {
    @Override
    public void actualizar(Pedido pedido) {
        try {
            Thread.sleep(1200); // Simula tiempo de procesamiento
            System.out.println("Notificando al cliente sobre el pedido: " + pedido.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}