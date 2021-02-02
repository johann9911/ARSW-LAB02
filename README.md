
### Escuela Colombiana de Ingeniería

### Arquitecturas de Software – ARSW
## Laboratorio Programación concurrente, condiciones de carrera, esquemas de sincronización, colecciones sincronizadas y concurrentes - Caso Dogs Race

## Integrantes 
* Lina Maria Buitrago Espindola
* Johann Steven Bogotá Vélez 

### Parte I 

1. Revise el programa “primos concurrentes” (en la carpeta parte1), dispuesto en el paquete edu.eci.arsw.primefinder. Este es un programa que calcula los números primos entre dos intervalos, distribuyendo la búsqueda de los mismos entre hilos independientes. Por ahora, tiene un único hilo de ejecución que busca los primos entre 0 y 30.000.000. Ejecútelo, abra el administrador de procesos del sistema operativo, y verifique cuantos núcleos son usados por el mismo.

    Despues de ejecutar el programa el numero de nucleos que esta usando el sistema es 12.

2. Modifique el programa para que, en lugar de resolver el problema con un solo hilo, lo haga con tres, donde cada uno de éstos hará la tercera parte del problema original. Verifique nuevamente el funcionamiento, y nuevamente revise el uso de los núcleos del equipo.
    
    En esta sección dividimos el trabajo en tres hilos , en 3 intervalos.
    
    ![image](https://user-images.githubusercontent.com/59893804/106672628-5b7aef00-657e-11eb-923e-5abe4859e12e.png)
    
    _El número de núcleos en este caso varia entre 18 y 22 núcleos_


3. Lo que se le ha pedido es: debe modificar la aplicación de manera que cuando hayan transcurrido 5 segundos desde que se inició la ejecución, se detengan todos los hilos y se muestre el número de primos encontrados hasta el momento. Luego, se debe esperar a que el usuario presione ENTER para reanudar la ejecución de los mismo.

     Despues de 5 segundos todos los hilos se detienen y muestran los primos encontrados hasta el momento e indica que si se quiere continuar se presione ENTER 
     
     ![image](https://user-images.githubusercontent.com/59893804/106673089-1f945980-657f-11eb-9895-fe600404769d.png)
     

     Despues de presionar _ENTER_ , el programa reanuda y termina.El proceso se tarda alrededor de 30segundos reanudando los hilos inmediatamente despues de el _stop_ en el          segundo 5   
     
     ![image](https://user-images.githubusercontent.com/59893804/106673599-d690d500-657f-11eb-92e2-e191f58d69d8.png)




### Parte II 


Para este ejercicio se va a trabajar con un simulador de carreras de galgos, cuya representación gráfica corresponde a la siguiente figura:

![](./img/media/image1.png)


Al iniciar la aplicación, hay un primer error evidente: los resultados (total recorrido y número del galgo ganador) son mostrados antes de que finalice la carrera como tal. Sin embargo, es posible que una vez corregido esto, haya más inconsistencias causadas por la presencia de condiciones de carrera.

   Para solucionar este problema hicimos uso del método _join_ que envía la excepcion hasta que el hilo referido termina.
   
   ![image](https://user-images.githubusercontent.com/59893804/106674702-bfeb7d80-6581-11eb-8af5-5729d63f90b9.png)
   
   A pesar de corregir este error encontramos otro y es que cuando la carrera acaba hay más de un ganador ,ya que hay varios galgos que llegan en la posición 1.
   
   ![image](https://user-images.githubusercontent.com/59893804/106674899-135dcb80-6582-11eb-8de0-877be30b889f.png)



Parte III

1.  Corrija la aplicación para que el aviso de resultados se muestre
    sólo cuando la ejecución de todos los hilos ‘galgo’ haya finalizado.
    
    Como ya se menciono anteriormente utilizamos el metodo _join_ para corregir el error y cuando la carrera acaba se notifica el ganador.
    
    ![image](https://user-images.githubusercontent.com/59893804/106675100-794a5300-6582-11eb-9ece-892b8848e153.png)

    Como se ve en la imagen el mensaje se muestra cuando todos los galgos han llegado al final    

2.  Una vez corregido el problema inicial, corra la aplicación varias
    veces, e identifique las inconsistencias en los resultados de las
    mismas viendo el ‘ranking’ mostrado en consola (algunas veces
    podrían salir resultados válidos, pero en otros se pueden presentar
    dichas inconsistencias). A partir de esto, identifique las regiones
    críticas () del programa.
    
    Como ya mencionamos anteriormente el problema que se presenta es que hay mas de un ganador ya que varios galgos toman la posición 1.A partir de eso identificamos las           regiones criticas.
    
    **Regiones Criticas**
    
    La región critica se encuentra en la clase _galgo_ con la variable _regl_ donde se registra la llegada y se cambia la ubicación
    
    ![image](https://user-images.githubusercontent.com/59893804/106675547-4a80ac80-6583-11eb-9beb-17486a71ecdb.png)
    
    
3.  Utilice un mecanismo de sincronización para garantizar que a dichas
    regiones críticas sólo acceda un hilo a la vez. Verifique los
    resultados.
    
    Para corregirlo usamos _synchronized_ de la variable antes mencionada en la región critica 
    
    ![image](https://user-images.githubusercontent.com/59893804/106675850-d7c40100-6583-11eb-9756-2125fc3dbe33.png)
    
    De este modo eliminamos el error que se generaba dandole a cada galgo una posición unica y tambien un solo ganador.
    
    ![image](https://user-images.githubusercontent.com/59893804/106675994-16f25200-6584-11eb-8ddc-a306ded4038a.png)


4.  Implemente las funcionalidades de pausa y continuar. Con estas,
    cuando se haga clic en ‘Stop’, todos los hilos de los galgos
    deberían dormirse, y cuando se haga clic en ‘Continue’ los mismos
    deberían despertarse y continuar con la carrera.
    
    **STOP**
    
    Todos los hilos se detienen 
    
    ![image](https://user-images.githubusercontent.com/59893804/106676476-fbd41200-6584-11eb-9c8c-1f8297b22ca8.png)

    
    **CONTINUE**
    
    Todos los hilos se reanudan y si no hay otro _stop_ finaliza la carrera 
    
    ![image](https://user-images.githubusercontent.com/59893804/106676562-2920c000-6585-11eb-9009-0ea9d1a16ef1.png)
    
    **Resumen de la carrera**
    
    ![image](https://user-images.githubusercontent.com/59893804/106676716-68e7a780-6585-11eb-8b78-c4c9cd2488f1.png)

    

