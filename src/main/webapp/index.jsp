<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Bootstrap CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <title>Inicio</title>
    </head>
    <body>
        <header id="main-header" class="py-2 bg-info text-white">
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1><i class="fas fa-cog"></i>QUILEIA</h1>
                    </div>
                </div>
            </div>
        </header>
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-md-6">
                        <h1>    
                            <a href="pacientes.jsp" class="btn btn-primary btn-lg btn-block">
                                <i class="fas fa-angle-double-right"></i> Gestionar Pacientes
                            </a>
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <h1>    
                            <a href="medicos.jsp" class="btn btn-secondary btn-lg btn-block">
                                <i class="fas fa-angle-double-right"></i> Gestionar Médicos
                            </a>
                        </h1>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6">
                        <h1>    
                            <a href="citas.jsp" class="btn btn-secondary btn-lg btn-block">
                                <i class="fas fa-angle-double-right"></i> Gestionar Citas
                            </a>
                        </h1>
                    </div>
                </div>
            </div>
        </section>

        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://kit.fontawesome.com/0370956726.js" crossorigin="anonymous"></script>
    </body>
</html>
