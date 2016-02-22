package com.rav.audtioapp.constants.param;

public class ParamConstants {

	// dao
	public static final String PARAM_NAME = "param_name";
	public static final String PARAM_ROLE = "param_role";
	public static final String PARAM_VALUE = "param_value";
	public static final String PARAM_TYPE = "param_type";
	public static final String PARAM_ACTOR = "param_actor";

	public static final String PARAM_TABLE_NAME = "Housing_Params";

	// param names
	public static final String STRATHY_ADMIN = "STRATHY_ADMIN";

	public static final String STRATHY_WEBSITE_HEADING = "STRATHY_WEBSITE_HEADING";

	public static final String STRATHY_ENTER_LOCATION_SEARCH_BAR = "STRATHY_ENTER_LOCATION_SEARCH_BAR";

	public static final String STRATHY_EMAIL_ADDRESS = "STRATHY_EMAIL_ADDRESS";
	public static final String STRATHY_EMAIL_ADDRESS_CONTENT = "riehla@queensu.ca";

	public static final String STRATHY_EMAIL_SUBJECT = "STRATHY_EMAIL_SUBJECT";
	public static final String STRATHY_EMAIL_SUBJECT_CONTENT = "New audio submission $ID$";

	public static final String STRATHY_EMAIL_BODY = "STRATHY_EMAIL_BODY";
	public static final String STRATHY_EMAIL_BODY_CONTENT = "Canadian English Voice Map user $ID$ is ready for review.";

	public static final String STRATHY_EMAIL_SUBJECT_TO_END_USER = "STRATHY_EMAIL_SUBJECT_TO_END_USER";
	public static final String STRATHY_EMAIL_SUBJECT_TO_END_USER_CONTENT = "Your reference number is: $ID$";

	public static final String STRATHY_EMAIL_TO_END_USER = "STRATHY_EMAIL_TO_END_USER";
	public static final String STRATHY_EMAIL_TO_END_USER_CONTENT = "Thank you for participating in the Canadian English Voice Map! Your reference number is "
			+ "$ID$"
			+ ".\n If you have any questions about your submission, please contact CEVM@queensu.ca.\n\n- The Strathy Language Unit";

	public static final String ADD_AUDIO_PAGE_WELCOME = "ADD_AUDIO_PAGE_WELCOME";
	public static final String ADD_AUDIO_PAGE_WELCOME_NON_BROWSER = "ADD_AUDIO_PAGE_WELCOME_NON_BROWSER";

	public static final String ADD_AUDIO_PAGE_HEADING = "ADD_AUDIO_PAGE_2_HEADING";

	public static final String ADD_AUDIO_PAGE_1 = "ADD_AUDIO_PAGE_1";

	public static final String ADD_AUDIO_PAGE_2_BIRTH_YEAR_TITLE = "ADD_AUDIO_PAGE_2_BIRTH_YEAR_TITLE";
	public static final String ADD_AUDIO_PAGE_2_GENDER_TITLE = "ADD_AUDIO_PAGE_2_GENDER_TITLE";
	public static final String ADD_AUDIO_PAGE_2_MOTHER_TOUNGE_TITLE = "ADD_AUDIO_PAGE_2_MOTHER_TOUNGE_TITLE";
	public static final String ADD_AUDIO_PAGE_2_FLUENCY_TITLE = "ADD_AUDIO_PAGE_2_FLUENCY_TITLE";
	public static final String ADD_AUDIO_PAGE_2_BORN_CANADA_TITLE = "ADD_AUDIO_PAGE_2_BORN_CANADA_TITLE";
	public static final String ADD_AUDIO_PAGE_2_WHAT_AGE_MOVE_IN_TITLE = "ADD_AUDIO_PAGE_2_WHAT_AGE_MOVE_IN_TITLE";
	public static final String ADD_AUDIO_PAGE_2_EMAIL_ADDRESS_TITLE = "ADD_AUDIO_PAGE_2_EMAIL_ADDRESS_TITLE";

	public static final String ADD_AUDIO_PAGE_3 = "ADD_AUDIO_PAGE_3";

	public static final String ADD_AUDIO_PAGE_5 = "ADD_AUDIO_PAGE_5";

	public static final String DOWNLOAD_AUDIO_HEAD = "DOWNLOAD_AUDIO_HEAD";
	public static final String DOWNLOAD_AUDIO_SELECT_WORD = "DOWNLOAD_AUDIO_SELECT_WORD_QUESTION";
	public static final String DOWNLOAD_AUDIO_SELECT_GENDER = "DOWNLOAD_AUDIO_SELECT_GENDER";
	public static final String DOWNLOAD_AUDIO_SELECT_MOTHER_TOUNGE = "DOWNLOAD_AUDIO_SELECT_MOTHER_TOUNGE";
	public static final String DOWNLOAD_AUDIO_SELECT_MINIMUM_AGE = "DOWNLOAD_AUDIO_SELECT_MINIMUM_AGE";
	public static final String DOWNLOAD_AUDIO_SELECT_MAXIMUM_AGE = "DOWNLOAD_AUDIO_SELECT_MAXIMUM_AGE";

