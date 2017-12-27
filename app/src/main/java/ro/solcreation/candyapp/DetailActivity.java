package ro.solcreation.candyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = DetailActivity.this.getIntent();
        String candy_name = "";

        if(intent != null && intent.hasExtra("candy_name")) {
            candy_name = intent.getStringExtra("candy_name");
        }

        TextView textView = (TextView)this.findViewById(R.id.text_view_name);
        textView.setText(candy_name);

        String candyImage = "";
        if(intent.hasExtra("candy_image"))
        candyImage = intent.getStringExtra("candy_image");

        String candyPrice = "";
        if(intent.hasExtra("candy_price"))
        candyPrice = intent.getStringExtra("candy_price");

        TextView textViewPrice = (TextView)this.findViewById(R.id.text_view_price);
        textViewPrice.setText(candyPrice);


        String candyDesc = "";
        if(intent.hasExtra("candy_desc"))
            candyDesc = intent.getStringExtra("candy_desc");

        TextView textViewDesc = (TextView)this.findViewById(R.id.text_view_desc);
        textViewDesc.setText(candyDesc);

        Log.d("DetailActivity", "Intent data: " + candyImage + ", " + candyPrice
        + ", " + candyDesc);

    }
}
