FROM tomcat:10.1-jdk21

# Eliminamos las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# 1. Copiamos todo el contenido de tu carpeta web real (HTML, JSP, CSS) al ROOT
COPY ["web/", "/usr/local/tomcat/webapps/ROOT/"]

# 2. Como la carpeta 'build' no se sube a GitHub, tomamos directamente 
# tus archivos fuente (.java) que se compilarán dentro del contenedor si es necesario,
# o en este caso, aseguramos que la estructura WEB-INF se mantenga si tienes archivos ahí.
# Copiamos la carpeta WEB-INF que está dentro de tu carpeta 'web' original.
COPY ["web/WEB-INF/", "/usr/local/tomcat/webapps/ROOT/WEB-INF/"]

# Modificamos el server.xml para que escuche en el puerto dinámico de Render
CMD ["sh", "-c", "sed -i 's/port=\"8080\"/port=\"'\"$PORT\"'\"/g' /usr/local/tomcat/conf/server.xml && catalina.sh run"]