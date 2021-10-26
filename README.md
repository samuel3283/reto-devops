### Features

- Servicio Rest 
- Desplegado desde jenkins a una instancia AWS EC2 con docker
- Utiliza JMeter para el functional test


####Stages del Pipeline　

```
Stage build
Stage test
Stage deploy
Stage functional test

```


####Parametros del Pipeline　para integración con JMeter

```
Hilo: Número de hilos a ejecutar
Repetición: Número de iteraciones por hilo

```

                    
###Servicio Lista Clientes
                    
Key  | Value
------------- | -------------
Endpoint  | http://ec2-54-234-174-119.compute-1.amazonaws.com:8085/services/rest/listClient
Method  | GET
Response  | [{ "email": "sramos@gmail.com",   "nombre": "Sergio Ramos"  }]

                
----

                    
###Servicio Crea Cliente
                    
Key  | Value
------------- | -------------
Endpoint  | http://ec2-54-234-174-119.compute-1.amazonaws.com:8085/services/rest/crearcliente
Method  | POST
Request  | { "email": "sramos@gmail.com",   "nombre": "Sergio Ramos"  }
Response  | { "code": "OK",  "description": "Usuario Sergio Ramos grabado." }

                
----

