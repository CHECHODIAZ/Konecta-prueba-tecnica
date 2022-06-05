# Konecta-prueba-tecnica
APP CAFETERIAKONECTA.

Lenguajes utiliados: JAVA 8, HTML5, CSS3, JAVASCRIPT.
Frameworks y librerias utilizados: SPRING MVC, HIBERNET, JPA, THYMELEAF, BOOTSTRAP.
Base de datos: POSTGRESQL (base de datos en la nube HEROKU).

Funcionamiento:
Cada metodo del controlador esta debidamente documentado para mejor detalle.
Se uso un patron MODELO VISTA CONTROLADOR. una vez corrido el codigo y exista un cliente en la vista:
Habra una pagina inicio con un menu en la parte superior Y con las siguientes opciones:
INICIO (redireccional a esta misma pantalla inicial).
NUEVO (Abre formulario para registrar un producto nuevo).
CONSULTAS (despliega tres opciones: MEJOR STOCK: trae el producto con mayor stock, MAS VENDIDO: muestra el producto mas vendido, OTROS: no derrollada)
CAMPO DE BUSQUEDA (busca un producto por un ID existente en la base datos, ver documentacion del metodo "getOneProduct")
debajo de la barra principal tenemos un TEXTO DE BIENVENIDA y debajo tenemos Un boton: TODOS LOS PRODUCTO (nos permite traer la lista de todos los productos).

Una vez se muestre uno o varios productos en pantalla cada uno de estos podra ser: ELIMIDADO presionando sobre el boton eliminar en la parte derecha de la fila, esto
nos traera un mensage en modal preguntando si estamos seguro en la ejecucion de la opcion;
EDITADO: presionando sobre el boton editar en la parte derecha de la misma fila. el boton editar traera un formulario precargado con la informacion del producto,
aqui podremos cambiar cualquier valor excepto su ID o STOCK. si deseamos actualizar el stock, podemos quitar cantidades del producto registrando la salida en el campo
"CANTIDAD VENDIDA" de esta forma nuestro inventario se actualizara. Podra verificar la efectividad del procedimiento busacando imediatamente el producto editado en la lista
retornada o buscando por ID En el campo busqueda de la barra de navegacion.




