package com.rav.audtioapp.dto;

public class DownloadAudioFilesDTO {

	private String wordsSelected;
	private String gendersSelected;
	private String minimumAge;
	private String maximumAge;

	public String getWordsSelected() {
		return wordsSelected;
	}

	public void setWordsSelected(String wordsSelected) {
		this.wordsSelected = wordsSelected;
	}

	public String getGendersSelected() {
		return gendersSelected;
	}

	public void setGendersSelected(String gendersSelected) {
		this.gendersSelected = gendersSelected;
	}

	public String getMinimumAge() {
		return minimumAge;
	}

	public void setMinimumAge(String minimumAge) {
		this.minimumAge = minimumAge;
	}

	public String getMaximumAge() {
		return maximumAge;
	}

	public void setMaximumAge(String maximumAge) {
		this.maximumAge = maximumAge;
	}

}
