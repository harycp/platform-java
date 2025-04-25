package com.example.myflexiblefragment;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class OptionDialogFragment extends DialogFragment implements  View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Button btnChoose, btnClose;
    private RadioGroup rgOptions;
    private RadioButton rbAwr, rbUnai, rbGeor, rbArteta;
    private OnOptionDialogListener onOptionDialogListener;


    public OptionDialogFragment() {
        // Required empty public constructor
    }

    public OnOptionDialogListener getOnOptionDialogListener() {
        return onOptionDialogListener;
    }

    public void setOnOptionDialogListener(OnOptionDialogListener onOptionDialogListener) {
        this.onOptionDialogListener = onOptionDialogListener;
    }

    public static OptionDialogFragment newInstance(String param1, String param2) {
        OptionDialogFragment fragment = new OptionDialogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_option_dialog, container, false);
        btnChoose = (Button)view.findViewById(R.id.btn_choose);
        btnChoose.setOnClickListener(this);
        btnClose = (Button)view.findViewById(R.id.btn_close);
        btnClose.setOnClickListener(this);

        rgOptions = (RadioGroup)view.findViewById(R.id.rg_options);
        rbAwr = (RadioButton) view.findViewById(R.id.rb_awr);
        rbUnai = (RadioButton) view.findViewById(R.id.rb_unai);
        rbGeor = (RadioButton) view.findViewById(R.id.rb_geor);
        rbArteta = (RadioButton)view.findViewById(R.id.rb_arteta);
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close) {
            getDialog().cancel();
        } else if (v.getId() == R.id.btn_choose) {
            int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();

            if (checkedRadioButtonId != -1) {
                String coach = null;

                if (checkedRadioButtonId == R.id.rb_awr) {
                    coach = rbAwr.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_unai) {
                    coach = rbUnai.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_geor) {
                    coach = rbGeor.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_arteta) {
                    coach = rbArteta.getText().toString().trim();
                }

                if (coach != null) {
                    getOnOptionDialogListener().onOptionChoosen(coach);
                }

                getDialog().cancel();
            }
        }
    }
    public interface OnOptionDialogListener{
        void onOptionChoosen(String text);
    }

}