package com.example.firstapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  Float selectedValue;
    private Spinner spinner;

   // private Float loan= 0.0F;
    //private Float down= 0.0F;
   // private Float intrest=0.0F;

    //private Float period=0.0F;
   // private float cPeriod=0.0F;
    //private Float remaining=0.0F;
    //private Float iEffective=0.0F;

    //private Float fValue= 0.0F;


    private ArrayList<SpinnerItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);

        // Create an array of items for the dropdown
      /*  String[] items = new String[]{
                "Daily",
                "Monthly",
                "Semi_Annually",
                "Annually"
        }; */

             items = new ArrayList<>();
        items.add(new SpinnerItem("Daily", 365));
        items.add(new SpinnerItem("Monthly", 12));
        items.add(new SpinnerItem("Semi-annually", 2));
        items.add(new SpinnerItem("Annually", 1));



        // Create an ArrayAdapter using a default spinner layout
        ArrayAdapter<SpinnerItem> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                items
        );

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        // Set up the selection listener
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SpinnerItem selectedItem = items.get(position);
                selectedValue = (float) selectedItem.getValue();

                // You can use the selected value here
                //handleSelectedValue(selectedValue);
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });
    }
//    private void handleSelectedValue(int value) {
//        // Do something with the value
//        switch (value) {
//            case 100:
//                // Handle Option 1 value
//                break;
//            case 200:
//                // Handle Option 2 value
//            case 300:
//            case 400:
//                break;
//            // ... and so on
//        }
   // }

    // Method to get the current selected value
    private int getSelectedValue() {
        SpinnerItem selectedItem = (SpinnerItem) spinner.getSelectedItem();
        return selectedItem.getValue();
    }



    public void hola(View v){
        EditText a= findViewById(R.id.loanAmount);
        String b=a.getText().toString();

        EditText c= findViewById(R.id.paymentDown);
        String d=c.getText().toString();

        EditText e= findViewById(R.id.rate);
        String f=e.getText().toString();

        EditText g= findViewById(R.id.year);
        String h= g.getText().toString();

        if(b.isEmpty() || d.isEmpty() || f.isEmpty() || h.isEmpty())
        {
            Toast.makeText(this, "field value can't be null", Toast.LENGTH_LONG).show();
        }
        else {
           Float loan = Float.parseFloat(b);
           Float down= Float.parseFloat(d);
           Float interest= Float.parseFloat(f);
            Float period=Float.parseFloat(h);

            if(down>=loan)
            {
                Toast.makeText(this, " loan must be greater", Toast.LENGTH_LONG).show();


            }
            else
            {
                Float remaining=loan-down;

                    Float iEffective= (float) Math.pow((1+((interest*0.01)/selectedValue)),selectedValue)-1;

                    Float fValue= (float) ((float) remaining*( Math.pow((1+iEffective),period)));

                    String amount= fValue.toString();
                ((TextView) findViewById(R.id.result)).setText(amount);

//                String k= iEffective.toString();
//                Log.d("klick", k);



//                if(selectedValue==100)
//                {
//                    cPeriod=365;
//                    iEffective= (float) Math.pow((1+((intrest*0.01)/365)),365);
//
//                    fValue= (float) Math.pow((1+iEffective),period)*remaining;
//
//
//                }
//
//                else if(selectedValue==200){
//                    cPeriod=12;
//                    iEffective= (float) Math.pow((1+((intrest*0.01)/12)),12);
//
//                    fValue= (float) Math.pow((1+iEffective),period)*remaining;
//                }

                }

        }









        //String s=selectedValue.toString();


//          if(loan==0.0F) {
//              Toast.makeText(this, "field value can't be null", Toast.LENGTH_LONG).show();
//
//          }





    }
}