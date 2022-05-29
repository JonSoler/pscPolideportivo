# ⛹️🏐 PSC Polideportivo 🏸🏊

PSC Polideportivo es una aplicación mediante la cual el cliente podrá reservar las distintas instalaciones disponibles del polideportivo. Para ello, deberá elegir un horario que no esté ocupado previamente. En el caso de que fuese necesario, también podrá reservar los materiales para realizar dicha actividad. 

## 📋 Pre-requisitos

Para la ejecución de PSC Polideportivo es necesario tener los siguientes programas correctamente instalados y configurados:

* [Java JDK 8]         (https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
* [Apache Maven (bin)] (https://maven.apache.org/download.cgi)
* [XAMPP]              (https://www.apachefriends.org/es/index.html)
  (Alternativamente también es posible usar):  
  [MySQL Workbench]    (https://dev.mysql.com/downloads/workbench/)


## 🚀 Comenzando

Para obtener una copia local del proyecto en funcionamiento para propósitos de desarrollo y pruebas es necesario descargarse el siguiente repositorio e importarlo a un IDE de programación compatible con los requisitos previamente nombrados.

https://github.com/JonSoler/pscPolideportivo.git


## 🔧 Instalación y ejecución

El primer paso será abrir nuesta herramienta de base de datos como "XAMPP" o "MySQL Workbench" y ejecutar el archivo "BDpolideportivo.sql" que aparece en la carpeta src/main/sql-BD con un usuario root. De esta manera, crearemos el esqueleto de la base de datos del proyecto.

Para la ejecución del proyecto es necesario abrir dos instancias del "cmd" (Símbolo del sistema) y ejecutar los siguientes comandos sin cerrar en ningún momento ninguna de las instancias:
 
Para ejecutar el servidor:

* "mvn clean" 
* "mvn compile"
* "mvn datanucleus:enhance" (Este comando solo es necesario realizarlo la primera vez que se realiza este proceso)
* "mvn datanucleus:schema-create" (Este comando solo es necesario realizarlo la primera vez que se realiza este proceso, sirve para crear las tablas en la BD)
* "mvn exec:java -PServer"

Para ejecutar el cliente (en la otra instancia del cmd):

* "mvn exec:java -PClient"


## 🛠️ Construido con

A continuación se detallan las herramientas utilizadas para crear el proyecto:

* [Eclipse]         (https://www.eclipse.org/) - Entorno de desarrollo de software 
* [Apache Maven]    (https://maven.apache.org/) - Manejador de dependencias
* [Log4j]           (http://logging.apache.org/log4j/1.2/) - Logger
* [JaCoCo]          (https://www.eclemma.org/jacoco/) - Analisis de teses y cobertura
* [Doxygen]         (https://www.doxygen.nl/) - Generar documentación
* [GitHub Actions]  (https://github.com/features/actions) - Integración continua
* [Sonarcloud]      (http://logging.apache.org/log4j/1.2/) - Bugs y vulnerabilidades


## ✒️ Autores

* [Jon Soler]          (https://github.com/JonSoler/pscPolideportivo)
* [Aitor Bonilla]      (https://github.com/bonillaaitor)


También es posible consultar la lista de todos los contribuyentes en GitHub:
https://github.com/JonSoler/pscPolideportivo/graphs/contributors 


## ℹ️ Versión

PSC Polideportivo© ver. 4.0 - 2022-05-29
