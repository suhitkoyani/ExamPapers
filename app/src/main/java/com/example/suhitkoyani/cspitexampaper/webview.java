package com.example.suhitkoyani.cspitexampaper;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by acer on 10/21/2017.
 */

public class webview extends Activity {
    private WebView myweb;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_show);
        myweb =(WebView)findViewById(R.id.web);
        String url = getIntent().getStringExtra("URL");
        //Toast.makeText(getApplicationContext(),url,Toast.LENGTH_LONG).show();
        myweb.loadUrl(url);
    }
}
