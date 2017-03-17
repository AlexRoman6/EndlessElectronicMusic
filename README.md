# Endless Electronic Music #
Esta aplicación tratará sobre el mundo de la música electrónica. Será un lugar donde poder conocer a los artistas más destacados y las mejores canciones de cada uno de los estilos, además de ver los temas mejor valorados por los usuarios y seguir los grandes festivales. 
- **Parte pública**: el usuario va a poder navegar por cada una de las entidades que describiremos más tarde. 
- **Parte privada**: el usuario deberá loguearse para tratar diferentes temas con otros usuarios y para poder votar positiva o negativamente las canciones. Igualmente, implementaremos un servicio de correo electrónico que enviará a los usuarios un mensaje de bienvenida cuando se registren en nuestra página.

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

**Páginas principales diseñadas**

- Inicio: Presenta una breve introducción, con información referida a nuestra página. Además, dispone de un espacio con las últimas canciones de la página y otro con las últimas entradas de los blogs, pudiendo visitarlas si se desea.

![Inicio](http://i.imgur.com/LjmkAsT.jpg "Inicio")

- Canciones: Contiene toda las canciones de nuestra página. Se pueden ordenar y clasificar por los siguientes criterios:

     - *Nombre*: Ordena las canciones alfabéticamente.
     - *Artista*: Ordena las canciones por el nombre del artista alfabéticamente.
     - *Genero*: Ordena las canciones por su género musical.
     - *Año*: Ordena las canciones por el año de creación de las mismas.
     ---    
     Pulsando en cada una de ellas podemos ir a su ficha.

![Canciones](http://i.imgur.com/DdpmeQ5.jpg "Canciones")

- Ficha de la canción: Se muestran los datos de cada canción, entre ellos su videoclip. Además, se muestran una canción del mismo género y otra del mismo autor, pudiendo visualizar su ficha de igual manera.

![Cancion](http://i.imgur.com/Jfpfg9Q.jpg "Cancion")

- Eventos: Lista de todos los eventos de nuestra página, indicándonos su temática y su localización, entre otros datos. Pulsando en cada uno de ellos iremos a su entrada.

![Eventos](http://i.imgur.com/TztmdCU.jpg "Eventos")

- Ficha del evento: Muestra información sobre el evento y los comentarios que han hecho los usuarios.

![Evento](http://i.imgur.com/n02E5ic.jpg "Evento")

- Noticias: Lista de todos los posts que publicamos en nuestra página. Pulsando en cada uno de ellos iremos a su entrada.

![Noticias](http://i.imgur.com/NRAemwd.jpg "Noticias")

- Ficha de la noticia: Muestra información sobre cada post y los comentarios que han hecho los usuarios.

![Noticia](http://i.imgur.com/nRIRsfc.jpg "Noticia")

- Staff: Aparecen los administradores de la página e información sobre ellos.

![Equipo](http://i.imgur.com/OjvB9XY.jpg "Equipo")

- Contacto: Muestra en un mapa nuestra ubicación e invita a rellenar un formulario para contactar con los administradores de la página.

![Contacto](http://i.imgur.com/WTXDibZ.jpg "Contacto")

## Fase 3 ##
Lo primero que hemos hecho al comenzar esta fase ha sido crear una página admin, a la que sólo tenemos acceso los usuarios registrados con el rol de administrador. En esta página se pueden añadir elementos a nuestra base de datos y, por consiguiente, a nuestra web, de una forma sencilla. En la siguiente captura de pantalla se pueden apreciar las tablas ya creadas y las opciones para añadir más canciones, artistas, eventos o posts.

