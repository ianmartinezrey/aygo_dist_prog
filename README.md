# aygo_dist_prog
Taller de Introducción a Virtualización y Prog. distribuida

Requisitos 
Tener instalado docker en la computadora

Procedimiento
1. Contenedores con la aplicacion java y base de datos
   a. Desde un terminal ubicarse en la carpeta "aygo", ejecutar el comando: 
      docker-compose up -d 
      
   b. Con los siguiente comandos crear 3 instancias de la aplicacion java
    •	docker run -d -p 34000:4567 --name firstdockercontainer --expose 34000 --network backend --link dbmongo:dbmongo aygo_web
    •	docker run -d -p 34001:4567 --name firstdockercontainer2 --expose 34001 --network backend --link dbmongo:dbmongo aygo_web
    •	docker run -d -p 34002:4567 --name firstdockercontainer3 --expose 34002 --network backend --link dbmongo:dbmongo aygo_web
    
2. Contenedor balanceador de carga
   a. Desde un terminal ubicarse en la carpeta "lblginx", ejecutar el comando: 
      docker run -d -p 8080:8080 --name lbnginx --expose 8080 --network backend lbnginx

3. Con el siguiente "docker ps" se visualizan todos los contenedores creados.

4. Abrir la aplicacion desde un navegador y ejecutar los servicios creados:
  a. Mostrar los ultimos 10 registros almacenados
     GET
     http://localhost:8080
  
  b. Agregar un registro a la base de datos
     POST
     http://localhost:8080/add   {name: "test"}
