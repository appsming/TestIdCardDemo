package com.cxgps.ocrcard.txocr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxgps.ocrcard.R;
import com.cxgps.ocrcard.txocr.base.BaseCaptureActivity;
import com.cxgps.ocrcard.txocr.common.CardType;


/**
 * 识别身份证照相机
 */

public class CaptureActivity extends BaseCaptureActivity {

    /**
     * @param context
     * @param type such as CardType.TYPE_ID_CARD_FRONT
     * @param requestCode
     */
    public static void startAction(Activity context, CardType type, int requestCode) {
        Intent intent = new Intent(context, CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(CARD_TYPE, type);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * @param context
     * @param type such as CardType.TYPE_ID_CARD_FRONT
     * @param requestCode
     * @param titleId
     */
    public static void startAction(Activity context, CardType type, @StringRes int titleId, int requestCode) {
        Intent intent = new Intent(context, CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(CARD_TYPE, type);
        bundle.putInt(TITLE, titleId);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * @param context
     * @param type such as CardType.TYPE_ID_CARD_FRONT
     * @param requestCode
     * @param url 保存截图文件夹路径
     */
    public static void startAction(Activity context, CardType type, String url, int requestCode) {
        Intent intent = new Intent(context, CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(CARD_TYPE, type);
        bundle.putString(URL, url);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }

    /**
     * @param context
     * @param type such as CardType.TYPE_ID_CARD_FRONT
     * @param requestCode
     * @param titleId
     * @param url 保存截图文件夹路径
     */
    public static void startAction(Activity context, CardType type, @StringRes int titleId, String url, int requestCode) {
        Intent intent = new Intent(context, CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(CARD_TYPE, type);
        bundle.putInt(TITLE, titleId);
        bundle.putString(URL, url);
        intent.putExtras(bundle);
        context.startActivityForResult(intent, requestCode);
    }


    @Override
    public int getLayoutId() {
        return R.layout.layout_coustom;
    }

    @Override
    public void initCustomView() {
        final ImageView imageBack = (ImageView) findViewById(R.id.image_back);
        final View btnTakePicture = findViewById(R.id.btn_take_picture);
        TextView txtTitle = (TextView)findViewById(R.id.txt_title);
        if (title == 0) {
            int titleResourceId;
            if (cartType == CardType.TYPE_BANK) {
                titleResourceId = R.string.txt_bank_card_title;
            } else if (cartType == CardType.TYPE_ID_CARD_FRONT) {
                titleResourceId = R.string.txt_id_card_title;
            } else if(cartType == CardType.TYPE_DRIVER){
                titleResourceId = R.string.txt_driver_card_title;

            } else if(cartType == CardType.TYPE_DRIVER_RUN){

                titleResourceId = R.string.txt_driver_run_card_title;

            }else {
                titleResourceId = R.string.txt_id_card_title2;
            }
            txtTitle.setText(titleResourceId);
        } else {
            txtTitle.setText(title);
        }
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v == imageBack) {
                    finish();
                } else if (v == btnTakePicture) {
                    identification();
                }
            }
        };
        imageBack.setOnClickListener(listener);
        btnTakePicture.setOnClickListener(listener);
    }
}
