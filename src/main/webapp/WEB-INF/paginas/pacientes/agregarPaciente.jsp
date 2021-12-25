<div class="modal fade" id="agregarPacienteModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-tittle">Agregar Paciente</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControladorPaciente?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="fechaNacimiento">Fecha de nacimiento</label>
                        <input type="text" class="form-control" name="fechaNacimiento" required>
                    </div>
                    <div class="form-group">
                        <label for="idPaciente">Identificación</label>
                        <input type="text" class="form-control" name="idPaciente" required>
                    </div>
                    <div class="form-group">
                        <label for="tipoIdentificacion">Tipo de Identificación</label>
                        <input type="text" class="form-control" name="tipoIdentificacion" required>
                    </div>
                    <div class="form-group">
                        <label for="eps">EPS</label>
                        <input type="text" class="form-control" name="eps" required>
                    </div>
                    <div class="form-group">
                        <label for="historiaClinica">Historia Clinica</label>
                        <input type="text" class="form-control" name="historiaClinica" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>     
                </div>
            </form>
        </div>
    </div>
</div>