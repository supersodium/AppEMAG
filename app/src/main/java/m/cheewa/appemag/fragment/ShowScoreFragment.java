package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


import m.cheewa.appemag.MainActivity;
import m.cheewa.appemag.R;

public class ShowScoreFragment extends Fragment{

    public static ShowScoreFragment showScoreInstance(String subjectString,
                                                      int scoreInt,
                                                      int allTestInt,
                                                      int indexInt,String[] loginStrings){

        ShowScoreFragment showScoreFragment = new ShowScoreFragment();
        Bundle bundle = new Bundle();
        bundle.putString("Subject", subjectString);
        bundle.putInt("Score", scoreInt);
        bundle.putInt("AllTest",allTestInt);
        bundle.putInt("Index",indexInt);
        bundle.putStringArray("Login",loginStrings);
        showScoreFragment.setArguments(bundle);
        return showScoreFragment;
    }



    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Show score
        showScore();

//        Create toolbar
        createToolbar();

//        readController();

//        Back Controller
        backController();


    }  //    Main Method

    private void backController() {
        Button button = getView().findViewById(R.id.btnContent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                getActivity().getSupportFragmentManager().popBackStack();


                getActivity().getSupportFragmentManager().popBackStack();

                String[] loginStrings = getArguments().getStringArray("Login");

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, ServiceFragment.serviceInstance(loginStrings))
                        .commit();

            }
        });
    }

    private void readController() {

        Button button = getView().findViewById(R.id.btnContent);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int indexInt = getArguments().getInt("Index",0);

                String[] strings = getArguments().getStringArray("Login");

                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment,
                                ReadPdfFragment.readpdfInstance(indexInt,strings))
                        .commit();

            }
        });

    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarShowScore);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        String subjectString = getArguments().getString("Subject");
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(subjectString);
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle("Score :");

    }

    private void showScore() {
        int scoreInt = getArguments().getInt("Score",0);
        int allTestInt = getArguments().getInt("AllTest",0);
        String scoreString = Integer.toString(scoreInt)+ " / " + Integer.toString(allTestInt);
        TextView textView = getView().findViewById(R.id.txtShowScore);
        textView.setText(scoreString);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frafment_show_score, container, false);
        return view;
    }
}
