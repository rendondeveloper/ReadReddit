package com.example.rendondev.readreddit.ReadRedditMvp.Util;

import android.app.Activity;
import android.app.Dialog;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.rendondev.readreddit.R;

public class DialogApp {

    final Activity activity;
    private Dialog dialogGeneral;

    public DialogApp(final Activity activity) {
        this.activity = activity;
    }

    private Dialog buildDialog(final int layout) {
        final Dialog dialog = new Dialog(this.activity, android.R.style.Theme_Translucent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.background_dialog);
        dialog.setContentView(layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(true);
        return dialog;
    }

    public void General(final String title,
                        final String message,
                        final DialogCallBack callBack) {
        if (this.dialogGeneral == null) {
            this.dialogGeneral = this.buildDialog(R.layout.dialog);
        }
        ((TextView) dialogGeneral.findViewById(R.id.tvTitle)).setText(title);
        ((TextView) dialogGeneral.findViewById(R.id.tvMessage)).setText(message);
        ((Button) dialogGeneral.findViewById(R.id.btnAction)).setText(this.activity.getString(R.string.text_default));
        dialogGeneral.findViewById(R.id.btnAction).setOnClickListener(v -> {
            dialogGeneral.dismiss();
            if (callBack != null) callBack.Execute(0);
        });
        dialogGeneral.show();
    }
}