	public static final String ABOUT_US = "ABOUT_US";
	public static final String CREDITS = "CREDITS";

	public static String PARAM_INSERT = "INSERT INTO " + PARAM_TABLE_NAME + " (" + PARAM_NAME + ", " + PARAM_VALUE
			+ ", active) VALUES (?, ?, 'Y')";

	public static final String STRATHY_ADMIN_CONTENT = "ravjot28";

	public static final String STRATHY_ENTER_LOCATION_SEARCH_BAR_CONTENT = "Enter Location";

	public static final String STRATHY_WEBSITE_HEADING_CONTENT = "Strathy Unit";

	public static final String ADD_AUDIO_PAGE_WELCOME_CONTENT = "<p>To choose your location:</p>\n"
			+ "<p>If you lived in Canada as a child, select the location where\n"
			+ "you spent the majority of your time between ages five and\n" + "eighteen.</p>\n"
			+ "<p>If you came to Canada as an adult, select the location where\n"
			+ "you have spent the majority of your time since arriving. Zoom in\n"
			+ "to get as precise a location as you can!</p>";

	public static final String ADD_AUDIO_PAGE_WELCOME_NON_BROWSER_CONTENT = "<p>The recording functionality is available for only Google\n"
			+ "Chrome and Firefox browser. Please open the website using Google\n" + "Chrome or Firefox Browser.</p>\n"
			+ "<p>\n" + "You can download Google Chrome by clicking <a target=\"_blank\"\n"
			+ "href=\"https://www.google.com/chrome/browser/desktop/\">here</a>\n" + "</p>\n" + "<p>\n"
			+ "You can download Firefox by clicking <a target=\"_blank\"\n"
			+ "href=\"https://www.mozilla.org/en-US/firefox/new/\">here</a>\n" + "</p>";

	public static final String ADD_AUDIO_PAGE_HEADING_CONTENT = "Add Audio";

	public static final String ADD_AUDIO_PAGE_1_CONTENT = "<p>Thank you for your interest in being a part of our voice\n"
			+ "map! Before we record your voice, please read the following\n"
			+ "information about the project and your consent to participate.\n"
			+ "Once you click\"Next\", you will proceed to a brief questionnaire\n"
			+ "and then to the recording task.</p>\n" + "<p>\n"
			+ "<strong>Canadian Voices Map</strong> is an interactive digital\n"
			+ "map with structured audio samples from around the country. The\n"
			+ "goal of the project is to explore dialect diversity in Canadian\n"
			+ "English. Users can listen to samples, download audio files and\n" + "contribute their own voices.\n" +

	"</p>\n" + "<p>On the following screens, you will be asked to answer some\n"
			+ "background questions about yourself and then to record yourself\n"
			+ "reading twenty different English words. The process should take\n"
			+ "less than ten minutes. There are no known risks to participation\n"
			+ "in the study; participation is voluntary, and you may decline to\n"
			+ "answer any questions you choose.</p>\n" + "<p>The audio files you submit will be available through the\n"
			+ "website to any user, and these files will be linked to your\n"
			+ "background information. We are not collecting names and your\n"
			+ "data will therefore be anonymous and your confidentiality\n"
			+ "protected. However, given that your voice could be recognized by\n"
			+ "others, you should be aware that it may be possible for some\n"
			+ "users to identify your data. If you complete the recording task\n"
			+ "but later decide you donot want your audio included, please\n"
			+ "contact us and we will remove the data.</p>\n" + "<p>\n"
			+ "Any questions about study participation may be directed to the\n"
			+ "Strathy Language Unit at <a href=\"mailto:strathy@queenus.ca\">strathy@queenus.ca</a>\n"
			+ ". Any ethical concerns may be directed to the Chair of the\n"
			+ "General Research Ethics Board at Queen's University at <a\n"
			+ "href=\"mailto:chair.GREB@queensu.ca\">chair.GREB@queensu.ca</a>\n"
			+ "or 613-533-6081. This study has been granted clearance according\n"
			+ "to the recommended principles of Canadian ethics guidelines, and\n" + "Queen's University policies.\n" +

	"</p>\n" + "<p>By clicking \"Next\" below, you acknowledge the following:</p>\n"
			+ "<p>1. You have read and understand the above Letter of\n" + "Information.</p>\n"
			+ "<p>2. You understand that the audio files and background\n"
			+ "information you submit will be available on a public website.</p>";

