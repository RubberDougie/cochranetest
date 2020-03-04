package com.rubberdougie.stringthings;

import java.util.ArrayList;
import java.util.List;

public class StringThings {

	public static String removeEndDigits(String string) {
		int originalStrLen = string.length();
		int newStrLen;

		if (originalStrLen == 0) {
			return "";
		}

		List<Character> digits = new ArrayList<>(List.of('1', '2', '3', '4', '5', '6', '7', '8', '9', '0'));

		for (newStrLen = originalStrLen - 1; digits.contains(string.charAt(newStrLen)); newStrLen--) {
		}

		return string.substring(0, newStrLen + 1);
	}
}