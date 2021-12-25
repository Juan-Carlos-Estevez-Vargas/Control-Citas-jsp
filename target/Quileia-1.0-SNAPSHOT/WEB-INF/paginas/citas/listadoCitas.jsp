<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX" />

<section id="citas">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Citas</h4>
                    </div> 
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>ID Cita</th>
                                <th>Médico</th>
                                <th>Paciente</th>
                                <th>Hora Cita</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!-- Iterando cada elemento de la lista de médicos -->
                            <c:forEach var="cita" items="${citas}" >
                                <tr> 
                                    <td>${medico.nombre}</td>
                                    <td>${medico.idMedico}</td>
                                    <td>${medico.tipoIdentificacion}</td>
                                    <td>${medico.NTarjetaProfesional}</td>
                                    <td>${medico.aniosExperiencia}</td>
                                    <td>${medico.especialidad}</td>
                                    <td>${medico.horaInicioAtencion}</td>
                                    <td>${medico.horaFinAtencion}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControladorMedico?accion=editar&idMedico=${medico.idMedico}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Agregando la tarjeta para el total de médicos -->
            <div class="col-md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Médicos</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalMedicos}
                        </h4>
                    </div>
                </div>  
            </div>
        </div>
    </div>
</section>

<!-- Agregar Cliente Modal -->
<jsp:include page="agregarMedico.jsp" />