package com.responsiRehan.responsiFintech.fragment;

        import androidx.fragment.app.Fragment;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.View.OnClickListener;
        import android.view.ViewGroup;
        import android.widget.ArrayAdapter;
        import android.widget.Button;
        import android.widget.ListView;

        import com.responsiRehan.responsiFintech.R;
        import com.responsiRehan.responsiFintech.menu.AccountActivity;


public class SettingFragment extends Fragment implements OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater
                .inflate(R.layout.fragment_setting, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Button newBlockButton = (Button) getActivity().findViewById(
                R.id.new_block_button);
        newBlockButton.setOnClickListener((OnClickListener) this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AccountActivity.class);
        startActivity(intent);
    }
}
