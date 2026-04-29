package command;

import model.CuentaBancaria;

public class DepositarCommand implements Command {
    private final CuentaBancaria cuenta;
    private final double monto;
    private boolean ejecutado;

    public DepositarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        cuenta.depositar(monto);
        ejecutado = true;
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            cuenta.retirar(monto);
            ejecutado = false;
            System.out.println("Deshacer depósito completado.");
        } else {
            System.out.println("No se puede deshacer: El depósito no fue ejecutado.");
        }
    }
}
