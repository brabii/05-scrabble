package com.scrabble;

import java.util.List;
import java.util.TreeMap;

public class Solution {
	static boolean isContainsWord(String mot, String lettresRestantes) {
		int count = 0;
		if (lettresRestantes.length() < mot.length()) {
			return false;
		}
		for (int i = 0; i < mot.length(); i++) {
			for (int j = 0; j < lettresRestantes.length(); j++) {
				if (mot.charAt(i) == lettresRestantes.charAt(j)) {
					count++;
					StringBuilder sb = new StringBuilder(lettresRestantes);
					sb.deleteCharAt(j);
					lettresRestantes = new String(sb);
					break;
				}
			}
		}
		if (count == mot.length()) {
			return true;
		}
		return false;
	}

	static int countPuissance(char c) {
		int sum = 0;
		String onePoint = "eaionrtlsu";
		String twoPoints = "dg";
		String threePoints = "bcmp";
		String fourPoints = "fhvwy";
		String fivePoints = "k";
		String eightPoints = "jx";
		String tenPoints = "qz";

		String val = Character.toString(c);

		if (onePoint.contains(val)) {
			sum = sum + 1;
		} else if (twoPoints.contains(val)) {
			sum = sum + 2;
		} else if (threePoints.contains(val)) {
			sum = sum + 3;
		} else if (fourPoints.contains(val)) {
			sum = sum + 4;
		} else if (fivePoints.contains(val)) {
			sum = sum + 5;
		} else if (eightPoints.contains(val)) {
			sum = sum + 8;
		} else if (tenPoints.contains(val)) {
			sum = sum + 10;
		}
		return sum;
	}

	static String getWordWithMaxPoints(List<String> dictionnaire, String lettresRestantes) {
		int puissance = 0;
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
		for (String mot : dictionnaire) {
			puissance = 0;
			if (lettresRestantes.equals(mot)) {
				for (int i = 0; i < lettresRestantes.length(); i++) {
					puissance = puissance + countPuissance(lettresRestantes.charAt(i));
				}
				treeMap.put(new Integer(puissance), lettresRestantes);
			} else {
				if (isContainsWord(mot, lettresRestantes)) {
					for (int i = 0; i < mot.length(); i++) {
						puissance = puissance + countPuissance(mot.charAt(i));
					}
					if (!treeMap.containsKey(puissance))
						treeMap.put(new Integer(puissance), mot);
				}
			}
		}
		return treeMap.lastEntry().getValue().toString();
	}
}
