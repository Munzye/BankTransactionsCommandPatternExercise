package model;

public class CuentaBancaria {
    private final String numeroCuenta;
    private final String titular;
    private double saldo;

    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) {
        validarMontoPositivo(monto);
        saldo += monto;
        System.out.println("Depósito exitoso: $" + monto + " en cuenta " + numeroCuenta);
    }

    public boolean retirar(double monto) {
        validarMontoPositivo(monto);

        if (monto > saldo) {
            System.out.println("Retiro rechazado: saldo insuficiente en cuenta " + numeroCuenta);
            return false;
        }

        saldo -= monto;
        System.out.println("Retiro exitoso: $" + monto + " de cuenta " + numeroCuenta);
        return true;
    }

    public boolean transferir(CuentaBancaria cuentaDestino, double monto) {
        validarMontoPositivo(monto);

        if (this.retirar(monto)) {
            cuentaDestino.depositar(monto);
            System.out.println("Transferencia exitosa: $" + monto + " desde " + numeroCuenta
                    + " hacia " + cuentaDestino.getNumeroCuenta());
            return true;
        }

        System.out.println("Transferencia rechazada desde cuenta " + numeroCuenta);
        return false;
    }

    public double consultarSaldo() {
        System.out.println("Saldo actual de " + titular + " [" + numeroCuenta + "]: $" + saldo);
        return saldo;
    }

    private void validarMontoPositivo(double monto) {
        if (monto <= 0) {
            throw new IllegalArgumentException("El monto debe ser mayor que cero.");
        }
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }
}
