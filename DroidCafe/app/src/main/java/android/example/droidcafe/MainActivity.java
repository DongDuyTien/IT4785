package android.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "android.example.droidcafe.extra.MESSAGE";
    ImageView donutImgView = null;
    ImageView iceImgView = null;
    ImageView froyoImgView = null;
    FloatingActionButton floatingActionButton = null;
    String mOrderMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImgView = findViewById(R.id.donut);
        donutImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.donut_order_message);
                Toast.makeText(MainActivity.this, mOrderMessage, Toast.LENGTH_LONG).show();
            }
        });

        iceImgView = findViewById(R.id.ice_cream);
        iceImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.ice_cream_order_message);
                Toast.makeText(MainActivity.this, mOrderMessage, Toast.LENGTH_LONG).show();
            }
        });

        froyoImgView = findViewById(R.id.froyo);
        froyoImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOrderMessage = getString(R.string.froyo_order_message);
                Toast.makeText(MainActivity.this, mOrderMessage, Toast.LENGTH_LONG).show();
            }
        });

        floatingActionButton = findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Your ordered something", Toast.LENGTH_LONG).show();
                Intent orderIntent = new Intent(MainActivity.this, OrderActivity.class);
                orderIntent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(orderIntent);
            }
        });
    }
}