package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
}   // Main Class
