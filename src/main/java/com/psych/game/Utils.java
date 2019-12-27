package com.psych.game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static List<Pair<String, String>> readQAFile(String fileName) throws FileNotFoundException {
        BufferedReader br = new BufferedReader(new FileReader("qa_facts.txt"));
        String question, answer;
        List<Pair<String, String>> questionAnswer = new ArrayList<>();
        try {
            do {
                question = br.readLine();
                answer = br.readLine();
                if(question==null || answer==null || question.length() > Constants.MAX_QUESTION_LENGTH || answer.length() > Constants.MAX_ANSWER_LENGTH) {
                    System.out.println("Skipping question: " + question);
                    System.out.println("Skipping answer: " + answer);
                    continue;
                }
                questionAnswer.add(new Pair<String, String>(question, answer));
            }
            while (question != null & answer != null);
        } catch(IOException ignored) {

        }
        return questionAnswer;
    }
}
