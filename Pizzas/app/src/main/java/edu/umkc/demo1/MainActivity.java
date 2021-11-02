package edu.umkc.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int quantity=3;
    String userName;
    boolean hasPaneer, hasChicken, hasPepperoni;
    float totalPrice;
    int paneerPrice=2, chickenPrice=3, pepperoniPrice=3;
    Button orderBtn;
    String orderSummaryMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textView = (TextView) findViewById(R.id.quantity_text_view);
        textView.setText(String.valueOf(quantity));

    }

    public void sendEmail(View view) {

        submitOrder();
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"reddyv532@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "Pizza Ordering App's Order");
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(userName,hasPaneer,hasChicken,hasPepperoni,quantity,totalPrice));

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void submitOrder()
    {
        EditText userInputNameView = (EditText) findViewById(R.id.user_input);
        userName = userInputNameView.getText().toString();

        CheckBox paneer = (CheckBox) findViewById(R.id.Paneer_cb);
        hasPaneer = paneer.isChecked();

        CheckBox chicken = (CheckBox) findViewById(R.id.Chicken_cb);
        hasChicken = chicken.isChecked();

        CheckBox pepperoni = (CheckBox) findViewById(R.id.Pepperoni_cb);
        hasPepperoni = pepperoni.isChecked();

        totalPrice = calculatePrice(hasPaneer, hasChicken, hasPepperoni);
        orderSummaryMessage = createOrderSummary(userName,hasPaneer,hasChicken,hasPepperoni,quantity,totalPrice);
    }

    public void summaryfun(View view)
    {
        submitOrder();
        Intent redirect = new Intent(MainActivity.this, SummaryActivity.class);
        redirect.putExtra("MESSAGE", orderSummaryMessage);
        MainActivity.this.startActivity(redirect);
    }
    private String boolToString(boolean bool) {
        return bool ? (getString(R.string.yes)) : (getString(R.string.no));
    }

    private String createOrderSummary(String userInputName, boolean hasPaneer, boolean hasChicken,boolean hasPepperoni,int quantity, float price) {
        String orderSummaryMessage = getString(R.string.order_summary_name, userInputName) + "\n" +
                getString(R.string.order_summary_Paneer, boolToString(hasPaneer)) + "\n" +
                getString(R.string.order_summary_Chicken, boolToString(hasChicken)) + "\n" +
                getString(R.string.order_summary_Pepperoni, boolToString(hasPepperoni)) + "\n" +
                getString(R.string.order_summary_quantity, quantity) + "\n" +
                getString(R.string.order_summary_total_price, price) + "\n" +
                getString(R.string.thank_you);
        return orderSummaryMessage;
    }

    private float calculatePrice(boolean hasPaneer, boolean hasChicken, boolean hasPepperoni) {
        int basePrice = 10;
        if (hasPaneer) {
            basePrice += paneerPrice;
        }
        if (hasChicken) {
            basePrice += chickenPrice;
        }
        if (hasPepperoni) {
            basePrice += pepperoniPrice;
        }
        return quantity * basePrice;
    }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method increments the quantity of coffee cups by one
     *
     * @param view on passes the view that we are working with to the method
     */

    public void increment(View view) {
        if (quantity < 100) {
            quantity = quantity + 1;
            display(quantity);
        } else {
            Log.i("MainActivity", "Please select less than one hundred cups of coffee");
            Context context = getApplicationContext();
            String lowerLimitToast = getString(R.string.too_much_pizza);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, lowerLimitToast, duration);
            toast.show();
            return;
        }
    }

    /**
     * This method decrements the quantity of coffee cups by one
     *
     * @param view passes on the view that we are working with to the method
     */
    public void decrement(View view) {
        if (quantity > 1) {
            quantity = quantity - 1;
            display(quantity);
        } else {
            Log.i("MainActivity", "Please select atleast one cup of coffee");
            Context context = getApplicationContext();
            String upperLimitToast = getString(R.string.too_little_pizza);
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, upperLimitToast, duration);
            toast.show();
            return;
        }
    }
}