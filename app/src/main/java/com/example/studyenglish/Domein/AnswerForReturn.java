package com.example.studyenglish.Domein;

import java.time.Instant;

public class AnswerForReturn {

    private String codeAnswer;
    private String codeTask;
    private Instant instant;

    public AnswerForReturn(String codeAnswer, String codeTask, Instant instant) {
        this.codeAnswer = codeAnswer;
        this.codeTask = codeTask;
        this.instant = instant;
    }

    public String getCodeAnswer() {
        return codeAnswer;
    }

    public String getCodeTask() {
        return codeTask;
    }

    public Instant getInstant() {
        return instant;
    }
}
