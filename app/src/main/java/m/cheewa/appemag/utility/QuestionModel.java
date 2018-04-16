package m.cheewa.appemag.utility;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionModel implements Parcelable{

    private String questionString,imageQuestionString,choice1String,choice2String,
            choice3String,choice4String,answerString;


    public QuestionModel(String questionString,
                         String imageQuestionString,
                         String choice1String,
                         String choice2String,
                         String choice3String,
                         String choice4String,
                         String answerString) {
        this.questionString = questionString;
        this.imageQuestionString = imageQuestionString;
        this.choice1String = choice1String;
        this.choice2String = choice2String;
        this.choice3String = choice3String;
        this.choice4String = choice4String;
        this.answerString = answerString;
    }

    protected QuestionModel(Parcel in) {
        questionString = in.readString();
        imageQuestionString = in.readString();
        choice1String = in.readString();
        choice2String = in.readString();
        choice3String = in.readString();
        choice4String = in.readString();
        answerString = in.readString();
    }

    public static final Creator<QuestionModel> CREATOR = new Creator<QuestionModel>() {
        @Override
        public QuestionModel createFromParcel(Parcel in) {
            return new QuestionModel(in);
        }

        @Override
        public QuestionModel[] newArray(int size) {
            return new QuestionModel[size];
        }
    };

    public String getQuestionString() {
        return questionString;
    }

    public void setQuestionString(String questionString) {
        this.questionString = questionString;
    }

    public String getImageQuestionString() {
        return imageQuestionString;
    }

    public void setImageQuestionString(String imageQuestionString) {
        this.imageQuestionString = imageQuestionString;
    }

    public String getChoice1String() {
        return choice1String;
    }

    public void setChoice1String(String choice1String) {
        this.choice1String = choice1String;
    }

    public String getChoice2String() {
        return choice2String;
    }

    public void setChoice2String(String choice2String) {
        this.choice2String = choice2String;
    }

    public String getChoice3String() {
        return choice3String;
    }

    public void setChoice3String(String choice3String) {
        this.choice3String = choice3String;
    }

    public String getChoice4String() {
        return choice4String;
    }

    public void setChoice4String(String choice4String) {
        this.choice4String = choice4String;
    }

    public String getAnswerString() {
        return answerString;
    }

    public void setAnswerString(String answerString) {
        this.answerString = answerString;
    }

    public QuestionModel() {




    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionString);
        dest.writeString(imageQuestionString);
        dest.writeString(choice1String);
        dest.writeString(choice2String);
        dest.writeString(choice3String);
        dest.writeString(choice4String);
        dest.writeString(answerString);
    }
}
