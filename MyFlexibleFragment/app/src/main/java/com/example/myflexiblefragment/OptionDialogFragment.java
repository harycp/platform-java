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

    private RadioButton rb1, rb2, rb3, rb4, rb5, rb6, rb7, rb8, rb9;
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
        rb1 = (RadioButton) view.findViewById(R.id.rb_1);
        rb2 = (RadioButton) view.findViewById(R.id.rb_2);
        rb3 = (RadioButton) view.findViewById(R.id.rb_3);
        rb4 = (RadioButton)view.findViewById(R.id.rb_4);
        rb5 = (RadioButton) view.findViewById(R.id.rb_5);
        rb6 = (RadioButton) view.findViewById(R.id.rb_6);
        rb7 = (RadioButton) view.findViewById(R.id.rb_7);
        rb8 = (RadioButton)view.findViewById(R.id.rb_8);
        rb9 = (RadioButton)view.findViewById(R.id.rb_9);
        return view;
    }
    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_close) {
            getDialog().cancel();
        } else if (v.getId() == R.id.btn_choose) {
            int checkedRadioButtonId = rgOptions.getCheckedRadioButtonId();

            if (checkedRadioButtonId != -1) {
                String kel = null;

                if (checkedRadioButtonId == R.id.rb_1) {
                    kel = rb1.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_2) {
                    kel = rb2.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_3) {
                    kel = rb3.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_4) {
                    kel = rb4.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_5) {
                    kel = rb5.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_6) {
                    kel = rb6.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_7) {
                    kel = rb7.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_8) {
                    kel = rb8.getText().toString().trim();
                } else if (checkedRadioButtonId == R.id.rb_9) {
                    kel = rb9.getText().toString().trim();
                }

                if (kel != null) {
                    getOnOptionDialogListener().onOptionChoosen(kel);
                }

                getDialog().cancel();
            }
        }
    }
    public interface OnOptionDialogListener{
        void onOptionChoosen(String text);
    }

}