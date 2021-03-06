package com.example.uriel.ordertracker.App.Model;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.uriel.ordertracker.App.Activities.OrderActivity;
import com.example.uriel.ordertracker.R;

import java.util.ArrayList;
import java.util.HashMap;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Uriel on 06-Jan-16.
 */
public class GridAdapter extends ArrayAdapter<Product>{

    private Activity context;
    private final ArrayList<Product> products;
    private final HashMap<Integer, String> order;
    private boolean readOnly;

    public GridAdapter(Activity c, ArrayList<Product> products, HashMap<Integer, String> order, boolean readOnly) {
        super(c, R.layout.grid_item, products);
        context = c;
        this.products = products;
        this.order = order;
        this.readOnly = readOnly;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Product getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return products.get(position).getId();
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View gridItem;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridItem = inflater.inflate(R.layout.grid_item, null);
        } else {
            gridItem = (View) convertView;
        }

        TextView idText = (TextView) gridItem.findViewById(R.id.idText);
        TextView descripcionText = (TextView) gridItem.findViewById(R.id.descripcionText);
        TextView brandText = (TextView) gridItem.findViewById(R.id.brandText);
        TextView priceText = (TextView) gridItem.findViewById(R.id.priceText);
        final ImageView imageView = (ImageView) gridItem.findViewById(R.id.itemImage);
        EditText qttText = (EditText) gridItem.findViewById(R.id.quantityText);
        final ImageView discountImage = (ImageView) gridItem.findViewById(R.id.discountImage);
        idText.setText(String.valueOf(products.get(position).getId()));
        descripcionText.setText(products.get(position).getDescription());
        brandText.setText(products.get(position).getBrand());
        priceText.setText("$" + String.format("%.2f", products.get(position).getPrice()));

        if (readOnly) {
            qttText.setVisibility(View.INVISIBLE);
        }

        if (order.get(products.get(position).getId()) != null) {
            qttText.setText(order.get(products.get(position).getId()).split("&")[1]);
        }

        imageView.setImageBitmap(Product.decodeBase64(products.get(position).getImageBase64()));

        final Bitmap bitmap = Product.decodeBase64(products.get(position).getImageBase64());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((OrderActivity) context).zoomImageFromThumb(imageView, bitmap);
            }
        });

        if(!products.get(position).hasDiscounts()){
            discountImage.setVisibility(View.INVISIBLE);
        }

        gridItem.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (products.get(position).hasDiscounts()) {
                    ArrayList<Discount> discounts = products.get(position).getDiscounts();
                    String content = "";
                    for (Discount discount : discounts) {
                        String rangeTo = "sin limite";
                        if (discount.getRangeTo() > 0) {
                            rangeTo = String.valueOf(discount.getRangeTo());
                        }
                        content += "Desde " + String.valueOf(discount.getRangeFrom()) + " a " + rangeTo + ": %" + String.valueOf(discount.getPercentage()) + "\n";
                    }

                    SweetAlertDialog dialog = Helpers.getBasicDialog(context, "Descuentos", content);
                    dialog.show();
                }

                return true;
            }
        });

        return gridItem;
    }
}
