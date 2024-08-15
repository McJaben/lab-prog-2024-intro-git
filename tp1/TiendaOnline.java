package tp1;

import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

// ver https://medium.com/javarevisited/a-complete-guide-on-executorservice-in-java-67528f1a535b

public class TiendaOnline {
    public static void main(String[] args) {
        // Crea un ExecutorService con un pool de 4 hilos
        ExecutorService executor = Executors.newFixedThreadPool(2);
        PedidoEntrante entradaPedido = new PedidoEntrante();

        // Agrega observadores que representan diferentes subsistemas
        entradaPedido.agregarObserver(new Inventario());
        entradaPedido.agregarObserver(new Facturacion());
        entradaPedido.agregarObserver(new Envio());
        entradaPedido.agregarObserver(new NotificacionCliente());

        // Crea un pedido y lo procesa utilizando el ExecutorService
        
        Pedido pedido = new Pedido(2);
        Pedido newPedido = new Pedido(1);
        entradaPedido.procesarPedido(newPedido, executor);
        entradaPedido.procesarPedido(pedido, executor);

        // Apaga el ExecutorService
        executor.shutdown();
    }
}