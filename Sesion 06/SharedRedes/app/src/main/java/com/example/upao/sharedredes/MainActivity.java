package com.example.upao.sharedredes;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.facebook.FacebookSdk;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.model.SharePhoto;
import com.facebook.share.model.SharePhotoContent;
import com.facebook.share.widget.MessageDialog;
import com.facebook.share.widget.ShareDialog;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FacebookSdk.sdkInitialize(getApplicationContext());

        Button btnCompartir;
        btnCompartir = (Button)findViewById(R.id.btn_compartir);

        final Bitmap imagen;
        imagen = BitmapFactory.decodeResource(getApplicationContext().getResources(), R.mipmap.ic_launcher);

        btnCompartir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharePhoto photo = new SharePhoto.Builder()
                        .setBitmap(imagen)
                        .build();
                SharePhotoContent content = new SharePhotoContent.Builder()
                        .addPhoto(photo)
                        .build();
                /*ShareLinkContent contenido2 = new ShareLinkContent.Builder()
                        .setContentUrl(Uri.parse("https://developers.facebook.com")).build();*/

                ShareDialog.show(MainActivity.this, content);
                MessageDialog.show(MainActivity.this, content);

            }
        });
    }


}
