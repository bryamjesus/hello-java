package org.bjtg.poo;

public class POO {
    public static void principles() {
        encapsulamiento();
    }

    private static void encapsulamiento() {
        System.out.println();
        System.out.println("Encapsulamiento");
        CuentaBancaria cuentaBancaria = new CuentaBancaria("Bryam", 100);
        System.out.println("cuentaBancari: " + cuentaBancaria);
        // No se puede ingresar de manera directa
        // System.out.println("cuentaBancaria = " + cuentaBancaria.titular);

        System.out.println("Titular: " + cuentaBancaria.getTitular());
        System.out.println("Saldo: " + cuentaBancaria.getSaldo());
        cuentaBancaria.retirar(10);
        System.out.println("Saldo: " + cuentaBancaria.getSaldo());

    }
}
