package com.saphal.yatra;

import android.content.ContentResolver;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.UploadTask;
import com.saphal.yatra.menu.MenuActivity;
import com.saphal.yatra.models.Hotel;
import com.saphal.yatra.models.HotelFire;
import com.saphal.yatra.models.Upload;
import com.saphal.yatra.utils.FirebaseHelper;
import com.squareup.picasso.Picasso;

public class HotelActivity extends AppCompatActivity {


    String hname,haddress,hphone,hwebsite,image;
    public static final int PICK_IMAGE_REQUEST = 1;
    private EditText hotelName,address,phone,website;
    private ImageButton img_select;
    private Uri imageuri;
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;
    private StorageTask mUploadTask;
    private FirebaseHelper mFirebaseHelper;
    private String userID;
    private ImageView profile_img;
    private HotelFire hotel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel2);
        hotelName=findViewById(R.id.hotelName);
        address=findViewById(R.id.h_address);
        phone=findViewById(R.id.phone);
        website=findViewById(R.id.website);
        img_select=findViewById(R.id.img_select);
        profile_img = findViewById(R.id.profile_img);


    }

    public void onClickHotelAdd(View view) {
        hname=hotelName.getText().toString();
        haddress=address.getText().toString();
        hphone=phone.getText().toString();
        hwebsite=website.getText().toString();
        mFirebaseHelper = new FirebaseHelper(getApplicationContext());
        mStorageRef = FirebaseStorage.getInstance().getReference("hotels");
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("hotels");


        if (mFirebaseHelper.getmAuth().getCurrentUser() != null) {
            userID = mFirebaseHelper.getmAuth().getCurrentUser().getUid();
        };
        if (mUploadTask != null && mUploadTask.isInProgress()) {
            Toast.makeText(this, "Upload in Progress", Toast.LENGTH_SHORT).show();

        } else {

            uploadFile();
        }


    }

    private void addToDatabase(HotelFire hotel) {
        mFirebaseHelper.getmRef().child("hotels")
                .setValue(hotel)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        startActivity(new Intent(getApplicationContext(), MenuActivity.class));
                        Toast.makeText(HotelActivity.this, "Hotel is added Successfully.", Toast.LENGTH_SHORT).show();

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(HotelActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });
    }



    private void uploadFile() {
        if (imageuri != null) {
            StorageReference fileReference = mStorageRef.child(System.currentTimeMillis()
                    + "." + getFileExtension(imageuri));

            mUploadTask = fileReference.putFile(imageuri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            Upload upload = new Upload(taskSnapshot.getStorage().getDownloadUrl().toString());
                            String uploadId = mDatabaseRef.push().getKey();
                            mDatabaseRef.child(uploadId).setValue(upload);
                            Toast.makeText(HotelActivity.this, "Upload successful", Toast.LENGTH_LONG).show();
                            image=upload.getImageuri().toString();
                            hotel=new HotelFire(
                                    hname,
                                    haddress,
                                    hphone,
                                    hwebsite,
                                    image
                            );
                            addToDatabase(hotel);

                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(HotelActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    })
                    .addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                            Toast.makeText(HotelActivity.this, "Uploading", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            Toast.makeText(this, "No file selected", Toast.LENGTH_SHORT).show();
        }
    }

    private String getFileExtension(Uri uri) {
        ContentResolver cR = getContentResolver();
        MimeTypeMap mime = MimeTypeMap.getSingleton();
        return mime.getExtensionFromMimeType(cR.getType(uri));
    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            imageuri = data.getData();
            Picasso.with(this).load(imageuri).into(profile_img);
        }
    }
    public void onClickPhotoAdd(View view) {
        openFileChooser();
        profile_img.setVisibility(View.VISIBLE);
    }
}
