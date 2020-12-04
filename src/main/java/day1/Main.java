package day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Main {

    // https://adventofcode.com/2020/day/1
    public static void main(String[] args) {
        Main main = new Main();
        int result = main.getAppropriateNumber();
        System.out.println(result);
    }

    private int getAppropriateNumber() {
        var inputNumbers = readAllNumbersFromFile();
        for (int entryNumber : inputNumbers) {
            int difference = 2020 - entryNumber;
            int secondEntryNumber = inputNumbers.stream().filter(n -> n == difference).findFirst().orElse(0);
            if (secondEntryNumber != 0) {
                return entryNumber * secondEntryNumber;
            }
        }
        return 0;
    }


    private List<Integer> readAllNumbersFromFile() {
        Path path = Path.of("src/main/resources/data.csv");
        try {
            return Files.readAllLines(path)
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return Collections.emptyList();
    }
}
