<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@taglib uri="/struts-jquery-tags" prefix="sj"%>
<%@page import="com.rav.audtioapp.constants.param.ParamConstants"%>
<%@page import="com.rav.audtioapp.dao.param.ParamsDAO"%>
<%
	ParamsDAO tc = new ParamsDAO();
%>
<html>
<head>
<meta name="viewport" content="initial-scale=1.0, user-scalable=no">

<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<link rel="stylesheet"
	href="https://lit-journey-6254.herokuapp.com/CSS/style.css"
	type="text/css" media="screen">
<link rel="stylesheet" href="/CSS/footer.css" type="text/css"
	media="screen">

<link rel="stylesheet" href="CSS/bootstrap-multiselect.css"
	type="text/css">
<script type="text/javascript" src="js/bootstrap-multiselect.js"></script>


<script type="text/javascript">
	$(document).ready(function() {
		//google.maps.event.addDomListener(window, "load", initAutocomplete);

		$('#genders').multiselect();
		$('#words').multiselect();
		$('#nativeLanguageSelection').multiselect();

		var map;
		$('.dropdown-menu').find('form').click(function(e) {
			e.stopPropagation();
		});

	});
	function initAutocomplete() {
		map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : 59.723705,
				lng : -110.7155106
			},
			zoom : 4,
			mapTypeId : google.maps.MapTypeId.ROADMAP,
			streetViewControl : false
		});

		/* $.get("getmap.action", function (data) {
			alert($(data).find("marker"));
			  $(data).find("marker").each(function () {
		         //Get user input values for the marker from the form
		          var name      = $(this).attr('name');
		          var address   = '<p>'+ $(this).attr('address') +'</p>';
		          var type      = $(this).attr('type');
		          var point     = new google.maps.LatLng(parseFloat($(this).attr('lat')),parseFloat($(this).attr('lng')));

		          //call create_marker() function for xml loaded maker
		          create_marker(point, name, address, false, false, false, "https://lit-journey-6254.herokuapp.com/icons/pin.png");
		    });
		});  */

		$
				.get(
						"getAudio.action",
						function(data) {

							//alert(data);

							var res = data.split("{}");
							var arrayLength = res.length;
							for (var i = 0; i < arrayLength; i++) {
								//alert(res[i]);

								var coordinates = res[i].split("}{");
								if (coordinates.length > 3) {
									var birthyear = coordinates[0].replace("{",
											"").replace("}", "");
									var longi = coordinates[1].replace("{", "")
											.replace("}", "");
									var lati = coordinates[2].replace("{", "")
											.replace("}", "");
									var id = coordinates[3].replace("{", "")
											.replace("}", "");

									var gender = coordinates[4]
											.replace("{", "").replace("}", "");
									var ifnotmothertounge = coordinates[5]
											.replace("{", "").replace("}", "");
									var mothertoungedata = coordinates[6]
											.replace("{", "").replace("}", "");
									var atwhatage = coordinates[7].replace("{",
											"").replace("}", "");

									var voices = coordinates[8]
											.replace("{", "").replace("}", "");

									var s = '<select id = \''+id+'\'>';
									var voiceOptions = voices.split("-");
									var voiceOptionsLength = voiceOptions.length;
									for (var k = 0; k < voiceOptionsLength; k++) {
										s += '<option value = '+id+"-"+voiceOptions[k]+'>'
												+ voiceOptions[k] + '</option>';
									}
									s += '</select>';

									var now = new Date();
									var past = new Date(birthyear);
									var nowYear = now.getFullYear();
									var pastYear = past.getFullYear();
									var age = nowYear - pastYear;
									var point = new google.maps.LatLng(
											parseFloat(longi), parseFloat(lati));
									var nativeLang;
									if (ifnotmothertounge == "true")
										nativeLang = "Yes";
									else
										nativeLang = mothertoungedata;
									create_marker(
											point,
											'ID: ' + id,
											'<div style="margin: 10px;">'
													+ '<p>Age: '
													+ age
													+ '</p>'
													+ '<p>Gender: '
													+ gender
													+ '</p>'
													+ '<p>Native language: '
													+ nativeLang
													+ '</p>'
													+ '<p>Time in Canada: '
													+ atwhatage
													+ '</p>'
													+ '<p>Choose Word:</p>'
													+ s
													+ '<p><audio id="audio" > <source src = ""/> </audio></p>'
													+ '<button class="'+id+'" id="playVoice">Play</button>'
													+ '<button class="'+id+'" id="downloadVoice">Download</button>'
													+ '<button class="'+id+'" id="downloadAllVoice">Download All</button>'
													+ '</div>', false, false,
											false, "../icons/pin.png");
								}
								//Do something
							}
							// $(data).find("marker").each(function () {
							//Get user input values for the marker from the form
							//        var name      = $(this).attr('name');
							//      var address   = '<p>'+ $(this).attr('address') +'</p>';
							//    var type      = $(this).attr('type');
							//  var point     = new google.maps.LatLng(parseFloat($(this).attr('lat')),parseFloat($(this).attr('lng')));

							//call create_marker() function for xml loaded maker
							//var point = new google.maps.LatLng(parseFloat(45.4), parseFloat(-75.7));
							//create_marker(point, 'Temp', '<p>Hello World</p>', false, false, false,
							//	"https://lit-journey-6254.herokuapp.com/icons/pin.png");
							//        create_marker(point, name, address, false, false, false, "https://lit-journey-6254.herokuapp.com/icons/pin.png");
							// });\
							$(document)
									.on(
											"click",
											"#playVoice",
											function() {
												id = $(this).attr('class');

												var voiceSelected = $(
														'#' + id + '').find(
														":selected").text();

												var request = {
													"id" : id,
													"voice" : voiceSelected
												};
												var ajaxData = {};
												ajaxData["array"] = [ JSON
														.stringify(request)
														.replace(',', ', ')
														.replace('[', '')
														.replace(']', '') ];
												$
														.ajax({
															"dataType" : 'json',
															"type" : "POST",
															"url" : 'getParticularAudio.action',
															"data" : JSON
																	.stringify(ajaxData),
															contentType : "application/json; charset=utf-8",
															async : false,
															success : function(
																	jsonString) {
																$("#audio")
																		.attr(
																				"src",
																				jsonString);
																$("#audio")[0]
																		.play();
															},
															complete : function(
																	msg, a, b) {
																console
																		.log('complete :'
																				+ msg);
															},
															error : function(
																	msg, a, b) {
																console
																		.log('error:'
																				+ msg);
															}
														});

											});

							$(document)
									.on(
											"click",
											"#downloadVoice",
											function() {
												id = $(this).attr('class');

												var voiceSelected = $(
														'#' + id + '').find(
														":selected").text();

												var request = {
													"id" : id,
													"voice" : voiceSelected
												};
												var ajaxData = {};
												ajaxData["array"] = [ JSON
														.stringify(request)
														.replace(',', ', ')
														.replace('[', '')
														.replace(']', '') ];
												$
														.ajax({
															"dataType" : 'json',
															"type" : "POST",
															"url" : 'getParticularAudio.action',
															"data" : JSON
																	.stringify(ajaxData),
															contentType : "application/json; charset=utf-8",
															async : false,
															success : function(
																	jsonString) {

																/* $("<a href='"
																	+ jsonString
																	+ "' download='"+id+"_"+voiceSelected++".wav'></a>")[0]
																		.click(); */
																var a = document
																		.createElement('a');
																$(a)
																		.attr(
																				'href',
																				jsonString)
																		.attr(
																				'download',
																				id
																						+ '_'
																						+ voiceSelected
																						+ '.wav')
																		.addClass(
																				'.voiceSelectedDownload')
																		.attr(
																				'id',
																				id
																						+ '_'
																						+ voiceSelected)
																		.appendTo(
																				'body');

																$(a)[0].click();
															},
															complete : function(
																	msg, a, b) {
																console
																		.log('complete :'
																				+ msg);
															},
															error : function(
																	msg, a, b) {
																console
																		.log('error:'
																				+ msg);
															}
														});

											});
						});

		$(document).on("click", "#downloadAllVoice", function() {
			id = $(this).attr('class');
			$("#id").val(id);

			$("#downloadAll").submit();

		});

		var input = document.getElementById('pac-input');
		var searchBox = new google.maps.places.SearchBox(input);
		map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

		map.addListener('bounds_changed', function() {
			searchBox.setBounds(map.getBounds());
		});

		searchBox.addListener('places_changed', function() {
			var places = searchBox.getPlaces();

			if (places.length == 0) {
				return;
			}

			var bounds = new google.maps.LatLngBounds();
			places.forEach(function(place) {
				if (place.geometry.viewport) {
					bounds.union(place.geometry.viewport);
				} else {
					bounds.extend(place.geometry.location);
				}
			});
			map.fitBounds(bounds);
		});
	}

	function create_marker(MapPos, MapTitle, MapDesc, InfoOpenDefault,
			DragAble, Removable, iconPath) {
		//new marker
		var marker = new google.maps.Marker({
			position : MapPos,
			map : map,
			draggable : DragAble,
			animation : google.maps.Animation.DROP,
			title : MapTitle,
			icon : iconPath
		});

		var contentString = $('<div class="marker-info-win">'
				+ '<div class="marker-inner-win"><span class="info-content">'
				+ '<h4 class="marker-heading">' + MapTitle + '</h4>' + MapDesc
				+ '</span>' + '</div></div>');

		var infowindow = new google.maps.InfoWindow();
		infowindow.setContent(contentString[0]);

		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});

		if (InfoOpenDefault) {
			infowindow.open(map, marker);
		}
	}
