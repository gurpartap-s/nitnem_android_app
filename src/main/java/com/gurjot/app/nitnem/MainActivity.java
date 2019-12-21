package com.gurjot.app.nitnem;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.gurpartap.app1.POSITION";

    public void startNewActivity(String str){
        final Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_MESSAGE, str);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Typeface mTypeface;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView) findViewById(R.id.list_view);
        mTypeface = Typeface.createFromAsset(getAssets(),"fonts/gurb_b.ttf");
        String [] myStringArray;
        myStringArray = getResources().getStringArray(R.array.list_items);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, myStringArray){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Cast the list view each item as text view
                TextView item = (TextView) super.getView(position,convertView,parent);
                item.setTypeface(mTypeface);
                //item.setTextColor(Color.parseColor("#FF3E80F1"));
                //item.setTypeface(item.getTypeface(), Typeface.BOLD);
                item.setTextSize(TypedValue.COMPLEX_UNIT_DIP,30);
                return item;
            }

        };

        listView.setAdapter(adapter);
        AdapterView.OnItemClickListener mMessageClickedHandler = new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                //String value = (String)parent.getItemAtPosition(position);
                startNewActivity(Integer.toString(position));
            }
        };

        listView.setOnItemClickListener(mMessageClickedHandler);
    }

    /*public void incrementQuantity(View view){
        numberOfCoffees++;
        display(numberOfCoffees);
        displayPrice(5*numberOfCoffees);
    }
    public void decrementQuantity(View view){
        if(numberOfCoffees == 0)
            return;
        numberOfCoffees--;
        display(numberOfCoffees);
        displayPrice(5*numberOfCoffees);
    }
    public void submitOrder(View view) {
        display(numberOfCoffees);
        displayPrice(5*numberOfCoffees);
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }
    private void displayPrice(int number){
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }*/
}
