package com.prakruthi.ui.ui.profile.myorders;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.prakruthi.R;
import com.prakruthi.ui.APIs.MyOrders;
import com.prakruthi.ui.HomeActivity;
import com.prakruthi.ui.Variables;
import com.prakruthi.ui.ui.productPage.ProductPage;
import com.prakruthi.ui.ui.profile.order_qty.OrderQtyActivity;
import com.saadahmedsoft.popupdialog.PopupDialog;
import com.saadahmedsoft.popupdialog.Styles;
import com.saadahmedsoft.popupdialog.listener.OnDialogButtonClickListener;

import java.util.ArrayList;

public class MyOrdersActivity extends AppCompatActivity implements MyOrders.OnProfileMyOrdersApiHitFetchedListener {

    String cart_id;
    ShimmerRecyclerView my_orders_recyclerview_List;

    AppCompatButton myOrders_back_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        myOrders_back_btn = findViewById(R.id.myOrders_back_btn);

//        myOrders_back_btn.setOnClickListener(v -> super.onBackPressed());
        myOrders_back_btn.setOnClickListener(v -> super.onBackPressed());

        cart_id= getIntent().getStringExtra("cart_id");

        my_orders_recyclerview_List = findViewById(R.id.my_orders_recyclerview_List);


        SetViews();
        CallApi();


    }

    public void CallApi()
    {
        MyOrders myOrders = new MyOrders(this);
        myOrders.HitAPi();
        my_orders_recyclerview_List.showShimmerAdapter();
    }
    public void SetViews()
    {
        my_orders_recyclerview_List = findViewById(R.id.my_orders_recyclerview_List);
    }
    @Override
    public void OnProfileItemMyOrders(ArrayList<MyOrdersModal> myOrdersModals) {
        runOnUiThread( () -> {
            my_orders_recyclerview_List.hideShimmerAdapter();
            my_orders_recyclerview_List.setLayoutManager(new LinearLayoutManager(this));
            my_orders_recyclerview_List.setAdapter(new MyOrdersAdaptor(myOrdersModals));
        } );
    }

    @Override
    public void OnProfileItemMyOrdersAPiGivesError(String error) {
        runOnUiThread( () -> {
            my_orders_recyclerview_List.hideShimmerAdapter();
            PopupDialog.getInstance(this)
                    .setStyle(Styles.ALERT)
                    .setDismissButtonBackground(R.color.Primary)
                    .setHeading("Uh-Oh")
                    .setDescription("There Are No Orders"+
                            " In Your Account.")
                    .setCancelable(false)
                    .showDialog(new OnDialogButtonClickListener() {
                        @Override
                        public void onDismissClicked(Dialog dialog) {
                            super.onDismissClicked(dialog);
                        }
                    });
        } );
    }
}