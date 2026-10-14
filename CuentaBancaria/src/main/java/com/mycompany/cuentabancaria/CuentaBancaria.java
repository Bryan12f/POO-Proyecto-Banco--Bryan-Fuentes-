/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.cuentabancaria;

/**
 *
 * @author Bryan Fuentes
 */
public class CuentaBancaria {

    public String numeroCuenta;
    public String titular;
    private double saldo;
    private int totalTransacciones;
    public double saldoInicial;
    
    public CuentaBancaria(String numeroCuenta,String titular, double saldoInicial){
        
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        if (saldoInicial < 0) {
            this.saldo = 0.0;
        } else {
            this.saldo = saldoInicial;
        }
        this.totalTransacciones = 0;
    }
    
    public double getSaldo(){
        return this.saldo;
    }
    
    public int getTotalTransacciones(){
        return this.totalTransacciones;
    }
    
    public double depositar(double monto){
        if(monto > 0){
            this.saldo += monto;
            this.totalTransacciones += 1;
            
        }
        
        if(monto < 0 ){
            throw new Error("El monto a agregar no puede ser menor a 0");
        }
        
        return this.saldo;
    }
    
    public boolean retirar(double monto){
        if(monto > 0 && saldo>= monto){
            saldo -= monto;
            this.totalTransacciones += 1;
            return true;
        }
        else{
            System.out.printf("No puede realizar esta operacion");
            return false;
        }
    }
    
    public String mostrarDatos(){
        return "El nombre del titular es: " + this.titular + "Su numero de cuenta es: " + this.numeroCuenta + "Su saldo es: " + this.saldo + " y su numero total de transacciones es: " + this.totalTransacciones;    
    }
    
    
}
