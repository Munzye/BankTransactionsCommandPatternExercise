package command;

import model.CuentaBancaria;

public class ConsultarSaldoCommand implements Command {
    private final CuentaBancaria cuenta;

    public ConsultarSaldoCommand(CuentaBancaria cuenta) {
        this.cuenta = cuenta;
    }

    @Override
    public void ejecutar() {
        cuenta.consultarSaldo();
    }

    @Override
    public void deshacer() {
        System.out.println("Consultar saldo no modifica la cuenta; no hay nada que deshacer.");
    }
}
