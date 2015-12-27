package com.rav.audtioapp.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class DownloadInputStream extends java.io.FileInputStream {

	File file = null;

	public DownloadInputStream(File file) throws FileNotFoundException {
		super(file);
		this.file = file;
	}

	@Override
	public void close() throws IOException {
		super.close();
		file.delete();
	}
}