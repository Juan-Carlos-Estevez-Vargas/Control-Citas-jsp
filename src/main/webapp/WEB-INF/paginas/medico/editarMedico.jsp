<!-- Usando la librería core de JSTL -->
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Editar Médico</title>
    </head>
    <body>
        <!-- Cabecero usando bootstrap -->
        <jsp:include page="/WEB-INF/paginas/medico/comunes/cabecero.jsp" />

        <form action="${pageContext.request.contextPath}/ServletControladorMedico?accion=modificar&idMedico=${medico.idMedico}" method="POST" class="was-validated">
            <!-- Botones de navegación -->
            <jsp:include page="/WEB-INF/paginas/medico/comunes/botonesNavegacionEdicion.jsp" />   
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar Médico</h4>
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre Completo</label>
                                        <input type="text" class="form-control" name="nombre" required value="${medico.getNombre()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="idMedico">Identificación</label>
                                        <input type="text" class="form-control" name="idMedico" required value="${medico.getIdMedico()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="tipoIdentificacion">Tipo Identificación</label>
                                        <select required name="tipoIdentificacion">
                                            <option value="CC">CC</option>
                                            <option value="TI">TI</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <label for="NTarjetaProfesional">Número Tarjeta Profesional</label>
                                        <input type="text" class="form-control" name="NTarjetaProfesional" required value="${medico.getNTarjetaProfesional()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="aniosExperiencia">Años de Experiencia</label>
                                        <input type="number" class="form-control" name="aniosExperiencia" required value="${medico.getAniosExperiencia()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="especialidad">Especialidad</label>
                                        <input type="text" class="form-control" name="especialidad" required value="${medico.getEspecialidad()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="horaInicioAtencion">Hora Inicio Atención</label>
                                        <input type="text" class="form-control" name="horaInicioAtencion" required value="${medico.getHoraInicioAtencion()}">
                                    </div>
                                    <div class="form-group">
                                        <label for="horaFinAtencion">Hora Fin Atencion</label>
                                        <input type="text" class="form-control" name="horaFinAtencion" required value="${medico.getHoraFinAtencion()}">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

        <!-- Pie de página o footer -->
        <jsp:include page="/WEB-INF/paginas/medico/comunes/piePagina.jsp" />

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/0370956726.js" crossorigin="anonymous"></script>
    </body>
</html>

