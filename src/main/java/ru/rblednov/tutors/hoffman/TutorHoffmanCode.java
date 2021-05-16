package ru.rblednov.tutors.hoffman;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TutorHoffmanCode {

    private void code(String request, Map<Character, String> dict) {
        StringBuilder response = new StringBuilder();
        while (request.length()!=0){
            for (Map.Entry<Character, String> entry : dict.entrySet()) {
                if (request.startsWith(entry.getValue())) {
                    response.append(entry.getKey());
                    request = request.replaceFirst(entry.getValue(),"");
                    break;
                }
            }
        }
        System.out.println(response);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Integer count = s.nextInt();
        Integer lenth = s.nextInt();
        Map<Character, String> dict = new HashMap<>();
        s.nextLine();
        for (int i = 0; i < count; i++) {
            String tmp = s.nextLine();
            String[] tmp2 = tmp.split(":");


            dict.put(tmp2[0].charAt(0), tmp2[1].replaceAll(" ", ""));
        }
        String string = s.nextLine();
        TutorHoffmanCode tutorHoffmanCode = new TutorHoffmanCode();
        tutorHoffmanCode.code(string, dict);
    }
}
