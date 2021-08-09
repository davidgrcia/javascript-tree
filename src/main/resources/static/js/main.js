// variables de las APIs necesarias para extraer la informacion en formato JSON 
var urlCultivos = 'http://localhost:8080/getCultivos';  
var urlEspecies = 'http://localhost:8080/getEspecies/'; //posteriormente concatenaremos la url con un ID para extraer la lista de especies dado un cultivo
var urlPlagas = 'http://localhost:8080/getPlagas/';
var urlSustancias = 'http://localhost:8080/getSustancias/';
var urlProductos = 'http://localhost:8080/getProductos/';

//variables para seleccionar los colores utilizados en el árbol y los botones
var color_verde = '#B8B530';
var color_marron = '#A2CFBB';

$(function() { // funcion que carga al comienzo la lista existente de cultivos
	$("#nodo1").append('<h1 id="replace-h1">Cultivos</h1>');
	//Obtenemos el JSON para recorrer los cultivos
	$.getJSON(urlCultivos, 
		function(respuesta) { 
			for (c in respuesta) {
				var cultivo = respuesta[c].nombre; //extrar el nombre del cultivo
				var cultivoid = respuesta[c].id; //extraer el id del cultivo
				var li_cultivo = '<li>' + cultivo + '</li>'; 
				var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarEspecie(\'' + cultivo + '\',\'' + cultivoid + '\')" id=btn-' + cultivo + '>▼</button>';
				var ul_especies = '<ul id=ul-' + cultivo + '>';

				// Seleccionamos el primer nodo y concatenamos: un elemento de la lista, un botón y una lista para las especies.
				$("#nodo1").append(li_cultivo + boton + ul_especies);
			}
		});
});

function DesplegarEspecie(nombre_cultivo, cultivoid) { // Función que dado un nombre de cultivo y su id despliega su lista de especies
	var id_padre = nombre_cultivo;
	var selector_boton = "btn-" + id_padre;
	var selector = "#ul-" + id_padre;
	var url = urlEspecies + cultivoid;

	if (document.getElementById("btn-" + nombre_cultivo).innerHTML == '▼') {
		$.getJSON(url,
			function(respuesta) { 
				for (e in respuesta) {
					//variables utilizadas para la informacion de las especies, e incluirlas en el html
					var especieConEspacios = respuesta[e].nombre;
					var especie = especieConEspacios.replaceAll(' ', '_');
					var especieid = respuesta[e].id;
					var ncientifico = respuesta[e].nombreCientifico;
					var id = id_padre + '-' + especie;
					var li_especie = '<li id="tooltip-' + id + '">' + especieConEspacios + '</li>';
					var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarPlaga(\'' + nombre_cultivo + '\',\'' + especie + '\',\'' + especieid + '\')" id=btn-' + id + '>▼</button>';
					var ul_plagas = '<ul id=ul-' + id + '>';

					$(selector).append(li_especie + boton + ul_plagas);
					// tooltip con fondo blanco para mostrar el nombre cientifico de las especies
					$("#tooltip-" + id).easyTooltip({
						content: ncientifico,
						tooltipDir: "left",
						defaultRadius: "3px",
						tooltipZindex: 1000,
						tooltipPadding: "10px 15px",
						tooltipBgColor: "rgba(255, 255, 255, 0.95)",
						tooltipFtSize: "14px",
						tooltipLineHeight: "24px",
						tooltipFtColor: "black",
						tooltipOpacity: 1,
						tooltipArwBorderWidth: 6,
						xOffset: 10,
						yOffset: 10
					});

				}
				// Al salir del bucle cerramos la lista
				$(selector).append('</ul>');
				$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo +'</h1>');
			});

		document.getElementById(selector_boton).style.background = color_marron;
		document.getElementById(selector_boton).innerHTML = '▲';
	}
	else {
		document.getElementById(selector_boton).style.background = color_verde;
		document.getElementById(selector_boton).innerHTML = '▼';
		$(selector).replaceWith('<ul id=ul-'  + id_padre + '></ul>');
		$('#replace-h1').replaceWith('<h1 id="replace-h1">Cultivos</h1>');
	}
};


function DesplegarPlaga(nombre_cultivo, nombre_especie, especieid) {
	
	var id_padre = nombre_cultivo + '-' + nombre_especie;
	var selector_boton = "btn-" + id_padre;
	var selector = "#ul-" + id_padre;
	var url = urlPlagas + especieid;
	// Si el botón no está desplegado al pulsarlo, cambiará el contenido, el color y mostrará la lista de plagas
	if (document.getElementById(selector_boton).innerHTML == '▼') {
		$.getJSON(url,
			function(respuesta) {
				for (p in respuesta) {
					var plagaConEspacios = respuesta[p].nombre;
					var plaga = plagaConEspacios.replaceAll(' ', '_');
					var plagaid = respuesta[p].id;
					var ncientifico = respuesta[p].nombreCientifico;
					var url = respuesta[p].url;
					var id = id_padre + '-' + plaga;
					var li_plaga = '<li id="tooltip-' + id + '"><a href="' + url + '">' + plagaConEspacios + '</a></li>';
					// En la funcion on click pasamos el nombre del cultivo y especie anterior, el nombre y el id de la plaga actual que utilizaremos en la funcion desplegarSustancia
					var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarSustancia(\'' + nombre_cultivo + '\',\'' + nombre_especie + '\',\'' + plaga + '\',\'' + plagaid + '\')" id=btn-' + id + '>▼</button>';
					var ul_sustancias = '<ul id=ul-' + id + '>';
					$(selector).append(li_plaga + boton + ul_sustancias);

					$("#tooltip-" + id).easyTooltip({
						content: ncientifico,
						tooltipDir: "left",
						defaultRadius: "3px",
						tooltipZindex: 1000,
						tooltipPadding: "10px 15px",
						tooltipBgColor: "rgba(0, 0, 0, 0.95)",
						tooltipFtSize: "14px",
						tooltipLineHeight: "24px",
						tooltipFtColor: "white",
						tooltipOpacity: 1,
						tooltipArwBorderWidth: 6,
						xOffset: 10,
						yOffset: 10
					});
				}
				$(selector).append('</ul>');
				$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo + ' - ' + nombre_especie +'</h1>');
			});
		document.getElementById(selector_boton).style.background = color_marron;
		document.getElementById(selector_boton).innerHTML = '▲';
	}
	else { // Si el botón esta desplegado, al pulsarlo cambiará el contenido, color y borrará la lista anterior
		document.getElementById(selector_boton).style.background = color_verde;
		document.getElementById(selector_boton).innerHTML = '▼';
		$(selector).replaceWith('<ul id=ul-'  + id_padre + '></ul>');
		$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo.replaceAll(' ', '_') + '</h1>');
	}
};

