package project.dragos.com.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by java2 on 9/29/2016.
 */

public class SecondActivity extends AppCompatActivity {
    Button btn2;
public static final String TAG ="Second";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Bundle extraInfo = getIntent().getExtras();
        int someInfo = extraInfo.getInt(MainActivity.KEY, 0);
        System.out.println(someInfo + "");
        linkUI();
        setListener();

    }

    @Override
    protected void onStart() {

        super.onStart();
        Log.d(TAG,"Started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"Resuming");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"Paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"Destroying");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"Restarting");
    }


    public void ffinish() {
        Intent i = new Intent();
        i.putExtra("Returning", "za Value");
        setResult(RESULT_OK, i);

    }


    public void linkUI() {
        btn2 = (Button) findViewById(R.id.btn2);
    }

    public void setListener() {
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ffinish();
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        ffinish();
        super.onBackPressed();
    }
}
