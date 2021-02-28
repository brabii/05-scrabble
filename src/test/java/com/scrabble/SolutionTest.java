package com.scrabble;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class SolutionTest {
	private static final List<String> LIST_ONLY_ONE_WORD = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/only-one-word");
	private static final List<String> LIST_2_WORDS_WITH_DIFFERENT_VALUES = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/2-words-with-different-value");
	private static final List<String> LIST_2_WORDS_WITH_SAME_VALUES = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/2-words-with-same-value");
	private static final List<String> LIST_CANNOT_USE_LETTER_TWICE = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/cannot-use-letter-twice");
	private static final List<String> LIST_LARGE_DICTIONNARY_1 = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/large-dictionnary-1");
	private static final List<String> LIST_LARGE_DICTIONNARY_2 = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/large-dictionnary-2");
	private static final List<String> LIST_MANY_POSSIBILITIES = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/many-possibilities");
	private static final List<String> LIST_VALID_WORD = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/valid-word");
	private static final List<String> LIST_VALUE_BETTER_THAN_SIZE = ConversionResourcesUtil
			.convertFromDataFileToRoundObjects("src/main/resources/value-better-than-size");

	@Test
	public void testOnlyOneWord() {
		String expectedString = "which";
		String lettresRestantes = "hicquwh";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_ONLY_ONE_WORD, lettresRestantes)));
	}

	@Test
	public void test2WordsWithDifferentValues() {
		String expectedString = "powers";
		String lettresRestantes = "tsropwe";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_2_WORDS_WITH_DIFFERENT_VALUES, lettresRestantes)));
	}

	@Test
	public void test2WordsWithSameValues() {
		String expectedString = "potsie";
		String lettresRestantes = "sopitez";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_2_WORDS_WITH_SAME_VALUES, lettresRestantes)));
	}

	@Test
	public void testCannotUseLetterTwice() {
		String expectedString = "powers";
		String lettresRestantes = "tsropwe";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_CANNOT_USE_LETTER_TWICE, lettresRestantes)));
	}

	@Test
	public void testLargeDictionnary1() {
		String expectedString = "satire";
		String lettresRestantes = "aretsui";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_LARGE_DICTIONNARY_1, lettresRestantes)));
	}

	@Test
	public void testLargeDictionnary2() {
		String expectedString = "pastern";
		String lettresRestantes = "retpasn";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_LARGE_DICTIONNARY_2, lettresRestantes)));
	}

	@Test
	public void testManyPossibilities() {
		String expectedString = "waster";
		String lettresRestantes = "arwtsre";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_MANY_POSSIBILITIES, lettresRestantes)));
	}

	@Test
	public void testValidWord() {
		String expectedString = "aeiou";
		String lettresRestantes = "qzaeiou";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_VALID_WORD, lettresRestantes)));
	}

	@Test
	public void testValueBetterThanTwice() {
		String expectedString = "tween";
		String lettresRestantes = "etiewrn";
		assertTrue(expectedString.equals(Solution.getWordWithMaxPoints(LIST_VALUE_BETTER_THAN_SIZE, lettresRestantes)));
	}
}
