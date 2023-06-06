

function validarPrecio(){  

    //aca traemos los valores con su id desde el html
       const cantidadEntradas = document.getElementById('cantidadEntradas');
       const categoria = document.getElementById('inputState');
       const totalaPagar = document.getElementById('totalapagar');
       //este es el valor de la entrada 
       
       let descuento = 0;

       //vamos a imprimir por consola el valor de cada constante 

       

        
        
    if (categoria.value == "estudiante") { 

        descuento = (cantidadEntradas.value*200)*0.80;

         totalaPagar.innerHTML = "" + cantidadEntradas.value*200 - descuento + " $ "; 

    

    } else if (categoria.value == "trainee") { 

        descuento = (cantidadEntradas.value*200)*0.50;

         
        totalaPagar.innerHTML = "" + cantidadEntradas.value*200 - descuento + " $ "; 

         

    } else if (categoria.value == "junior") { 

        descuento = (cantidadEntradas.value*200)*0.15;


        totalaPagar.innerHTML = "" +cantidadEntradas.value*200 - descuento + " $ ";  
        

   }  
     
       
} 


    
   



