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

public class ServiceFragment extends Fragment{

    private String tag = "17novV2";
    private String[] loginString;
    private String[] unitStrings;

    public static ServiceFragment serviceInstance(String[] loginStrings) {

        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        serviceFragment. setArguments(bundle);
        return serviceFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Unit
        getUnit();

//        Get Value From Argument
        getValueFromArgument();

//        Create Toolbar
        createToolbar();

//      Unit1 Controller
        unit1Controller();

//        Unit2 Controller
        unit2Controller();

//        Unit3 Controller
        unit3Controller();

//        FirstTest Controller
        firstTestController();

//        LastTest Controller
        lastTestController();

//        Quit Controller
        quitController();


    }  // Main method

    private void quitController() {
        Button button = getView().findViewById(R.id.btnLogOut);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    private void lastTestController() {
        Button button = getView().findViewById(R.id.btnLastTest);
        button.setText(unitStrings[4]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment,PreTestFragment.preTestFragment(loginString,4))
                        .addToBackStack(null)
                        .commit();

            }
        });
    }

    private void firstTestController() {
        Button button = getView().findViewById(R.id.btnFirstTest);
        button.setText(unitStrings[3]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment,PreTestFragment.preTestFragment(loginString,3))
                        .addToBackStack(null)
                        .commit();


            }
        });
    }

    private void getUnit() {
        MyConstant myConstant = new MyConstant();
        unitStrings = myConstant.getUnitStrings();
    }

    private void unit1Controller() {
        Button button = getView().findViewById(R.id.btnUnit1);
        button.setText(unitStrings[0]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment, ReadPdfFragment.readpdfInstance(0,loginString))
                        .addToBackStack(null).commit();

            }
        });


    }

    private void unit2Controller() {
        Button button = getView().findViewById(R.id.btnUnit2);
        button.setText(unitStrings[1]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment,
                                ReadPdfFragment.readpdfInstance(1,loginString))
                        .addToBackStack(null).commit();

            }
        });


    }

    private void unit3Controller() {
        Button button = getView().findViewById(R.id.btnUnit3);
        button.setText(unitStrings[2]);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentMainFragment,
                                ReadPdfFragment.readpdfInstance(2,loginString))
                        .addToBackStack(null).commit();

            }
        });


    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarService);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(getString(R.string.title_service));
        ((MainActivity) getActivity()).getSupportActionBar().setSubtitle(loginString[1] + " " + loginString[2]);
    }

    private void getValueFromArgument() {
        loginString = getArguments().getStringArray("Login");
        for (int i=0; i<loginString.length; i+=1 ) {
            Log.d(tag, "Login[" + i + "]==> " + loginString[i]);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}   // Main Class
