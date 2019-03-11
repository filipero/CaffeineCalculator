package com.example.caffeinecalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextView txtDrinkAmount, txtCaffeineAmount;
    Spinner spnDrinks;
    Button btnCalculate, btnDrinkPlus, btnDrinkMinus;

    Double blackTea = 100d;
    Double greenTea = 65d;
    Double coffee = 240d;
    Double iceCoffee = 200d;
    Double espresso = 75d;
    Double cappucino = 150d;
    Double totalCaffeine = 0d;
    Double totalDrinks = 1d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonCalculateVoid();
        buttonAddVoid();
        buttonSubtractVoid();
        printDrinks();
    }

    private void buttonCalculateVoid(){
        btnCalculate = findViewById(R.id.buttonCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
            }
        });
    }

    private void buttonAddVoid(){
        btnDrinkPlus = findViewById(R.id.buttonDrinkPlus);
        btnDrinkPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }

    private void buttonSubtractVoid(){
        btnDrinkMinus = findViewById(R.id.buttonDrinkMinus);

        btnDrinkMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subtract();
            }
        });
    }

    private void calculate(){
        spnDrinks = findViewById(R.id.spinnerDrinks);

        String selectedDrink = spnDrinks.getSelectedItem().toString();


        if(selectedDrink.equals("Black Tea")){
            totalCaffeine = blackTea * totalDrinks;
        }
        else if(selectedDrink.equals("Green Tea")){
            totalCaffeine = greenTea * totalDrinks;
        }
        else if(selectedDrink.equals("Coffee")){
            totalCaffeine = coffee * totalDrinks;
        }
        else if(selectedDrink.equals("Ice Coffee")){
            totalCaffeine = iceCoffee * totalDrinks;
        }
        else if(selectedDrink.equals("Espresso")){
            totalCaffeine = espresso * totalDrinks;
        }
        else if(selectedDrink.equals("Cappucino")) {
            totalCaffeine = cappucino * totalDrinks;
        }
        else {

        }

        printMiliGrams();
    }

    private void add(){
        totalDrinks = totalDrinks+1;
        printDrinks();
    }
    private void subtract(){
        if (totalDrinks > 0) {
            totalDrinks = totalDrinks - 1;
        }
        printDrinks();
    }
    private void printDrinks(){
        txtDrinkAmount = findViewById(R.id.textDrinkAmount);

        String formatTotal = String.format("%1.0f", totalDrinks);

        txtDrinkAmount.setText("Amount of Drinks: "+ formatTotal);
    }

    private void printMiliGrams(){
        txtCaffeineAmount = findViewById(R.id.textCaffeineAmount);

        String formatTotal = String.format("%1.0f", totalCaffeine);

        if (totalCaffeine <= 200){
            txtCaffeineAmount.setTextColor(Color.BLACK);
        }else if(totalCaffeine<= 400){
            txtCaffeineAmount.setTextColor(Color.rgb(255,150,0));
        }else{
            txtCaffeineAmount.setTextColor(Color.RED);
        }

        txtCaffeineAmount.setText(formatTotal + " mg");
    }
}
