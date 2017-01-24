<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Listado Ingredientes</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>
			<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
				<table id="ingredientes" class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Nombre</th>
							<th>Categoria</th>
							<th>Editar</th>
							<th>Borrar</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${ingredientes}" var="ingrediente">
							<tr data-id="${ingrediente.id}">
								<td>${ingrediente.id}</td>
								<td>${ingrediente.nombre}</td>
								<td>${ingrediente.categoria}</td>
								<td>
									<button type="button" class="btn btn-warning btn-editar-ing">Editar</button>
								</td>
								<td>
									<button type="button" class="btn btn-danger btn-borrar-ing">Deletar</button>
								</td>
							</tr>
						</c:forEach>
					<tfoot>
						<tr>
							<td colspan="5">Ingredientes registrados: <span
								id="registrar-ingredientes">${ingredientes.size()}</span></td>
						</tr>
						<tr>
							<td colspan="5"><a class="btn btn-primary"
								data-toggle="modal" href='#modal-ingrediente'>Add Ingrediente</a></td>
						</tr>
					</tfoot>
					</tbody>

				</table>
			</div>
			<div class="col-xs-3 col-sm-3 col-md-3 col-lg-3"></div>
		</div>
	</div>
	</table>



	<div class="modal fade" id="modal-ingrediente">
		<div class="modal-dialog">
			<div class="modal-content">
				<form id="form-ingrediente" method="post">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="tituloModal">Añadir Ingrediente</h4>
					</div>
					<div class="modal-body">
						<label for="nombre">Nombre: </label> <input id="nombre"
							name="nombre" class="form-control"> <label
							for="categoria">Categoria: </label> <select id="categoria"
							name="categoria" class="form-control">
							<c:forEach items="${categorias}" var="categoria">
								<option value="${categoria}">${categoria}</option>
							</c:forEach>
						</select> <input id="id" name="id" type="hidden"> <input id="csrf"
							name="_csrf" type="hidden" value="${_csrf.token}">

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
						<button type="submit" class="btn btn-primary">Guardar</button>
					</div>
				</form>
			</div>
		</div>
	</div>



</body>
</html>