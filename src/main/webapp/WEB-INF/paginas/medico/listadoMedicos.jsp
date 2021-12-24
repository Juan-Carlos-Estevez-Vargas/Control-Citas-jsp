<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX" />

<section id="medicos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Médicos</h4>
                    </div> 
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>ID</th>
                                <th>Tipo ID</th>
                                <th># Tarjeta</th>
                                <th>Experiencia</th>
                                <th>Especialidad</th>
                                <th>Inicio</th>
                                <th>Fin</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!<!-- Iterando cada elemento de la lista de clientes -->
                            <c:forEach var="medico" items="${medicos}" >
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
                                        <a href="${pageContext.request.contextPath}/ServletControlador?accion=editar&idMedico=${medico.idMedico}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Agregando las tarjetas para los totales -->
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