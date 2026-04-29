package command;

import model.CuentaBancaria;

public class TransferirCommand implements Command {
    private final CuentaBancaria cuentaOrigen;
    private final CuentaBancaria cuentaDestino;
    private final double monto;
    private boolean ejecutado;

    public TransferirCommand(CuentaBancaria cuentaOrigen, CuentaBancaria cuentaDestino, double monto) {
        this.cuentaOrigen = cuentaOrigen;
        this.cuentaDestino = cuentaDestino;
        this.monto = monto;
    }

    @Override
    public void ejecutar() {
        ejecutado = cuentaOrigen.transferir(cuentaDestino, monto);
    }

    @Override
    public void deshacer() {
        if (ejecutado) {
            boolean reversado = cuentaDestino.transferir(cuentaOrigen, monto);
            if (reversado) {
                ejecutado = false;
                System.out.println("Deshacer transferencia completado.");
            }
        } else {
            System.out.println("No se puede deshacer: la transferencia no fue ejecutada.");
        }
    }
}
