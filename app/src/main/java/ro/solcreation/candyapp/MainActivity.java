package ro.solcreation.candyapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.loopj.android.http.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {
    private Candy[] candies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        ImageView imageView = (ImageView)this.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.candy_coded_logo);

        final ArrayList<String> candy_list =  new ArrayList<String>();

        candy_list.add("Tropical Wave");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.list_item_candy,
                R.id.text_view_candy,
                candy_list);

        ListView listView = (ListView)this.findViewById(R.id.list_view_candy);
        listView.setAdapter(adapter);

        Context context = this;
        String text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(
                    AdapterView<?> adapterView, View view, int i, long l) {
                //Toast toast = Toast.makeText(MainActivity.this, ""+i, Toast.LENGTH_SHORT);
                //toast.show();
                Intent detailIntent = new Intent(MainActivity.this,
                                            DetailActivity.class);
                detailIntent.putExtra("cand_name", candies[i].name);
                detailIntent.putExtra("candy_image",candies[i].imageURL);
                detailIntent.putExtra("candy_price",candies[i].price);
                detailIntent.putExtra("candy_description",candies[i].description);
                startActivity(detailIntent);
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://courseware.codeschool.com/super_sweet_android_time/API/TinyBytes.json",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.d("AsyncHttpClient", "response =" + responseString);
                        Gson gson = new GsonBuilder().create();
                        Candy[] candies = gson.fromJson(responseString, Candy[].class);
                        adapter.clear();
                        for(Candy candy : candies) {
                            adapter.add(candy.name);
                        }
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                        Log.d("AsyncHttpClient", "response =" + responseString);
                    }
                });

    }
}
