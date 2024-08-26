<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Conversor de Divisas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h1 class="mb-4">Conversor de Divisas</h1>
    <form action="convert" method="post">
        <div class="mb-3">
            <label for="amount" class="form-label">Cantidad en Soles:</label>
            <input type="number" class="form-control" id="amount" name="amount" step="0.01" required>
        </div>
        <div class="mb-3">
            <label for="currency" class="form-label">Seleccione la moneda:</label>
            <select class="form-select" id="currency" name="currency" required>
                <option value="USD">Dólar Estadounidense (USD)</option>
                <option value="EUR">Euro (EUR)</option>
                <option value="JPY">Yen Japonés (JPY)</option>
                <option value="GBP">Libra Esterlina (GBP)</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Convertir</button>
        <button type="submit" name="invert" value="true" class="btn btn-secondary">Invertir Conversión</button>
    </form>
    <% if(request.getAttribute("result") != null) { %>
    <div class="mt-3 alert alert-success">
        Resultado: <%= request.getAttribute("result") %>
    </div>
    <% } %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>