function DesplegarSustancia(nombre_cultivo, nombre_especie, nombre_plaga, plagaid) {
	// Utilizamos un id_padre para asignarlo al boton y a la lista de la clase anterior
	var id_padre = nombre_cultivo + '-' + nombre_especie + '-' + nombre_plaga;
	var selector_boton = "btn-" + id_padre;
	var selector = "#ul-" + id_padre;
	var url = urlSustancias + plagaid;
	
	if (document.getElementById(selector_boton).innerHTML == '▼') {
		$.getJSON(url,
			function(respuesta) {
				for (s in respuesta) {
					var sustanciaConEspacios = respuesta[s].nombre;
					var sustancia = sustanciaConEspacios.replaceAll(' ', '_');
					var sustanciaid = respuesta[s].id;
					// Este id, es  asignado al boton y a la lista actuales, obteniendo ids unicos en cada uno de ellos
					var id = id_padre + '-' + sustancia;
					var li_sustancia = '<li>' + sustanciaConEspacios + '</li>';
					var boton = '<button type="button" class="btn btn-primary btn-sm" onClick="DesplegarProducto(\'' + nombre_cultivo + '\',\'' + nombre_especie + '\',\'' + nombre_plaga + '\',\'' + sustancia + '\',\'' + sustanciaid + '\')" id=btn-' + id + '>▼</button>';
					var ul_productos = '<ul id=ul-' + id + '>';
					$(selector).append(li_sustancia + boton + ul_productos);
				}
				$(selector).append('</ul>');
				// si el boton esta desplegado, se muestra la miga de pan de la plaga seleccionada
				$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo + ' - ' + nombre_especie + ' - ' + nombre_plaga.replaceAll('_', ' ')  +'</h1>');
			});
		document.getElementById(selector_boton).style.background = color_marron;
		document.getElementById(selector_boton).innerHTML = '▲';
	}
	else {
		document.getElementById(selector_boton).style.background = color_verde;
		document.getElementById(selector_boton).innerHTML = '▼';
		$(selector).replaceWith('<ul id=ul-' + id_padre + '></ul>');
		//Cuando se repliega la lista, quitamos la plaga de la miga de pan
		$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo + ' - ' + nombre_especie + '</h1>');
	}
};

function DesplegarProducto(nombre_cultivo, nombre_especie, nombre_plaga, nombre_sustancia, sustanciaid) {

	var id_padre = nombre_cultivo + '-' + nombre_especie + '-' + nombre_plaga + '-' + nombre_sustancia;
	//Declaramos estas variables para seleccionar el boton y la lista deseada
	var selector_boton = "btn-" + id_padre;
	var selector = "#ul-" + id_padre;
	var url = urlProductos + sustanciaid;
	
	if (document.getElementById(selector_boton).innerHTML == '▼') {
		$.getJSON(url,
			function(respuesta) {
				for (p in respuesta) {
					var productoConEspacios = respuesta[p].nombre;
					var url = respuesta[p].url;
					var li_producto = '<li><a href="' + url + '">' + productoConEspacios + '</a></li>';
					//seleccionamos la lista con la variable selector
					$(selector).append(li_producto);
					$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo + ' - ' + nombre_especie + ' - ' + nombre_plaga.replaceAll('_', ' ')  + ' - ' + nombre_sustancia.replaceAll('_', ' ') +'</h1>');
				}
			});
		// seleccionamos el boton con la variable "selector_boton" para cambiarle el contenido y el color
		document.getElementById(selector_boton).style.background = color_marron;
		document.getElementById(selector_boton).innerHTML = '▲';
	}
	else {
		document.getElementById(selector_boton).style.background = color_verde;
		document.getElementById(selector_boton).innerHTML = '▼';
		$(selector).replaceWith('<ul id=ul-' + id_padre + '></ul>');
		$('#replace-h1').replaceWith('<h1 id="replace-h1">'+nombre_cultivo + ' - ' + nombre_especie + ' - ' + nombre_plaga.replaceAll('_', ' ') + '</h1>');
	}

};


