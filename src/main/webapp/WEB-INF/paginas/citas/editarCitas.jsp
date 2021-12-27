<!-- Usando la librer�a core de JSTL -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Editar Cita</title>
    </head>
    <body>
        <!-- Cabecero usando bootstrap -->
        <jsp:include page="/WEB-INF/paginas/citas/comunes/cabecero.jsp" />

        <form action="${pageContext.request.contextPath}/ServletControladorCitas?accion=modificar&idCita=${medico.idCita}" method="POST" class="was-validated">
            <!-- Botones de navegaci�n -->
            <jsp:include page="/WEB-INF/paginas/citas/comunes/botonesNavegacionEdicion.jsp" />   
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Cita</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="medico">M�dico</label>
                                        <select>
                                            <c:forEach var="medico" items="${citas}" >
                                                <option value="nombreMedico">${medico.nombreMedico}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="paciente">Paciente</label>
                                        <select>
                                            <c:forEach var="paciente" items="${citas}" >
                                                <option value="nombre">${paciente.nombre}</option>
                                            </c:forEach>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="hora">Hora</label>
                                        <input type="time" class="form-control" name="hora" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <!-- Pie de p�gina o footer -->
        <jsp:include page="/WEB-INF/paginas/medico/comunes/piePagina.jsp" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/0370956726.js" crossorigin="anonymous"></script>
    </body>
</html>

