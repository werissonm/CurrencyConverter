package com.college.converter;



import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.college.converter.databinding.ActivityMainBinding;
import static android.content.ContentValues.TAG;
import android.util.Log;

/*
    TODOs:
    In groups of 4, complete the following tasks, 1 for each team member:
    1. Extract all the strings into the strings.xml file and use them in the layout and the activity
    2. Change the theme of the app to a NoActionBar theme and modify the primary colors
    3. Add Log messages at the entry/exit of onCreate() and convertCurrency methods. Level should be Info
    4. Add ViewBinding to the project

    ** Each task must be done in a separate branch and merged to the main branch
    after completion using a Pull Request.
    ** Each task must be done by a different team member.

*/

public class MainActivity extends AppCompatActivity {
    static private final Float CONVERSION_RATE = 0.80F;
    private ActivityMainBinding binding; // Declare binding object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("MainActivity","Entering OnCreate method");
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inflate layout using View Binding
        setContentView(binding.getRoot().getRootView()); // Set the root view of the layout as the content v
        
        // Set onClickListener using method reference
        binding.convertButton.setOnClickListener(this::convertCurrency);

        Log.i("MainActivity","Exiting OnCreate");

    }
  
    public void convertCurrency(View view) {

        String inputAmount = binding.entryId.getText().toString(); // Access EditText using View Binding
        Log.i("MainActivity","Entering convertCurrency");

        
        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);
            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            binding.resultId.setText(resultFloat + " Euros"); // Access TextView using View Binding
        }
        Log.i("MainActivity","Exiting convertCurrency");
    }
}
