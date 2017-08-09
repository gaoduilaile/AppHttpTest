package shike.apphttptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                RetrofitUtils.login(MainActivity.this,"13783539376","123");
//
//                RetrofitUtils.register(MainActivity.this,"13783539376","123");

//
                String token1 = "MTM3ODM1MzkzNzZUaHUgSnVsIDI3IDEyOjU4OjA5IENTVCAyMDE3";
                String token2 = "kr_v%88";
                StringBuffer buffer = new StringBuffer();
                String tokenStr = buffer.append(token1.trim()).append(token2.trim()).toString().trim();
                String encodedString = Base64.encodeToString(tokenStr.getBytes(), Base64.NO_WRAP);
//
//                String str4 = encodedString.replaceAll("\\s*", "");
//                Log.e("sdf",str4);

//                RetrofitUtils.getInfo(MainActivity.this, encodedString);
                RetrofitUtils.update(encodedString, "s", "gao", "23", "1", "134_1234", "sdf", "其他", "reren1jianjei1", new RetrofitUtils.Func() {
                    @Override
                    public void onJsonString(String response) throws JSONException {
                        Log.e("我的",response);
                    }
                });

            }
        });

    }


}
