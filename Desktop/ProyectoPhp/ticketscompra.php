<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
    <link rel="stylesheet" href="practica.css">
    <script src="script.js"></script>
    <title>Compra</title> 
</head>
<body>
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
                <!--Cards-->
  <!--===================================-->  
<section class=" justify-content-center d-flex pt-4 " id="cards">
    <div class=" text-center border border-primary mr-3 pr-2 pl-2 pt-2 pb-2 card" >
        <h4 class="pb-2">Estudiante</h4>
        <h6 class="pb-2">Tienen un descuento</h6>
        <h5 class="pb-2">80%</h5>
        <p class="text-secondary">* presentar documentación</p>
    </div>
    <div class=" text-center border border-success mr-3 pr-2 pl-2 pt-2 pb-2 card">
        <h4 class="pb-2">Trainee</h4>
        <h6 class="pb-2">Tienen un descuento</h6>
        <h5 class="pb-2">50%</h5>
        <p class="text-secondary">* presentar documentación</p>
    </div>
    <div class=" text-center border border-warning pr-2 pl-2 pt-2 pb-2 card">
        <h4 class="pb-2">Junior</h4>
        <h6 class="pb-2">Tienen un descuento</h6>
        <h5 class="pb-2">15%</h5>
        <p class="text-secondary">* presentar documentación</p>
    </div>
</section>

<!--===================================-->
                <!--Form-->
  <!--===================================-->
<form class="container-fluid col-6 justify-content-center text-center pt-3 " id="formulario" method="POST" action="datosCompra.php">
    <h6>venta</h6>
    <h1>VALOR DE TICKET 200$</h1>
    <div class="form-row">
        <div class="col">
            <input type="text" class="form-control" placeholder="Nombre" name="nombre" required>
        </div>
        <div class="col">
            <input type="text" class="form-control" placeholder="Apellido" name="apellido" required>
        </div>
    </div>
    <div class="form-group pt-3">
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp"
            placeholder="Correo" name="email" required> 
    </div>
    <div class="form-row">
        <div class="col">
            <label for="">Cantidad</label>
            <input type="number" class="form-control" placeholder="Cantidad" id="cantidadEntradas" name="cantidad" >
        </div>
        <div class="col">
            <label for="inputState">Categoria</label>
            <select id="inputState" class="form-control" name="categoria" >
                <option value="estudiante" >Estudiante</option>
                <option value="trainee" >Trainee</option>
                <option value="junior" >Junior</option> 
                <option value="general" >General</option>
            </select>
        </div>
    </div>
    <div class="bg-info text-light mt-3 pt-2 pb-2 rounded text-left pl-2" >
        <p >total a pagar : <span id="totalapagar" ></span> </p>
    </div>
       
   
    <div class=" mt-4 d-flex justify-content-center">
        <button type="button" class=" btn btn-success btn-block">Borrar</button>
        <button type="button" class=" btn btn-success btn-block m-0 p-2 ml-1"  onclick="validarPrecio()" >Resumen</button>
    </div>
    <div>
    <button type="submit" class=" btn btn-primary btn-block mt-2" >Comprar</button>
    </div>
</form>


   <!--===================================-->
                <!--Footer-->
  <!--===================================-->


  <footer class="d-flex bg-dark text-light pt-4  mt-3 pb-3  justify-content-center">
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
            <h6> <a href ="tickets.php#" class="text-light">Tickets</a></h6>

        </div>
    </div> 

    
</footer>






<script src="script.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js" integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s" crossorigin="anonymous"></script>
</body>
</html>