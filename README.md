# Sistema de Control Médico Básico

Este es un sistema de control médico básico desarrollado en Java 8 y Swing con una base de datos MySQL 8 o 5. Este sistema permite a los usuarios administrar información médica, pacientes, citas y más.


## Requisitos

Antes de ejecutar este sistema, asegúrate de tener instalado lo siguiente:

- Java 8 o superior
- MySQL Server 8 o 5
- Bibliotecas JDBC para MySQL (normalmente incluidas en tu IDE o proyecto)

## Configuración de la Base de Datos

1. Crea una base de datos MySQL llamada "control_medico" (puedes elegir otro nombre si lo prefieres).
2. Ejecuta el script SQL `control_medico.sql` para crear las tablas necesarias y cargar datos de ejemplo.

3. sql
mysql -u tu_usuario -p control_medico < control_medico.sql
Actualiza la información de conexión a la base de datos en el archivo ConfiguracionBD.java con tus credenciales de MySQL.
java

