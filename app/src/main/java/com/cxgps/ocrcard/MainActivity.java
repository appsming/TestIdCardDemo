package com.cxgps.ocrcard;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.cxgps.ocrcard.txocr.CaptureActivity;
import com.cxgps.ocrcard.txocr.bean.DriverCardInfo;
import com.cxgps.ocrcard.txocr.bean.IdCardInfo;
import com.cxgps.ocrcard.txocr.common.CardType;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{

    public static final String TAG = MainActivity.class.getName();


    private Button  idCardZheng;

    private Button  idCardBei;

    private Button  driverBook;

    private ImageView imageResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private  void initView(){

        idCardZheng = (Button) findViewById(R.id.idcard_zheng);

        idCardBei  = (Button) findViewById(R.id.idcard_bei);

        driverBook = (Button) findViewById(R.id.driver_book);

        imageResult = (ImageView) findViewById(R.id.image_result);

        imageResult.setVisibility(View.GONE);


        idCardZheng.setOnClickListener(this);
        idCardBei.setOnClickListener(this);
        driverBook.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        String dirPath = Environment.getExternalStorageDirectory() + "/images";
        switch (view.getId()){

            case R.id.idcard_zheng:

                Log.i(TAG,"=======idcard_zheng========");
                CaptureActivity.startAction(this, CardType.TYPE_ID_CARD_FRONT,dirPath, 1);
                break;

            case R.id.idcard_bei:
                CaptureActivity.startAction(this, CardType.TYPE_ID_CARD_BACK,dirPath, 0);
                Log.i(TAG,"=====idcard_bei==========");
                break;
            case R.id.driver_book:
                CaptureActivity.startAction(this, CardType.TYPE_DRIVER,dirPath, 2);
                Log.i(TAG,"=======driver_book========");
                break;
        }

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            imageResult.setVisibility(View.GONE);
            if (requestCode == 0) {
                IdCardInfo info = (IdCardInfo)data.getSerializableExtra(CaptureActivity.BUNDLE_DATA);
                if (!TextUtils.isEmpty(info.getImageUrl())) {
                    imageResult.setVisibility(View.VISIBLE);
                    imageResult.setImageBitmap(BitmapFactory.decodeFile(info.getImageUrl()));
                }

            } else if (requestCode == 1){
                IdCardInfo info = (IdCardInfo)data.getSerializableExtra(CaptureActivity.BUNDLE_DATA);
                if (!TextUtils.isEmpty(info.getImageUrl())) {
                    imageResult.setVisibility(View.VISIBLE);
                    imageResult.setImageBitmap(BitmapFactory.decodeFile(info.getImageUrl()));
                }
            } else {
                DriverCardInfo info = (DriverCardInfo)data.getSerializableExtra(CaptureActivity.BUNDLE_DATA);
                imageResult.setVisibility(View.VISIBLE);
                imageResult.setImageBitmap(BitmapFactory.decodeFile(info.getImageUrl()));
            }
        }



    }
}
