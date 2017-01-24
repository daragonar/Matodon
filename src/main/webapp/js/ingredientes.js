		$(document).ready(function() {
					$('.btn-borrar-ing').on('click',function() {
								var id = $(this).parents('tr').data('id');
									
								$.ajax({
									url : "ingredientes/" + id,
									type : 'DELETE',
									success : function(result) {
										$('tr[data-id="' + id + '"]').remove();
										var ingredientes = parseInt($(
												'#registrar-ingredientes')
												.text());
										$('#registrar-ingredientes').text(
												ingredientes - 1);
									}
								});

							});
					
					$('.btn-editar-ing').on('click', function(){
						var id = $(this).parents('tr').data('id');
						var url = 'ingredientes/'+id;
						
						$.get(url)
							.success(function(ingrediente){
								$('#tituloModal').text("Editar Ingrediente");
								$('#id').val(ingrediente.id);
								$('#nombre').val(ingrediente.nombre);
								$('#categoria').val(ingrediente.categoria);
								
								$('#modal-ingrediente').modal('show');
							});
					});
					
					$('.btn-borrar-pizza').on('click', function(){
						var pizzaId = $(this).parents('tr').data('id');
						
						$.ajax({
							url : 'pizza/'+pizzaId,
							type: 'DELETE',
							success: function() {
						    	$('tr[data-id="'+pizzaId+'"]').remove();
								var pizzas = parseInt( $('#quantidade-pizzas').text() );
						    	$('#pizzas-registradas').text(pizzas - 1);
						    }
						});
						
					});
					
					$('.btn-editar-pizza').on('click', function(){
						var pizzaId = $(this).parents('tr').data('id');
						var url = 'pizza/'+pizzaId;
						$.get(url)
							.success(function(pizza){
								$('#id').val(pizza.id);
								$('#nome').val(pizza.nombre);
								$('#preco').val(pizza.precio);
								$('#categoria').val(pizza.categoria);
								
								pizza.ingredientes.forEach(function(ingrediente){
									var id = ingrediente.id;
									$('#ingredientes option[value='+id+']').attr('selected', true);
								});
								
								$('#modal-pizza').modal('show');
							});;
					});

				});