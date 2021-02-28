package com.scrabble;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class ConversionResourcesUtil {

	public static List<String> convertFromDataFileToRoundObjects(String fileName) {
		File f = new File(fileName);
		List<String> list = new ArrayList<>();
		Scanner in = null;
		try {
			in = new Scanner(f);
			while (in.hasNext()) {
				String line = in.nextLine();
				list.add(line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			in.close();
		}

		return list;
	}

	private ConversionResourcesUtil() {

	}
}
