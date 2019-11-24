package com.example.myapplication522;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.ui.PlacePicker;

import javax.sql.StatementEvent;

public class MainActivity extends AppCompatActivity {
    Button btpicker;
    TextView textView;
int PLACE_PICKER_REQUEST=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
btpicker=findViewById(R.id.bt_picker);
textView=findViewById(R.id.text_view);
btpicker.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PlacePicker.IntentBuilder builder=new PlacePicker.IntentBuilder();
        try {
            startActivityForResult(builder.build(MainActivity.this),PLACE_PICKER_REQUEST);
        }catch (GooglePlayServicesRepairableException e){
            e.printStackTrace();
        }catch (GooglePlayServicesNotAvailableException e){
            e.printStackTrace();
        }

    }
});
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
       if(requestCode==PLACE_PICKER_REQUEST){
          if (resultCode==RESULT_OK){
              Place place=PlacePicker.getPlace(data,this);
              StringBuilder stringBuilder=new StringBuilder();
              String Latitude=String.valueOf(place.getLatLng().latitude);
              String Longitude= String.valueOf(place.getLatLng().longitude);
              stringBuilder.append("LATITUDE:");
              stringBuilder.append(Latitude);
              stringBuilder.append("/n");
;              stringBuilder.append("LONGITUDE:");
              stringBuilder.append(Longitude);
              textView.setText(stringBuilder.toString());


          }
       }
    }
}
