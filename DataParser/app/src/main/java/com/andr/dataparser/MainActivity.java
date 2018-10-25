package com.andr.dataparser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        parseJSONFromAssets();
    }

 public String  parseJSONFromAssets(){
        String json = null;
        try {
            InputStream is = getAssets().open("myData.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }

        Log.e("data", json);
        parseJSON(json);
        return json;
    }
	
	private void parseJSON(String info){
    //    StringTokenizer token = new StringTokenizer(info, ".");
        String[] ary = info.split("Ques:");
        for(int i=1;i<ary.length;i++){
            Log.d("Array","Qustion Array:::"+ary[i].substring(0,ary[i].indexOf("?")+1));
        }

        String[] ansAry = info.split("Ans:");
        for(int i=1;i<ansAry.length;i++){
            Log.d("Array","Answer Array:::"+ansAry[i]/*.substring(0,ansAry[i].indexOf("Ques:")+1)*/);
        }

    }

    
}
