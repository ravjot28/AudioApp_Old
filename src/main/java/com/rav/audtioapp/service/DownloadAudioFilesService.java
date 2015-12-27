package com.rav.audtioapp.service;

import java.io.FileOutputStream;
import java.util.Base64;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.rav.audtioapp.dao.DownloadAudioFilesDAO;
import com.rav.audtioapp.dto.DownloadAudioFilesDTO;

public class DownloadAudioFilesService {

	public String process(DownloadAudioFilesDTO dto) {
		Map<String, String> voices = null;

		voices = new DownloadAudioFilesDAO().getVoices(dto);
		String fileName = null;
		if (voices != null)
			fileName = createZipFile(voices);

		return fileName;
	}

	private String createZipFile(Map<String, String> voices) {
		
		
		String fname = null;
		try {
			fname = "Words" + System.currentTimeMillis() + ".zip";
			FileOutputStream fout = new FileOutputStream(fname);
			ZipOutputStream zout = new ZipOutputStream(fout);

			for (Map.Entry<String, String> voice : voices.entrySet()) {
				byte[] bytes = createWavFileContent(voice.getValue(), voice.getKey());
				if (bytes != null) {
					ZipEntry ze = new ZipEntry(voice.getKey());
					zout.putNextEntry(ze);

					zout.write(bytes, 0, bytes.length);
					zout.closeEntry();
				}
			}
			zout.close();
		} catch (Exception e) {
			e.printStackTrace();
			fname = null;
		}
		return fname;
	}

	private byte[] createWavFileContent(String content, String fName) {
		byte[] bytes = null;
		try {
			bytes = Base64.getDecoder().decode(content);
		} catch (Exception r) {
			System.out.println(fName+" "+content);
			r.printStackTrace();
		}
		return bytes;
	}

}
