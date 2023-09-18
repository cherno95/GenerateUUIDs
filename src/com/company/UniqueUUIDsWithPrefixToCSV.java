package com.company;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class UniqueUUIDsWithPrefixToCSV {
    public static void main(String[] args) {
        Set<String> uuidSet = new HashSet<>();

        while (uuidSet.size() < 100) {
            UUID uuid = UUID.randomUUID();
            String uuidStr = uuid.toString();
            uuidSet.add(uuidStr);
        }

        try (FileWriter writer = new FileWriter("uuids.csv")) {
            writer.write("NUMBER; UUID" + "\n");
            int counter = 1;
            int total = uuidSet.size();
            for (String uuid : uuidSet) {
                String line = counter + ";" + uuid;
                writer.write(line);
                if (counter < total) {
                    writer.write("\n");
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
