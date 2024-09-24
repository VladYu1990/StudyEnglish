package com.example.studyenglish.Application;

import com.example.studyenglish.Connectors.GetURLData;
import com.example.studyenglish.Domein.AnswerForReturn;
import com.example.studyenglish.Domein.ArrayDequeAnswersForReturn;

import org.json.JSONException;
import org.json.JSONObject;

public class AnswersForReturnService {

    public AnswersForReturnService() {
    }

    public void work(){
        if(!checkSizeArrayDequeAnswers()){
           returnAnswers();
        }
    }

    private boolean checkSizeArrayDequeAnswers(){
        if(ArrayDequeAnswersForReturn.answersForReturn.size()>0){
            return false;
        }
        else {return true;}
    }

    private void returnAnswers(){
        for(AnswerForReturn answerForReturn: ArrayDequeAnswersForReturn.answersForReturn) {
            GetURLData getURLData = new GetURLData();
            String stringURL = "tasks/return_reply/" + answerForReturn.getCodeTask() + "/answer/" + answerForReturn.getCodeAnswer();
            getURLData.goToUrl(
                    stringURL,
                    "POST",
                    answerForReturn.getInstant());
            if(checkResponseIsOk(mappingResponse(getURLData.getJsonObject()))){
                ArrayDequeAnswersForReturn.answersForReturn.remove(answerForReturn);
            }
            else {
                return;
            }
        }
    }

    private String mappingResponse(JSONObject jsonObject){
        try {
            return jsonObject.getString("response");
        }
        catch (JSONException e){
            return "not ok";
        }
    }

    private boolean checkResponseIsOk(String response) {
        if (response.equals("ok")){
            return true;
        }
        else {
            return false;
        }
    }
}
