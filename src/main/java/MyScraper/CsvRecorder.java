package MyScraper;

import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class CsvRecorder {
	
	public static void save(LinkedList<String[]> records, String filepath) throws IOException {
		
		String[] headers = records.pollFirst();
		
		try(
			FileWriter writer = new FileWriter(filepath);
			CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader(headers))
		) {
			csvPrinter.printRecords(records);
		}
	}
	
}
