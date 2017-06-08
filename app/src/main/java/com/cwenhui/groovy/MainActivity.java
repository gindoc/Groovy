package com.cwenhui.groovy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView webView;
    private TextView textView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = (WebView) findViewById(R.id.webView);
        textView = (TextView) findViewById(R.id.text);
        // 启用javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 从assets目录下面的加载html
        webView.loadUrl("file:///android_asset/html/TestForHybrid.html");
        webView.addJavascriptInterface(this, "wx");
    }

    public void callJSWithParams(View view) {
        webView.loadUrl("javascript:actionFromNativeWithParam(" + "'come from Native'" + ")");
    }

    public void callJS(View view) {
        webView.loadUrl("javascript:actionFromNative()");
    }

    @android.webkit.JavascriptInterface
    public void actionFromJs() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "js调用了Native函数", Toast.LENGTH_SHORT).show();
                String text = textView.getText() + "\njs调用了Native函数";
                textView.setText(text);
            }
        });
    }

    @android.webkit.JavascriptInterface
    public void actionFromJsWithParam(final String str) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "js调用了Native函数,传递参数：" + str, Toast.LENGTH_SHORT).show();
                String text = textView.getText() +  "\njs调用了Native函数,传递参数：" + str;
                textView.setText(text);
            }
        });
    }
}
