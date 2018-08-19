package com.example.saurav.delenstask;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.saurav.delenstask.model.Entity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OrderDetailsActivity extends AppCompatActivity {
    private static final String TAG = OrderDetailsActivity.class.getName();
    @BindView(R.id.TVODJobType)
    TextView TVODJobType;
    @BindView(R.id.TVODDeliveredDate)
    TextView TVODDeliveredDate;
    @BindView(R.id.TVODStatus)
    TextView TVODStatus;
    @BindView(R.id.TVODAddress)
    TextView TVODAddress;
    @BindView(R.id.imageView2)
    ImageView imageView2;
    @BindView(R.id.TVODPersonAssigned)
    TextView TVODPersonAssigned;
    @BindView(R.id.LLStatus)
    LinearLayout LLStatus;
    @BindView(R.id.TVODRate)
    TextView TVODRate;
    @BindView(R.id.TVODTax)
    TextView TVODTax;
    @BindView(R.id.TVODDiscount)
    TextView TVODDiscount;
    @BindView(R.id.TVODGrantTotalAmount)
    TextView TVODGrantTotalAmount;
    @BindView(R.id.TVODStartTime)
    TextView TVODStartTime;
    @BindView(R.id.TVODEndTime)
    TextView TVODEndTime;
    @BindView(R.id.TVODTotalTime)
    TextView TVODTotalTime;
    @BindView(R.id.TVODPaymentStatus)
    TextView TVODPaymentStatus;
    @BindView(R.id.TVODAmountAndDate)
    LinearLayout TVODAmountAndDate;
    @BindView(R.id.TVODJobDetailLabel)
    TextView TVODJobDetailLabel;
    @BindView(R.id.TVLabelJOb)
    TextView TVLabelJOb;
    @BindView(R.id.TVODServicesFor)
    TextView TVODServicesFor;
    @BindView(R.id.TVODLabelServiceFor)
    LinearLayout TVODLabelServiceFor;
    @BindView(R.id.TVODServicePlace)
    TextView TVODServicePlace;
    @BindView(R.id.LLODLabelServicePlace)
    LinearLayout LLODLabelServicePlace;
    @BindView(R.id.button)
    Button button;

    private Entity entity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            entity = (Entity) extras.getSerializable("Entity");
            this.setTitle(entity.getId());
        }
        intiliseAllTextView();
    }

    private void intiliseAllTextView() {
        if (entity != null) {
            TVODJobType.setText(entity.getJob_type());
            TVODAddress.setText(entity.getAdress());
            TVODDeliveredDate.setText(entity.getDelivered_date());
            TVODStatus.setText(entity.getStatus());
            TVODPersonAssigned.setText(entity.getPerson_assigned());

            TVODRate.setText(entity.getRate());
            TVODTax.setText(entity.getTax());

            TVODDiscount.setText(entity.getDiscount());
            TVODStartTime.setText(entity.getStart_time());
            TVODEndTime.setText(entity.getEnd_time());
            TVODPaymentStatus.setText(entity.getPayment_status());

            TVODServicesFor.setText(entity.getServices_for());
            TVODServicePlace.setText(entity.getService_place());


        } else {
            Log.i(TAG, "intiliseAllTextView: +Error in getting Entity from adapter");
        }
    }

    @OnClick(R.id.button)
    public void onViewClicked() {
        Toast.makeText(this, "TODO next", Toast.LENGTH_SHORT).show();
    }
}
