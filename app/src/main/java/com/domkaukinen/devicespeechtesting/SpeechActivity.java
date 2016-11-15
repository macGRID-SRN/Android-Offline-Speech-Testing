package com.domkaukinen.devicespeechtesting;

import android.content.Context;
import android.content.Intent;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class SpeechActivity extends AppCompatActivity {


    private SpeechRecognizer mSpeechRecognizer;
    private Intent mSpeechRecognizerIntent;
    private boolean mIslistening;
    private static String TAG = "Speeching";
    private static Context context;
    private Button speechButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech);
        context = this;
        speechButton = (Button)findViewById(R.id.buttonSpeech);
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_CALLING_PACKAGE,
                this.getPackageName());


        SpeechRecognitionListener listener = new SpeechRecognitionListener();
        mSpeechRecognizer.setRecognitionListener(listener);




    }


    public void goSpeech(View view){
        if (!mIslistening)
        {
            Toast.makeText(context, "listening", Toast.LENGTH_SHORT).show();
            mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
        }
    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        if (mSpeechRecognizer != null)
        {
            mSpeechRecognizer.destroy();
        }
    }



    protected class SpeechRecognitionListener implements RecognitionListener
    {

        @Override
        public void onBeginningOfSpeech()
        {
            //Log.d(TAG, "onBeginingOfSpeech");
        }

        @Override
        public void onBufferReceived(byte[] buffer)
        {

        }

        @Override
        public void onEndOfSpeech()
        {
            //Log.d(TAG, "onEndOfSpeech");
        }

        @Override
        public void onError(int error)
        {
            Toast.makeText(context, "error, listening", Toast.LENGTH_SHORT).show();
            mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
            //Log.d(TAG, "error = " + error);
        }

        @Override
        public void onEvent(int eventType, Bundle params)
        {

        }

        @Override
        public void onPartialResults(Bundle partialResults)
        {

        }

        @Override
        public void onReadyForSpeech(Bundle params)
        {
            Log.d(TAG, "onReadyForSpeech"); //$NON-NLS-1$
        }

        @Override
        public void onResults(Bundle results)
        {
            //Log.d(TAG, "onResults"); //$NON-NLS-1$
            ArrayList<String> matches = results.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
            Toast.makeText(context, matches.get(0), Toast.LENGTH_LONG).show();
            // matches are the return values of speech recognition engine
            // Use these values for whatever you wish to do
        }

        @Override
        public void onRmsChanged(float rmsdB)
        {
        }
    }


}
