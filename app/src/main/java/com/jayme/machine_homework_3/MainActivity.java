package com.jayme.machine_homework_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private CheckBox pineappleCheckbox = null;
    private CheckBox sausagebitsCheckbox = null;
    private CheckBox mozzarelaCheckbox = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Pizza Time!");

        RadioGroup flavorGroup = findViewById(R.id.flavor_group);
        flavorGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.hawaiian_radioButton:
                        Toast.makeText(MainActivity.this, "Hawaiian Pizza!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.pepperoni_radioButton:
                        Toast.makeText(MainActivity.this, "Pepperoni Pizza!", Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.stuffedcrust_radioButton:
                        Toast.makeText(MainActivity.this, "Stuffed Crust Pizza!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        pineappleCheckbox = findViewById(R.id.pineapple_checkBox);
        sausagebitsCheckbox = findViewById(R.id.sausagebits_checkBox);
        mozzarelaCheckbox = findViewById(R.id.mozarella_checkBox);

        /*FloatingActionButton orderFab = findViewById(R.id.order_fab);
        orderFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vanillaCheckBoxValue = vanillaCheckbox.isChecked();
                chocolateCheckBoxValue = chocolateCheckBox.isChecked();
                strawberryCheckBoxValue = strawberryCheckBox.isChecked();
                doubleDutchCheckBoxValue = doubleDutchCheckBox.isChecked();

                Toast.makeText(CheckboxDemoActivity.this, "Flavors added to cart.", Toast.LENGTH_SHORT).show();
            }
        });*/

        pineappleCheckbox.setOnCheckedChangeListener(this);
        sausagebitsCheckbox.setOnCheckedChangeListener(this);
        mozzarelaCheckbox.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        String message = "";
        int id = buttonView.getId();
        switch (id){
            case R.id.pineapple_checkBox:
                message = isChecked ? "with Pineapple!" : "";
                break;

            case R.id.sausagebits_checkBox:
                message = isChecked ? "with Sausage Bits!" : "";
                break;

            case R.id.mozarella_checkBox:
                message = isChecked ? "with Mozarella!" : "";
                break;

        }
        if(!message.isEmpty()){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }

    }
}
