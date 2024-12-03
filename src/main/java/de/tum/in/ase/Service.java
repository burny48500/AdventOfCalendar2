package de.tum.in.ase;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Service {
    private List<List<Integer>> lineList;
    private int countSafe;

    public int cleaner(File inputFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(inputFile);
        lineList = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            List<Integer> tokens = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
            lineList.add(tokens);
        }

        for (List<Integer> report : lineList) {
            if (isSafe(report)) {
                countSafe++;
            } else {
                for (int i = 0; i < report.size(); i++) {
                    List<Integer> modifiedReport = new ArrayList<>(report);
                    modifiedReport.remove(i);
                    if (isSafe(modifiedReport)) {
                        countSafe++;
                        break;
                    }
                }
            }
        }
        return countSafe;
    }

    private boolean isSafe(List<Integer> levels) {
        return (isAscending(levels) || isDescending(levels)) && goodDiff(levels);
    }

    private boolean isAscending(List<Integer> levels) {
        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) >= levels.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean isDescending(List<Integer> levels) {
        for (int i = 0; i < levels.size() - 1; i++) {
            if (levels.get(i) <= levels.get(i + 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean goodDiff(List<Integer> levels) {
        for (int i = 0; i < levels.size() - 1; i++) {
            int diff = Math.abs(levels.get(i) - levels.get(i + 1));
            if (diff < 1 || diff > 3) {
                return false;
            }
        }
        return true;
    }
}