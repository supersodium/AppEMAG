package m.cheewa.appemag.utility;

import java.net.URL;

/**
 * Created by kik on 11/16/2017.
 */

public class MyConstant {

    //    URL
    private String urlGetAllQuestion = "http://androidthai.in.th/dium/getAllQuestion.php";
    private String urlPostUserString = "http://androidthai.in.th/dium/addDatadium.php";
    private String urlGetUserString = "http://androidthai.in.th/dium/getAllDatadium.php";
    private String urlGetQuestionWhereSubject = "http://androidthai.in.th/dium/getQuestionWhereSubject.php";
    //    Array
    private String[] columnUserStrings = new String[]{"id", "Name", "Surname", "ID_Student", "User", "Password"};
    private String[] unitStrings = new String[]{
            "วิเคราะห์เวกเตอร์",
            "ระบบพิกัดและการแปลงเวกเตอร์",
            "สนามไฟฟ้า",
            "แบบทดสอบก่อนเรียน",
            "แบบทดสอบหลังเรียน"};

    private String[] columnQuestionStrings = new String[]{"id", "Subject", "Question", "ImageQuestion",
            "Choice1", "Choice2", "Choice3", "Choice4", "Answer"};

    private String[] pdfStrings = new String[]{"chapter1.pdf","chapter2.pdf","chapter3.pdf"};

//    getter


    public String getUrlGetAllQuestion() {
        return urlGetAllQuestion;
    }

    public String[] getPdfStrings() {
        return pdfStrings;
    }

    public String[] getColumnQuestionStrings() {
        return columnQuestionStrings;
    }

    public String getUrlGetQuestionWhereSubject() {
        return urlGetQuestionWhereSubject;
    }

    public String[] getUnitStrings() {
        return unitStrings;
    }

    public String getUrlGetUserString() {
        return urlGetUserString;
    }

    public String getUrlPostUserString() {
        return urlPostUserString;
    }

    public String[] getColumnUserStrings() {
        return columnUserStrings;
    }
}   // Main Class
