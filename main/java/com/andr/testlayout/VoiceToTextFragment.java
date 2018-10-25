package com.andr.testlayout;


import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VoiceToTextFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VoiceToTextFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    public VoiceToTextFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VoiceToTextFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VoiceToTextFragment newInstance(String param1, String param2) {
        VoiceToTextFragment fragment = new VoiceToTextFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
View view = null;
    EditText message;
    ImageView mic;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.activity_main, container, false);
        initViews(view);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                askSpeechInput();
            }
        });
        Log.d("VoiceToText","JSON String:::"+parseJSONFromAssets());
        return view;
    }
    private void initViews(View view){
        message = (EditText)view.findViewById(R.id.msg);
        mic = (ImageView)view.findViewById(R.id.imageButton);
    }
    private final int REQ_CODE_SPEECH_INPUT = 100;
    private void askSpeechInput() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT,
                "Hi speak something");
        try {
            startActivityForResult(intent, REQ_CODE_SPEECH_INPUT);
        } catch (ActivityNotFoundException a) {

        }
    }


    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //oiceInput.setText(result.get(0));
                    Log.d("VoiceToTextFrag","Result::::"+result.get(0));
                }
                break;
            }

        }
    }*/

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQ_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {

                    ArrayList<String> result = data
                            .getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    //oiceInput.setText(result.get(0));
                    Log.d("VoiceToTextFrag","Result::::"+result.get(0));
                    message.setText(result.get(0));
                }
                break;
            }

        }
    }


    public String  parseJSONFromAssets(){
        String json = null;
        try {
            InputStream is = getActivity().getAssets().open("myData.json");
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

    /*
      Ques:How to Transfer  a call?\n
      Ans:1.From an active call, press Transfer.\n
      2. Enter the transfer recipient’s phone number.\n
      3. Press Transfer again (before or after the party answers). The transfer completes.\n
      Ques:How to Hold the call?\n
      Ans:1. Press Hold . The hold icon appears and  the line button flashes green.\n2. To resume a call from hold, press the flashing green line button, Resume, or Hold.\nQues: How to Voicemail?\nAns:New message indicators:\n• A solid red light on your handset.\n• A stutter dial tone (if available).\n• The voicemail icon and number display on the screen along with one idle session button.\nQues: How to Divert a call?\nAns: Press Divert when the call is ringing, active, or on hold. Divert redirects an individual call to voicemail or to another number set up by your system administrator.\nQues: How to view call history?\nAns: 1. Press Applications .\n2. Scroll and select Call History.\n3. Select a line to view. Your phone displays the last 150 missed, placed, and received calls.\n4. To view details for a call, scroll to the call, press More, and then press Details. Americas Headquarters.\n
      */

    /*

      "qna":[
          {"How to Transfer  a call?":   "1.From an active call, press Transfer.\n
                                          2. Enter the transfer recipient’s phone number.\n
                                          3. Press Transfer again (before or after the party answers). The transfer completes.\n"
          },
          {"How to Hold the call?":
            "1. Press Hold . The hold icon appears and  the line button flashes green.\n2. To resume a call from hold, press the flashing green line button, Resume, or Hold.\n"}
      ]
    */


    private void parseJSON(String info){
    //    StringTokenizer token = new StringTokenizer(info, ".");
        String outPut="";
        String text = "Ques:[a-zA-Z0-9]\\n";

        String modifiedString = "";
        String answerModifiedString="";
        if(info.contains("Ques: ")){
            modifiedString = info.replace("Ques: ","Ques:" );
        }else{
            modifiedString = info;
        }

      if(modifiedString.contains("Ans: ")) {
          answerModifiedString = modifiedString.replace("Ans: ","Ans:" );
      }else{
          answerModifiedString =  modifiedString;
      }
      Log.d("Pattern","AnswerModifiedString::::"+answerModifiedString);
        // String patternString = "Ques:[a-zA-Z0-9\\s\\S_]*Ans";
       String patternString = "Ques:\\s*\\S*\\w*\\W*\\d*\\D*Ans:";
  //     String patternString = "Ques:[ a-zA-Z0-9_ ]*Ans";
        Pattern ptn = Pattern.compile(patternString,Pattern.CASE_INSENSITIVE);
        String[] result = ptn.split(answerModifiedString);


        for (String temp: result)
            System.out.println("element = "+temp);
       /* Matcher mtch = ptn.matcher(answerModifiedString);
        while(mtch.find()){
            outPut = 	  mtch.group(0).substring(mtch.group(0).indexOf(":")+1,mtch.group(0).lastIndexOf("Ans"));
            Log.d("Pattern","element = "+outPut);
        }*/
        /*Pattern pattern = Pattern.compile(patternString);

        String[] split = pattern.split(info);

        System.out.println("split.length = " + split.length);

        for(String element : split){
            //System.out.println("element = " + element);
            Log.d("Pattern","element = " + element);
        }*/
    }
}
