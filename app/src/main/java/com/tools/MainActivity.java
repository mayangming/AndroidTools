package com.tools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import com.tools.dialog.OpenGiftDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showOpenGift("10.00",true);
    }
    /**
     * 打开中奖的dialog
     * @param amount 中奖金额
     * @param isLuck 是否中奖
     */
    private void showOpenGift(String amount,boolean isLuck){
        OpenGiftDialog openGiftDialog = new OpenGiftDialog();
        Bundle bundle = new Bundle();
        bundle.putString(OpenGiftDialog.ACTION_AMOUNT,amount);
        if (isLuck){
            bundle.putInt(OpenGiftDialog.ACTION_TYPE,OpenGiftDialog.LUCK);
        }else {
            bundle.putInt(OpenGiftDialog.ACTION_TYPE,OpenGiftDialog.NO_LUCK);
        }
        openGiftDialog.setArguments(bundle);
        openGiftDialog.setStyle(DialogFragment.STYLE_NO_FRAME,R.style.MyMinDialogWidth);
        openGiftDialog.show(getSupportFragmentManager(),"对话框");
    }
}
