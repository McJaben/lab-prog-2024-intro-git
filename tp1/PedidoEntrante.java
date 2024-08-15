package tp1;
import java.util.concurrent.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoEntrante {
    private List<PedidoObserver> observers = new ArrayList<>();

    public void agregarObserver(PedidoObserver observer) {
        observers.add(observer);
    }

    public void procesarPedido(Pedido pedido, ExecutorService executor) {
        List<Callable<String>> tareas = new ArrayList<>();

        for (PedidoObserver observer : observers) {
            // Cada observador es una tarea separada
            tareas.add(() -> {
                observer.actualizar(pedido);
                return "Procesado por " + observer.getClass().getSimpleName();
            });
        }

        try {
            // Ejecuta todas las tareas de forma concurrente
            List<Future<String>> resultados = executor.invokeAll(tareas);

            for (Future<String> resultado : resultados) {
                // Obtiene el resultado de cada tarea
                System.out.println(resultado.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}