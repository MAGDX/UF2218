<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>JSP - Java Server Page</h1>
<hr>

<p>JavaServer Pages (JSP) es una tecnolog�a que ayuda a los desarrolladores de software a crear p�ginas web din�micas basadas en HTML y XML, entre otros tipos de documentos. JSP es similar a PHP, pero usa el lenguaje de programaci�n Java.</p>
<p>Para desplegar y correr JavaServer Pages, se requiere un servidor web compatible con contenedores servlet como Apache Tomcat o Jetty.</p>
<p>TagLibs -> JSP -> Servidor Aplicaciones (Servlets) -> Cliente (Navegador)</p>
<p>El rendimiento de una p�gina JSP es el mismo que tendr�a el servlet equivalente, ya que el c�digo es compilado como cualquier otra clase Java. A su vez, la m�quina virtual compilar� din�micamente a c�digo de m�quina las partes de la aplicaci�n que lo requieran. Esto hace que JSP tenga un buen desempe�o y sea m�s eficiente que otras tecnolog�as web que ejecutan el c�digo de una manera puramente interpretada.</p>
<p>La principal ventaja de JSP frente a otros lenguajes es que el lenguaje Java es un lenguaje de prop�sito general que excede el mundo web y que es apto para crear clases que manejen l�gica de negocio y acceso a datos de una manera prolija. Esto permite separar en niveles las aplicaciones web, dejando la parte encargada de generar el documento HTML en el archivo JSP.</p>
<p>Otra ventaja es que JSP hereda la portabilidad de Java, y es posible ejecutar las aplicaciones en m�ltiples plataformas sin cambios. Es com�n incluso que los desarrolladores trabajen en una plataforma y que la aplicaci�n termine siendo ejecutada en otra.</p>
<p>Los servlets y Java Server Pages (JSPs) son dos m�todos de creaci�n de p�ginas web din�micas en servidor usando el lenguaje Java. En ese sentido son similares a otros m�todos o lenguajes tales como el PHP, ASP o los CGIs, programas que generan p�ginas web en el servidor. Sin embargo, se diferencian de ellos en otras cosas.</p>
<p>Para empezar, los JSPs y servlets se ejecutan en una m�quina virtual Java, lo cual permite que, en principio, se puedan usar en cualquier tipo de ordenador, siempre que exista una m�quina virtual Java para �l. Cada servlet (o JSP, a partir de ahora lo usaremos de forma indistinta) se ejecuta en su propio hilo, es decir, en su propio contexto; pero no se comienza a ejecutar cada vez que recibe una petici�n, sino que persiste de una petici�n a la siguiente, de forma que no se pierde tiempo en invocarlo (cargar programa + int�rprete). Su persistencia le permite tambi�n hacer una serie de cosas de forma m�s eficiente: conexi�n a bases de datos y manejo de sesiones, por ejemplo.</p>
<p>Las JSPs son en realidad una forma alternativa de crear servlets ya que el c�digo JSP se traduce a c�digo de servlet Java la primera vez que se le invoca y en adelante es el c�digo del nuevo servlet el que se ejecuta produciendo como salida el c�digo HTML que compone la p�gina web de respuesta.</p>

<h2>Descripci�n</h2>
<hr>
<p>JSP puede ser visto como una abstracci�n de alto nivel de los servlets Java. Las JavaServer Pages son traducidas a servlets en tiempo real; cada servlet es guardado en cach� y rehusado hasta que la JSP original es modificada. Dicho en otras palabras un JSP son p�ginas java para un ambiente web.</p>

<h2>Sintaxis</h2>
<hr>
<h4>Directivas</h4>
<section class="p-2 bg-light">
	<code>&lt;%@ directiva atributo="valor" %&gt;</code>
</section>
<h4>Declaraciones</h4>
<section class="p-2 bg-light">
	<code>&lt;%! int maxAlumnosClase = 30; %&gt;</code>
</section>
<h4>Scriptlets</h4>
<section class="p-2 bg-light">
	<code>&lt;% ... Codigo Java ... %&gt;</code>
</section>
<h4>Expresiones</h4>
<section class="p-2 bg-light">
	<code>&lt;%= maxAlumnosClase + 1%&gt;</code>
</section>

<%@include file="../includes/footer.jsp"%>