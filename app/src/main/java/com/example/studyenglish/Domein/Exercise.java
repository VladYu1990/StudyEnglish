package com.example.studyenglish.Domein;

import java.util.ArrayList;
import java.util.UUID;

public class Exercise {
    private UUID code;
    private String question;
    private ArrayList<Answer> answers;

    public Exercise(UUID code, String question, ArrayList<Answer> answers) {
        this.code = code;
        this.question = question;
        this.answers = answers;
    }

    public UUID getCode() {
        return code;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public int getNumberTryAnswer() throws Exception {
        for (Answer answer:answers){
            if(answer.isCorrect()==true){
                return answers.indexOf(answer);}
            }

       throw new Exception();
    }
}

