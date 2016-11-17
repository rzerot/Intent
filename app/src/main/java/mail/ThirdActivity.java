package mail;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import project.dragos.com.intent.R;

/**
 * Created by java2 on 9/29/2016.
 */

public class ThirdActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_third);
        super.onCreate(savedInstanceState);

        buttonPressed();
    }

    public void buttonPressed(){
        Uri uri =Uri.parse("smsto:0700000000");
        Intent intent = new Intent(Intent.ACTION_SENDTO,uri);
        intent.putExtra("sms_body", "Call your bunny");
        startActivity(intent);

    }
}
