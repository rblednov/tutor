package ru.rblednov.tutors.work_tests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<byte[]> arrayOfByteFiles = new ArrayList<>();

        for (int i = 1; i <= 5; i++) {
            arrayOfByteFiles.add(i - 1, Files.readAllBytes(Path.of(
                    "./src/main/java/ru/rblednov/tutors/work_tests/content-store-" + i + ".json")));
        }

        countHashs(arrayOfByteFiles);
        countHashs(arrayOfByteFiles);
        countHashs(arrayOfByteFiles);
        countHashs(arrayOfByteFiles);
        countHashs(arrayOfByteFiles);

    }

    private static void countHashs(List<byte[]> arrayOfByteFiles) {
        long start = System.nanoTime();
        for (int i = 0; i < 5; i++) {

            int hashCode = Arrays.hashCode(arrayOfByteFiles.get(i));
//            System.out.println(hashCode);
        }
        long end = System.nanoTime();

        System.err.println(end - start);
    }
}
