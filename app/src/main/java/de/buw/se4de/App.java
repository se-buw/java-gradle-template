/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package de.buw.se4de;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class App {
	public String getGreeting() {
		String result = "";
		try (Reader reader = Files.newBufferedReader(Paths.get("src/main/resources/book.csv"));
				@SuppressWarnings("deprecation")
				CSVParser csvParser = new CSVParser(reader,
						CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());) {
			for (CSVRecord csvRecord : csvParser) {
				String name = csvRecord.get("author");
				result += "Hello " + name + "!\n";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Enter your name:");
		Scanner scanner = new Scanner(System.in);
		String inputString = scanner.nextLine();
		System.out.println("Hello " + inputString + "!");
		scanner.close();

		return result;
	}

	public static void main(String[] args) {
		System.out.println(new App().getGreeting());
	}
}
