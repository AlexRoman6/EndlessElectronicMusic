# Endless Electronic Music #
Esta aplicación tratará sobre el mundo de la música electrónica. Será un lugar donde poder conocer a los artistas más destacados y las mejores canciones de cada uno de los estilos, además de ver los temas mejor valorados por los usuarios y seguir los grandes festivales. 
- **Parte pública**: el usuario va a poder navegar por cada una de las entidades que describiremos más tarde. 
- **Parte privada**: el usuario deberá loguearse para tratar diferentes temas con otros usuarios y para poder votar positiva o negativamente las canciones. Igualmente, implementaremos un servicio de correo electrónico que enviará a los usuarios registrados, cada cierto periodo de tiempo, la lista de las canciones con mejor valoración.

Las entidades que se pueden distinguir en nuestra web son las siguientes:
- **Artistas**: Aquí aparecerán los diferentes músicos que aparecerán en nuestra web.
- **Canciones**: Listas de canciones de los artistas.
- **Estilos**: Diferentes estilos que engloba la música electrónica.
- **Mejor valoradas**: Lista con las canciones que más votos positivos obtienen.
- **Eventos**: Distintas actuaciones en conciertos o festivales.
- **Blog**: Los usuarios podrán comentar las entradas.

Los desarrolladores de esta web somos:
- David García Herrero. Correo URJC: d.garciaherr@alumnos.urjc.es. Cuenta en Github: Davidgh96.
- Alejandro Román Matellanes. Correo URJC: a.romanma@alumnos.urjc.es. Cuenta en Github: AlexRoman6.
- Francisco Moreno Tejeda. Correo URJC: f.morenot.2016@alumnos.urjc.es. Cuenta en Github: framortej.

## Fase 2 ##
En esta fase hemos planificado cómo va a ser nuestra aplicación. En el siguiente diagrama de navegación se puede ver cómo movernos entre las distintas pantallas de la web. 

![Diagrama](http://i.imgur.com/j9C1Xiy.png "De navegacion")

Para esta fase no hemos diferenciado entre la parte pública y la privada, puesto que no es necesario. Sin embargo, hemos decidido que la parte privada será para que el usuario pueda escribir en el blog y votar las diferentes canciones, y el resto de la página será pública.

A continuación, mostramos un diagrama UML de nuestra base de datos MySQL, en el que pueden verse las entidades con sus atributos y las relaciones que existen entre ellas.

![UML](http://i.imgur.com/yKX12c3.png "UML")

Cabe destacar que hasta la fase siguiente no existirá una relación entre los usuarios y las canciones, ya que será entonces cuando los usuarios puedan registrarse en la página y votar. Para entonces, nuestra página seguirá este diagrama entidad-relación.

![ER](http://i.imgur.com/FjMDqZd.jpg "ER")
