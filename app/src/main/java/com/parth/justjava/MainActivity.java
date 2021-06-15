package com.parth.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;
    int priceOfCoffee = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //id association
        Button btnOrder =findViewById(R.id.btnOrder);
        Button btnPlus,btnMinus;
        btnPlus =findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        TextView edQuantity =findViewById(R.id.edQuantity);
        TextView edPrice = findViewById(R.id.edPrice);



        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "order done!!", Toast.LENGTH_SHORT).show();
                displayPrice(numberOfCoffees*priceOfCoffee);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfCoffees++;
                edQuantity.setText(Integer.toString(numberOfCoffees));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberOfCoffees--;
                edQuantity.setText(Integer.toString(numberOfCoffees));
            }
        });
    }

    private void displayPrice(int number) {
        TextView edPrice = findViewById(R.id.edPrice);
        edPrice.setText("Total:" +NumberFormat.getCurrencyInstance().format(number)+"\r\n"+"Thank You!!");
    }

}