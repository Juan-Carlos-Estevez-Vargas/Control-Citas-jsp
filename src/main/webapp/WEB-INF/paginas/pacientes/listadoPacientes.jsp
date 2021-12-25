<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="es_MX" />

<section id="medicos">
    <div class="container">
        <div class="row">
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4>Listado de Pacientes</h4>
                    </div> 
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nombre</th>
                                <th>Nacimiento</th>
                                <th>Identificación</th>
                                <th>Tipo ID</th>
                                <th>EPS</th>
                                <th>Historia Clínica</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <!<!-- Iterando cada elemento de la lista de clientes -->
                            <c:forEach var="paciente" items="${pacientes}" >
                                <tr> 
                                    <td>${paciente.nombre}</td>
                                    <td>${paciente.fechaNacimiento}</td>
                                    <td>${paciente.idPaciente}</td>
                                    <td>${paciente.tipoIdentificacion}</td>
                                    <td>${paciente.eps}</td>
                                    <td>${paciente.historiaClinica}</td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/ServletControladorPaciente?accion=editar&idPaciente=${paciente.idPaciente}" class="btn btn-secondary">
                                            <i class="fas fa-angle-double-right"></i> Editar
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

            <!-- Agregando la tarjeta para los totales -->
            <div class="col-md-3">
                <div class="card text-center bg-success text-white mb-3">
                    <div class="card-body">
                        <h3>Total Pacientes</h3>
                        <h4 class="display-4">
                            <i class="fas fa-users"></i> ${totalPacientes}
                        </h4>
                    </div>
                </div>  
            </div>
        </div>
    </div>
</section>

<!-- Agregar Cliente Modal -->
<jsp:include page="agregarPaciente.jsp" />