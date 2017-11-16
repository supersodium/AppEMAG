package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import m.cheewa.appemag.MainActivity;
import m.cheewa.appemag.R;
import m.cheewa.appemag.utility.MyAlert;
import m.cheewa.appemag.utility.MyConstant;
import m.cheewa.appemag.utility.PostUserToServer;

/**
 * Created by User on 8/9/2560.
 */

public class SignUpFragment extends Fragment {

    //    Explicit
    private String nameString, surnameString, idStudentString, userString, passwordString;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fregment_sign_up, container, false);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //ToolBar Controller
        toolBarController();

//        SignUp Controller
        signUpController();


    }   // Main Method

    private void signUpController() {
        Button button = getView().findViewById(R.id.btnSingUp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                Initial view
                EditText nameEditText = getView().findViewById(R.id.edtName);
                EditText surnameEditText = getView().findViewById(R.id.edtSurname);
                EditText idStudentEditText = getView().findViewById(R.id.edtIDstudent);
                EditText userEditText = getView().findViewById(R.id.edtUser);
                EditText passwordEditText = getView().findViewById(R.id.edtPassword);

//                Get Value From EdiText
                nameString = nameEditText.getText().toString().trim();
                surnameString = surnameEditText.getText().toString().trim();
                idStudentString = idStudentEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();

//                Check Space
                if (nameString.isEmpty() ||
                        surnameString.isEmpty() ||
                        idStudentString.isEmpty()||
                        userString.isEmpty() ||
                        passwordString.isEmpty()) {
//                    Have Space
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog(getString(R.string.title_have_space),getString(R.string.message_have_space));

                } else if (idStudentString.length() == 8) {
//                    id Student True
                    uploadUsertoServer();

                } else {

//                    id Student False
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog("ID Student false",
                            "ID Student is 8 digi ?");
                }


            }   //onClick
        });
    }

    private void uploadUsertoServer() {

        try {


            MyConstant myConstant = new MyConstant();
            PostUserToServer postUserToServer = new PostUserToServer(getActivity());
            postUserToServer.execute(nameString, surnameString, idStudentString, userString, passwordString, myConstant.getUrlPostUserString());

            if (Boolean.parseBoolean(postUserToServer.get())) {
                // True
                getActivity().getSupportFragmentManager().popBackStack();
                Toast.makeText(getActivity(),"Upload Success",Toast.LENGTH_SHORT).show();
            }

            else {
//            False
                MyAlert myAlert = new MyAlert(getActivity());
                myAlert.normalDialog("Cannot Upload User",
                        "Please Try Again");

            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void toolBarController() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarSignUp);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getResources().getString(R.string.new_register));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });


    }
}   // Main Class
