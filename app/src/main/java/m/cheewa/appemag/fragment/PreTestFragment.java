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

import m.cheewa.appemag.MainActivity;
import m.cheewa.appemag.R;
import m.cheewa.appemag.utility.MyConstant;

/**
 * Created by kik on 11/17/2017.
 */

public class PreTestFragment extends Fragment {

    private String[] loginStrings;
    private String tag = "17novV3";
    private String[] titleUnitStrings;
    private int anInt = 0;

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


        // GetValue Argument
        getValueArgument();

//        Create Toolbar
        createToolbar();

    }   // Main Method

    private void createToolbar() {


        Toolbar toolbar = getView().findViewById(R.id.toolbarPertest);

        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        MyConstant myConstant = new MyConstant();
        titleUnitStrings = myConstant.getUnitStrings();
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(titleUnitStrings[anInt]);
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(loginStrings[1]+ " "+loginStrings[2]);

        ((MainActivity)getActivity()).getSupportActionBar()
                .setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar()
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
        for (int i=0; i<loginStrings.length; i+=1 ) {
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
