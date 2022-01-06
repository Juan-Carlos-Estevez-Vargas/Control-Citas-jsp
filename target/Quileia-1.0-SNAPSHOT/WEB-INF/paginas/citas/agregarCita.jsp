<div class="modal fade" id="agregarCitasModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-tittle">Agregar Cita</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControladorCitas?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="idCita">ID Cita</label>
                        <input type="number" class="form-control" name="idCita" required>
                    </div>
                    <div class="form-group">
                        <label for="medico">Médico</label>
                        <input type="text" class="form-control" name="medico" required>
                    </div>
                    <div class="form-group">
                        <label for="paciente">Paciente</label>
                        <input type="text" class="form-control" name="paciente" required>
                    </div>
                    <div class="form-group">
                        <label for="hora">Hora</label>
                        <input type="text" class="form-control" name="hora" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>     
                </div>
            </form>
        </div>
    </div>
</div>