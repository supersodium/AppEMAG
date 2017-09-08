package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import m.cheewa.appemag.R;

/**
 * Created by User on 8/9/2560.
 */

public class MainFragment extends Fragment{

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

    }   //onActivityCreate

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
