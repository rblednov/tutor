package ru.rblednov.tutors.hoffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class TutorHoffmanDecode {

    public class FreqNode implements Comparable<FreqNode> {
        Map<Character, String> chars = new HashMap<>();

        Integer freq = 0;

        @Override
        public int compareTo(FreqNode o) {
            if (this.freq - o.freq == 0) {
                return -1;
            }
            return this.freq - o.freq;
        }
    }

    private void decode(String string) {
        if (string.length() == 1) {
            System.out.println("1 1");
            System.out.println(string + ": 0");
            System.out.println("0");
            return;
        }
        Map<Character, Integer> dummy = new HashMap<>();
        string
                .chars()
                .mapToObj(x -> (char) x)
                .forEach(character -> {
                    if (dummy.containsKey(character)) {
                        Integer current = dummy.get(character);
                        dummy.put(character, current + 1);
                    } else {
                        dummy.put(character, 1);
                    }
                });

        if (dummy.size() == 1) {
            Map.Entry<Character, Integer> elem = dummy.entrySet().iterator().next();
            int count = elem.getValue();
            char chr = elem.getKey();
            System.out.println("1 " + count);
            System.out.println(string.charAt(0) + ": 0");
            System.out.println(string.replaceAll(String.valueOf(chr), "0"));
            return;
        }

        TreeSet<FreqNode> freqNodeTreeSet = dummy.entrySet().stream().map(x -> {
            FreqNode freqNode = new FreqNode();
            freqNode.freq = x.getValue();
            freqNode.chars.put(x.getKey(), "");
            return freqNode;
        }).collect(Collectors.toCollection(TreeSet::new));

        while (freqNodeTreeSet.size() >= 2) {
            FreqNode low0 = freqNodeTreeSet.pollFirst();
            FreqNode low1 = freqNodeTreeSet.pollFirst();

            FreqNode freqNode = new FreqNode();

            freqNode.freq = low0.freq + low1.freq;

            low0.chars.replaceAll((k, v) -> "0" + v);
            low1.chars.replaceAll((k, v) -> "1" + v);
            freqNode.chars.putAll(low0.chars);
            freqNode.chars.putAll(low1.chars);

            freqNodeTreeSet.add(freqNode);
        }
        FreqNode lastNode = freqNodeTreeSet.pollFirst();

        Integer difCount = dummy.size();

        String result = string.chars()
                .mapToObj(x -> (char) x)
                .map(x -> lastNode.chars.get(x)).reduce("", (code1, code2) -> code1 + code2);

        System.out.println(difCount + " " + result.length());
        lastNode.chars.forEach((chr, code) -> System.out.println(chr + ": " + code));
        System.out.println(result);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        TutorHoffmanDecode tutorHoffmanCode = new TutorHoffmanDecode();
        tutorHoffmanCode.decode(a);
    }
}
