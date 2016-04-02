package android.com.sampleassignment;

import android.content.Intent;
import android.net.Uri;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.textView2);
    }

    public void locateAddress(View view) {
        Uri location = Uri.parse("geo:0,0?q=7718+Hanover+Pkwy,+Greenbelt,+MD");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);
        startActivity(mapIntent);

    }

    public void shareLink(View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, "sailu_chinni123@yahoo.co.in");
        intent.putExtra(Intent.EXTRA_TEXT, "Sailaja's Restaurant@Greenbelt" + textView.getText().toString());
        startActivity(Intent.createChooser(intent, "Share via"));
    }

    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "wake up")
                .putExtra(AlarmClock.EXTRA_HOUR, 18)
                .putExtra(AlarmClock.EXTRA_MINUTES, 40);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
