<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/6784074dee.js" crossorigin="anonymous"></script>
    <title>Lista</title> 
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
       
        <a class="nav-link active" aria-current="page" href="ingresarProducto.php">Ingresar Productos</a> 
        
       </div>
    </div>
  </div>
</nav> 

<!--===================================-->
                <!--tabla-->
  <!--===================================--> 
  <div class="container mt-5 ">
    <table class="table table-light text-dark">
        <thead> 
            <tr>
                <th scope="col">Id</th> 
                <th scope="col">Nombre</th>
                <th scope="col">Marca</th>
                <th scope="col">Hecho en</th>
                <th scope="col">Precio</th>
                <th scope="col">Acciones</th> 
              
            </tr>
        </thead>
        <tbody>
            
   <?php   
             include("conexion.php");
    
   
            $sql = "SELECT * FROM  productos"; 
            $consulta = mysqli_query($conexion, $sql);

            if (mysqli_num_rows($consulta) > 0) {
            
            while($fila = mysqli_fetch_assoc($consulta)) {
            echo "
            <tr>
            <td>" . $fila["id"] . "</td>
            <td>" . $fila["nombre"]."</td>
            <td>" . $fila["marca"]."</td>
            <td>" . $fila["hecho"]. "</td>
            <td>" . $fila["precio"]. "</td>
            <td><a href=\"modificarProductos.php?id=" . $fila["id"] . "\"><i class=\"fa-solid fa-pen-to-square fa-beat\"></i></a> 
            <a href=\"eliminarDatos.php?id=" . $fila["id"] . "\"><i class=\"fa-solid fa-trash fa-shake\"></i></a> </td>
           </tr>";
           
           }
        }
           
            mysqli_close($conexion);
      
      ?> 
      
        </tbody>
    </table>
</div>

  


  
    






  
    


<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.min.js" integrity="sha384-fbbOQedDUMZZ5KreZpsbe1LCZPVmfTnH7ois6mU1QK+m14rQ1l2bGBq41eYeM/fS" crossorigin="anonymous"></script>
</body>
</html>