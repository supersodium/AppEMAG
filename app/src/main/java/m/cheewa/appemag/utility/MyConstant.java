package m.cheewa.appemag.utility;

import java.net.URL;

/**
 * Created by kik on 11/16/2017.
 */

public class MyConstant {

    //    URL
    private String urlPostUserString = "http://androidthai.in.th/dium/addDatadium.php";


    //    Array
    private String[] columnUserStrings = new String[]{"id", "Name", "Surname", "ID_Student", "User", "Password"};


//    getter


    public String getUrlPostUserString() {
        return urlPostUserString;
    }

    public String[] getColumnUserStrings() {
        return columnUserStrings;
    }
}   // Main Class
