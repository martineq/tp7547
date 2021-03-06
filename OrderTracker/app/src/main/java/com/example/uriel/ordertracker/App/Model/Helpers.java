package com.example.uriel.ordertracker.App.Model;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.TextView;

import com.example.uriel.ordertracker.App.Services.Impl.RestService;
import com.example.uriel.ordertracker.App.Services.Interface.IRestService;
import com.example.uriel.ordertracker.R;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;

import org.json.JSONException;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * Created by Uriel on 14-Feb-16.
 */
public class Helpers {

    public static SweetAlertDialog getSuccesDialog(Activity context, String title, String content){
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText(title)
                .setContentText(content);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                SweetAlertDialog alertDialog = (SweetAlertDialog) dialog;
                TextView text = (TextView) alertDialog.findViewById(R.id.title_text);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView content = (TextView) alertDialog.findViewById(R.id.content_text);
                content.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView confirm = (TextView) alertDialog.findViewById(R.id.confirm_button);
                confirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            }
        });

        return dialog;
    }

    public static SweetAlertDialog getErrorDialog(Activity context, String title, String content){
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.ERROR_TYPE)
                .setTitleText(title)
                .setContentText(content);

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                SweetAlertDialog alertDialog = (SweetAlertDialog) dialog;
                TextView text = (TextView) alertDialog.findViewById(R.id.title_text);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView content = (TextView) alertDialog.findViewById(R.id.content_text);
                content.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView confirm = (TextView) alertDialog.findViewById(R.id.confirm_button);
                confirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            }
        });

        return dialog;
    }

    public static SweetAlertDialog getConfirmationDialog(Activity context, String title, String content, String confirmText, String cancelText){
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(content)
                .setCancelText(cancelText)
                .setConfirmText(confirmText)
                .showCancelButton(true);

        dialog.setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
            @Override
            public void onClick(SweetAlertDialog sweetAlertDialog) {
                sweetAlertDialog.cancel();
            }
        });

        dialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                SweetAlertDialog alertDialog = (SweetAlertDialog) dialog;
                TextView text = (TextView) alertDialog.findViewById(R.id.title_text);
                text.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView content = (TextView) alertDialog.findViewById(R.id.content_text);
                content.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView confirm = (TextView) alertDialog.findViewById(R.id.confirm_button);
                confirm.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
                TextView cancel = (TextView) alertDialog.findViewById(R.id.cancel_button);
                cancel.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
            }
        });

        return dialog;
    }

    public static SweetAlertDialog getProgessDialog(Activity context, String title){
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
        dialog.getProgressHelper().setBarColor(Color.parseColor("#A5DC86"));
        dialog.setTitleText(title);
        dialog.setCancelable(false);

        return dialog;
    }

    public static SweetAlertDialog getBasicDialog(Activity context, String title, String content){
        SweetAlertDialog dialog = new SweetAlertDialog(context);
        dialog.setTitleText(title);
        dialog.setContentText(content);

        return dialog;
    }

    public static String ObtenerRegistrationTokenEnGcm(Context context) throws  Exception
    {
        InstanceID instanceID = InstanceID.getInstance(context);
        String token = instanceID.getToken("503700765257", GoogleCloudMessaging.INSTANCE_ID_SCOPE, null);

        return token;
    }

    public static void RegistrarseEnAplicacionServidor(Context context,String registrationToken, String username, String token) throws  Exception
    {
        try {
            IRestService restService = new RestService();
            restService.registerGcmToken(username, token, registrationToken, context);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
