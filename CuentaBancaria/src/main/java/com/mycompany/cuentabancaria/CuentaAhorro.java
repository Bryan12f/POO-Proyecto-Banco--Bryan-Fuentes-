/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

/**
 *
 * @author Bryan Fuentes
 */
public class CuentaAhorro extends CuentaBancaria {

    public double tasaInteresAnual;
    private int retirosRealizadosMes = 0;
    private double comisionPorExceso = 20.0;        


    public CuentaAhorro(String numeroCuenta, String titular, double saldoInicial, double tasaInteresAnual) {
        super(numeroCuenta, titular, saldoInicial);
        this.tasaInteresAnual = tasaInteresAnual;
    }
    
    void retirarConComision(double monto){
        if (this.retirosRealizadosMes >= 3) {
            if (getSaldo() >= (monto + this.comisionPorExceso)) {
                double montoTotal = monto + this.comisionPorExceso;
                super.retirar(montoTotal);
                this.retirosRealizadosMes += 1;
                System.out.println("Comision cobrada: " + comisionPorExceso);
            } else {
                throw new IllegalArgumentException("Saldo insuficiente para cubrir retiro y comision");
            }
        } else {
            if (getSaldo() >= monto) {
                super.retirar(monto);
                this.retirosRealizadosMes += 1;
                System.out.println("Retiro Completado");
            } else {
                throw new IllegalArgumentException("Saldo insuficiente");
            }
        }
    }
    
    void aplicarInteresMensual(double interesMensual){
        interesMensual = (super.getSaldo()*(this.tasaInteresAnual/100))/12;
        super.depositar(interesMensual);
    }
}

