


<div id="footer">
	<ul id="footer_menu">
		<li><a href="strathyUnit">Home</a></li>
		<li><a href="strathyUnitAddAudio">Add Audio</a></li>
		<li><a data-toggle="modal" href="#downloadForm">Download
				Audio</a></li>


		<li><a href="#">About Us</a>
			<div class="one_column_layout">
				<div>
					<h2>About Us</h2>
				</div>

				<div class="clear"></div>
				<div class="col_1">
				
				
				<%= tc.getParamValue(ParamConstants.ABOUT_US)  %>
				
				
					<!-- <p>
						<strong>Canadian English Voice Map</strong>
					<p>is an interactive map that allows you to listen to sound
						samples submitted by users around the country as well as submit
						your own samples. The purpose of the map is to explore dialect
						variation throughout the country. Users also have the option of
						downloading files for their own analysis.</p>
					<br /> <br />
					<p>
						The map was created by the Strathy Language Unit <a
							href="http://www.queensu.ca/strathy/" target="_blank"
							rel="noreferrer">at Queen's University</a>
					</p>
					<p>
						We welcome your feedback. Please contact us at <a
							href="mailto:CVM@queensu.ca" target="_blank" rel="noreferrer">CVM@queensu.ca</a>
					</p>
					<p>
						How do I use the map?<br /> To listen to a recording, simply
						click on a marker to reveal a pop-up box with information on the
						speaker and an option to play or download a word. To zoom into a
						dense area, you can type an address/city/region into the search
						box. To add your own voice or download a set of files, click on
						the relevant tab and follow the instructions. Note that the "Add
						your voice" function only works with Chrome as your search engine.
					</p>

					<p>
						Why did you choose these words?<br /> The words in the recording
						list were chosen to highlight different areas of possible dialect
						variation.
					</p> -->

				</div>

			</div></li>


		<li><a href="#">Credits</a>
			<div class="one_column_layout">
				<div>
					<h2>Credits</h2>
				</div>

				<div class="clear"></div>
				<div class="col_1">
				<%= tc.getParamValue(ParamConstants.CREDITS)  %>
					<!-- <p>
						<strong>Canadian English Voice Map</strong>
					<p>
						iCanadian English Voice Map is a product of the Strathy Language
						Unit <a href="http://www.queensu.ca/strathy/" target="_blank"
							rel="noreferrer">at Queen's University</a>
						<br />It was launched in April 2016. 
						<br />Project Director: Anastasia Riehl, Queen's University 
						<br />Project Partner: Charles Boberg, McGill
						<br />University Program Developer: Ravjot Singh
					</p> -->


				</div>

			</div></li>
	</ul>

	<ul id="notifications">
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
				<h4 class="modal-title" id="myModalLabel"><%= tc.getParamValue(ParamConstants.DOWNLOAD_AUDIO_HEAD)  %></h4>
				<!-- Download Voices -->
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
						<label for="exampleInputEmail1"><%= tc.getParamValue(ParamConstants.DOWNLOAD_AUDIO_SELECT_WORD)  %> <!-- Select the word(s) to be
							downloaded --></label> <select id="words" class="form-control"
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
						<label for="exampleInputPassword1"><%= tc.getParamValue(ParamConstants.DOWNLOAD_AUDIO_SELECT_GENDER)  %><!-- Select Gender(s) --></label> <select
							id="genders" class="form-control" multiple="multiple">
							<option value="Female">Female</option>
							<option value="Male">Male</option>
							<option value="Other">Other</option>
						</select>
					</div>

					<div class="form-group">
						<label for="nativeLanguageSelect"><%= tc.getParamValue(ParamConstants.DOWNLOAD_AUDIO_SELECT_MOTHER_TOUNGE)  %> <!-- English as mother tongue --></label>
						<select id="nativeLanguageSelection" class="form-control"
							multiple="multiple">
							<option>Yes</option>
							<option>No</option>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleInputPassword1"><%= tc.getParamValue(ParamConstants.DOWNLOAD_AUDIO_SELECT_MINIMUM_AGE)  %><!-- Select minimum age --></label> <input
							type="text" class="form-control" id="mAge"
							placeholder="Enter minimum age" /> <label
							for="exampleInputPassword3"><%= tc.getParamValue(ParamConstants.DOWNLOAD_AUDIO_SELECT_MAXIMUM_AGE)  %> <!-- Select maximum age --></label> <input
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