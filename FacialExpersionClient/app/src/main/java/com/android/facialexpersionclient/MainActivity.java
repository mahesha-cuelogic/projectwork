package com.android.facialexpersionclient;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView capturePhoto;
    TextView addSongsbutton;
    private final int requestCode=20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        capturePhoto=(TextView) findViewById(R.id.startCamera);

        capturePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent,requestCode);
                Log.d("vidya","Clicking Capture Photo Button");
            }
        });

        addSongsbutton=(TextView) findViewById(R.id.addSongs);

        addSongsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SongsActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.d("vidya","In OnActivityResult");
        if(this.requestCode == requestCode && resultCode == RESULT_OK){
            try {
                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
               // String path = storeCameraPhotoInSDCard(bitmap);

               // Intent newActivity = new Intent(this, DisplayImageActivity.class);
               // newActivity.putExtra("Image", path);
                //startActivity(newActivity);
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }


}
