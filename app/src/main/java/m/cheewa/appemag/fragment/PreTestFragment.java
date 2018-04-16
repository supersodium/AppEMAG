package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import m.cheewa.appemag.MainActivity;
import m.cheewa.appemag.R;
import m.cheewa.appemag.utility.GetQuestionWhereSubject;
import m.cheewa.appemag.utility.MyAlert;
import m.cheewa.appemag.utility.MyConstant;
import m.cheewa.appemag.utility.QuestionModel;

/**
 * Created by kik on 11/17/2017.
 */

public class PreTestFragment extends Fragment {

    private String[] loginStrings;
    private String tag = "17novV3";
    private String[] titleUnitStrings;
    private int anInt = 0;
    private int timesAnInt = 0;
    private ArrayList<String> stringArrayList;

    private TextView questiontextView;
    private ImageView imageView;
    private RadioGroup radioGroup;
    private RadioButton choice1RadioButton, choice2RadioButton, choice3RadioButton, choice4RadioButton;
    private Button Button;


    public static PreTestFragment preTestFragment(String[] loginStrings,
                                                  int indexUnit) {
        PreTestFragment preTestFragment = new PreTestFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        bundle.putInt("Index", indexUnit);
        preTestFragment.setArguments(bundle);
        return preTestFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Initial View
        initialView();

        // GetValue Argument
        getValueArgument();

//        Create Toolbar
        createToolbar();


//        Question
        question();

        //Answer Controller
        answerController();

    }   // Main Method

    private void answerController() {
        Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkChoose()) {
                    // Non Choose
                    MyAlert myAlert = new MyAlert(getActivity());
                    myAlert.normalDialog("Non choose","Please choose choice Answer");
                } else {

                    // Calculator Score


                    if (timesAnInt < stringArrayList.size()) {
                        timesAnInt+=1;
                        showQuestion();

                    } else {
                     // Conclusion



                    }


                } //if1



            }   // onClick
        });

    }

    private boolean checkChoose() {
        boolean b = true;

        b = choice1RadioButton.isChecked() || choice2RadioButton.isChecked() ||
                choice3RadioButton.isChecked() || choice4RadioButton.isChecked();

        return !b;
    }

    private void initialView() {

        questiontextView = getView().findViewById(R.id.txtQuestion);
        imageView = getView().findViewById(R.id.imgQuestion);
        radioGroup = getView().findViewById(R.id.regChoice);
        choice1RadioButton = getView().findViewById(R.id.redChoice1);
        choice2RadioButton = getView().findViewById(R.id.redChoice2);
        choice3RadioButton = getView().findViewById(R.id.redChoice3);
        choice4RadioButton = getView().findViewById(R.id.redChoice4);
        Button = getView().findViewById(R.id.btnAnswer);


    }

    private void question() {

        try {


            MyConstant myConstant = new MyConstant();
            GetQuestionWhereSubject getQuestionWhereSubject = new GetQuestionWhereSubject(getActivity());
            getQuestionWhereSubject.execute(titleUnitStrings[anInt],
                    myConstant.getUrlGetQuestionWhereSubject());

            String jsonString = getQuestionWhereSubject.get();

            Log.d("16AprilV1", "JSON==>" + jsonString);

            JSONArray jsonArray = new JSONArray(jsonString);
            String[] columnString = myConstant.getColumnQuestionStrings();
             stringArrayList = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i += 1) {

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                ArrayList<String>  stringArrayList1 = new ArrayList<>();
                for (int i1 = 2; i1 < columnString.length; i1 += 1) {

                    stringArrayList1.add(jsonObject.getString(columnString[i1]));


                } // for2


                Log.d("16AprilV2", "ArrayList==>" + stringArrayList.toString());
                stringArrayList.add(stringArrayList1.toString());

            }  // for1

            Log.d("16AprilV3", "ArrayList==>" + stringArrayList.toString());

            showQuestion();


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void showQuestion() {
        String s = stringArrayList.get(timesAnInt);

        Log.d("16AprilV4","s==>"+s);

        s = s.substring(1,s.length()-1);
        Log.d("16AprilV4","sต ่อมา ==>"+s);

        String[] strings = s.split(",");
        for (int i=0;i<strings.length; i+=1) {

            Log.d("16AprilV4","strings["+i+"]==>"+strings[i]);

        }

        QuestionModel questionModel = new QuestionModel(strings[0],strings[1],
                strings[2],strings[3],strings[4],strings[5],strings[6]);


        int i = timesAnInt +1;

        questiontextView.setText(Integer.toString(i) +". "+questionModel.getQuestionString());
        choice1RadioButton.setText("ก. " + questionModel.getChoice1String());
        choice2RadioButton.setText("ข. " + questionModel.getChoice2String());
        choice3RadioButton.setText("ค. " + questionModel.getChoice3String());
        choice4RadioButton.setText("ง. " + questionModel.getChoice4String());




    }

    private void createToolbar() {


        Toolbar toolbar = getView().findViewById(R.id.toolbarPertest);

        ((MainActivity) getActivity()).setSupportActionBar(toolbar);

        MyConstant myConstant = new MyConstant();
        titleUnitStrings = myConstant.getUnitStrings();
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(titleUnitStrings[anInt]);
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(loginStrings[1] + " " + loginStrings[2]);

        ((MainActivity) getActivity()).getSupportActionBar()
                .setHomeButtonEnabled(true);
        ((MainActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });

    }

    private void getValueArgument() {

        loginStrings = getArguments().getStringArray("Login");
        for (int i = 0; i < loginStrings.length; i += 1) {
            Log.d(tag, "Login[" + i + "]==> " + loginStrings[i]);
        }

        anInt = getArguments().getInt("Index");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pre_test_fragment, container, false);
        return view;
    }
}       // Main Class
