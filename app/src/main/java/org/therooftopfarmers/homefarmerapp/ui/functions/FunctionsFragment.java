package org.therooftopfarmers.homefarmerapp.ui.functions;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import org.therooftopfarmers.homefarmerapp.R;

public class FunctionsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_functions, container, false);
    }
}