package com.example.encryptionanddecryption;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editTextMassage;
    Button buttonEncrypt;
    Button buttonDecrypt;
    TextView textViewEncryptMassage;
    TextView textViewDecryptMassage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMassage = findViewById(R.id.editTextMassage);
        buttonEncrypt = findViewById(R.id.buttonEncrypt);
        textViewEncryptMassage = findViewById(R.id.textViewEncryptMassage);
        buttonDecrypt = findViewById(R.id.buttonDecrypt);
        textViewDecryptMassage = findViewById(R.id.textViewDecryptMassage);


        buttonEncrypt.setOnClickListener(v -> {

            String massage = editTextMassage.getText().toString();
            try {
                String encrypt = KeyStoreCryptoUtils.encrypt(massage);
                textViewEncryptMassage.setVisibility(View.VISIBLE);
                buttonDecrypt.setVisibility(View.VISIBLE);
                textViewEncryptMassage.setText(encrypt);
            } catch (Exception e) {
                e.printStackTrace();
            }


        });


        buttonDecrypt.setOnClickListener(view -> {
            try {
                String massage = textViewEncryptMassage.getText().toString();
                String decrypt = KeyStoreCryptoUtils.decrypt(massage);
                textViewDecryptMassage.setVisibility(View.VISIBLE);
                textViewDecryptMassage.setText(decrypt);

            } catch (Exception e) {
                e.printStackTrace();
                Log.d("Decryption Error", "Error -> " + e);
            }

        });






    }

}