	public static final String ADD_AUDIO_PAGE_2_BIRTH_YEAR_TITLE_CONTENT = "Select your birth year:";
	public static final String ADD_AUDIO_PAGE_2_GENDER_TITLE_CONTENT = "Select your gender:";
	public static final String ADD_AUDIO_PAGE_2_MOTHER_TOUNGE_TITLE_CONTENT = "Do you consider English your mother tongue (the language you learned first as a child and still use/understand)?";
	public static final String ADD_AUDIO_PAGE_2_FLUENCY_TITLE_CONTENT = "How would you rate your fluency in English?:";
	public static final String ADD_AUDIO_PAGE_2_BORN_CANADA_TITLE_CONTENT = "Were you born in Canada?";
	public static final String ADD_AUDIO_PAGE_2_WHAT_AGE_MOVE_IN_TITLE_CONTENT = "If no, at what age did you move to Canada?:";
	public static final String ADD_AUDIO_PAGE_2_EMAIL_ADDRESS_TITLE_CONTENT = "Is there an email address where we can contact you about your participation if necessary?";

	public static final String ADD_AUDIO_PAGE_3_CONTENT = "<p>\n" + "<h2>\n" + "<font color=\"red\">Alert!!</font>\n"
			+ "</h2>\n" + "<p>\n" + "Before you get started, make sure that your microphone is working\n"
			+ "and that you are in a relatively quiet location. For some tips on\n"
			+ "improving the quality of your recording, <a target=\"_blank\"\n"
			+ "href=\"http://www.soundonsound.com/sos/dec98/articles/20tips.568.htm\">click\n" + "here</a>.\n"
			+ "</p>\n" +

	"<p>To record, click on the \"start recording\" button and then\n"
			+ "say the word in a natural, casual manner. Press \"stop\" when you\n"
			+ "are done. To re-record a word, simply do it again and the\n" + "previous version will be erased.</p>";

	public static final String ADD_AUDIO_PAGE_5_CONTENT = "Do you want to submit the details?";

	public static final String DOWNLOAD_AUDIO_HEAD_CONTENT = "Download Voices";
	public static final String DOWNLOAD_AUDIO_SELECT_WORD_CONTENT = "Select the word(s) to be downloaded";
	public static final String DOWNLOAD_AUDIO_SELECT_GENDER_CONTENT = "Select Gender(s)";
	public static final String DOWNLOAD_AUDIO_SELECT_MOTHER_TOUNGE_CONTENT = "English as mother tongue";
	public static final String DOWNLOAD_AUDIO_SELECT_MINIMUM_AGE_CONTENT = "Select minimum age";
	public static final String DOWNLOAD_AUDIO_SELECT_MAXIMUM_AGE_CONTENT = "Select maximum age";

	public static final String ABOUT_US_CONTENT = "<p>\n" + "<strong>Canadian English Voice Map</strong>\n"
			+ "<p>is an interactive map that allows you to listen to sound\n"
			+ "samples submitted by users around the country as well as submit\n"
			+ "your own samples. The purpose of the map is to explore dialect\n"
			+ "variation throughout the country. Users also have the option of\n"
			+ "downloading files for their own analysis.</p>\n" + "<br /> <br />\n" + "<p>\n"
			+ "The map was created by the Strathy Language Unit <a\n"
			+ "href=\"http://www.queensu.ca/strathy/\" target=\"_blank\"\n"
			+ "rel=\"noreferrer\">at Queen's University</a>\n" + "</p>\n" + "<p>\n"
			+ "We welcome your feedback. Please contact us at <a\n"
			+ "href=\"mailto:CVM@queensu.ca\" target=\"_blank\" rel=\"noreferrer\">CVM@queensu.ca</a>\n" + "</p>\n"
			+ "<p>\n" + "How do I use the map?<br /> To listen to a recording, simply\n"
			+ "click on a marker to reveal a pop-up box with information on the\n"
			+ "speaker and an option to play or download a word. To zoom into a\n"
			+ "dense area, you can type an address/city/region into the search\n"
			+ "box. To add your own voice or download a set of files, click on\n"
			+ "the relevant tab and follow the instructions. Note that the \"Add\n"
			+ "your voice\" function only works with Chrome as your search engine.\n" + "</p>\n" +

	"<p>\n" + "Why did you choose these words?<br /> The words in the recording\n"
			+ "list were chosen to highlight different areas of possible dialect\n" + "variation.\n" + "</p>";

	public static final String CREDITS_CONTENT = "<p>\n" + "<strong>Canadian English Voice Map</strong>\n" + "<p>\n"
			+ "iCanadian English Voice Map is a product of the Strathy Language\n"
			+ "Unit <a href=\"http://www.queensu.ca/strathy/\" target=\"_blank\"\n"
			+ "rel=\"noreferrer\">at Queen's University</a>\n" + "<br />It was launched in April 2016. \n"
			+ "<br />Project Director: Anastasia Riehl, Queen's University\n"
			+ "<br />Project Partner: Charles Boberg, McGill\n" + "<br />University Program Developer: Ravjot Singh\n"
			+ "</p>";

}
