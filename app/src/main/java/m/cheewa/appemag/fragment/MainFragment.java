package m.cheewa.appemag.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import m.cheewa.appemag.R;
import m.cheewa.appemag.utility.GetAllData;
import m.cheewa.appemag.utility.MyAlert;
import m.cheewa.appemag.utility.MyConstant;

/**
 * Created by User on 8/9/2560.
 */

public class MainFragment extends Fragment{

//    Explicit
    private String userString, passwordString;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        return view;
    }   // onCreateView


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //NewRegister Controller
        newRegisterController();

//        Login Controller
        loginController();


    }   //onActivityCreate

    private void loginController() {
        Button button = getView().findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Initial View
                EditText userEditText = getView().findViewById(R.id.edtuser);
                EditText passwordText = getView().findViewById(R.id.edtPassword);

//                Get Value From EditText
                userString = userEditText.getText().toString().trim();
                passwordString = passwordText.getText().toString().trim();


//                Check Speace
                if (userString.isEmpty()||passwordString.isEmpty() ){
//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog(getString(R.string.title_have_space),
                            getString(R.string.message_have_space));

                }

                else {

//                    No Space
                    checkUserAndPass();




                }
            }
        });


    }

    private void checkUserAndPass() {

        try {
            String tag = "17novV1";
            MyAlert myAlert = new MyAlert(getActivity());
            MyConstant myConstant = new MyConstant();
            Boolean b = true;   // true ==> User false, False ==> User true
            String[] columnUser = myConstant.getColumnUserStrings();
            String[] loginString = new String[columnUser.length];

            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlGetUserString());
            String resultJSON = getAllData.get();
            Log.d(tag, "JSON ==> " + resultJSON);

            JSONArray jsonArray = new JSONArray(resultJSON);
            for (int i=0; i<jsonArray.length();i+=1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                if (userString.equals(jsonObject.getString(columnUser[4]))) {

                    b = false;
                    for (int i1=0; i1<columnUser.length; i1+=1) {

                        loginString[i1] = jsonObject.getString(columnUser[i1]);
                        Log.d(tag, "login[" + i1 + "] ==> " + loginString[i1]);


                    }   // for

                }   // if

            }   // for

//            Check User
            if (b) {
//                User False
                myAlert.normalDialog("User False",
                        "No This User In My Database");
            } else if (passwordString.equals(loginString[5])) {
//                Password True
                Toast.makeText(getActivity(),"Welcom" + loginString[1],
                        Toast.LENGTH_SHORT).show();

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, ServiceFragment.serviceInstance(loginString))
                        .commit();



            } else {
//                Password False
                myAlert.normalDialog("Password False",
                        "Please try again Password false");
            }



        } catch (Exception e){
            e.printStackTrace();
        }

    }



    private void newRegisterController() {
        TextView textView = getView().findViewById(R.id.textNewRegister);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment,new SignUpFragment())
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}   //Main Class
