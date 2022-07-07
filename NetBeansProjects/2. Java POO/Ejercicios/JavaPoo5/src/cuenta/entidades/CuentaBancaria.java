
package cuenta.entidades;

public class CuentaBancaria {
        
    private long dni;
    private int numeroCuenta;
    private double saldo, interes;

    public CuentaBancaria() {
    }

    public CuentaBancaria(long dni, int numeroCuenta, double saldo, double interes) {
        this.dni = dni;
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
        this.interes = interes;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public int getnCuenta() {
        return numeroCuenta;
    }

    public void setnCuenta(int nCuenta) {
        this.numeroCuenta = nCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getInteres() {
        return interes;
    }

    public void setInteres(double interes) {
        this.interes = interes;
    }

    public String mostrarDatos() {
        return "La CuentaBancaria con dni "+ dni + ", y  numero de cuenta " + numeroCuenta + ", posse el sgte saldo " + saldo + ",con " + interes +" de interes";
    }
}