</script>

<script
	src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
	async defer></script>
<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	width: 100%;
	height: 88.9%;
	margin-top: 0px;
	margin-left: auto;
	margin-right: auto;
}

.controls {
	margin-top: 10px;
	border: 1px solid transparent;
	border-radius: 2px 0 0 2px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	height: 32px;
	outline: none;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
}

#pac-input {
	background-color: #fff;
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	margin-left: 12px;
	padding: 0 11px 0 13px;
	text-overflow: ellipsis;
	width: 300px;
}

#pac-input:focus {
	border-color: #4d90fe;
}

.pac-container {
	font-family: Roboto;
}

#type-selector {
	color: #fff;
	background-color: #4d90fe;
	padding: 5px 11px 0px 11px;
}

#type-selector label {
	font-family: Roboto;
	font-size: 13px;
	font-weight: 300;
}
</style>
<title><%=tc.getParamValue(ParamConstants.STRATHY_WEBSITE_HEADING)%>
</title>
<style>
#target {
	width: 345px;
}
</style>
</head>
<body>
	<s:if
		test="hasFieldErrors() || hasActionMessages() || hasActionErrors()">

		<div style="visibility: hidden">
			<sj:dialog id="ErrorDialog" title=" " modal="true" width="500"
				resizable="false"
				buttons="{
        'Ok':function() {
        $(this).dialog('close');
        }
        }">
				<h6>
					<s:actionerror />
					<s:fielderror />
					<s:actionmessage />
				</h6>
			</sj:dialog>
		</div>

	</s:if>

	<div class="container-fullwidth">
		<div class="row">
			<div class="col-md-12">
				<nav class="navbar navbar-default" role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#"><%=tc.getParamValue(ParamConstants.STRATHY_WEBSITE_HEADING)%>
						<!-- Strathy Language --></a>
				</div>
				</nav>
			</div>
		</div>
	</div>


	<form action="downloadAllAudioFiles.action" method="post" role="form"
		id="downloadAll">
		<input type="hidden" id="id" name="id" value="" />
	</form>


	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true"
		style="display: none;">
		<div class="modal-dialog">
			<div class="loginmodal-container">
				<h1>Sign Up</h1>
				<br>
				<s:form action="register" method="post">
					<input type="text" id="emailAddress" name="emailAddress"
						placeholder="Email Address">
					<input type="text" id="userName" name="userName"
						placeholder="User Name">
					<input type="password" id="password" name="password"
						placeholder="Password">
					<input type="password" id="repassword" name="repassword"
						placeholder="Re enter the Password">
					<input type="submit" name="login" class="login loginmodal-submit"
						value="Sign Up">
				</s:form>
			</div>
		</div>
	</div>
	<input id="pac-input" class="controls" type="text"
		placeholder="Enter the Location">
	<div id="map"></div>
	<%@include file="/WEB-INF/footer.jsp"%>
</body>
</html>