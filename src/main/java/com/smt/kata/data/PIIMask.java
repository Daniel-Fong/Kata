package com.smt.kata.data;

/****************************************************************************
 * <b>Title</b>: PIIMask.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Masking Personal Information Kata
 * 
 * You are given a personal information string s, representing either an email
address or a phone number. Return the masked personal information using the below rules.
 * 
 * Email address:
 * 
 * An email address is:
 * 
 * A name consisting of uppercase and lowercase English letters, followed by
 * The '@' symbol, followed by
 * The domain consisting of uppercase and lowercase English letters with a dot '.' 
 * somewhere in the middle (not the first or last character).
 * 
 * To mask an email:
 * 
 * The uppercase letters in the name and domain must be converted to lowercase letters.
 * The middle letters of the name (i.e., all but the first and last letters) 
 * must be replaced by 5 asterisks "*****".
 * Phone number:
 * 
 * A phone number is formatted as follows:
 * 
 * The phone number contains 10-13 digits.
 * The last 10 digits make up the local number.
 * The remaining 0-3 digits, in the beginning, make up the country code.
 * Separation characters from the set {'+', '-', '(', ')', ' '} separate the 
 * above digits in some way.
 * 
 * To mask a phone number:
 * 
 * Remove all separation characters.
 * The masked phone number should have the form:
 * "***-***-XXXX" if the country code has 0 digits.
 * "+*-***-***-XXXX" if the country code has 1 digit.
 * "+**-***-***-XXXX" if the country code has 2 digits.
 * "+***-***-***-XXXX" if the country code has 3 digits.
 * "XXXX" is the last 4 digits of the local number.
 * 
 * Example 1:
 * Input: s = "LeetCode@LeetCode.com"
 * Output: "l*****e@leetcode.com"
 * Explanation: s is an email address.
 * The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
 * 
 * Example 2:
 * Input: s = "AB@qq.com"
 * Output: "a*****b@qq.com"
 * Explanation: s is an email address.
 * The name and domain are converted to lowercase, and the middle of the name is replaced by 5 asterisks.
 * Note that even though "ab" is 2 characters, it still must have 5 asterisks in the middle.
 * 
 * Example 3:
 * Input: s = "1(234)567-890"
 * Output: "***-***-7890"
 * Explanation: s is a phone number.
 * There are 10 digits, so the local number is 10 digits and the country code is 0 digits.
 * Thus, the resulting masked number is "***-***-7890".
 * 
 * Example 4:
 * Input: s = "86-(10)12345678"
 * Output: "+**-***-***-5678"
 * Explanation: s is a phone number.
 * There are 12 digits, so the local number is 10 digits and the country code is 2 digits.
 * Thus, the resulting masked number is "+**-***-***-7890".
 * 
 * Constraints:
 * s is either a valid email or a phone number.
 * If s is an email:
 * 8 <= s.length <= 40
 * s consists of uppercase and lowercase English letters and exactly one '@' symbol and '.' symbol.
 * If s is a phone number:
 * 10 <= s.length <= 20
 * s consists of digits, spaces, and the symbols '(', ')', '-', and '+'.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Nov 30, 2021
 * @updates:
 ****************************************************************************/
public class PIIMask {
	/**
	 * Regex to use for email validation if desired
	 */
	protected static final String EMAIL_REGEX = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
	
	/**
	 * Masks the email address or phone number
	 * @param source Email or a phone
	 * @return Masked data.  Empty if data is invalid
	 */
	public String mask(String source) {
		if (source == null || source.length() == 0) return "";
		if (source.indexOf('@') >= 0) {
			return maskEmail(source);
		} else {
			return maskPhoneNumber(source);
		}
	}
	
	public String maskEmail(String source) {
		source = source.toLowerCase();
		String[] arr = source.split("@");
		if (arr.length > 2 || arr[0].length() < 1) {
			return "";
		}
		String str1 = arr[0].charAt(0) + "*****" + arr[0].charAt(arr[0].length() - 1);
		return str1 + "@" + arr[1];
	}
	
	public String maskPhoneNumber(String source) {
		source = source.replaceAll("[()-]", ".");
		String source1 = source.replaceAll("\\.", "");
		if (source1.length() < 10) return "";
		source = source.replaceAll("[^\\d.]", "");
		String[] arr = source.split("\\.");
		System.out.println(source1);
		String str1 = "";
		if (arr.length == 4 && arr[0].length() > 0) {
			str1 = "+";
			for (int i = 0; i < arr[0].length(); i++) {
				str1 = str1 + "*";
			}
			str1 = str1 + "-";
		}
		return str1 + "***-***-" + arr[arr.length - 1];
	}
}
