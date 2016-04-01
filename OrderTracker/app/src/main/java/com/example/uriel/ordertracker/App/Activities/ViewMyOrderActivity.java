package com.example.uriel.ordertracker.App.Activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.uriel.ordertracker.App.Model.Helpers;
import com.example.uriel.ordertracker.App.Model.Order;
import com.example.uriel.ordertracker.App.Model.OrderLine;
import com.example.uriel.ordertracker.App.Model.User;
import com.example.uriel.ordertracker.App.Services.Impl.ClientService;
import com.example.uriel.ordertracker.App.Services.Impl.ProductService;
import com.example.uriel.ordertracker.App.Services.Impl.UserService;
import com.example.uriel.ordertracker.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class ViewMyOrderActivity extends DrawerActivity {

    HashMap<Integer, String> order;
    int clientId;
    int userId;
    double total;
    Button confirmarButton;
    private UserService userService;
    private ClientService clientService;
    private ProductService productService;
    final Activity context = this;
    private boolean blockBackKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_my_order);
        userService = new UserService();
        clientService = new ClientService();
        productService = new ProductService();
        blockBackKey = false;

        setTitle("Su pedido");
        configDrawerAfterCreate(savedInstanceState);

        Intent intent = getIntent();
        userId = intent.getExtras().getInt("userId");
        order = (HashMap<Integer, String>)intent.getSerializableExtra("order");
        total = intent.getExtras().getDouble("total");
        clientId = intent.getExtras().getInt("clientId");

        confirmarButton = (Button)findViewById(R.id.confirmarButton);
        if(order.size() == 0){
            confirmarButton.setEnabled(false);
        }

        TextView totalText = (TextView) findViewById(R.id.totalText);
        totalText.setText("Total: $" + String.format("%.2f", total));

        //add header
        TableLayout table = (TableLayout) findViewById(R.id.orderTable);
        TableRow header = createHeader();
        table.addView(header, new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        Iterator iterator = order.keySet().iterator();
        while(iterator.hasNext()) {
            int key = (int)iterator.next();
            String value = order.get(key);
            TableRow row = createRow(value);
            table.addView(row, new TableLayout.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        }

        table.setColumnStretchable(0, true);
        table.setColumnStretchable(4, true);
        table.setColumnStretchable(6, true);
        table.setColumnShrinkable(2, true);
    }

    public TableRow createHeader(){
        TableRow header = new TableRow(this);
        header.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        header.setBackgroundColor(Color.LTGRAY);

        TextView headerQuantity = new TextView(this);
        headerQuantity.setText("Cant");
        headerQuantity.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        headerQuantity.setTextSize(25);
        headerQuantity.setLines(1);

        TextView headerDescripcion = new TextView(this);
        headerDescripcion.setText("Producto");
        headerDescripcion.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        headerDescripcion.setTextSize(25);
        headerDescripcion.setLines(1);

        TextView headerPrice = new TextView(this);
        headerPrice.setText("P. Unit.");
        headerPrice.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        headerPrice.setTextSize(25);
        headerPrice.setLines(1);

        TextView headerTotal = new TextView(this);
        headerTotal.setText("Total");
        headerTotal.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        headerTotal.setTextSize(25);
        headerTotal.setLines(1);

            /* Add Texts to row. */
        header.addView(headerQuantity);
        header.addView(createDivider());
        header.addView(headerDescripcion);
        header.addView(createDivider());
        header.addView(headerPrice);
        header.addView(createDivider());
        header.addView(headerTotal);

        return header;
    }

    public TableRow createRow(String product){
        TableRow tr = new TableRow(this);
        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        TextView qttText = new TextView(this);
        qttText.setText(product.split("&")[1]);
        qttText.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        qttText.setTextSize(25);

        TextView descriptionText = new TextView(this);
        descriptionText.setText(product.split("&")[0]);
        descriptionText.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        descriptionText.setTextSize(25);

        TextView priceText = new TextView(this);
        priceText.setText("$" + product.split("&")[2]);
        priceText.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        priceText.setTextSize(25);

        TextView totalText = new TextView(this);
        totalText.setText("$" + String.format("%.2f", Integer.valueOf(product.split("&")[1]) * Double.valueOf(product.split("&")[2])));
        totalText.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        totalText.setTextSize(25);

            /* Add Texts to row. */
        tr.addView(qttText);
        tr.addView(createDivider());
        tr.addView(descriptionText);
        tr.addView(createDivider());
        tr.addView(priceText);
        tr.addView(createDivider());
        tr.addView(totalText);

        return tr;
    }

    public void ConfirmarPedido(View v){
        SweetAlertDialog dialog = Helpers.getConfirmationDialog(this, "Confirmar pedido", "Esta seguro que desea confirmar el pedido?", "Aceptar", "Cancelar");
        dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                Confirmar();
                sweetAlertDialog.cancel();
            }
        });

        dialog.show();
    }

    public void Confirmar(){
        //agregar registro de pedido
        try{
            User seller = userService.getById(userId);
            Order order = new Order(0, clientService.getById(clientId), Calendar.getInstance().getTime(), total, seller, new ArrayList<OrderLine>());

            SweetAlertDialog dialog = Helpers.getSuccesDialog(this, "Pedido", "El pedido se almaceno con exito");

            dialog.setCancelable(false);
            dialog.setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                @Override
                public void onClick(SweetAlertDialog sweetAlertDialog) {
                    blockBackKey = false;
                    Intent intent = new Intent(context, DiaryActivity.class);
                    intent.putExtra("userId", userId);
                    startActivity(intent);
                    sweetAlertDialog.cancel();
                }
            });

            dialog.show();

        }catch(Exception e){
            SweetAlertDialog dialog = Helpers.getErrorDialog(this, "Error", "No se pudo almacenar el pedido, intente nuevamente");
            dialog.show();
        }
    }

    public TextView createDivider(){
        TextView divider = new TextView(this);
        divider.setBackgroundColor(Color.BLACK);
        divider.setLayoutParams(new TableRow.LayoutParams(2, TableRow.LayoutParams.MATCH_PARENT));

        return divider;
    }

    @Override
    public void onBackPressed() {
        if(blockBackKey){
            return;
        }
        super.onBackPressed();
    }
}
