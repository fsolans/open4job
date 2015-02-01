# ejercicio-jdbc

# Dependencias de Maven

Como el driver JDBC de Oracle obliga a aceptar la licencia, éste no puede descargarse de ningún repositorio por lo que se incluye el jar descargado directamente del fabricante y debe instalarse de forma local para que Maven lo encuentre.

mvn install:install-file -Dfile={Path/to/your/ojdbc6.jar} -DgroupId=com.oracle 
-DartifactId=ojdbc6 -Dversion=11.2.0.4 -Dpackaging=jar

# Compilación del proyecto

mvn compile

