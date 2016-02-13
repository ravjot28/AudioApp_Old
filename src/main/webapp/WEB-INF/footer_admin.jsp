


<div id="footer">
	<ul id="footer_menu">
		<li><a data-toggle="modal" href="#downloadForm">Update
				Parameters</a></li>
	</ul>
	<ul id="notifications">
		<li>Strathy Language Unit</li>
		<li><a target="_blank" href="http://www.queensu.ca/strathy/home"
			class="notificationIcons"><img src='../images/queens_logo.png'
				alt="" /></a></li>

		<li><a href="#" class="notificationIcons"><img
				src='../images/facebook-icon.png' alt="" /></a></li>
		<li><a href="#" class="notificationIcons"><img
				src='../images/Twitter_logo_blue_48.png' alt="" /></a></li>

	</ul>

</div>



<div class="modal fade" id="downloadForm" tabindex="-1" role="dialog"
	aria-labelledby="downloadForm" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Update parameter</h4>
				<!-- Download Voices -->
			</div>

			<!-- Modal Body -->
			<div class="modal-body">
				<form action="updateParameter.action" method="post" role="form"
					id="target">

					<input type="hidden" id="parameterName" name="parameterName"
						value="" /> <input type="hidden" id="parameterValue"
						name="parameterValue" value="" /> <select id="myoptions">

					</select>


					<textarea id="paramContent" name="paramContent" rows="15" cols="75"
						style="resize: none;" data-role="none"></textarea>


				</form>
			</div>

			<!-- Modal Footer -->
			<div class="modal-footer">
				<button id="InfroTextSubmit" type="button" class="btn btn-default">Update
					Parameter</button>
			</div>

		</div>
	</div>
</div>




<script>
	$("#InfroTextSubmit").click(
			function(e) {
				$("#parameterName").val(
						$("#myoptions").find(':selected').text());
				$("#parameterValue").val($("#paramContent").val());

				//alert($("#myoptions").find(':selected').text());

				//alert($("#paramContent").val());

				if (new String($("#myoptions").find(':selected').val())
						.valueOf() == new String($("#paramContent").val())
						.valueOf()) {
					alert("There is no change in the parameter value");
				} else {
					$("#target").submit();
				}

			});
</script>