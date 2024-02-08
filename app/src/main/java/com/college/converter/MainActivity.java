package com.college.converter;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.college.converter.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    static private final Float CONVERSION_RATE = 0.80F;
    private ActivityMainBinding binding; // Declare binding object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater()); // Inflate layout using View Binding
        setContentView(binding.getRoot().getRootView()); // Set the root view of the layout as the content view

        // Set onClickListener using method reference
        binding.convertButton.setOnClickListener(this::convertCurrency);
    }
    public void convertCurrency(View view) {
        String inputAmount = binding.entryId.getText().toString(); // Access EditText using View Binding
        if (!inputAmount.isEmpty()) {
            Float inputAmountDecimal = Float.valueOf(inputAmount);
            Float resultFloat = inputAmountDecimal * CONVERSION_RATE;
            binding.resultId.setText(resultFloat + " Euros"); // Access TextView using View Binding
        }
    }
}
