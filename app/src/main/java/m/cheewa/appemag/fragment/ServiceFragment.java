package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import m.cheewa.appemag.R;

/**
 * Created by kik on 11/17/2017.
 */

public class ServiceFragment extends Fragment{

    private String Tag = "17novV2";
    private String[] loginString;

    public ServiceFragment serviceInstance(String[] loginStrings) {

        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login", loginStrings);
        serviceFragment. setArguments(bundle);
        return serviceFragment;


    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

//        Get Value From Argument





    }  // Main method

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;
    }
}   // Main Class
