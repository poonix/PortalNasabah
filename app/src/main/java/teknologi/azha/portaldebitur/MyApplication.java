package teknologi.azha.portaldebitur;

import android.app.Application;
import android.content.Context;
import android.os.StrictMode;

import com.crashlytics.android.Crashlytics;
import com.crashlytics.android.ndk.CrashlyticsNdk;
import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

import io.fabric.sdk.android.Fabric;
/**
 * Created by user on 29/08/2017.
 */

public class MyApplication extends Application {
    private static Context context;
    private static Bus eventBus;


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics(), new CrashlyticsNdk());
        context = this;
        eventBus = new Bus(ThreadEnforcer.ANY);
        //https://stackoverflow.com/questions/38200282/android-os-fileuriexposedexception-file-storage-emulated-0-test-txt-exposed
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }


    public static Context getContext() {
        return context;
    }

    public static Bus getEventBus() {
        return eventBus;
    }
}
