package com.rav.audtioapp.service;

import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import com.rav.audtioapp.dao.audio.AudioDetailsDAO;
import com.rav.audtioapp.dao.audio.DownloadAudioFilesDAO;
import com.rav.audtioapp.dto.DownloadAudioFilesDTO;

public class DownloadAudioFilesService {

	public String process(DownloadAudioFilesDTO dto) {
		Map<String, String> voices = null;

		voices = new DownloadAudioFilesDAO().getVoices(dto);
		String fileName = null;
		if (voices != null) {
			String content = "ID,longitude , lattitude ,birthyear , gender , mother tounge , rate fluency ,  at what age ,  emailaddress , town ,  born in canada , if not mother tounge ,"
					+ "province  " + System.getProperty("line.separator");
			Set<Integer> ids = new HashSet<Integer>();
			for (Map.Entry<String, String> voice : voices.entrySet()) {
				String name = voice.getKey();
				ids.add(Integer.parseInt(name.substring(0, name.indexOf("_")).replaceAll("CVMX-", "")));
			}

			for (int id : ids)
				content += "CVMX-" + id + "," + new AudioDetailsDAO().getAudioDetails(id)
						+ System.getProperty("line.separator");

			fileName = createZipFile(voices, content);
		}

		return fileName;
	}

	public String downloadAllVoices(String id) {

		Map<String, String> voices = null;
		int id1 = Integer.parseInt(id.replaceAll("CVMX-", ""));
		voices = new DownloadAudioFilesDAO().getAllVoices(id1);
		String fileName = null;
		if (voices != null) {
			String content = "ID,longitude , lattitude ,birthyear , gender , mother tounge , rate fluency ,  at what age ,  emailaddress , town ,  born in canada , if not mother tounge ,"
					+ "province  " + System.getProperty("line.separator");
			Set<Integer> ids = new HashSet<Integer>();
			for (Map.Entry<String, String> voice : voices.entrySet()) {
				String name = voice.getKey();
				ids.add(Integer.parseInt(name.substring(0, name.indexOf("_")).replaceAll("CVMX-", "")));
			}

			for (int id11 : ids)
				content += "CVMX-" + id11 + "," + new AudioDetailsDAO().getAudioDetails(id11)
						+ System.getProperty("line.separator");
			fileName = createZipFile(voices, content);
		}

		return fileName;
	}

	private String createZipFile(Map<String, String> voices, String content) {

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

			ZipEntry ze = new ZipEntry("Summary.csv");
			zout.putNextEntry(ze);
			zout.write(content.getBytes(StandardCharsets.UTF_8));
			zout.closeEntry();

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
			System.out.println(fName + " " + content);
			r.printStackTrace();
		}
		return bytes;
	}

}
