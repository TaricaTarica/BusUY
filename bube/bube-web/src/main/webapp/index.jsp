<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="head.jsp"%>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="assets/busuy.css" />
	<script type="text/javascript" src="assets/proj4.js" ></script>
	<script src='https://npmcdn.com/@turf/turf/turf.min.js'></script>
</head>
<body>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script> 
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script>
	  document.addEventListener('DOMContentLoaded', function() {
		    var elems = document.querySelectorAll('.collapsible');
		    var instances = M.Collapsible.init(elems, {
		    	  accordion: false
		    });
		  });
	  $(document).ready(function(){
		    $('select').formSelect();
		  });

	  $(document).ready(function(){
		    $.get('${pageContext.request.contextPath}/ListarCompanias', function(companiasJson){
		    	$.each(companiasJson, function(index, compania) {
		    		$('#compania-linea').append($('<option>').val(compania.id).text(compania.nombre));
		    		$('#compania-buscar').append($('<option>').val(compania.id).text(compania.nombre));
		    		$('select').formSelect();
		    		
			    });
			});
		    
		});

	  document.addEventListener('DOMContentLoaded', function() {
          var elems = document.querySelectorAll('.modal');
          var instances = M.Modal.init(elems);
        });
	</script>
	<%@include file="navbar.jsp"%>
	
	<div class="row">
		<div class="col s12 m3 l3">
			<%if(sesion.getAttribute("administrador") != null){ %>
			 <ul class="collapsible">
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">edit_location</i>Agregar Paradas</div>
			      <div class="collapsible-body">
			      	<div class="input-field col s12">
				      <input name = "nombre-parada" id="nombre-parada" type="text">
				      <label class="active" for="nombre-parada">Nombre parada</label>
				      <div class="input-field col s12">
					      <div class="right">
					      	<button id="btnAddParada" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
							  <i class="material-icons">control_point</i>
						  	</button>
					      </div>
				      </div>
				    </div>
			      </div>
			    </li>
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">map</i>Agregar Linea</div>
			      <div class="collapsible-body mh">
				  	<div class="input-field col s12">
				      <input name = "codigo-linea" id="codigo-linea" type="text">
				      <label class="active" for="codigo-linea">Codigo</label>
				    </div>
				    <div class="input-field col s12">
				    	<p>
					      <label>
					        <input id="desvio-linea" value="true" type="checkbox" />
					        <span>¿Desvío?</span>
					      </label>
					    </p>
				    </div>
				    <div class="input-field col s6">
				    	<input name = "origen-linea" id="origen-linea" type="text">
				      	<label class="active" for="origen-linea">Origen</label>
				    </div>
				    <div class="input-field col s6">
				    	<input name = "destino-linea" id="destino-linea" type="text">
				      	<label class="active" for="destino-linea">Destino</label>
				    </div>
				    <div class="input-field col s12">
					    <select id="compania-linea">
					      <option value="" disabled selected>Elegir compañia</option>
					    </select>
					    <label>Compañia</label>
				    </div>
				    <div class="input-field col s12">
				    	<div class="right">
				      	<button id="btnAddLinea" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">control_point</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">location_off</i>Eliminar Paradas</div>
			      <div class="collapsible-body">
			      	<div class="input-field col s12">
					<p>Presion el botón y luego seleccione la parada que desea eliminar</p>
				      <div class="right">
				      	<button id="btnDeleteParada" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">delete</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">timeline</i>Eliminar una línea</div>
			      <div id="eliminar-linea-container" class="collapsible-body">
			      	<div class="input-field col s12">
					<p>Presione el botón y luego seleccione el recorrido en el mapa para eliminar la línea de bus</p>
				      <div class="right">
				      	<button id="btnDeleteRecorrido" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">delete</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>				

		      	<!-- <span>Lorem ipsum dolor sit amet.</span>
		      	<button id="btnArea" class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">
				  <i class="material-icons">signal_cellular_null</i>
				</button>-->
			</ul>
			<%}else{%>
				<ul class="collapsible">
					<li>
						<div class="collapsible-header"><i class="teal-text material-icons">edit_location</i>Buscar Direccion</div>
						<div class="collapsible-body">
							<div class="input-field col s12 m12 l6">
								<input name = "dir_id" id="dirId" type="text">
								<label class="active" for="dir_id">Nombre de la calle</label>
							</div>
							<div class="input-field col s12 m12 l6">
								<input name = "num_p" id ="numP" type="text"/> 
								<label class="active" for="num_p">Nro de puerta</label>
							</div>
							<div class="input-field col s12">	 
								<div class="right">
									<button onclick="buscarDir()" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
										<i class="material-icons">search</i>
									</button> 
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="collapsible-header"><i class="teal-text material-icons">add</i>Buscar Intersección</div>
						<div class="collapsible-body">
							<div class="input-field col s12 m12 l6">
								<input name = "calle1" id="calle_1" type="text">
								<label class="active" for="calle1">Nombre de la calle 1</label>
							</div>
							<div class="input-field col s12 m12 l6">
								<input name = "calle2" id="calle_2" type="text">
								<label class="active" for="calle2">Nombre de la calle 2</label>
							</div>
							<div class="input-field col s12">	 
								<div class="right">
									<button onclick="buscarCruce()" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
										<i class="material-icons">search</i>
									</button> 
								</div>
							</div>
						</div>
					</li>
					<li>
						<div class="collapsible-header"><i class="teal-text material-icons">edit_location</i>Buscar un recorrido</div>
						<div class="collapsible-body">
							<div class="input-field col s12 m12 l6">
								<input name = "destino_s" id="destino" type="text">
								<label class="active" for="destino_s">Destino</label>
							</div>
							<div class="input-field col s12 m12 l6">
								<input name = "nrolinea_s" id ="codigo" type="text"/> 
								<label class="active" for="nrolinea_s">Nro de linea</label>
							</div>
							<div class="input-field col s12">	 
								<div class="right">
									<button onclick="buscarRecorrido()" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
										<i class="material-icons">search</i>
									</button> 
								</div>
							</div>
						</div>
					</li>	
					<li>
				      <div class="collapsible-header"><i class="teal-text material-icons">info</i>Información de Linea</div>
				      <div class="collapsible-body">
						<div class="input-field col s12" id="infoLinea">
							<p>Presione el botón y luego seleccione un recorrido en el mapa</p>
						</div>
						<div class="input-field col s12">
					      <div class="right">
					      	<button id="btnInfoLinea" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
							  <i class="material-icons">info</i>
						  	</button>
					      </div>
					     </div>
					    </div>
				    </li>
					<li>
				      <div class="collapsible-header"><i class="teal-text material-icons">access_time</i>Horarios por parada</div>
				      <div class="collapsible-body">
						<div class="input-field col s12 l6" id="infoLinea">
							<p>Presione el botón y luego seleccione una parada para ver los horarios</p>
						</div>
						<div class="input-field col s12 l6">
					      <div class="right">
					      	<button id="btnInfoLinea" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
							  <i class="material-icons">info</i>
						  	</button>
					      </div>
					    </div>
				      </div>
				    </li>
				    <li>
				      <div class="collapsible-header"><i class="teal-text material-icons">directions_bus</i>Ver lineas en una parada</div>
				      <div class="collapsible-body">
						<div class="input-field col m12 l6" id="verLineasParada">
							<p>Presione el botón y luego seleccione una parada</p>
						</div>
						<div class="input-field col m12 l6">
							<a id="ver-lineas-init"
							class="white-text orange darken-4 btn modal-trigger"
							href="#ver-lineas-modal" style="display:none;" >Ver líneas</a>
							<input id="paradaIdModal" type="text" style="display:none;" disabled>
						    <div class="right">  
						      	<button id="btnVerLineasParada" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
								  <i class="material-icons">add_location</i>
							  	</button>
						    </div>
					    </div>
				      </div>
				    </li>
					<li>
						<div class="collapsible-header"><i class="teal-text material-icons">directions_bus</i>Ver paradas habilitadas-deshabilitadas</div>
						<div class="collapsible-body">
						  <div class="input-field col s12" id="infoParada">
							  <!-- <p>Presione el botón para cambiar de habilitada a deshabilitada</p> -->
						  </div>
						  <div class="input-field col s12" id="infoParada">
							<div class="right">
								<button id="btnParada" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
								<i class="material-icons">info</i>
								</button>
							</div>
						   </div>
						</div>
					  </li>	
					  <li>
						<div class="collapsible-header"><i class="teal-text material-icons">info</i>Ver paradas y recorridos cercanos</div>
						<div class="collapsible-body">
							<div class="input-field col s12">
								<input name = "distancia" id="distancia" type="text">
								<label class="distancia" for="distancia">Distancia (en mts)</label>
						  <!-- <div id="infoParada">
							  <p>Presione el botón para cambiar de habilitada a deshabilitada</p>
						  </div> -->
						  	</div>
						  	<div class="input-field col s12">
								<div class="right">
									<button onclick="RecPar()" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
									<i class="material-icons">info</i>
									</button>
								</div>
							</div>
						  </div>
					  </li>
					<li>
						<div class="collapsible-header">
							<i class="teal-text material-icons">directions_bus</i>Ver líneas de una compañía
						</div>
						<div class="collapsible-body">
							<div class="input-field col s12 m12 l7">
								<select id="compania-buscar">
									<option value="" disabled selected>Elegir compañia</option>
								</select> <label>Compañia</label>
							</div>
							<div class="input-field col m12 s12 l3">
								<a id="buscar-modal-init"
									class="white-text orange darken-4 btn modal-trigger"
									href="#compania-buscar-modal">Ver líneas</a>
							</div>
						</div>
					</li>
					<li>
						<div class="collapsible-header">
							<i class="teal-text material-icons">info</i>Lineas en un poligono
						</div>
						<div class="collapsible-body">
							<div class="right">
								<button id="btnArea" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
								<i class="material-icons">info</i>
								</button>
							</div>
						</div>
					</li>
					<li>
				      <div class="collapsible-header"><i class="teal-text material-icons">info</i>Recorridos y paradas que han cambiado</div>
				      <div class="collapsible-body">
				      	<div class="input-field col s12">
						<div id="infoLinea">
							<p>Seleccione recorrido o parada para ver cual a cambiado en las últimas 24 horas</p>
						</div>
						<form action="#">
						      <label>
						        <input name="group1" type="radio" checked />
						        <span>Recorrido</span>
						      </label>
						      <label>
						        <input name="group1" type="radio" />
						        <span>Parada</span>
						      </label>
						</form>
					      <div class="right">
					      	<button id="btnInfoLinea" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
							  <i class="material-icons">info</i>
						  	</button>
					      </div>
					    </div>
				      </div>
				    </li>
			</ul>		
			<%
				}
			%>
			
		

			
		</div>
    	<div id="map-container" class="col s12 m9 l9">
			<div id="map"></div>
		</div>

		
		<div id="localizar-container">
			<button onclick="localizar()"><i class="teal-text material-icons">edit_location</i>
			</button>	
		</div> 

		<!-- <div> 			
			<input name = "dir_id" id="dirId" type="text">
			<label class="active" for="dir_id">Nombre de la calle</label>									
		</div>

		<div>
			<input name = "num_p" id ="numP" type="text"/> 
			<label class="active" for="num_p">Nro de puerta</label>
			<button onclick="buscarDir()" ></button>dd
		</div> -->
	
    </div>

	<!-- BUSCAR LINEA DE COMPANIA MODAL -->
	<div id="compania-buscar-modal" class="modal mh">
		<div class="modal-content">
			<div id="compania-buscar-titulo"></div>
			<table class="striped highlight centered">
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Origen</th>
						<th>Destino</th>
						<th>Desvío</th>
					</tr>
				</thead>
				<tbody id="compania-buscar-tabla">
				</tbody>
			</table>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-close waves-effect waves-green btn-flat">Cerrar</a>
		</div>
	</div>
	
		<!-- VER LINEA DE PARADA MODAL -->
	<div id="ver-lineas-modal" class="modal mh">
		<div class="modal-content">
			<div id="ver-lineas-titulo"></div>
			<table class="striped highlight centered">
				<thead>
					<tr>
						<th>Compañia</th>
						<th>Codigo</th>
						<th>Origen</th>
						<th>Destino</th>
					</tr>
				</thead>
				<tbody id="ver-lineas-tabla">
				</tbody>
			</table>
		</div>
		<div class="modal-footer">
			<a href="#!" class="modal-close waves-effect waves-green btn-flat">Cerrar</a>
		</div>
	</div>	

	<script type="text/javascript">

	var map;
	var coord;
	var coordenadasUser;
    if (!proj4.defs("EPSG:32721")){
        proj4.defs("EPSG:32721","+proj=utm +zone=21 +south +ellps=WGS84 +datum=WGS84 +units=m +no_defs");    
    }    
    
    var pronos = ol.proj.get('EPSG:32721');
	
	
	var formatWFS = new ol.format.WFS();

    var formatGML = new ol.format.GML3({
    	featureNS: 'busUy',
        featureType: 'parada',
        srsName: 'EPSG:32721'
    });

    var formatGML2 = new ol.format.GML3({
    	featureNS: 'busUy',
        featureType: 'linea',
        srsName: 'EPSG:32721'
    });

    var xs = new XMLSerializer();

	var sourceWFS = new ol.source.Vector({
	    loader: function (extent, resolution, projection) {
	        var url = "http://localhost:8080/geoserver/wfs?service=WFS"
	                + "&version=2.0.0&request=GetFeature"
	                + '&outputFormat=application/json'
	                + "&typename=busUy:departamento"
	                + "&format_options=callback:loadFeatures"
	                + '&srsname=EPSG:32721';
	        // use jsonp: false to prevent jQuery from adding the "callback"
	        $.ajax({url: url, dataType: 'jsonp', jsonp: false});
	    }
	});

	/**
	 * JSONP WFS callback function.
	 * @param {Object} response The response object.
	 */
	window.loadFeatures = function (response) {
		 sourceWFS.addFeatures(new ol.format.GeoJSON().readFeatures(response));
	};	

    var layerWFS = new ol.layer.Vector({
        visible: true,
    	source: sourceWFS
	});

    var layerWFS2 = new ol.layer.Vector({
        visible: true,
    	source: sourceWFS
	});

	var layers = [
	    new ol.layer.Image({
	        visible: true,
	        source: new ol.source.ImageWMS({
	            url: 'http://localhost:8080/geoserver/wms?',
	            params: {'LAYERS': 'busUy:Montevideo'},
	            serverType: 'geoserver',
	            crossOrigin: 'anonymous'
	        }),
	        opacity: 0.5
	    }),
	    new ol.layer.Vector({
	        visible: true,
	    	source: new ol.source.Vector({
	        	url: 'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy:parada&srs=EPSG:32721&outputFormat=application/json',
	        	format: new ol.format.GeoJSON()
	    	})
		}), 
		 new ol.layer.Vector({
	        visible: true,
	    	source: new ol.source.Vector({
	        	url: 'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy:linea&srs=EPSG:32721&outputFormat=application/json',
	        	format: new ol.format.GeoJSON()
	    	})
		}),
	layerWFS    
	];	
	
	var interaction;
	
	var interactionSelectPointerMove = new ol.interaction.Select({
	    condition: ol.events.condition.pointerMove
	});
	
	var interactionSelect = new ol.interaction.Select({
	    style: new ol.style.Style({
	        stroke: new ol.style.Stroke({
	            color: '#FF2828'
	        })
	    })
	});
	
	var interactionSnap = new ol.interaction.Snap({
	    source: layerWFS.getSource()
	});

	var interactionSnap2 = new ol.interaction.Snap({
	    source: layerWFS2.getSource()
	});

	
	map = new ol.Map({
	    layers: layers,
	    controls: [],
	    interactions: [
	    	interactionSelectPointerMove,
	        new ol.interaction.MouseWheelZoom(),
	        new ol.interaction.DragPan()
	    ],
	    target: 'map',
	    view: new ol.View({
            projection: "EPSG:32721",
            center: [577018.6005431287, 6140276.016949373],
            zoom: 12
	        })
	});

	var transactWFS = function (p, f) {
	    var node;
	    switch (p) {
	        case 'insert':
	            node = formatWFS.writeTransaction([f], null, null, formatGML);
	            break;
	        case 'update':
	            node = formatWFS.writeTransaction(null, [f], null, formatGML);
	            break;
	        case 'delete':
	            node = formatWFS.writeTransaction(null, null, [f], formatGML);
	            break;
	    }
	    s = new XMLSerializer();
	    str = s.serializeToString(node);
	    $.ajax('http://localhost:8080/geoserver/wfs', {
	        type: 'POST',
	        dataType: 'xml',
	        processData: false,
	        contentType: 'text/xml',
	        data: str
	    }).done( function(){
	    	layerWFS.getSource().clear();
	        layerWFS.getSource().refresh();
	        });
	}

	var transactWFS2 = function (p, f) {
	    var node;
	    switch (p) {
	        case 'insert':
	            node = formatWFS.writeTransaction([f], null, null, formatGML2);
	            break;
	        case 'update':
	            node = formatWFS.writeTransaction(null, [f], null, formatGML2);
	            break;
	        case 'delete':
	            node = formatWFS.writeTransaction(null, null, [f], formatGML2);
	            break;
	    }
	    s = new XMLSerializer();
	    str = s.serializeToString(node);
	    $.ajax('http://localhost:8080/geoserver/wfs', {
	        type: 'POST',
	        dataType: 'xml',
	        processData: false,
	        contentType: 'text/xml',
	        data: str
	    }).done( function(){
	        layerWFS2.getSource().clear();
	        layerWFS2.getSource().refresh();
	        });
	}
	
	$('button').click(function () {
		
	    $(this).siblings().removeClass('btn-active');
	    $(this).addClass('btn-active');
	    map.removeInteraction(interaction);
	    interactionSelect.getFeatures().clear();
	    map.removeInteraction(interactionSelect);	    

	    switch ($(this).attr('id')) {

	        case 'btnEdit':
	            map.addInteraction(interactionSelect);
	            interaction = new ol.interaction.Modify({
	                features: interactionSelect.getFeatures()
	            });
	            map.addInteraction(interaction);
	            map.addInteraction(interactionSnap);
	            map.addInteraction(interactionSnap2);
	            dirty = {};
	            interactionSelect.getFeatures().on('add', function (e) {
	                e.element.on('change', function (e) {
	                    dirty[e.target.getId()] = true;
	                });
	            });
	            interactionSelect.getFeatures().on('remove', function (e) {
	                var f = e.element;
	                if (dirty[f.getId()]) {
	                    delete dirty[f.getId()];
	                    var featureProperties = f.getProperties();
	                    delete featureProperties.boundedBy;
	                    var clone = new ol.Feature(featureProperties);
	                    clone.setId(f.getId());
	                    transactWFS('update', clone);
	                }
	            });
	            break;

	        case 'btnAddParada':
	        	var nombreParada = document.getElementById("nombre-parada").value;
				var estado = 'habilitada';
	            interaction = new ol.interaction.Draw({
	                type: 'Point',
	                source: layerWFS.getSource()
	            });
	            map.addInteraction(interaction);
	            interaction.on('drawend', function (e) {
	                    var geom = e.feature.getGeometry().transform('EPSG:3857', 'EPSG:32721');
	                    //e.feature.set('geom', e.feature.getGeometry()); 
	                    e.feature.set('geom', geom);
	                	e.feature.set('nombre', nombreParada);
						e.feature.set('estado',estado);
	                    transactWFS('insert', e.feature); 
	            });
	            break;

	        case 'btnAddLinea':
	        	const fechaActual = new Date().toISOString();
		        
	        	var codigoLinea = document.getElementById("codigo-linea").value;
	        	var desvioLinea = $('#desvio-linea:checked').val();
	        	var origenLinea = document.getElementById("origen-linea").value;
	        	var destinoLinea = document.getElementById("destino-linea").value;
	        	var companiaLinea = $('#compania-linea').find(":selected").val();

	        	if (desvioLinea == null){
	        	    desvioLinea = false;
	        	}
	        	else{
					desvioLinea = true;
		        }


	        	console.log(desvioLinea);
	        	console.log(fechaActual);
	        	
	        	interaction = new ol.interaction.Draw({
	                type: 'LineString',
	                source: layerWFS2.getSource()
	            });
	            map.addInteraction(interaction);
	            interaction.on('drawend', function (e) {
                    var geom = e.feature.getGeometry().transform('EPSG:3857', 'EPSG:32721');
                    e.feature.set('geom', geom);
                    //e.feature.set('geom', e.feature.getGeometry()); 
                	e.feature.set('codigo', codigoLinea);
                	e.feature.set('destino', destinoLinea);
                	e.feature.set('origen', origenLinea);
                	e.feature.set('compania_id', companiaLinea);
                	e.feature.set('desvio', desvioLinea);
                	e.feature.set('fechamod', fechaActual);
	                transactWFS2('insert', e.feature);
	            });
	            break;

	        case 'btnDeleteParada':
	            interaction = new ol.interaction.Select();
	            interaction.getFeatures().on('add', function (e) {
	                transactWFS('delete', e.target.item(0));
	                layerWFS.getSource().removeFeature(e.target.item(0));
	                interactionSelectPointerMove.getFeatures().clear();
	                interaction.getFeatures().clear();
	            });
	            map.addInteraction(interaction);
	            break;

	        case 'btnDeleteRecorrido':
	            interaction = new ol.interaction.Select();
	            interaction.getFeatures().on('add', function (e) {
	                transactWFS2('delete', e.target.item(0));
	                layerWFS2.getSource().removeFeature(e.target.item(0));
	                interactionSelectPointerMove.getFeatures().clear();
	                interaction.getFeatures().clear();
	            });
	            map.addInteraction(interaction);
	            break;

	        case 'btnInfoLinea':
	            interaction = new ol.interaction.Select();
	            interaction.getFeatures().on('add', function (e) {
	            	var info = document.getElementById('infoLinea');
		            if (e.target.item(0).c.includes("linea")) {
		            	$.ajax({
		                    type : "GET",
		                    data : {},
		                    url : "/bube-web/BuscarCompania?id=" + e.target.item(0).get('compania_id'),
		                    success: function(data){
		                            var nombreCompania = data.nombre;
		                            info.innerHTML = "Datos de la linea seleccionada:" + '<br>';
		        	                info.innerHTML += "Compania: " + nombreCompania + '<br>';
		        	                info.innerHTML += "Codigo: " + e.target.item(0).get('codigo') + '<br>';
		        	                info.innerHTML += "Origen: " + e.target.item(0).get('origen') + '<br>';
		        	                info.innerHTML += "Destion: " + e.target.item(0).get('destino') + '<br>';
		        	                if (e.target.item(0).get('desvio')){
		        	                	info.innerHTML += "Recorrido con desvios por obras"
		        			        } else {
		        			        	info.innerHTML += "Recorrido sin variaciones"
		        					}
		                   }
		                });
				    } else {
				    	info.innerHTML = "Seleccione un recorrido en el mapa";
					}
	            });
	            map.addInteraction(interaction);
	            break;
	        case 'btnVerLineasParada':
 	            interaction = new ol.interaction.Select();
	            interaction.getFeatures().on('add', function (e) {
	           		if (e.target.item(0).c.includes("parada")) {
	           			var lineasP = document.getElementById('verLineasParada');
		            	var id = e.target.item(0).c.split(".");
	           			document.getElementById('paradaIdModal').value = id;
		            	lineasP.innerHTML = "<strong>Parada seleccionada: </strong>" + e.target.item(0).get('nombre');
		            	document.getElementById('ver-lineas-init').style.display = '';
				    } else {
				    	var lineasP = document.getElementById('verLineasParada');
				    	lineasP.innerHTML = "Presione el botón y luego seleccione una parada";
				    	document.getElementById('ver-lineas-init').style.display = 'none';
					}
	            });
	            map.addInteraction(interaction);
	            break; 
		 	case 'btnBuscarDir':
				var direccion_dir = document.getElementById('dirId').value;
        		var numeroPuerta = document.getElementById('numP').value;

				var image = new ol.layer.Image({
                visible: true, 
                source: new ol.source.ImageWMS({
					url: 'http://localhost:8080/geoserver/busUy/wms?&REQUEST=GetMap&LAYERS=busUy%3Adirecciones&srs=EPSG:32721&CQL_FILTER=nom_calle like' + direccion_dir + 'and num_puerta=' + numeroPuerta,
					params: {'LAYERS': 'busUy:direcciones'},
                    serverType: 'geoserver',
                    crossOrigin: 'anonymous'
                }),
                style: new ol.style.Circle({
                    fill: fill,
                    stroke: stroke,
                    radius: 10
              	}),
              	projection: new OpenLayers.Projection("EPSG:32721"),
                opacity: 0.0
            	});
        		map.addLayer(image);  

				break;
		 	case 'btnArea':
		 		interaction = new ol.interaction.Draw({
	                type: 'Polygon',
	                source: layerWFS2.getSource()
	            });
		 		map.addInteraction(interaction);
	            interaction.on('drawend', function (e) {
	             	var geom = e.feature.getGeometry().transform('EPSG:3857', 'EPSG:32721');
	             	//pertenece(geom);
	             	console.log(geom.getCoordinates());
	             	var fill = new ol.style.Fill({
	         		   color: '#000000'
	         		 });
	             	var stroke = new ol.style.Stroke({
	         		   color: '#3399CC',
	         		   width: 1.25
	         		 });
	            	var image = new ol.layer.Image({
	                visible: true, 
	                source: new ol.source.ImageWMS({
						url: 'http://localhost:8080/geoserver/busUy/wms?&REQUEST=GetMap&LAYERS=busUy%3Alinea&srs=EPSG:32721&CQL_FILTER=DWITHIN(geom%2CSRID=32721;POLYGON((576212.0092879354 6145605.999291176,578522.673845531 6142120.6495206645,575001.5174303966 6137209.332153993,576212.0092879354 6145605.999291176))%2C1%2Ckilometers)',// ' + geom.getCoordinates().join(",") + '))%2C0.5%2Ckilometers)',						
	                }),
	                style: new ol.style.Circle({
	                    fill: fill,
	                    stroke: stroke,
	                    radius: 10
	              	}),
	              	projection: new OpenLayers.Projection("EPSG:32721"),
	                opacity: 1
	            	});
	        		map.addLayer(image); 
	            
	            });
		 		break;

	        default:
	            break;
	    }
	});
	
	function pertenece(geomArea) {
		var format = new ol.format.GeoJSON();
		var lineas;
		fetch(
				'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy%3Alinea&srs=EPSG:32721&outputFormat=application/json')
				.then(function(response) {
					return response.json();
				}).then(function(json) {
					lineas = format.readFeatures(json);
					//   var street = features[0];
					
					for (var i = 0; i < lineas.length; i++) {
						var linea = lineas[i];
						var polygon = turf.polygon(geomArea.getCoordinates(), { name: 'poly1' });
						console.log(linea.getGeometry().getType());
						
						var featureProperties = linea.getProperties();
						var clone = new ol.Feature(featureProperties);
	                    clone.setGeometry(linea.getGeometry());
	                    var line = turf.linestring(clone.getGeometry().getCoordinates(), { name: 'line1'});
	                    //clone.setGeometryType(linea.getGeometry().getType());
						if (!turf.booleanDisjoint(polygon, line)) {					
							console.log('TEST');
						}
					}
					layerWFS2.getSource().clear();
					layerWFS2.getSource().refresh();
				});
	}
	var draw;
	/* function buscarDireccion() {
    	var direccion = document.getElementById('direccionId');
        var direccionVal = direccion.value;
        if (direccionVal !=='') { 
        	var fill = new ol.style.Fill({
        		   color: '#eb05d8'
        		 });
        	 var stroke = new ol.style.Stroke({
        		   color: '#3399CC',
        		   width: 1.25
        		 });
        	 
        	var image = new ol.layer.Image({
                visible: true, 
                source: new ol.source.ImageWMS({
                    url: 'http://localhost:8080/geoserver/busUy/wms?service=WMS&version=1.1.0&request=GetMap&layers=busUy%3Amanzanas&bbox=553617.1875%2C6134394.5%2C589042.5625%2C6158890.0&srs=EPSG%3A32721&styles=&format=image%2Fpng&CQL_FILTER=carpeta_ca=' + direccionVal,
                    params: {'LAYERS': 'busUy:manzanas'},
                    serverType: 'geoserver',
                    crossOrigin: 'anonymous'
                }),
                style: new ol.style.Circle({
                    fill: fill,
                    stroke: stroke,
                    radius: 5
              	}),
              	projection: new OpenLayers.Projection("EPSG:32721"),
                opacity: 0.5
            });
        	map.addLayer(image);        	
        	
        	   		       
        }
    } */

	function localizar(){
		if(navigator.geolocation){
			var success = function(position){
				var latitud = position.coords.latitude,
				longitud = position.coords.longitude;
			}
			navigator.geolocation.getCurrentPosition(success, function(msg){
				console.error( msg );
			});
		}
	}
	
	function buscarDir() {

    	var direccion_dir = document.getElementById('dirId').value;
        var numeroPuerta = document.getElementById('numP').value;
		
	    if (direccion_dir !=='') { 
        	var fill = new ol.style.Fill({
        		   color: '#000000'
        		 });
        	 var stroke = new ol.style.Stroke({
        		   color: '#000000',
        		   width: 10.25
        		 });
        	 
        	var image = new ol.layer.Image({
                visible: true, 
                source: new ol.source.ImageWMS({
					url: 'http://localhost:8080/geoserver/busUy/wms?&REQUEST=GetMap&LAYERS=busUy%3Adirecciones&styles=busUyPunto&srs=EPSG%3A32721&format=image%2Fpng&CQL_FILTER=nom_calle like %27' + direccion_dir + '%27 and num_puerta=' + numeroPuerta,
					params: {'LAYERS': 'busUy:direcciones'},
                    serverType: 'geoserver',
                    crossOrigin: 'anonymous',
					ratio: 10
                }),
                style: new ol.style.Circle({
                    fill: fill,
                    stroke: stroke,
                    //radius: 10
              	}),
              	projection: new OpenLayers.Projection("EPSG:32721"),
                opacity: 1,
				name:'dir_search'
            });
			map.getLayers().getArray()
			.filter(layer => layer.get('name') === 'dir_search')
			.forEach(layer => map.removeLayer(layer));
  			
        	map.addLayer(image);  
			console.log(
			map.getLayers().getArray()
			);      	
        	
        	   		       
        }
	}
	
	function removeCruce() {
		map.getLayers().forEach(layer => {
			  if (layer.get('name') && layer.get('name') == 'cruceLayer'){
				  console.log(layer.get('name'))
			      map.removeLayer(layer)
			  }
			});
	}

	function buscarCruce() {

		this.removeCruce();
		
		
		var calle_1 = document.getElementById('calle_1').value;
		var calle_2 = document.getElementById('calle_2').value;
		var c1 = calle_1.toUpperCase();
		var c2 = calle_2.toUpperCase();
		console.log(c1);
		console.log(c2);

		endpoint = "http://localhost:8080/bube-web/rest/buscar-cruce-calles/" + c1 + "/" + c2;

	    $.ajax({
	        url: endpoint,
	        cache: false,
	        success: function (html) {
	        	const obj = JSON.parse(html);
	
	        	const x = obj.coordinates[0];
	        	const y = obj.coordinates[1];

	        	console.log(obj.coordinates)

	        	var iconFeature = new ol.Feature({
	        	    geometry: new ol.geom.Point([x, y]),
	        	    name: 'nombre',
	        	    population: 4000,
	        	    rainfall: 500
	            });

	            var iconStyle = new ol.style.Style({
	        	    image: new ol.style.Icon( /** @type {olx.style.IconOptions} */ ({
	        		    anchor: [0.5, 46],
	        		    anchorXUnits: 'fraction',
	        		    anchorYUnits: 'pixels',
	        		    opacity: 1,
	        		    src: 'https://i.ibb.co/3Fhg3gD/point.png'
	        	    }))
	            });
	            iconFeature.setStyle(iconStyle);

	            var vectorSource = new ol.source.Vector({
	        			features: [iconFeature]
	            });
	           	console.log("VectorSource: ",vectorSource);

	            //vectorSource.addFeature(iconFeature);

	            var cruceLayer = new ol.layer.Vector({
	        	    source: vectorSource,
	        	    name: "cruceLayer"
	            });

	        	console.log("vectorLayer ", cruceLayer);
	            map.addLayer(cruceLayer)
	            //map.removeLayer(cruceLayer);
	            
	    	    	        	
	        }
	    })
	}

	function buscarRecorrido() {

		var destino = document.getElementById('destino').value;
		var codigo = document.getElementById('codigo').value;

		if (destino !=='') { 
				var vector = new ol.layer.Vector({
                visible: true,
                source: new ol.source.Vector({
                    url: 'http://localhost:8080/geoserver/busUy/wfs?request=getFeature&typeName=busUy:linea&srs=EPSG:32721&outputFormat=application/json&cql_filter=%20destino%20like %27' + destino + '%27 and codigo like %27' + codigo + '%27',
                    format: new ol.format.GeoJSON()
                }),
				//name:'recorrido_search'
            });

            map.addLayer(vector);
			vectorLayer.getSource().removeFeature(vector);			
		
			map.getLayers().getArray()/*
			.filter(layer => layer.get('name') === 'recorrido_search')
			.forEach(layer => map.removeLayer(layer));
			*/
			console.log(
			map.getLayers().getArray()
			); 							
		}
	}
	function localizar(){
		if(navigator.geolocation){
			var success = function(position){
				var latitud = position.coords.latitude,
				longitud = position.coords.longitude;
				coordenadasUser = ol.proj.transform([latitud, longitud], 'EPSG:4326', 'EPSG:32721');
			}
			navigator.geolocation.getCurrentPosition(success, function(msg){
				console.error( msg );
			});
		}
	}
	var btn = document.getElementById('btnParada'),
		estado = '',
	//	div = document.getElementById('infoParada'),
		eParada = 0;

	function cambiarEstado(){
		if (eParada == 0){
			estado = 'habilitada';
			document.getElementById('infoParada').innerHTML = '<p><strong>Paradas habilitadas</strong></p>';
			eParada = 1;			
		}
		else{
			estado = 'deshabilitada';
			document.getElementById('infoParada').innerHTML = '<p><strong>Paradas des-habilitadas</strong></p>';
			eParada = 0;
		}
		verEstadoParada(estado);	
	}

	function verEstadoParada(estado) {		
    	if (estado !=='') { 
			map.getLayers().getArray()
			.filter(layer => layer.get('className') === 'test')
			.forEach(layer => map.removeLayer(layer));
			var vector = new ol.layer.Vector({
				visible: true,
                source: new ol.source.Vector({                  
                    url: 'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy:parada&srs=EPSG:32721&outputFormat=application/json&styles=busUyPunto&CQL_FILTER=estado like %27' + estado + '%27',
					format: new ol.format.GeoJSON()					
                }),	
				className: 'test',						
            });
			
            map.addLayer(vector);			
			console.log(
			map.getLayers().getArray()
			); 		       
        }
	}
	//btn.addEventListener('click',cambiarEstado,true)

	function RecPar() {		
		var distancia = document.getElementById('distancia').value;
		var dis = distancia/1000;
    	if (distancia !=='') { 
			map.getLayers().getArray()
			.filter(layer => layer.get('className') === 'vector')
			.forEach(layer => map.removeLayer(layer));
			var vectorP = new ol.layer.Vector({
				visible: true,
                source: new ol.source.Vector({                  
                    url: 'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy:parada&srs=EPSG:32721&outputFormat=application/json&styles=busUyPunto&CQL_FILTER=DWITHIN(geom%2CPoint(-6263300.32312%20-4135892.57609)%2C' + dis +'%2Ckilometers)',//CQL_FILTER=estado like %27' + estado + '%27',
					format: new ol.format.GeoJSON()					
                }),	
				className: 'vector',						
            });	
			var vectorL = new ol.layer.Vector({
				visible: true,
                source: new ol.source.Vector({                  
                    url: 'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy:linea&srs=EPSG:32721&outputFormat=application/json&styles=busUyPunto&CQL_FILTER=DWITHIN(geom%2CPoint(-6263300.32312%20-4135892.57609)%2C' + dis +'%2Ckilometers)',//CQL_FILTER=estado like %27' + estado + '%27',
					format: new ol.format.GeoJSON()					
                }),	
				className: 'vector',						
            });
            map.addLayer(vectorP);
			map.addLayer(vectorL);
			
		}
	}
	$(document).ready(function(){
        $(function(){
            $('#buscar-modal-init').click(function() {
                var compania_id = $('#compania-buscar').find(":selected").val();
                var compania_nombre = $("#compania-buscar option:selected").html();
                var titulo = document.getElementById("compania-buscar-titulo");
                var tabla = document.getElementById("compania-buscar-tabla");
                $.ajax({
                    type : "GET",
                    data : {},
                    url : "/bube-web/ListarLineaCompania?id=" + compania_id,
                    success: function(data){
                        titulo.innerHTML = "<h4> Líneas de " + compania_nombre + "</h4>";
						tabla.innerHTML = "";
						if(data != null){
							
						}
                        $.each(data, function(index, d) {
                            if(d.desvio == true){
                                tabla.innerHTML += "<td>" + d.codigo + "</td><td>" +d.origen + "</td><td>" +d.destino + "</td><td>Si</td>";
                            }
                            else{
                                tabla.innerHTML += "<td>" + d.codigo + "</td><td>" +d.origen + "</td><td>" +d.destino + "</td><td>No</td>";

                            }
                        });

                    }
                });
            });
        });
    });
    
	$(document).ready(function(){
        $(function(){
            $('#ver-lineas-init').click(function() {
                var id= document.getElementById("paradaIdModal").value;
                var titulo = document.getElementById("ver-lineas-titulo");
                var tabla = document.getElementById("ver-lineas-tabla");
                console.log(id);
                var id = id.split(",");
                console.log(id[1]);
                $.ajax({
                    type : "GET",
                    data : {},
                    url : "/bube-web/GetLineasForParada?gid=" + id[1],
                    success: function(data){
                        titulo.innerHTML = "<h4> Líneas de la parada </h4>";
						tabla.innerHTML = "";
						if(data != null){
							
						}
                        $.each(data, function(index, d) {
                            tabla.innerHTML += "<td>" + d.nombre_compania + "</td><td>" + d.codigo + "</td><td>" +d.origen + "</td><td>" +d.destino;

                        });

                    }
                });
            });
        });
    });
</script>
</body>
</html>