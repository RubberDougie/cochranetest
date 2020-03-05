package com.rubberdougie.stringthings;

import java.util.ArrayList;
import java.util.List;

public class StringThings {

	static final List<Character> DIGITS = new ArrayList<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

	static final List<Character> ROMAN_LETTERS = new ArrayList<>(
			List.of('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
					'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
					'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'));

	public static String removeEndDigits(String string) {
		int originalStrLen = string.length();
		int newStrLen;

		// null string isn't handled

		if (originalStrLen == 0) {
			return "";
		}

		for (newStrLen = originalStrLen - 1; DIGITS.contains(string.charAt(newStrLen)); newStrLen--) {
		}

		return string.substring(0, newStrLen + 1);
	}

	public static String removeEndRomanetters(String string) {
		int originalStrLen = string.length();
		int newStrLen;

		// null string isn't handled

		if (originalStrLen == 0) {
			return "";
		}

		for (newStrLen = originalStrLen - 1; ROMAN_LETTERS.contains(string.charAt(newStrLen)); newStrLen--) {
		}

		return string.substring(0, newStrLen + 1);
	}
}