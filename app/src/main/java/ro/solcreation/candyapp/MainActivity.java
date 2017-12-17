package ro.solcreation.candyapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)this.findViewById(R.id.text_view_title);
        textView.setText(R.string.products_title);

        ImageView imageView = (ImageView)this.findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.candy_coded_logo);

        ArrayList<String> candy_list =  new ArrayList<String>();

        candy_list.add("Tropical Wave");
        candy_list.add("Berry Bouncer");
        candy_list.add("Grape Gummer");
        candy_list.add("Apple of My Eye");
        candy_list.add("Roygbiv Spinner");
        candy_list.add("Roygbiv Spinner2");
        candy_list.add("Roygbiv Spinner3");
        candy_list.add("Roygbiv Spinner4");
        candy_list.add("Roygbiv Spinner5");
        candy_list.add("Roygbiv Spinner6");
        candy_list.add("Roygbiv Spinner7");
        candy_list.add("Roygbiv Spinner8");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
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
    }
}
