package tp1;

public class Inventario implements PedidoObserver {
    @Override
    public void actualizar(Pedido pedido) {
        try {
            Thread.sleep(1000); // Simula tiempo de procesamiento
            System.out.println("Actualizando inventario para pedido: " + pedido.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
