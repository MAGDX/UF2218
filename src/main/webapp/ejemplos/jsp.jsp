<%@include file="../includes/header.jsp"%>
<%@include file="../includes/navbar.jsp"%>

<h1>JSP - Java Server Page</h1>
<hr>

<p>JavaServer Pages (JSP) es una tecnología que ayuda a los desarrolladores de software a crear páginas web dinámicas basadas en HTML y XML, entre otros tipos de documentos. JSP es similar a PHP, pero usa el lenguaje de programación Java.</p>
<p>Para desplegar y correr JavaServer Pages, se requiere un servidor web compatible con contenedores servlet como Apache Tomcat o Jetty.</p>
<p>TagLibs -> JSP -> Servidor Aplicaciones (Servlets) -> Cliente (Navegador)</p>
<p>El rendimiento de una página JSP es el mismo que tendría el servlet equivalente, ya que el código es compilado como cualquier otra clase Java. A su vez, la máquina virtual compilará dinámicamente a código de máquina las partes de la aplicación que lo requieran. Esto hace que JSP tenga un buen desempeño y sea más eficiente que otras tecnologías web que ejecutan el código de una manera puramente interpretada.</p>
<p>La principal ventaja de JSP frente a otros lenguajes es que el lenguaje Java es un lenguaje de propósito general que excede el mundo web y que es apto para crear clases que manejen lógica de negocio y acceso a datos de una manera prolija. Esto permite separar en niveles las aplicaciones web, dejando la parte encargada de generar el documento HTML en el archivo JSP.</p>
<p>Otra ventaja es que JSP hereda la portabilidad de Java, y es posible ejecutar las aplicaciones en múltiples plataformas sin cambios. Es común incluso que los desarrolladores trabajen en una plataforma y que la aplicación termine siendo ejecutada en otra.</p>
<p>Los servlets y Java Server Pages (JSPs) son dos métodos de creación de páginas web dinámicas en servidor usando el lenguaje Java. En ese sentido son similares a otros métodos o lenguajes tales como el PHP, ASP o los CGIs, programas que generan páginas web en el servidor. Sin embargo, se diferencian de ellos en otras cosas.</p>
<p>Para empezar, los JSPs y servlets se ejecutan en una máquina virtual Java, lo cual permite que, en principio, se puedan usar en cualquier tipo de ordenador, siempre que exista una máquina virtual Java para él. Cada servlet (o JSP, a partir de ahora lo usaremos de forma indistinta) se ejecuta en su propio hilo, es decir, en su propio contexto; pero no se comienza a ejecutar cada vez que recibe una petición, sino que persiste de una petición a la siguiente, de forma que no se pierde tiempo en invocarlo (cargar programa + intérprete). Su persistencia le permite también hacer una serie de cosas de forma más eficiente: conexión a bases de datos y manejo de sesiones, por ejemplo.</p>
<p>Las JSPs son en realidad una forma alternativa de crear servlets ya que el código JSP se traduce a código de servlet Java la primera vez que se le invoca y en adelante es el código del nuevo servlet el que se ejecuta produciendo como salida el código HTML que compone la página web de respuesta.</p>

<h2>Descripción</h2>
<hr>
<p>JSP puede ser visto como una abstracción de alto nivel de los servlets Java. Las JavaServer Pages son traducidas a servlets en tiempo real; cada servlet es guardado en caché y rehusado hasta que la JSP original es modificada. Dicho en otras palabras un JSP son páginas java para un ambiente web.</p>

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