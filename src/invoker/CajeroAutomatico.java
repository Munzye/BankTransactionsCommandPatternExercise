package invoker;

import command.Command;
import java.util.Stack;

//ATM
public class CajeroAutomatico {
    private final Stack<Command> historial = new Stack<>();

    public void ejecutarOperacion(Command command) {
        command.ejecutar();
        historial.push(command);
    }

    public void deshacerUltimaOperacion() {
        if (historial.isEmpty()) {
            System.out.println("No hay operaciones para deshacer.");
            return;
        }

        Command ultimoCommand = historial.pop();
        ultimoCommand.deshacer();
    }
}
