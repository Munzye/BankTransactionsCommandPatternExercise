package command;

import model.CuentaBancaria;

public class RetirarCommand implements Command {
    private final CuentaBancaria cuenta;
    private final double monto;
    private boolean ejecutado;

    public RetirarCommand(CuentaBancaria cuenta, double monto) {
        this.cuenta = cuenta;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        ejecutado = cuenta.retirar(monto);
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            cuenta.depositar(monto);
            ejecutado = false;
            System.out.println("Deshacer retiro completado.");
        } else {
            System.out.println("No se puede deshacer: El retiro no fue ejecutado.");
        }
    }
}
