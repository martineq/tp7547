<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Datos del cliente ${client.name} modificados</title>
</head>
<body>

<h1>Datos del cliente ${client.name} modificados</h1>

<div> Nuevos datos: </div>
<div class="table-responsive">
  <table class="table">
     <tr>
    <th class="tg-yw4l">Nombre</th>
    <th class="tg-yw4l">Dirección</th>
    <th class="tg-yw4l">Ciudad</th>
    <th class="tg-yw4l">E-mail</th>
  </tr>
  
  <tr>
    <td class="tg-yw4l">${client.name}</td>
    <td class="tg-yw4l">${client.address}</td>
    <td class="tg-yw4l">${client.city}</td>
    <td class="tg-yw4l">${client.email}</td>
  </tr>

  </table>
</div>

</br>
<div align="center">
<a href="/client/index"><button type="button" class="btn btn-default">Volver</button></a>
</div>


</body>
</html>
