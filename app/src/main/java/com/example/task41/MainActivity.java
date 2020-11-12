package com.example.task41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaCodec;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
TextInputLayout inputemail,inputpass ,inputusername;
TextInputEditText textInput_email ,textInput_pass,textusername ;
Button btn_submit;
private static final Pattern passwordpattern = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
        "(?=.*[@#$%^&+=])(?=\\s+$).{6,20}$");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputemail=findViewById(R.id.input_email);
        inputpass=findViewById(R.id.input_pass);
        inputusername=findViewById(R.id.input_username);
        textInput_email=findViewById(R.id.input_edittextemail);
        textInput_pass=findViewById(R.id.input_edittextpass);
        textusername=findViewById(R.id.input_edittextusername);
        btn_submit=findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit_form();

                Intent in=new Intent(getBaseContext(),Lifecycle.class);
                startActivity(in);
            }
        });
    }
   private boolean validdate_username(){
    String input_username=textInput_email.getText().toString().trim();
    if(input_username.isEmpty()){
        textusername.setError("Field can't be Empty");
        return false;
    }
    else if(input_username.length()>15){
        textusername.setError("Username is too long");
        return false;
    }
    else{
        textusername.setError(null);
        return true;
    }

   }
    public void requestFocus(View v){
        if(v.requestFocus()){
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }
     private boolean validate_email(){
     if(textInput_email.getText().toString().trim().isEmpty()){
         inputemail.setError("Enter Email");
         requestFocus(textInput_email);
         return false;
     }
     else if(!Patterns.EMAIL_ADDRESS.matcher((CharSequence) inputemail).matches()){
         inputemail.setError("Please Enter a valid email address");
         requestFocus(textInput_email);
         return false;
     }
     else{
         if(textInput_email.getText().toString().trim().length()<5){
             inputemail.setError("Minimum 5 Character");
             requestFocus(textInput_email);
             return false;
         }
     }
   return true;
     }
    private boolean validate_pass(){
        if(textInput_pass.getText().toString().trim().isEmpty()){
            inputpass.setError("Enter Password");
            requestFocus(textInput_pass);
            return false;
        }
        else if(!passwordpattern.matcher((CharSequence) inputpass).matches()){
            inputpass.setError("Password too weak");
            requestFocus(textInput_pass);
            return false;
        }
        else{
            if(textInput_pass.getText().toString().trim().length()<5){
                inputpass.setError("Minimum 5 Character");
                requestFocus(textInput_pass);
                return false;
            }
        }
        return true;
    }
    private void submit_form(){
        if(!validate_email() | !validate_pass()|!validdate_username()){
            return;
        }
        String input="Email : "+textInput_email.getText().toString();
        input+="\n";
        input+="Username : "+textusername.getText().toString();
        input+="\n";
        input+="Password : "+textInput_pass.getText().toString();

        Toast.makeText(getBaseContext(),input+"\n"+"Successfully",Toast.LENGTH_LONG).show();



    }




}
