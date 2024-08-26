package com.example.webcontainer;

public class CurrencyConverter {

    // Tasas de cambio de monedas extranjeras a soles peruanos (PEN)
    private static final double USD_RATE = 3.68;  // 1 dólar estadounidense ≈ 3.68 soles
    private static final double EUR_RATE = 4.01;  // 1 euro ≈ 4.01 soles
    private static final double JPY_RATE = 0.025; // 1 yen japonés ≈ 0.025 soles
    private static final double GBP_RATE = 4.73;  // 1 libra esterlina ≈ 4.73 soles

    // Convierte un monto desde soles peruanos a la moneda especificada
    public static double convertFromSoles(double amount, String currency) {
        // Utiliza una expresión switch para realizar la conversión según la moneda
        return switch (currency) {
            case "USD" -> amount * USD_RATE; // Convierte de soles a dólares estadounidenses
            case "EUR" -> amount * EUR_RATE; // Convierte de soles a euros
            case "JPY" -> amount * JPY_RATE; // Convierte de soles a yenes japoneses
            case "GBP" -> amount * GBP_RATE; // Convierte de soles a libras esterlinas
            // Lanza una excepción si la moneda no es soportada
            default -> throw new IllegalArgumentException("Moneda no soportada: " + currency);
        };
    }

    // Convierte un monto desde la moneda especificada a soles peruanos
    public static double convertToSoles(double amount, String currency) {
        // Utiliza una expresión switch para realizar la conversión según la moneda
        return switch (currency) {
            case "USD" -> amount / USD_RATE; // Convierte de dólares estadounidenses a soles
            case "EUR" -> amount / EUR_RATE; // Convierte de euros a soles
            case "JPY" -> amount / JPY_RATE; // Convierte de yenes japoneses a soles
            case "GBP" -> amount / GBP_RATE; // Convierte de libras esterlinas a soles
            // Lanza una excepción si la moneda no es soportada
            default -> throw new IllegalArgumentException("Moneda no soportada: " + currency);
        };
    }
}