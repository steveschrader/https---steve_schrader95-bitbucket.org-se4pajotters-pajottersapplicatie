<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welkom in de Pajottersapplicatie</title>
        <link href=opmaak.css rel="stylesheet"/>
    </head>
    
    <body>
    	<div id="BovenPaneel">
			<div id="Titel">
				<h1>Lijst van Partijen</h1>
			</div>
		</div>
		<div id="MiddenPaneel">
			<div id="Inhoud">
				<ul>
		            <c:forEach items="${partijen}" var="partij">
		                <c:url var="partijUrl" value="/partij.html">
		                    <c:param name="id" value="${partij.id}" />
		                </c:url>
		                <li>
		                    <a href='<c:out value="${partijUrl}"/>'>
		                        <c:out value="${partij.voornaam}" />
		                        <c:out value="${partij.familienaam}" />
		                        <c:out value="${partij.id}" />
		                    </a>
		                </li>
		            </c:forEach>
		        </ul>
		        <c:url var="nieuwePartijUrl" value="/nieuwePartij.html" />
		        
		        <div class="knoppenpaneel">
		        	<a class="knop" href='<c:out value="${nieuwePartijUrl}"/>'>Partij Toevoegen</a>
		        </div>
			</div>
		</div>
    </body>
</html>
