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
