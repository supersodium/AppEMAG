package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import m.cheewa.appemag.MainActivity;
import m.cheewa.appemag.R;

/**
 * Created by User on 8/9/2560.
 */

public class SignUpFragment extends Fragment{

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
    }

    private void toolBarController() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarSignUp);
        ((MainActivity)getActivity()).getSupportActionBar(toolbar);
        ((MainActivity)getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
        ((MainActivity)getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ((MainActivity)getActivity()).getSupportActionBar().setTitle(getResources().getString(R.string.new_register));

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });




    }
}   // Main Class
