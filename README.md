[![Presentación WEB Endless Electronic Music](https://img.youtube.com/vi/puVFGFXAqpk/0.jpg)](https://www.youtube.com/embed/puVFGFXAqpk)
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
Lo primero que hemos hecho al comenzar esta fase ha sido crear una página admin, a la que sólo tenemos acceso los usuarios registrados con el rol de administrador. En esta página se pueden añadir elementos a nuestra base de datos y, por consiguiente, a nuestra web, de una forma sencilla. También se pueden borrar los elementos ya creados. En la siguiente captura de pantalla se pueden apreciar las tablas ya creadas y las opciones para añadir más canciones, artistas, eventos o posts.

![Administración](http://i.imgur.com/e6kpTgE.jpg "Admin")

**Navegación**

Lo siguiente fue implementar seguridad en nuestra página mediante Spring Security. Cuando un usuario quiera iniciar sesión o registrarse lo hará a través del siguiente formulario:

![Login](http://i.imgur.com/ZvZ261I.jpg "Registro")

Esto ha cambiado respecto a la fase anterior, en la que el registro y el logueo se hacía a través de un pop up.
Se puede acceder a esta nueva página desde cualquiera de los otros apartados de nuestra web. Sin embargo, la web redirigirá automáticamente a esta página a cualquier persona que intente acceder a la ficha de una canción, evento o post, para votar o comentar, si esta persona no está logueada. Una vez se loguee o se registre, la web le redigirá automáticamente hacia la canción o entrada a la que ha intentado acceder.
Por todo esto, el diagrama de navegación también cambia un poco respecto a la fase anterior:

![Diagrama](http://i.imgur.com/BCoOizX.jpg "Nuevo")

**Servicio interno**

El servicio interno que hemos implementado para nuestra aplicación web es un servidor de correo electrónico. Su función es enviar un email de bienvenida a los usuarios cuando se registran en nuestra página.

Este servidor de correo se comunica con nuestra página mediante comunicación por sockets, una de las técnicas que nos explicaron en el tema 3 de la asignatura. Desde el cliente se envía un list con el nombre de usuario y su email y es el servidor el que envía el correo con nuestro mensaje.

**Diagrama de clases y templates**

En la siguiente imagen se puede apreciar el conjunto de clases que forman nuestra web, su tipo y las relaciones que existe entre ellas:

![Diagrama](http://i.imgur.com/HijSInk.jpg "De clases")

**Instrucciones para desplegar la aplicación en Azure**

Para que nuestra página funcione correctamente en Azure, hemos seguido los siguientes pasos:

1. Generamos un certificado pem para poder acceder a la máquina y protegemos la clave privada.
2. Creamos nuestra primera máquina virtual en Azure, accedemos a ella con un cliente ssh usando nuestra clave privada, le instalamos java 8 y mysql y generamos una imagen a partir de ella.
3. Generamos el jar en nuestra aplicación con la opción mvn build... package.
4. Desde la consola, vamos a la carpeta target de nuestro proyecto, donde se ha generado el jar, y lo subimos mediante un comando scp -i.
5. Accedemos a la máquina virtual donde hemos subido el jar mediante el comando ssh -i e iniciamos la aplicación con java -jar.
6. Accedemos a la aplicación via web. Antes de esto, habremos tenido que abrir el puerto para https 8443 y mapearlo al 8443 de nuestra máquina.

**Comandos AZURE**

ssh -i azureus.key -p 22 azureuser@dadeem.cloudapp.net

scp -i azureus.key EndlessElectronicMusic-0.0.1-SNAPSHOT.jar azureuser@dadeem.cloudapp.net:/home/azureuser/

scp -i azureus.key MailService-0.0.1-SNAPSHOT.jar azureuser@dadeem.cloudapp.net:/home/azureuser/

ssh -i azureus.key -p 22 azureuser@dadeem.cloudapp.net java -jar EndlessElectronicMusic-0.0.1-SNAPSHOT.jar
ssh -i azureus.key -p 22 azureuser@dadeem.cloudapp.net java -jar MailService-0.0.1-SNAPSHOT.jar

## Fase 4 ##
La primera tarea que hemos llevado a cabo en esta última fase, ha sido cambiar la forma en la que nuestra aplicación web se comunica con nuestro servicio interno de envío de correos electrónicos. Hemos pasado de una comunicación mediante sockets a una por API REST. Ahora el servicio está formado por tres clases: Application.java, tablonController.java y mailRestController.java.

El diagrama de clases y templates ha variado ligeramente debido a los cambios en el servicio interno y a la implementación de que algunas consultas se puedan cachear. Este es el resultado final:

![Diagrama](http://i.imgur.com/991HVqX.jpg "Clases y templates")

En el siguiente diagrama se puede ver cómo hemos distribuido nuestra aplicación en Azure. Utilizamos 9 máquinas virtuales ditintas: 3 para los balanceadores de carga, 2 para el servicio web, 2 para el servicio interno y 2 para la base de datos. 

![Diagrama](http://i.imgur.com/PPJUJT3.jpg "Azure")
