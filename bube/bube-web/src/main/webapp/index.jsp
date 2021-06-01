<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="head.jsp"%>
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
	</script>
	<%@include file="navbar.jsp"%>
	
	<div class="row">
		<div class="col s3">
			<%if(sesion.getAttribute("administrador") != null){ %>
			 <ul class="collapsible">
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">edit_location</i>Agregar Paradas</div>
			      <div class="collapsible-body">
			      	<div class="input-field col s12">
				      <input name = "nombre-parada" id="nombre-parada" type="text">
				      <label class="active" for="nombre-parada">Nombre parada</label>
				      <div class="right">
				      	<button id="btnAddParada" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">control_point</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">map</i>Agregar Recorrido</div>
			      <div class="collapsible-body">
				  	<div class="input-field col s12">
				      <input name = "nombre-recorrido" id="nombre-recorrido" type="text">
				      <label class="active" for="nombre-recorrido">Nombre recorrido</label>
				      <div class="right">
				      	<button id="btnAddRecorrido" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">edit</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">location_off</i>Eliminar Paradas</div>
			      <div class="collapsible-body">
			      	<div class="input-field col s12">
					<p>Seleccione las paradas a eliminar luego de presionar el botón</p>
				      <div class="right">
				      	<button id="btnDeleteParada" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">remove_circle</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>
			    <li>
			      <div class="collapsible-header"><i class="teal-text material-icons">timeline</i>Eliminar Recorrido</div>
			      <div class="collapsible-body">
			      	<div class="input-field col s12">
					<p>Seleccione los recorridos a eliminar luego de presionar el botón</p>
				      <div class="right">
				      	<button id="btnDeleteRecorrido" class="white-text orange darken-4 mdl-button mdl-js-button mdl-button--fab">
						  <i class="material-icons">delete</i>
					  	</button>
				      </div>
				    </div>
			      </div>
			    </li>
			  </ul>
				

		      	<!-- <span>Lorem ipsum dolor sit amet.</span>
		      	<button id="btnArea" class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">
				  <i class="material-icons">signal_cellular_null</i>
				</button>
				
				<button id="btnInfo" class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">
				  <i class="material-icons">info</i>
				</button> -->
				<!-- <div id="infoCont"></div> -->
			<%} %>
			
		</div>
    	<div class="col s9">
			<div id="map"></div>
		</div>
    </div>
	
	
	<script type="text/javascript">

	var map;
	var coord;
	proj4.defs('EPSG:32721', '+proj=utm + zone=21 + south + datum=WGS84 + units=m + no_defs');
	//ol.proj.proj4.register(proj4);
	
	//var pronos = ol.proj.get('EPSG:32721');
	
	
	var formatWFS = new ol.format.WFS();

    var formatGML = new ol.format.GML3({
    	featureNS: 'busUy',
        featureType: 'parada',
        srsName: 'EPSG:32721'
    });

    var formatGML2 = new ol.format.GML3({
    	featureNS: 'busUy',
        featureType: 'recorrido',
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
	        	url: 'http://localhost:8080/geoserver/wfs?request=getFeature&typeName=busUy:recorrido&srs=EPSG:32721&outputFormat=application/json',
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
	    	//projection: pronos,
	        center: ol.proj.fromLonLat([-56.18816, -34.90328]),
	        zoom: 11
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
	            interaction = new ol.interaction.Draw({
	                type: 'Point',
	                source: layerWFS.getSource()
	            });
	            map.addInteraction(interaction);
	            interaction.on('drawend', function (e) {
	            		e.feature.set('geom', e.feature.getGeometry()); 
	                	e.feature.set('nombre', nombreParada);
	                    transactWFS('insert', e.feature); 
	            });
	            break;

	        case 'btnAddRecorrido':
	        	var nombreRecorrido = document.getElementById("nombre-recorrido").value;
	            interaction = new ol.interaction.Draw({
	                type: 'LineString',
	                source: layerWFS2.getSource()
	            });
	            map.addInteraction(interaction);
	            interaction.on('drawend', function (e) {
	            	e.feature.set('geom', e.feature.getGeometry()); 
                	e.feature.set('nombre', nombreRecorrido);
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

	        case 'btnInfo':
	            interaction = new ol.interaction.Select();
	            interaction.getFeatures().on('add', function (e) {
	            //todo
	                var info = document.getElementById('infoCont');
	                info.innerHTML = e.target.item(0).getId();
	            });
	            map.addInteraction(interaction);
	            break;

	        default:
	            break;
	    }
	});
</script>
 
</body>
</html>