package m.cheewa.appemag.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.github.barteksc.pdfviewer.PDFView;

import m.cheewa.appemag.MainActivity;
import m.cheewa.appemag.R;
import m.cheewa.appemag.utility.MyConstant;

public class ReadPdfFragment extends Fragment{

    private String [] subjectString;
    private int anInt;

    public static ReadPdfFragment readpdfInstance(int indexInt,String[] loginStrings){

        ReadPdfFragment readPdfFragment = new ReadPdfFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("Index",indexInt);
        bundle.putStringArray("Login",loginStrings);
        readPdfFragment.setArguments(bundle);
        return readPdfFragment;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        anInt = getArguments().getInt("Index",0);

//        Create Toolbar
        createToolbar();


//        Read Pdf
        readPdf();


    }  // Main Method


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId()== R.id.itemTest){

            String[] strings = getArguments().getStringArray("Login");


            getActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.contentMainFragment,PreTestFragment.preTestFragment(strings,anInt))
                    .commit();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.menu_read_pdf,menu);

    }

    private void readPdf() {

        MyConstant myConstant = new MyConstant();
        String[] pdfStrings = myConstant.getPdfStrings();

        PDFView pdfView = getView().findViewById(R.id.pdfViewContent);
        pdfView.fromAsset(pdfStrings[anInt])
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(true)
                .load();
    }

    private void createToolbar() {
        Toolbar toolbar = getView().findViewById(R.id.toolbarReadPdf);
        ((MainActivity)getActivity()).setSupportActionBar(toolbar);

        MyConstant myConstant = new MyConstant();
        subjectString = myConstant.getUnitStrings();
        ((MainActivity) getActivity()).getSupportActionBar().setTitle(subjectString[anInt]);

      ((MainActivity) getActivity()).getSupportActionBar().setHomeButtonEnabled(true);
      ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
      toolbar.setNavigationOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              getActivity().getSupportFragmentManager().popBackStack();
          }
      });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_read_pdf,container,false);
        return view;
    }
}
