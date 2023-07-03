<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title> 
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="tickets.css" >
</head>
<body class="bg-secondary">  

<!--===================================-->
                <!--Navbar-->
  <!--===================================-->
<nav class="navbar navbar-light bg-dark">
    <span class="navbar-brand h1 text-light pl-3 ml-3">conf Bs As</span>

    <button id="button" class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExample01"
        aria-controls="navbarsExample01" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse fs-16  " id="navbarsExample01" data-spy="scroll" data-target="#navbar-example2"
        data-offset="0">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link text-secondary" href="#">La conferencia</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-secondary" href="#oradores">Los oradores</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-secondary" href="#imagencontexto">El lugar y la fecha</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-light" href="#formulario">Conviértete en orador</a>
            </li>
            <li class="nav-item">
                <a class="nav-link text-success" href="#carouselExampleCaptions">comprar tickets</a>
            </li>
        </ul>
    </div>
</nav> 
 

<!--===================================-->
                <!--tabla-->
  <!--===================================--> 
  <div class="container ">
    <table class="table table-dark">
        <thead> 
            <tr>
                <th scope="col">id</th> 
                <th scope="col">Nombre</th>
                <th scope="col">Apellido</th>
                <th scope="col">Email</th>
                <th scope="col">Categoría</th>
                <th scope="col">Cantidad</th>  
            </tr>
        </thead>
        <tbody>
            
   <?php   
             include("conexionBD.php");
    
   
            $sql = "SELECT * FROM  tickets";
            $consulta = mysqli_query($conexion, $sql);

            if (mysqli_num_rows($consulta) > 0) {
            
            while($fila = mysqli_fetch_assoc($consulta)) {
            echo "
            <tr>
            <td>" . $fila["id"] . "</td>
            <td>" . $fila["nombre"]."</td>
            <td>" . $fila["apellido"]."</td>
            <td>" . $fila["email"]. "</td>
            <td>" . $fila["categoria"]. "</td>
            <td>" . $fila["cantidad"]. "</td>
            </tr>";
            }
        }
           
            mysqli_close($conexion);
      
      ?>
        </tbody>
    </table>
</div>





 
   <!--===================================-->
                <!--Footer-->
  <!--===================================-->

<footer class="d-flex bg-dark text-light pt-4   pb-3  justify-content-center" id="footer">
    <div class="row pt-3" id="textofooter">
        <div class="col-6 col-md">
            <h6 href="#">Preguntas frecuentes</h6>
        </div>
        <div class="col-6 col-md">
            <h6 href="#">Contáctanos</h6>

        </div>
        <div class="col-6 col-md">
            <h6 href="#">Prensa</h6>

        </div>
        <div class="col-6 col-md">
            <h6 href="#">Conferencias</h6>

        </div>
        <div class="col-6 col-md">
            <h6 href="#">Términos y condiciones </h6>

        </div>
        <div class="col-6 col-md">
            <h6 href="#">Privacidad</h6>

        </div>
        <div class="col-6 col-md">
            <h6 href="#">Estudiantes</h6>

        </div>
    </div>
</footer>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>