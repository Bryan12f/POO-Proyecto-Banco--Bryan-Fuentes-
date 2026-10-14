/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cuentabancaria;

/**
 *
 * @author Bryan Fuentes
 */
public class Main {
    public static void main(String[] args) {
        
        // ==========================================
        // 1. PRUEBA DE ENCAPSULAMIENTO
        // ==========================================
        CuentaBancaria cuentaPrueba = new CuentaBancaria("HN-001", "Juan Perez", 1000.0);
        
        // ==========================================
        // 2. ACCESO DIRECTO A ATRIBUTOS PÚBLICOS
        // ==========================================
        System.out.println("=== 2. ACCESO DIRECTO A ATRIBUTOS PUBLICOS ===");

        System.out.println("Titular de la cuenta: " + cuentaPrueba.titular);
        System.out.println("numero de cuenta: " + cuentaPrueba.numeroCuenta);
        System.out.println();

        
        // ==========================================
        // 3. PRUEBA DE CUENTAAHORRO (4 Retiros)
        // ==========================================
        System.out.println("=== 3. PRUEBA DE CUENTAAHORRO ===");

        CuentaAhorro ahorro = new CuentaAhorro("HN-SAV01", "Carlos Mendoza", 3000.0, 5.0);
        System.out.println("Saldo inicial de ahorro: L. " + ahorro.getSaldo());
        
        System.out.print("[Retiro 1] "); ahorro.retirarConComision(500);
        System.out.print("[Retiro 2] "); ahorro.retirarConComision(500);
        System.out.print("[Retiro 3] "); ahorro.retirarConComision(500);
        

        System.out.print("[Retiro 4] "); ahorro.retirarConComision(500);
        System.out.println("Saldo final tras 4 retiros: L. " + ahorro.getSaldo());
        System.out.println();

        
        // ==========================================
        // 4. RENDIMIENTO DE AHORRO (Intereses)
        // ==========================================
        System.out.println("=== 4. RENDIMIENTO DE AHORRO ===");
        System.out.println("Saldo antes de intereses: L. " + ahorro.getSaldo());
        ahorro.aplicarInteresMensual(0); 
        System.out.println("Saldo despues de aplicar interes mensual: L. " + ahorro.getSaldo());
        System.out.println();

        
        // ==========================================
        // 5. PRUEBA DE CUENTACORRIENTE
        // ==========================================
        System.out.println("=== 5. PRUEBA DE CUENTACORRIENTE ===");

        CuentaCorriente corriente = new CuentaCorriente("HN-CHK01", "Empresa X", 1000.0, "Empresa S.A.", 5000.0);
        System.out.println("Saldo corriente inicial: L. " + corriente.getSaldo());
        

        corriente.retirarConSobregiro(3500);
        System.out.println("Saldo real en cuenta: L. " + corriente.getSaldo());
        System.out.println("Sobregiro utilizado registrado: L. " + corriente.getSobregiroUtilizado());
        System.out.println();

        
        // ==========================================
        // 6. AMORTIZACION DE DEUDA
        // ==========================================
        System.out.println("=== 6. AMORTIZACION DE DEUDA ===");

        System.out.println("Abonando L. 3,000 para pagar la deuda...");
        corriente.pagarSobregiro(3000);
        
        System.out.println("--- ESTADO FINAL ---");
        System.out.println("Deuda de sobregiro restante: L. " + corriente.getSobregiroUtilizado());
        System.out.println("Saldo real disponible en cuenta: L. " + corriente.getSaldo());
    }
}

