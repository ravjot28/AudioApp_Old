package com.rav.audtioapp.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.rav.audtioapp.service.DownloadAudioFilesService;
import com.rav.audtioapp.util.DownloadInputStream;

public class DownloadAllAudioFilesAction {

	private InputStream inputStream;
	private String fileName;
	private long contentLength;
	private String id;

	public String execute() throws FileNotFoundException {

		String fName = new DownloadAudioFilesService().downloadAllVoices(id);
		if (fName != null) {
			File fileToDownload = new File(fName);
			inputStream = new DownloadInputStream(fileToDownload);
			fileName = fileToDownload.getName();
			contentLength = fileToDownload.length();
			return "success";
		}
		return "invalidSelection";

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void setContentLength(long contentLength) {
		this.contentLength = contentLength;
	}

	public long getContentLength() {
		return contentLength;
	}

	public String getFileName() {
		return fileName;
	}

	public InputStream getInputStream() {
		return inputStream;
	}
}
