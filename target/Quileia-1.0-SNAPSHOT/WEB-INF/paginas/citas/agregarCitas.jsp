<div class="modal fade" id="agregarCitaModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-tittle">Agregar Citas</h5>
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            <form action="${pageContext.request.contextPath}/ServletControladorCitas?accion=insertar" method="POST" class="was-validated">
                <div class="modal-body">
                    <!--<div class="form-group">
                        <label for="nombreMedico">Médico</label>
                        <select>
                            <c:forEach var="medico" items="${citas}" >
                                <option value="nombreMedico">${medico.medico}</option>
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
                    </div>-->
                    <div class="form-group">
                        <label for="nombreMedico">Medico</label>
                        <input type="text" class="form-control" name="nombreMedico" required ">
                    </div>
                    <div class="form-group">
                        <label for="nombre">Paciente</label>
                        <input type="text" class="form-control" name="nombre" required ">
                    </div>
                    <div class="form-group">
                        <label for="hora">Hora</label>
                        <input type="time" class="form-control" name="hora" required ">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>     
                </div>
            </form>
        </div>
    </div>
</div>