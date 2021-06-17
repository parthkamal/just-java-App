package com.parth.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 1;
    int priceOfCoffee = 5;

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

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(), "order done!!", Toast.LENGTH_SHORT).show();
                displayMessage(numberOfCoffees*priceOfCoffee);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(numberOfCoffees>=100){
                    ;
                }else {
                    numberOfCoffees++;
                }
                edQuantity.setText(Integer.toString(numberOfCoffees));
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numberOfCoffees<2){
                    ;
                }
                else{
                    numberOfCoffees--;
                }
                edQuantity.setText(Integer.toString(numberOfCoffees));
            }
        });
    }

    private void displayMessage(int number) {
        CheckBox WhippedCream =  findViewById(R.id.checkWhippedCream);
        CheckBox chocolate =findViewById(R.id.chocolate_checkbox);
        EditText Name = findViewById(R.id.Name);
        Boolean whipped_checked = WhippedCream.isChecked();
        Boolean chocolate_checked = chocolate.isChecked();
        int extra = toppings(whipped_checked,chocolate_checked);
        if(number<0){
            number=0;
        }
        String message = "Name: "+Name.getText().toString() + "\r\n" + "Want Whipped Cream? " + whipped_checked.toString()+ "\r\n" + "Want Chocolate? " + chocolate_checked.toString() + "\r\n" + "Quantity: " + numberOfCoffees + "\r\n" + "Total:" + NumberFormat.getCurrencyInstance().format(number+extra) + "\r\n" + "Thank You!!";

        //intent for emailing the order summary
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setType("*/*");
            //setData is used so that only email apps should handle this
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_EMAIL, "kamalparth925@gmail.com");
            intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java Order Summary");
            intent.putExtra(Intent.EXTRA_TEXT,message);
            startActivity(intent);

    }

    int toppings(Boolean a,Boolean b){
        int ans=0;
        if(a){
            ans+=1;
            if(b){
                ans+=2;
            }
        }
        else{
            if(b){
                ans+=2;
            }
        }
        return ans;
    }

}

