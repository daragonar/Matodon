<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Contacto</title>
</head>
<body>
	<div class="container">
		<div class="col-md-4">
			<table id="ingredientes" class="table table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Tamaño</th>
						<th>Ingredientes</th>
						<th>Editar</th>
						<th>Borrar</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pizzas}" var="pizza">
						<tr data-id="${pizza.id}">
							<td>${pizza.id}</td>
							<td>${pizza.nombre}</td>
							<td>${pizza.precio}</td>
							<td>${pizza.categoria}</td>
							<td>
							<c:forEach items="${pizza.ingredientes}" var="ingrediente">
							- ${ingrediente.nombre} <br>
							</c:forEach>
							</td>
							<td>
								<button type="button" class="btn btn-warning btn-editar-pizza">Editar</button>
							</td>
							<td>
								<button type="button" class="btn btn-danger btn-borrar-pizza">Deletar</button>
							</td>
						</tr>
					</c:forEach>
				<tfoot>
					<tr>
						<td colspan="7">Pizzas registrados: <span
							id="pizzas-registradas">${pizzas.size()}</span></td>
					</tr>
					<tr>
						<td colspan="7"><a class="btn btn-primary"
							data-toggle="modal" href='#modal-pizza'>Añadir pizza</a></td>
					</tr>
				</tfoot>
				</tbody>

			</table>
		</div>
	</div>
	
	
	<div class="modal fade" id="modal-pizza" tabindex="-1" role="dialog" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<form id="form-pizza" method="post">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title">Informações da Pizza</h4>
				</div>
				<div class="modal-body">
					<label for="nome">Nome: </label>
					<input id="nome" name="nombre" class="form-control">
					
					<label for="nome">Preço: </label>
					<input id="preco" name="precio" class="form-control">
					
					<label for="categoria">Categoria: </label>
					<select id="categoria" name="categoria" class="form-control">
						<c:forEach items="${categorias}" var="categoria">
							<option value="${categoria}">${categoria}</option>
						</c:forEach>
					</select>
					
					<label for="ingredientes">Ingredientes: </label>
					<select id="ingredientes" name="ingredientes" class="form-control" multiple="multiple">
						<c:forEach items="${ingredientes}" var="ingrediente">
							<option value="${ingrediente.id}">${ingrediente.nombre}</option>
						</c:forEach>
					</select>
					
					<input id="id" name="id" type="hidden">
					<input id="csrf" name="_csrf" type="hidden" value="${_csrf.token}">
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
					<button id="btn-salvar" type="submit" class="btn btn-primary">Salvar Informações</button>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>