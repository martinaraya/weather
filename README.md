# weather
Ejercicio para aplicar a Meliá


# ¿Qué has empezado implementando y por qué?

Primero he ampliado la clase test de junit para verificar el comportamiento ante situaciones poco convencionales, por ejemplo:
 - qué pasa si la ciudad que se solicita no es válida
 - qué pasa si la fecha que se solicita es mayor a 6 días
 - qué pasa si la fecha es anterior a hoy

Tengo la costumbre de usar un enfoque TDD, por eso escribí prinero las clases de test

# ¿Qué problemas te has encontrado al implementar los tests y cómo los has solventado?

No he encontrado problemas más allá de la verificación de valores devueltos por los métodos de las clases

# ¿Qué componentes has creado y por qué?

He intentado desacoplar las funcionalidades, las cuales podrían resumirse en:
 - crear una simple clase base para el cliente rest, del cual se heredará la específica para el servicio de www.metawhather.com, esto con la 
 finalidad de que se pueda intercambiar/modificar/mantener el cliente, sin afectar al resto de modulos.
 - refactorizar la clase inicial WeatherForecast para que se comporte como un servicio que hace uso del cliente creado.

# Si has utilizado dependencias externas, ¿por qué has escogido esas dependencias?
 - No he usado dependencias externas
 
# ¿Has utilizado  streams, lambdas y optionals de Java 8? ¿Qué te parece la programación funcional?
 - Para este exjemplo no he usado streams y lambdas. La verdad, pensaba usarlo, pero tengo sólo experiencia usandolo en List y ArrayList, pero por alguna razón que no llego a entender, no he podido usarlo con el JSONArray, y hasta donde pensaba, JSONArrayList es una subclase de ArraList :( 

# ¿Qué piensas del rendimiento de la aplicación? 
 - No me parece malo

# ¿Qué harías para mejorar el rendimiento si esta aplicación fuera a recibir al menos 100 peticiones por segundo?
 - Quizás se podría mejorar la dependencia de la libreria google-http-client porque según he leido es una abtracción a nivel superior. Osea que quizás quitando capas de abstracción podamos mejorar el rendimiento, quizas usando apache-httpclient o algo similar.

# ¿Cuánto tiempo has invertido para implementar la solución? 
 - unas tres horas

# ¿Crees que en un escenario real valdría la pena dedicar tiempo a realizar esta refactorización?
  -Toda mejora y/o optimización de código es siempre bienvenida si es que es parte importante del core.
  
  

