package com.smt.kata.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
// JDK 11.x
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/****************************************************************************
 * <b>Title</b>: CountingLines.java
 * <b>Project</b>: SMT-Kata
 * <b>Description: </b> Counting Code Lines
 * 
 * Counting lines of code in Java source is not quite as simple as it seems.
 * 
 * This week let’s write something vaguely useful: a utility that counts the number
 * of lines of actual code in a Java source file. For the purpose of this exercise, 
 * a line is counted if it contains something other than whitespace or text in a comment. 
 * 
 * <b>Copyright:</b> Copyright (c) 2021
 * <b>Company:</b> Silicon Mountain Technologies
 * 
 * @author James Camire
 * @version 3.0
 * @since May 26, 2021
 * @updates:
 ****************************************************************************/
public class CountingLines {
	
	/**
	 * Get the actual number of lines of code for the given package and class
	 * @param clazzName Fully qualified name (com.smt.util.someclass)
	 * @return Number of lines of java code in the file
	 * @throws IOException
	 */
	public int getNumberLines(String clazzName) throws IOException {	
		if (clazzName == null) throw new NullPointerException();
		String path = "src/main/java/" + clazzName.replace('.', '/') + ".java";
		String line = "";
		int count = 0;
		try (BufferedReader fr = new BufferedReader(new FileReader(path))){
			while ((line = fr.readLine()) != null) {
				if (line.trim().length() == 0) {
					continue;
				} else if (line.trim().startsWith("/") || line.trim().startsWith("*")) {
					continue;
				} else {
					count ++;
				}
			}
			return count;
		}
	}
}
