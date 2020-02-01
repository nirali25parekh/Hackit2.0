package com.example.hackit20;



public class QuestionLibrary  {

    private String error="";
    private String mQuestions[]={
            "Which of the following are you unlikely to find traded officially on world stock markets?",
            "Which of the following might you see roaming a stock market?",
            "Which of the following might be a reason for a stock market to lose value suddenly?",
            "Which term most accurately describes selling shares at a higher price than the price at which they were bought?",
            "Which term is used to describe a payout made to shareholders representing their share of a corporation's profit?",
    };
    private String mChoices[][]={
            {"Foreign Currency","Property"," Gold"},
            {"bulls","cows","mice"},
            {" A big company going bankrupt"," Fear of a global recession","All of these"},
            {"dividend","profit","asset"},
            {"jackpot","dividend","coupon"}

    };

    private String mCorrectChoices[]={
        "Property","bulls","All of these","profit",

    };

    public String getQuestion(int a){
        if(a<length()){
        String question=mQuestions[a];
        return question;
    }else{
            return error;
        }

        }

    public String getChoice0(int a){

        if(a<length()) {
            String choice0 = mChoices[a][0];
            return choice0;
        }else return error;
    }

    public String getChoice1(int a){
        if(a<length()) {
            String choice1 = mChoices[a][1];
            return choice1;
        }
    else return error;}

    public String getChoice2(int a){
        if(a<length()) {
            String choice2 = mChoices[a][2];
            return choice2;
        }else return error;
    }

    public String getCorrectAnswer(int a){
    if(a<length()) {
        String correctAnswer = mCorrectChoices[a];
        return correctAnswer;
    }else return error;
    }

    public int length(){

        return mQuestions.length-1;

    }

}
