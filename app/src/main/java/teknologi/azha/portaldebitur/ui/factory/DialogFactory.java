package teknologi.azha.portaldebitur.ui.factory;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.Window;

import teknologi.azha.portaldebitur.R;

/**
 * Created by user on 29/08/2017.
 */

public class DialogFactory {

    private static ProgressDialog progressDialog;
    private static Dialog dialog;

    public static void showProgress(Context context, String message) {
        dismissProgress();
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
    }


    public static void showAlert(Context context, String msg) {
        showAlert(context,msg,null);
    }

    public static void showAlert(Context context, String msg, final DialogInterface.OnDismissListener closeListener) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(context.getString(R.string.app_name))
                .setMessage(msg)
                .setPositiveButton(context.getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        dialog.dismiss();
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                    }
                })
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                    }
                })
                .create();

        dialog.show();
    }

    public static void showConfirmation(Context context, String title, String message, final DialogInterface.OnClickListener onOKListener, final DialogInterface.OnDismissListener closeListener) {
        AlertDialog confirmDialog = new AlertDialog.Builder(context)
                .setTitle(TextUtils.isEmpty(title) ? context.getString(R.string.app_name) : title)
                .setMessage(message)
                .setPositiveButton(context.getString(R.string.btn_ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        if (onOKListener != null) {
                            onOKListener.onClick(dialog, whichButton);
                        }
                        dialog.dismiss();
                    }
                })
                .setNegativeButton(context.getString(R.string.btn_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                        dialog.dismiss();
                    }
                })
                .setCancelable(true)
                .setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialog) {
                        if (closeListener != null) {
                            closeListener.onDismiss(dialog);
                        }
                    }
                })
                .create();
        confirmDialog.show();
    }

    public static void showProgress(Context context) {
        dismissProgress();

        dialog = new Dialog(context);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_progressbar);
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.show();
    }

    public static void dismissProgress() {
        try {
            if (progressDialog != null && progressDialog.isShowing()) {
                progressDialog.dismiss();
            }
        }catch (Exception e) {}

        try {
            if (dialog != null && dialog.isShowing()) {
                dialog.dismiss();
            }
        }catch (Exception e) {}
    }


}
