package project.dragos.com.intent;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String KEY = "key1";
    public static final int REQCODE = 456;
    private Button btn;
    public static final String TAG="First";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Creating");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

    public void onButtonPressed() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra(KEY, 987);
        startActivityForResult(intent, REQCODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK && requestCode == REQCODE) {
            if (data.hasExtra("Returning")) {
                System.out.println(data.getStringExtra("Returning"));
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void linkUI() {
        btn = (Button) findViewById(R.id.btn);

    }

    public void setListener() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onButtonPressed();
            }
        });
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation== Configuration.ORIENTATION_LANDSCAPE){

            Toast.makeText(this, "landscape", Toast.LENGTH_SHORT).show();
            btn.setText("landscape");
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            Toast.makeText(this,"portrait", Toast.LENGTH_SHORT).show();
            btn.setText("portrait");
        }
    }
}
