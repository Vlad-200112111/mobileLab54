package com.example.mobilelab_54;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnCamera;
    private ImageView imgPhoto;
    private final int REQUEST_CAMERA_IMAGE =0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamera = (ImageButton) findViewById(R.id.btnCamera);
        imgPhoto = (ImageView) findViewById(R.id.imageView);
    }

    public void onClick(View view){
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, REQUEST_CAMERA_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CAMERA_IMAGE){
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imgPhoto.setImageBitmap(imageBitmap);
        }
    }
}