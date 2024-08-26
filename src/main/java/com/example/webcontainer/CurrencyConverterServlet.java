package com.example.webcontainer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/convert")
public class CurrencyConverterServlet extends HttpServlet {

    // Maneja las solicitudes POST (enviadas típicamente desde un formulario HTML)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Obtiene el monto a convertir desde el parámetro "amount" de la solicitud
        double amount = Double.parseDouble(request.getParameter("amount"));

        // Obtiene la moneda seleccionada desde el parámetro "currency" de la solicitud
        String currency = request.getParameter("currency");

        // Determina si se debe invertir la conversión (de otra moneda a soles)
        boolean invert = "true".equals(request.getParameter("invert"));

        // Variable para almacenar el resultado de la conversión
        double result;

        // Realiza la conversión según la dirección indicada (invertir o no)
        if (invert) {
            // Convierte de la moneda seleccionada a soles peruanos
            result = CurrencyConverter.convertToSoles(amount, currency);
        } else {
            // Convierte de soles peruanos a la moneda seleccionada
            result = CurrencyConverter.convertFromSoles(amount, currency);
        }

        // Formatea el resultado con dos decimales y la moneda correspondiente (o "PEN (SOLES)" si se invirtió la conversión)
        String formattedResult = String.format("%.2f %s", result, invert ? "PEN (SOLES)" : currency);

        // Establece el resultado formateado como un atributo en el objeto de solicitud (request) para que esté disponible en la JSP
        request.setAttribute("result", formattedResult);

        // Redirige la solicitud a la página index.jsp para mostrar el resultado al usuario
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}