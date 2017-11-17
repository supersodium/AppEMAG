package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import m.cheewa.appemag.R;
import m.cheewa.appemag.utility.MyAlert;

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
                }
            }
        });


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
