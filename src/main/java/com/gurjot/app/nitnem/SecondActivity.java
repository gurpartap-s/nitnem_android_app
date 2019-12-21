package com.gurjot.app.nitnem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Typeface mTypeface;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        TextView scrollable = (TextView)findViewById(R.id.text_view2);
        scrollable.setMovementMethod(new ScrollingMovementMethod());
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        int position = Integer.parseInt(message);
        TextView textView = findViewById(R.id.text_view2);
        mTypeface = Typeface.createFromAsset(getAssets(),"fonts/gurb_b.ttf");
        int toShow;
        switch(position) {
            case 0:
                toShow = R.string.japjisahib_text;
                break;
            case 1:
                toShow = R.string.jaapsahib_text;
                break;
            case 2:
                toShow = R.string.swaiye_text;
                break;
            case 3:
                toShow = R.string.chaupaisahib_text;
                break;
            case 4:
                toShow = R.string.anandsahib_text;
                break;
            case 5:
                toShow = R.string.rehrassahib_text;
                break;
            case 6:
                toShow = R.string.sohilasahib_text;
                break;
            case 7:
                toShow = R.string.ardaas_text;
                break;
            default:
                toShow = R.string.japjisahib_text;
                break;

        }
        Spanned sp = Html.fromHtml( getString(toShow));
        textView.setTextSize(30);
        textView.setTypeface(mTypeface);
        //textView.setMovementMethod(new ScrollingMovementMethod());
        textView.setText(sp);


    }
}
