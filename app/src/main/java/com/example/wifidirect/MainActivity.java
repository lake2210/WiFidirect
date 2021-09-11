package com.example.wifidirect;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;

import fi.iki.elonen.NanoHTTPD;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("NanoHttpd")
                .setMessage("起動しました")
                .setPositiveButton("OK", null)
                .show();
        try {
            WebServer wb =new WebServer();
            wb.start();
        } catch (IOException e) {
        }
    }
    private class WebServer extends NanoHTTPD {
        public WebServer() throws IOException {
            super(8080);
        }
        @Override
        public Response serve(IHTTPSession session) {
            Log.d("NanoHttod", "起動したよ！");
            String msg01="&lt;!DOCTYPE html&gt;\n" +
                    "&lt;html lang=\"ja\"&gt;\n" +
                    "&lt;head&gt;\n" +
                    "&lt;meta charset=\"UTF-8\"&gt;\n" +
                    "&lt;title&gt;サイトのタイトル&lt;/title&gt;\n" +
                    "&lt;/head&gt;\n" +
                    "&lt;body&gt;\n" +
                    " \n" +
                    "//ここにサイトに表示するコンテンツ内容を記述\n" +
                    " \n" +
                    "&lt;/body&gt;\n" +
                    "&lt;/html&gt;\n";
            return newFixedLengthResponse(msg01);
        }
    }
}