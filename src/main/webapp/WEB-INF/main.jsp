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

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="/CSS/style.css" type="text/css"
	media="screen">
<link rel="stylesheet" href="/CSS/footer.css" type="text/css"
	media="screen">

<link rel="stylesheet" href="CSS/bootstrap-multiselect.css"
	type="text/css">

<style>
html, body {
	height: 100%;
	margin: 0;
	padding: 0;
}

#map {
	width: 100%;
	height: 88.9%;
	margin-top: 50px;
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
				<nav class="navbar navbar-default navbar-inverse navbar-fixed-top"
					role="navigation"> <!-- Brand and toggle get grouped for better mobile display -->
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
				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav navbar-right">
						<li><a href="strathyUnitLogin">Logout</a></li>

					</ul>
				</div>
				<!-- /.navbar-collapse --> </nav>
			</div>
		</div>
	</div>
	<input id="pac-input" class="controls" type="text"
		placeholder="<%=tc.getParamValue(ParamConstants.STRATHY_ENTER_LOCATION_SEARCH_BAR)%>">
	<div id="map"></div>

	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
	<%@include file="/WEB-INF/footer.jsp"%>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-multiselect.js"></script>
	<%-- <script
		src="https://maps.googleapis.com/maps/api/js?libraries=places&callback=initAutocomplete"
		async defer></script> --%>

	<script>
		function initAutocomplete() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 59.3207266,
					lng : -105.2373684
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
						"getUnapprovedAudio.action",
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
										
										var locV = coordinates[8].replace("{",
										"").replace("}", "");

										var voices = coordinates[9]
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

									var form = '<div style="margin: 10px;">'
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
											+ s+'<p><audio id="audio" > <source src = ""/> </audio></p>'
											+ '<button class="'+id+'" id="playVoice">Play</button>'
											+ '<p><button class="'+id+'" id="approve">Approve</button>'
											+ '<button class="'+id+'" id="reject">Reject</button></p>'
											+ '</div>'

									create_marker(
											point,
											'Hi',
											form,
											false,
											false,
											false,
											"../icons/pin_strathyunit.png",
											id,age,
											gender, nativeLang, atwhatage);

								}
								//Do something
							}

							$(document)
									.on(
											"click",
											"#approve",
											function() {
												var approvalId = null;
												id = $(this).attr('class');
												var request = {
													"status" : "APPROVED",
													"id" : id,
													"approvalId" : approvalId
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
															"url" : 'audioRequestApproval.action',
															"data" : JSON
																	.stringify(ajaxData),
															contentType : "application/json; charset=utf-8",
															async : false,
															success : function(
																	jsonString) {
																//alert(jsonString);
																for (var i = 0; i < markers.length; i++) {
																	if (markers[i].id == id) {
																		markers[i]
																				.setMap(null);
																		markers
																				.splice(
																						i,
																						1);
																		return;
																	}
																}
																alert(id
																		+ ' succeffully accepted');
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
											"#reject",
											function() {
												id = $(this).attr('class');

												var request = {
													"status" : "REJECT",
													"id" : id
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
															"url" : 'audioRequestApproval.action',
															"data" : JSON
																	.stringify(ajaxData),
															contentType : "application/json; charset=utf-8",
															async : false,
															success : function(
																	jsonString) {
																for (var i = 0; i < markers.length; i++) {
																	if (markers[i].id == id) {
																		markers[i]
																				.setMap(null);
																		markers
																				.splice(
																						i,
																						1);
																		return;
																	}
																}
																alert(id
																		+ ' succeffully rejected');
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
				DragAble, Removable, iconPath, id, age, gender, nativeLang,
				atwhatage,locV) {
			//new marker
			var marker = new google.maps.Marker({
				position : MapPos,
				map : map,
				draggable : DragAble,
				animation : google.maps.Animation.DROP,
				title : MapTitle,
				icon : iconPath,
				gender: null,
				age: null,
				nativeLang:null,
				atwhatage:null
			});

			marker.id = id;
			marker.age = age;
			marker.gender = gender;
			marker.nativeLang = nativeLang;
			marker.atwhatage = atwhatage;
			marker.locationV = locV;
			uniqueId++;

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
			markers.push(marker);
		}

		</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCGLwCkDXVFyy0ryStEIONSMkMrWk3z4a4&libraries=places&callback=initAutocomplete"
		async defer></script>

	<script type="text/javascript">
	var markers = [];
	var uniqueId = 1;
	$(document).ready(function() {
		//google.maps.event.addDomListener(window, "load", initAutocomplete);

		$('#filterGeneder').multiselect();
		$('#nativeSpeakerFilter').multiselect();
		$('#timeInCanadaFilter').multiselect();

		$('#genders').multiselect();
		$('#words').multiselect();
		$('#nativeLanguageSelection').multiselect();

		var map;
		$('.dropdown-menu').find('form').click(function(e) {
			e.stopPropagation();
		});

	});
	</script>
	
	<script type="text/javascript">
		var d = document.createElement('div');
		
		var locations;
		
		$.get("getLocation.action", function (data) {
			locations=data;
		});
		
		
		d.id = 'panelSide';
		d.style.position = 'fixed';
		d.style.padding = '10px';
		d.style.left = '0px';
		d.style.top = '40vh';
		d.style.backgroundColor = 'rgba(265,0,0,0.5)';
		d.style.border = '1px solid black';

		var gender = '<select id="filterGeneder" class="form-control" multiple="multiple">'
				+ '<option value="Female">Female</option>'
				+ '<option value="Male">Male</option>'
				+ '<option value="Other">Other</option>' + '</select>';

		var minAge = '<input size="17px" type="text" id="filterMinimumAge" name="filterMinimumAge" placeholder="Minimum Age">';
		var maxAge = '<input  size="17px" type="text" id="filterMaximumAge" name="filterMaximumAge" placeholder="Maximum Age">';

		var nativeSpeaker = '<select id="nativeSpeakerFilter" class="form-control" multiple="multiple">'
			+ '<option value="true">yes</option>'
			+ '<option value="false">no</option>' + '</select>';
			
			
		var locationDropDown = '<select id="locationOfVoices" class="form-control" multiple="multiple">'
		+locations+ '</select>';

	var timeInCanada = '<select id="timeInCanadaFilter" class="form-control" multiple="multiple">'
			+ '<option value="before age 5">before age 5</option>'
			+ '<option value="between 5 and 12">between 5 and 12</option>'
			+ '<option value="between 13 and 20">between 13 and 20</option>'
			+ '<option value="age 21 or older">age 21 or older</option>'
			+ '<option value="I have never lived in Canada">I have never lived in Canada</option>' + '</select>';

			
			if( !(typeof locations === 'undefined') && locations.trim().length>0){
				
			
		d.innerHTML = '<table><tr><td align="center" colspan="2" style="width:100%"><h2>Filter results</h2></td></tr>'
				+ '<tr><td>Gender</td><td>'
				+ gender
				+ '</td></tr>'
				+ '<tr><td>Minimum Age</td><td>'
				+ minAge
				+ '</td></tr>'
				+ '<tr><td>Maximum Age</td><td>'
				+ maxAge
				+ '</td></tr>'
				+ '<tr><td>Native Canadian<br />'
				+ 'English Speaker</td><td>'
				+ nativeSpeaker
				+ '</td></tr>'
				+'<tr><td>Locations</td><td>'
				+locationDropDown
				+ '</td></tr>'
				+ '<tr><td>Time in Canada</td><td>'
				+ timeInCanada
				+ '</td></tr>'
				+ '<tr><td></td><td><button id="filterSubmit" type="button" class="btn btn-primary">Apply</button> </td></tr></table>';
			}else{
				d.innerHTML = '<table><tr><td align="center" colspan="2" style="width:100%"><h2>Filter results</h2></td></tr>'
					+ '<tr><td>Gender</td><td>'
					+ gender
					+ '</td></tr>'
					+ '<tr><td>Minimum Age</td><td>'
					+ minAge
					+ '</td></tr>'
					+ '<tr><td>Maximum Age</td><td>'
					+ maxAge
					+ '</td></tr>'
					+ '<tr><td>Native Canadian<br />'
					+ 'English Speaker</td><td>'
					+ nativeSpeaker
					+ '</td></tr>'
					+ '<tr><td>Time in Canada</td><td>'
					+ timeInCanada
					+ '</td></tr>'
					+ '<tr><td></td><td><button id="filterSubmit" type="button" class="btn btn-primary">Apply</button> </td></tr></table>';
				
			}
		$(document)
				.on(
						"click",
						"#filterSubmit",
						function() {
							var locationFilterSelected = "";
							if( !(typeof locations === 'undefined') && locations.trim().length>0){
							
							
							$('#locationOfVoices :selected').each(function() {
								locationFilterSelected += $(this).text() + ",";
							});
							}

							var genderFilterSelected = "";
							$('#filterGeneder :selected').each(function() {
								genderFilterSelected += $(this).text() + ",";
							});
							if (genderFilterSelected.length > 2)
								genderFilterSelected = genderFilterSelected
										.substring(0,
												genderFilterSelected.length - 1);
							var nativeSpeakerFilterSelected = "";
							$('#nativeSpeakerFilter :selected').each(
									function() {
										var transformedNativeLangValue = null;
										if( $(this)
												.text().equals("yes")){
											transformedNativeLangValue = "true";
										}else if( $(this)
												.text().equals("no")){
											transformedNativeLangValue = "false";
										}
										
										nativeSpeakerFilterSelected +=transformedNativeLangValue
												+ ",";
									});
							if (nativeSpeakerFilterSelected.length > 2)
								nativeSpeakerFilterSelected = nativeSpeakerFilterSelected
										.substring(
												0,
												nativeSpeakerFilterSelected.length - 1);
							var timeInCanadaSelectedFilter = "";
							$('#timeInCanadaFilter :selected').each(
									function() {
										timeInCanadaSelectedFilter += $(this)
												.text()
												+ ",";
									});
							if (timeInCanadaSelectedFilter.length > 2)
								timeInCanadaSelectedFilter = timeInCanadaSelectedFilter
										.substring(
												0,
												timeInCanadaSelectedFilter.length - 1);

							for (var i = 0; i < markers.length; i++) {

								genderCheck = false;
								nativeCheck = false;
								timeInCheck = false;
								ageCheck = false;
								locationCheck = false;

								min = 0;
								max = 999999;

								if ($("#filterMinimumAge").val() > 0) {
									min = $("#filterMinimumAge").val();
								}

								if ($("#filterMaximumAge").val() > 0) {
									max = $("#filterMaximumAge").val();
								}


								if(markers[i].age <=max && markers[i].age>=min){
									ageCheck=true;
								}

								
								if (locationFilterSelected.length > 0) {
									temp = locationFilterSelected.split(',');
									for (var j = 0; j <= temp.length; j++) {
										if(temp[j] == markers[i].locationV){
											locationCheck = true;
											break;
										}
									}
								}else{
									locationCheck = true;
								}
								

								if (genderFilterSelected.length > 0) {
									temp = genderFilterSelected.split(',');
									for (var j = 0; j <= temp.length; j++) {
										if(temp[j] == markers[i].gender){
											genderCheck = true;
											break;
										}
									}
								}else{
									genderCheck = true;
								}

								if (nativeSpeakerFilterSelected.length > 0) {
									temp = nativeSpeakerFilterSelected.split(',');
									for (var j = 0; j <= temp.length; j++) {
										if(temp[j] == markers[i].nativeLang){
											nativeCheck = true;
											break;
										}
									}
								}else{
									nativeCheck = true;
								}

								if (timeInCanadaSelectedFilter.length > 0) {
									temp = timeInCanadaSelectedFilter.split(',');
									for (var j = 0; j <= temp.length; j++) {
										if(temp[j] == markers[i].atwhatage){
											timeInCheck = true;
											break;
										}
									}
								}else{
									timeInCheck = true;
								}

								if(genderCheck && nativeCheck && timeInCheck && ageCheck && locationCheck){
									if(markers[i].getMap() == null){
										markers[i].setMap(map);
									}
								}else{
									markers[i]
									.setMap(null);
								}
							}

						});

		document.body.appendChild(d);
	</script>
</body>
</html>
