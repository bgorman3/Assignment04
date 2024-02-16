package edu.uncc.assignment04.fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import edu.uncc.assignment04.R;

public class IdentificationFragment extends Fragment {

    public interface OnDataPass {
        void onDataPass(String name, String email, String role);
    }

    private OnDataPass dataPasser;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            dataPasser = (OnDataPass) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnDataPass");
        }
    }

    public void passDataToActivity() {
        EditText nameField = getView().findViewById(R.id.editTextName);
        EditText emailField = getView().findViewById(R.id.editTextEmail);
        // Find the RadioGroup and the selected RadioButton
        RadioGroup roleGroup = getView().findViewById(R.id.radioGroup);
        int selectedId = roleGroup.getCheckedRadioButtonId();
        RadioButton selectedRoleButton = getView().findViewById(selectedId);

        // Extract the text from the selected RadioButton
        String role = selectedRoleButton.getText().toString();

        // Extract the text from the EditText fields
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();

        // Pass the data to the activity using the OnDataPass interface
        dataPasser.onDataPass(name, email, role);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_identification, container, false);
        Button buttonNext = view.findViewById(R.id.buttonNext);
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                passDataToActivity();
            }
        });
        return view;
    }
}
