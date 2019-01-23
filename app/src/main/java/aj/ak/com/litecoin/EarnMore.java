package aj.ak.com.litecoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.startapp.android.publish.ads.nativead.NativeAdDetails;
import com.startapp.android.publish.ads.nativead.NativeAdPreferences;
import com.startapp.android.publish.ads.nativead.StartAppNativeAd;
import com.startapp.android.publish.adsCommon.Ad;
import com.startapp.android.publish.adsCommon.StartAppSDK;
import com.startapp.android.publish.adsCommon.adListeners.AdEventListener;

import java.util.ArrayList;
import java.util.Iterator;dInstanceState) {
        super.onCreate(savedInstanc

public class EarnMore extends AppCompatActivity {
    private StartAppNativeAd startAppNativeAd = new StartAppNativeAd(this);
    @Override
    protected void onCreate(Bundle saveeState);
        setContentView(R.layout.activity_earn_more);
        StartAppSDK.init(this, "202580835", false);
        startAppNativeAd.loadAd(new NativeAdPreferences());
        startAppNativeAd.loadAd();

        startAppNativeAd.getNativeAds("level_failed");
nativeAd();
    }
    void nativeAd(){
        // Declare Native Ad Preferences
        NativeAdPreferences nativePrefs = new NativeAdPreferences()
                .setAdsNumber(3)                // Load 3 Native Ads
                .setAutoBitmapDownload(true)    // Retrieve Images object
                .setPrimaryImageSize(2);        // 150x150 image

// Declare Ad Callbacks Listener
        AdEventListener adListener = new AdEventListener() {     // Callback Listener
            @Override
            public void onReceiveAd(Ad arg0) {
                // Native Ad received
                ArrayList<NativeAdDetails> ads = startAppNativeAd.getNativeAds();    // get NativeAds list

                // Print all ads details to log
                Iterator<NativeAdDetails> iterator = ads.iterator();
                while(iterator.hasNext()){
                    Log.d("MyApplication", iterator.next().toString());
                }
            }

            @Override
            public void onFailedToReceiveAd(Ad arg0) {
                // Native Ad failed to receive
                Log.e("MyApplication", "Error while loading Ad");
            }
        };

// Load Native Ads
        startAppNativeAd.loadAd(nativePrefs, adListener);
        startAppNativeAd.show();
    }
}
