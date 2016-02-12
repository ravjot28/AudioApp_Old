package com.rav.audtioapp.languageExtraction;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GetAllLanguages {
	public static void main(String[] args) throws IOException {
		String languages = "";
		languages += new GetAllLanguages().getText("/Users/ravjotsingh/Desktop/List of languages of the world.html");
		languages += new GetAllLanguages().getText("/Users/ravjotsingh/Desktop/List of languages of the world1.html");
		languages += new GetAllLanguages().getText("/Users/ravjotsingh/Desktop/List of languages of the world2.html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("langauges.txt")));
		bw.append(languages.substring(0, languages.length() - 1));
		bw.close();
	}

	public String getText(String fName) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File(fName)));
		String line = br.readLine();
		String result = "";
		while (line != null) {
			if (line.trim().equals("<p style=\"line-height: 200%\">")) {
				line = br.readLine();
				while (!line.contains("</p>")) {
					if (line.trim().length() > 0) {

						// System.out.println();
						System.out.println(line);
						try {
							result += line.substring(0, line.indexOf("(")) + "["
									+ line.substring(line.indexOf(">") + 1, line.indexOf("</a>")) + "]" + ",";
						} catch (Exception e) {

						}
					}

					line = br.readLine();
				}

			}
			line = br.readLine();
		}
		br.close();

		return result;
	}
}
