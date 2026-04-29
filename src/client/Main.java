package client;

import command.Command;
import command.ConsultarSaldoCommand;
import command.DepositarCommand;
import command.RetirarCommand;
import command.TransferirCommand;
import invoker.CajeroAutomatico;
import model.CuentaBancaria;

public class Main {
    public static void main(String[] args) {
        CuentaBancaria cuentaPaul = new CuentaBancaria("001", "Paul", 1_000_000);
        CuentaBancaria cuentaMaria = new CuentaBancaria("002", "María", 500_000);

        CajeroAutomatico cajero = new CajeroAutomatico();

        Command consultarSaldoInicial = new ConsultarSaldoCommand(cuentaPaul);
        Command depositar = new DepositarCommand(cuentaPaul, 250_000);
        Command retirar = new RetirarCommand(cuentaPaul, 100_000);
        Command transferir = new TransferirCommand(cuentaPaul, cuentaMaria, 300_000);
        Command consultarSaldoFinalPaul = new ConsultarSaldoCommand(cuentaPaul);
        Command consultarSaldoFinalMaria = new ConsultarSaldoCommand(cuentaMaria);

        System.out.println("= SIMULACIÓN DE TRANSACCIONES BANCARIAS =");

        //Consulta
        cajero.ejecutarOperacion(consultarSaldoInicial);

        //Depósito
        cajero.ejecutarOperacion(depositar);

        //Withdraw (retiro)
        cajero.ejecutarOperacion(retirar);

        //Transferencia
        cajero.ejecutarOperacion(transferir);

        //Consulta final
        cajero.ejecutarOperacion(consultarSaldoFinalPaul);
        cajero.ejecutarOperacion(consultarSaldoFinalMaria);

        System.out.println("\n= DESHACER ÚLTIMA OPERACIÓN =");
        cajero.deshacerUltimaOperacion();

        System.out.println("\n= DESHACER TRANSFERENCIA =");
        cajero.deshacerUltimaOperacion();
        cajero.deshacerUltimaOperacion();

        System.out.println("\n= SALDOS DESPUÉS DE DESHACER TRANSFERENCIA =");
        cajero.ejecutarOperacion(new ConsultarSaldoCommand(cuentaPaul));
        cajero.ejecutarOperacion(new ConsultarSaldoCommand(cuentaMaria));
    }
}
