<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Datos del vendedor ${seller.name} modificados</title>
</head>
<body>
<g:if test="${okpass==true}" >
<h1>Datos del vendedor ${seller.name} modificados</h1>

<div> Nuevos datos: </div>
<div class="table-responsive">
  <table class="table">
     <tr>
    <th class="tg-yw4l">DNI</th>
    <th class="tg-yw4l">Nombre</th>
    <th class="tg-yw4l">Teléfono</th>
    <th class="tg-yw4l">Zona</th>
  </tr>
  
  <tr>
    <td class="tg-yw4l">${seller.document_number}</td>
    <td class="tg-yw4l">${seller.name}</td>
    <td class="tg-yw4l">${seller.phone}</td>
    <td class="tg-yw4l">${seller.zone}</td>
  </tr>

  </table>
</div>

</br>
<div align="center">
<a href="/seller/index"><button type="button" class="btn btn-default">Volver</button></a>
</div>
</g:if>

<g:else >
<h1>Contraseña incorrecta</h1>
<div align="center">
Las contraseñas ingresadas no concuerdan.<br>
<button type="button" class="btn btn-default" onclick="history.go(-1);">Volver</button></div>
</g:else>

</body>
</html>
