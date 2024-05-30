# Proyecto Final TAP

# Sistema de Control Médico

Este es un sistema de control médico básico desarrollado en Java 8 y Swing con una base de datos MySQL 8 o 5. Este sistema permite a los usuarios administrar información médica, pacientes, citas y más.

## Arquitectura MVC

El patrón Modelo-Vista-Controlador (MVC) es una arquitectura de software que separa una aplicación en tres componentes principales:

### Modelo (Model)

Representa la lógica de negocio y la estructura de datos de la aplicación. Se encarga de gestionar los datos, la lógica y las reglas del negocio. En tu proyecto, los archivos del modelo están en el paquete `Modelo`. Estos incluyen:

- `appPrincipal.java`
- `modeloDatos.java`
- `modeloUsuario.java`

### Vista (View)

Es la interfaz de usuario de la aplicación. La vista muestra los datos del modelo al usuario y envía las acciones del usuario al controlador. En el proyecto, los archivos de la vista están en el paquete `Vista`. Estos incluyen:

- `addUsuarios.java`
- `editUsuarios.java`
- `loginInMedico.java`
- `vistaCitas.java`
- `vistaControlDatos.java`
- `vistaNuevaCita.java`
- `vistaPacientes.java`
- `vistaPrincipal.java`
- `vistaRecetasMedicas.java`
- `vistaRegistroPaciente.java`
- `vistaUnidadMedica.java`
- etc.

### Controlador (Controller)

Actúa como un intermediario entre el modelo y la vista. Recibe la entrada del usuario desde la vista, procesa la entrada con el modelo y actualiza la vista. En el proyecto, los archivos del controlador están en el paquete `Controlador`. Estos incluyen:

- `ControlReports.java`
- `ControladorReportePreesincripcion.java`
- `EmailSender.java`
- `controladorAmbulancia.java`
- `controladorBD.java`
- `controladorLibrerias.java`
- `controladorReporteTabla.java`
- etc.

### Conexión a la Base de Datos

Además, hay un paquete `com.mysql.jdbc` que  se utiliza para la conexión a la base de datos, y contiene:

- `Connection.java`

## Requisitos

Antes de ejecutar este sistema, asegúrate de tener instalado lo siguiente:

- Java 8 o superior
- MySQL Server 8 o 5
- Bibliotecas JDBC para MySQL (normalmente incluidas en tu IDE o proyecto)

## Configuración de la Base de Datos

1. Crea una base de datos MySQL llamada `control_medico` (puedes elegir otro nombre si lo prefieres).
2. Ejecuta el script SQL `control_medico.sql` para crear las tablas necesarias y cargar datos de ejemplo:

    ```sh
    mysql -u tu_usuario -p control_medico < control_medico.sql
    ```

3. Actualiza la información de conexión a la base de datos en el archivo `ConfiguracionBD.java` con tus credenciales de MySQL.

 ## Configurar Correo Electrónico:
Antes de utilizar el componente, asegúrate de configurar el correo electrónico desde el cual se enviarán los mensajes, así como el servidor SMTP. 
Para hacer esto, busca en el código del componente la sección donde se especifica el servidor SMTP y el puerto del correo electrónico:

String smtpServer = "smtp.example.com"; // Cambia "smtp.example.com" por tu servidor SMTP 

String smtpPort = "el puerto"; // Cambia "el puerto" por el puerto SMTP correspondiente 

Antes de utilizar el componente, asegúrate de configurar el correo electrónico desde el cual se enviarán los mensajes. 
Para hacer esto, busca en el código del componente la sección donde se especifica el nombre de usuario y la contraseña del correo electrónico:


String username = "tucorreo@gmail.com"; // Cambia por tu dirección de correo electrónico 

String password = "tupassword"; // Cambia por tu contraseña 

## Utilizar el Programa

Una vez hayas configurado la Base de Datos, Configurado las credenciales para las notificaciones de Correos Electronicos, Importado todas las Librerias de la carpeta Lib 

* Daras click derecho en el proyecto y Clean and Build
* Ejecutaras la Clase appPrincipal.java Y listo. Deberia dejarte Iniciar sesion ( usuario:admin pass:admin )

![image](https://github.com/Betinsky/Proyecto-Final/assets/168485195/d49cc9ce-816d-48a0-b5c7-725946ccf453)

* Pulsaras Aceptar y se te desplegara el menu principal

![image](https://github.com/Betinsky/Proyecto-Final/assets/168485195/133f0259-0b56-483f-a72d-d95287ff5a2e)



