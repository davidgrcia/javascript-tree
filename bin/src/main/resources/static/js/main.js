/*
var  especie = respuesta[cultivo].especie[0].nombre;
				var  plaga = respuesta[cultivo].especie[0].plagas[0].nombre;
				var  sustancia = respuesta[cultivo].especie[0].plagas[0].sustancias[0].nombre;
				var  producto = respuesta[cultivo].especie[0].plagas[0].sustancias[0].productos[0].nombre;
				
				console.log(especie);
				console.log(plaga);
				console.log(sustancia);
				console.log(producto);
*/

//var fila = '<div class="row">';
//var columna = '<div class="col">';
//var cierre_div = '</div>';

var urlCultivos = 'http://localhost:8080/cultivos';

$(function() {

	$.getJSON(urlCultivos,
		function(respuesta) {

			for (cultivo in respuesta) {
				var li_cultivo = '<li>' + respuesta[cultivo].nombre + '</li>';
				var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarEspecie(\'' + respuesta[cultivo].nombre + '\')" id=btn-' + respuesta[cultivo].nombre + '> Desplegar</button>';
				var ul_especies = '<ul id=ul-' + respuesta[cultivo].nombre + '>';

				$("#nodo1").append(li_cultivo + boton + ul_especies);
			}
		});
});

function DesplegarEspecie(nombre_cultivo) {
	$.getJSON(urlCultivos,
		function(respuesta) {

			for (cultivo in respuesta) {
				for (i = 0; i < respuesta[cultivo].especie.length; i++) {
					var especie = respuesta[cultivo].especie[i].nombre;
					var li_especie = '<li>' + especie + '</li>';
					var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarPlaga(\'' + especie + '\')" id=btn-' + especie + '> Desplegar</button>';
					var ul_plagas = '<ul id=ul-' + especie + '>';
					var selector = "#ul-" + respuesta[cultivo].nombre;
					if (respuesta[cultivo].nombre == nombre_cultivo) {
						$(selector).append(li_especie + boton + ul_plagas);
					}
				}
				$(selector).append('</ul>');
			}
		});
};

//AQUI SE REPITEN.
function DesplegarPlaga(nombre_especie) {

	$.getJSON(urlCultivos,
		function(respuesta) {

			for (cultivo in respuesta) {
				for (i = 0; i < respuesta[cultivo].especie.length; i++) {
					for (j = 0; j < respuesta[cultivo].especie[i].plagas.length; j++) {
						var plaga = respuesta[cultivo].especie[i].plagas[j].nombre;
						var li_plaga = '<li>' + plaga + '</li>';
						var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarSustancia(\'' + plaga + '\')" id=btn-' + plaga + '> Desplegar</button>';
						var ul_sustancias = '<ul id=ul-' + plaga + '>';
						var selector = "#ul-" + respuesta[cultivo].especie[i].nombre;
						if (respuesta[cultivo].especie[i].nombre == nombre_especie) {
							$(selector).append(li_plaga + boton + ul_sustancias);
						}
					}
					$(selector).append('</ul>');
				}
			}
		});
};

function DesplegarSustancia(nombre_plaga) {
	$.getJSON(urlCultivos,
		function(respuesta) {
			for (cultivo in respuesta) {
				for (i = 0; i < respuesta[cultivo].especie.length; i++) {
					for (j = 0; j < respuesta[cultivo].especie[i].plagas.length; j++) {
						for (k = 0; k < respuesta[cultivo].especie[i].plagas[j].sustancias.length; k++) {
							var sustancia = respuesta[cultivo].especie[i].plagas[j].sustancias[k].nombre;
							var li_sustancia = '<li>' + sustancia + '</li>';
							var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarProducto(\'' + sustancia + '\')" id=btn-' + sustancia + '> Desplegar</button>';
							var ul_productos = '<ul id=ul-' + sustancia + '>';
							var selector = "#ul-" + respuesta[cultivo].especie[i].plagas[j].nombre;

							if (respuesta[cultivo].especie[i].plagas[j].nombre == nombre_plaga) {
								$(selector).append(li_sustancia + boton + ul_productos);
							}
						}
						$(selector).append('</ul>');
					}

				}
			}
		});
};

function DesplegarProducto(nombre_sustancia) {
	$.getJSON(urlCultivos,
		function(respuesta) {
			for (cultivo in respuesta) {
				for (i = 0; i < respuesta[cultivo].especie.length; i++) {
					for (j = 0; j < respuesta[cultivo].especie[i].plagas.length; j++) {
						for (k = 0; k < respuesta[cultivo].especie[i].plagas[j].sustancias.length; k++) {
							for (n = 0; n < respuesta[cultivo].especie[i].plagas[j].sustancias[k].productos.length; n++) {
								var producto = respuesta[cultivo].especie[i].plagas[j].sustancias[k].productos[n].nombre;
								var li_producto = '<li>' + producto + '</li>';
								var selector = "#ul-" + respuesta[cultivo].especie[i].plagas[j].sustancias[k].nombre;

								if (respuesta[cultivo].especie[i].plagas[j].sustancias[k].nombre == nombre_sustancia) {
									$(selector).append(li_producto);
								}
							}
						}

					}

				}
			}
		});
};


