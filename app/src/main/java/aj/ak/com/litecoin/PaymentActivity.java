package aj.ak.com.litecoin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.startapp.android.publish.adsCommon.StartAppSDK;

public class PaymentActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    FirebaseDatabase database;
    private DatabaseReference mDatabase;
    FirebaseUser u;
    TextView payment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StartAppSDK.init(this, "202580835", false);
        setContentView(R.layout.activity_payment);

        mAuth = FirebaseAuth.getInstance();

        if (mAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
        }
        u = mAuth.getCurrentUser();
        database = FirebaseDatabase.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
        payment = findViewById(R.id.payment);
        payment.setMovementMethod(LinkMovementMethod.getInstance());


        ReadUserData();
    }

    public void ReadUserData(){
        ValueEventListener userListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Users user =      dataSnapshot.child("WInner").child(u.getUid()).getValue(Users.class);
                if (user!=null&&user.name!=""){
                    payment.setText(Html.fromHtml( "<a herf ="+"<font color='#000'>"+"<b>" +user.name+"</b>"+"</font>"+"</a>"));


                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(getApplication(),databaseError.getMessage(),Toast.LENGTH_LONG).show();
            }

        };
        mDatabase.addValueEventListener(userListener);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.back, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.close:
                finish();
                startActivity(new Intent(this, MainActivity.class));
                break;

        }
        return true;
    }


}
