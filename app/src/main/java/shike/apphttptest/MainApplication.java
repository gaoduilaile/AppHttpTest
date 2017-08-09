package shike.apphttptest;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2017/7/23.
 */

public class MainApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
    }
}
