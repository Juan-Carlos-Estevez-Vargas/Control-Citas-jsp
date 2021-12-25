<div class="modal fade" id="agregarMedicoModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-tittle">Agregar Médico</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControladorMedico?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre Completo</label>
                        <input type="text" class="form-control" name="nombre" required>
                    </div>
                    <div class="form-group">
                        <label for="idMedico">Identificación</label>
                        <input type="text" class="form-control" name="idMedico" required>
                    </div>
                    <div class="form-group">
                        <label for="tipoIdentificacion">Tipo Identificación</label>
                        <input type="text" class="form-control" name="tipoIdentificacion" required>
                    </div>
                    <div class="form-group">
                        <label for="NTarjetaProfesional">Número Tarjeta Profesional</label>
                        <input type="text" class="form-control" name="NTarjetaProfesional" required>
                    </div>
                    <div class="form-group">
                        <label for="aniosExperiencia">Años de Experiencia</label>
                        <input type="number" class="form-control" name="aniosExperiencia" required>
                    </div>
                    <div class="form-group">
                        <label for="especialidad">Especialidad</label>
                        <input type="text" class="form-control" name="especialidad" required>
                    </div>
                    <div class="form-group">
                        <label for="horaInicioAtencion">Hora Inicio Atención</label>
                        <input type="text" class="form-control" name="horaInicioAtencion" required>
                    </div>
                    <div class="form-group">
                        <label for="horaFinAtencion">Hora Fin Atencion</label>
                        <input type="text" class="form-control" name="horaFinAtencion" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>     
                </div>
            </form>
        </div>
    </div>
</div>