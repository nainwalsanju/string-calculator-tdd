package com.incubyte.string_calculator_tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String numbers) {
        if (numbers == null || numbers.isEmpty()) {
            return 0;
        }

        String delimiter = "[,\\n]";  // Split by comma or newline by default
        String numbersToProcess = numbers;

        // Check for custom delimiter
        if (numbers.startsWith("//")) {
            int delimiterEndIndex = numbers.indexOf("\n");
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("Invalid format for custom delimiter");
            }
            String customDelimiter = numbers.substring(2, delimiterEndIndex);
            // Include custom delimiter along with default delimiters (comma, newline)
            delimiter = Pattern.quote(customDelimiter) + "|[,\\n]";
            numbersToProcess = numbers.substring(delimiterEndIndex + 1);
        }

        String[] numberArray = numbersToProcess.split(delimiter);
        List<Integer> negativeNumbers = new ArrayList<>();
        int sum = 0;

        for (String num : numberArray) {
            if (!num.trim().isEmpty()) {
                int value = Integer.parseInt(num.trim());
                if (value < 0) {
                    negativeNumbers.add(value);
                }
                sum += value;
            }
        }

        if (!negativeNumbers.isEmpty()) {
            throw new IllegalArgumentException("negative numbers not allowed " + negativeNumbers.toString());
        }

        return sum;
    }
}
