class CuentaBancaria {
    private int numeroCuenta;
    private double saldo;

    public CuentaBancaria(int numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public void depositar(double monto) { saldo += monto; }
    public void retirar(double monto) { if (saldo >= monto) saldo -= monto; }
    public double getSaldo() { return saldo; }
}

public class Ejercicio2_Deptal2 {
    public static void main(String[] args) {
        CuentaBancaria c = new CuentaBancaria(1001, 500.0);
        c.depositar(200.0);
        c.retirar(150.0);
        System.out.println("Saldo final: " + c.getSaldo());
    }
}
