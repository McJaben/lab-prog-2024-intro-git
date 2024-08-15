package tp1;

public class Facturacion implements PedidoObserver {
    @Override
    public void actualizar(Pedido pedido) {
        try {
            Thread.sleep(1500); // Simula tiempo de procesamiento
            System.out.println("Generando factura para pedido: " + pedido.getId());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}