package com.example.webcontainer;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/processForm")
public class ProcessFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Obtenemos el parámetro del formulario
        String nombre = req.getParameter("nombre");

        //Procesamos la informacion (en este caso creamos un mensaje)
        String mensaje = "¡Hola estimad@ " + nombre
                + "! tu formulario ha sido procesado.";

        //Almacenamos el mensaje como un atributo de solicitud
        req.setAttribute("mensaje", mensaje);

        //Redirigimos de vuelta al index.jsp
        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
