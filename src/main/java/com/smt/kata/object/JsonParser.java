package com.smt.kata.object;

// JDK 11.x
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/****************************************************************************
 * <b>Title</b>: JsonParser.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Json Parser
 * Write a function to flatten a nested dictionary. Namespace the keys with a period.
 * 
 * For example, given the following dictionary:
 * 
 * {
 *     "key": 3,
 *     "foo": {
 *         "a": 5,
 *         "bar": {
 *             "baz": 8
 *         }
 *     }
 * }
 * 
 * it should become:
 * 
 * {
 *     "key": 3,
 *     "foo.a": 5,
 *     "foo.bar.baz": 8
 * }
 * 
 * You can assume keys do not contain dots in them, i.e. no clobbering will occur.
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since Jul 19, 2021
 * @updates:
 ****************************************************************************/
public class JsonParser {

	/**
	 * Parses the json string and returns a map of unique keys and values
	 * @param json Json object to parse
	 * @return Map of keys and values.  Values are mapped to their data types
	 * @throws IOException 
	 */
	public Map<String, Object> parse(String json) throws IOException {
		System.out.println(json);
		String[] arr = json.split("{");
		Map<String, Object> data = new HashMap<>();
		for (int i = 0; i<arr.length; i++) {
			String[] arr1 = arr[i].split(",");
			for (int j = 0; j < arr1.length; j++) {
				String key = "";
				String value = "";
				int keyStart = 0;
				int keyEnd = 0;
				boolean inKey = false;
				String[] arr2 = arr1[j].split(":");
				System.out.println(arr1[0]);
				for (int k = 0; k < arr2[0].length(); k++) {
					if (arr2[0].charAt(k) == '\'') {
						if (!inKey) {
							keyStart = k + 1;
							inKey = true;
						} else {
							keyEnd = k - 1;
						}
					}
				}
				key = arr2[0].substring(keyStart, keyEnd);
				value = arr2[1];
				data.put(key, value);
			}
		}
		

		return data;
	}
}
