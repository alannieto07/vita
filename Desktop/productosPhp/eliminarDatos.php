<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <title>Document</title>
</head>
<body>
    <!--===================================-->
                <!--Navbar-->
  <!--===================================--> 
  <nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">Productos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
      <div class="navbar-nav">
        <a class="nav-link active" aria-current="page" href="lista.php">Lista de tickets</a>
       </div>
    </div>
  </div>
</nav> 



<?php
$id = $_GET["id"];

include("conexion.php");

try{ 
    $sql = "DELETE FROM productos WHERE id = '$id'";
$consulta = mysqli_query($conexion,$sql); 
?>
<section>
<div class="alert alert-success mt-5 text-center" role="alert">
<h4 class="alert-heading"> El Producto se elimino con exito!</h4> 
<p class="mb-0"></p>
</div>
</section> 
<?php

}catch(Exception $th){ 
    ?> 
<section>
<div class="alert alert-success mt-5 text-center" role="alert">
<h4 class="alert-heading"> El Producto no pudo ser elimninado!</h4>  
<p class="mb-0"></p>
</div>
</section> 
<?php
exit();
}
?>









<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>