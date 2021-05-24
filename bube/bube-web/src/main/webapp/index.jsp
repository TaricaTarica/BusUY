<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<%@include file="head.jsp"%>
</head>
<body>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

	<%@include file="navbar.jsp"%>
	<div class="row">
		<div class="col s3">
		</div>
    	<div class="col s9">
			<div id="map"></div>
		</div>
    </div>
	
	
	<script type="text/javascript">
	
		var map;
		proj4.defs('EPSG:32721', '+proj=utm + zone=21 + south + datum=WGS84 + units=m + no_defs');
		//ol.proj.proj4.register(proj4);
	
		//var pronos = ol.proj.get('EPSG:32721');
	
	
		var formatWFS = new ol.format.WFS();
	
	    var formatGML = new ol.format.GML3({
	        featureType: 'busUy:departamento',
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
	
		var layers = [
		    new ol.layer.Image({
		        visible: true,
		        source: new ol.source.ImageWMS({
		            url: 'http://localhost:8080/geoserver/wms?',
		            params: {'LAYERS': 'Montevideo'},
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
		layerWFS
		];
	
		var cordss = ol.proj.transform([-56.43260187272308, -34.937287127586856], 'EPSG:4326', 'EPSG:32721');
	
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
		    $.ajax('http://localhost:808/geoserver/wfs', {
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
	</script>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</body>
</html>