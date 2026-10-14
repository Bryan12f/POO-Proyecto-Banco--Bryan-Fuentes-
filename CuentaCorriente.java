/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

/**
 *
 * @author Bryan Fuentes
 */
public class CuentaCorriente extends CuentaBancaria{
    public String nombreEmpresa;
    private double limiteSobregiro;
    private double sobregiroUtilizado = 0.0;

    public CuentaCorriente(String numeroCuenta, String titular, double saldoInicial, String nombreEmpresa, double limiteSobregiro) {
        super(numeroCuenta, titular, saldoInicial);
        this.nombreEmpresa = nombreEmpresa;
        this.limiteSobregiro = limiteSobregiro;
    }
    
    double getLimiteSobregiro(){
        return this.limiteSobregiro;
    }
    
    double  getSobregiroUtilizado(){
        return this.sobregiroUtilizado;
    }
    
    void retirarConSobregiro(double monto) {

        if (getSaldo() >= monto) {
            super.retirar(monto);
            System.out.println("Retiro normal completado.");
        } 

        else if (monto <= (getSaldo() + (limiteSobregiro - sobregiroUtilizado))) {
            double loQueLeFalta = monto - getSaldo();
            double cargoSobregiro = loQueLeFalta * 0.03; 
            this.sobregiroUtilizado += (loQueLeFalta + cargoSobregiro);
            super.retirar(getSaldo()); 
            System.out.println("Retiro realizado usando sobregiro. Deuda actual: " + this.sobregiroUtilizado);
        } 

        else {
            throw new IllegalArgumentException("No se pudo realizar la operacion porque excede el limite");
        }
    }
    
    void  pagarSobregiro(double monto){
        if (monto >= this.sobregiroUtilizado) {
            double dineroQueSobra = monto - this.sobregiroUtilizado;
            this.sobregiroUtilizado = 0.0;
            super.depositar(dineroQueSobra); 
            System.out.println("Deuda saldada. Se depositaron $" + dineroQueSobra + " al saldo real.");
        }else{
            this.sobregiroUtilizado -= monto;
            System.out.println("Abono realizado. Deuda restante: $" + this.sobregiroUtilizado);
        }
    }
    
}
