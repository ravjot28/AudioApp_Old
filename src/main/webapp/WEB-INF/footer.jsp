
<div id="footer">
	<ul id="footer_menu">
		<li><a href="strathyUnit">Home</a></li>
		<li><a href="strathyUnitAddAudio">Add Audio</a></li>
		<li><a data-toggle="modal" href="#downloadForm">Download
				Audio</a></li>
		<li><a href="#" class="drop">About</a>

			<div class="one_column_layout">
				<div>
					<h2>About this website</h2>
				</div>

				<div class="clear"></div>

				<div>
					<p class="black_box">This website records the voices and also
						allows user to hear the voices which are persisted in the
						application</p>
				</div>
				<div class="clear"></div>

				<div>
					<h2>Developer Profile</h2>
				</div>

				<div>
					<!-- Examples of paragraphs with side images -->
					<p>
						<img
							src="https://s-media-cache-ak0.pinimg.com/236x/60/b0/bb/60b0bb993c54a65281b56d0543faefa6.jpg"
							class="img_left whiteBorder" alt="" /> <a
							style="display: inline; font-weight: bold; color: white;">Ravjot
							Singh</a> <a href="http://cultofprogramming.blogspot.ca">Read
							more...</a>
					</p>
				</div>
			</div></li>
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
				<h4 class="modal-title" id="myModalLabel">Download Voices</h4>
			</div>

			<!-- Modal Body -->
			<div class="modal-body">
				<form action="downloadAudioFiles.action" method="post" role="form"
					id="target">
					<input type="hidden" id="wordsSelected" name="wordsSelected"
						value="" /> <input type="hidden" id="gendersSelected"
						name="gendersSelected" value="" /> <input type="hidden"
						id="minimumAge" name="minimumAge" value="" /> <input
						type="hidden" id="maximumAge" name="maximumAge" value="" /> <input
						type="hidden" id="nativeLanguage" name="nativeLanguage" value="" />

					<div class="form-group">
						<label for="exampleInputEmail1">Select the word(s) to be
							downloaded</label> <select id="words" class="form-control"
							multiple="multiple">
							<option value="bag">bag</option>
							<option value="cot">cot</option>
							<option value="gang">gang</option>
							<option value="past">past</option>
							<option value="spa">spa</option>
							<option value="band">band</option>

							<option value="deck">deck</option>
							<option value="house">house</option>
							<option value="pasta">pasta</option>
							<option value="test">test</option>
							<option value="boat">boat</option>
							<option value="duck">duck</option>

							<option value="how">how</option>
							<option value="pool">pool</option>
							<option value="tie">tie</option>
							<option value="boot">boot</option>
							<option value="face">face</option>
							<option value="kiss">kiss</option>

							<option value="seat">seat</option>
							<option value="tight">tight</option>
							<option value="caught">caught</option>
							<option value="far">far</option>
							<option value="pack">pack</option>
							<option value="sharp">sharp</option>

							<option value="too">too</option>
						</select>

					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Select Gender(s)</label> <select
							id="genders" class="form-control" multiple="multiple">
							<option value="Male">Male</option>
							<option value="Female">Female</option>
							<option value="Other">Other</option>
						</select>
					</div>
					
					<div class="form-group">
						<label for="nativeLanguageSelect">English as mother tongue</label> <select
							id="nativeLanguageSelection" class="form-control" multiple="multiple">
							<option>Yes</option>
							<option>No</option>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1">Select minimum age</label> <input
							type="text" class="form-control" id="mAge"
							placeholder="Enter minimum age" /> <label
							for="exampleInputPassword3">Select maximum age</label> <input
							type="text" class="form-control" id="maAge"
							placeholder="Enter maximum age" />
					</div>

				</form>
			</div>

			<!-- Modal Footer -->
			<div class="modal-footer">
				<button id="InfroTextSubmit" type="button" class="btn btn-default">Submit</button>
			</div>

		</div>
	</div>
</div>




<script>
	$("#InfroTextSubmit").click(
			function(e) {
				var wordsSelected = "";
				$('#words :selected').each(function() {
					wordsSelected += $(this).text() + ",";
				});
				if (wordsSelected.length > 2)
					wordsSelected = wordsSelected.substring(0,
							wordsSelected.length - 1);
				var gendersSelected = "";
				$('#genders :selected').each(function() {
					gendersSelected += $(this).text() + ",";
				});
				if (gendersSelected.length > 2)
					gendersSelected = gendersSelected.substring(0,
							gendersSelected.length - 1);
				$("#wordsSelected").val(wordsSelected);
				$("#gendersSelected").val(gendersSelected);
				$("#minimumAge").val($("#mAge").val());
				$("#maximumAge").val($("#maAge").val());
				
				var nativeLanguageSelected = "";
				$('#nativeLanguageSelection :selected').each(function() {
					nativeLanguageSelected += $(this).text() + ",";
				});
				
				$("#nativeLanguage").val(nativeLanguageSelected);

				$("#target").submit();

			});
</script>