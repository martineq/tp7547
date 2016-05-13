<!doctype html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Vendedores</title>
</head>
<body>
            <h1>Vendedores</h1>
<p>Listado de todos los vendedores, ordenados por número de documento.</p>

<div align="right"><g:link action="up"><b>Agregar</b><asset:image src="add.png" alt="Editar" style="width:38px;height:38px;"/></g:link></div>

<div class="table-responsive">
  <table class="table">
     <tr>
    <th class="tg-yw4l">Documento</th>
    <th class="tg-yw4l">Nombre</th>
     <th class="tg-yw4l">Teléfono</th>
    <th class="tg-yw4l">Zona</th>
    <th class="tg-yw4l"><div align="center">Editar</div></th>
    <th class="tg-yw4l"><div align="center">Borrar</div></th>
  </tr>
  
    <g:each in="${sellers}" var="seller" status="i">

  <tr>
    <td class="tg-yw4l"> ${seller.document_number}</td>
    <td class="tg-yw4l">${seller.name}</td>
    <td class="tg-yw4l">${seller.phone}</td>
    <td class="tg-yw4l">${seller.zone}</td>
        <td class="tg-yw4l">
    <div align="center">
    <g:link action="editseller" id="${seller.id}" params="[name: ("${seller.name}") ]" ><asset:image src="edit.png" title="Editar" alt="Editar" style="width:20px;height:20px;"/> </g:link>
    </div></td>
    <td class="tg-yw4l"><div align="center"><g:link action="deleteconfirm" id="${seller.id}" params="[name: ("${seller.name}") ]" ><asset:image src="delete.png" title="Borrar" alt="Borrar" style="width:20px;height:20px;"/></g:link></div></td>
  </tr>
</g:each>


  </table>
</div>

</body>
</html>
