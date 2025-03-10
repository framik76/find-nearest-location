package com.nearest.location.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LoadCSV {

    private final String COMMA_DELIMITER = ",";

    public List<List<String>> load() {
        List<List<String>> records = new ArrayList<>();
        var file = this.getClass().getClassLoader().getResource("joinon_areas.csv");
        try (Scanner scanner = new Scanner(file.openStream())) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return records;
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

}
