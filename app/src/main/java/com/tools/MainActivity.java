package com.tools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import com.tools.dialog.OpenGiftDialog;
import com.ywl5320.wlmedia.WlMedia;
import com.ywl5320.wlmedia.enums.WlCodecType;
import com.ywl5320.wlmedia.enums.WlPlayModel;
import com.ywl5320.wlmedia.listener.WlOnPreparedListener;
import com.ywl5320.wlmedia.listener.WlOnVideoViewListener;
import com.ywl5320.wlmedia.surface.WlTextureView;

public class MainActivity extends AppCompatActivity {
    private WlTextureView wlTextureView;
    private  WlMedia wlMedia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        showOpenGift("10.00",true);
        wlTextureView = findViewById(R.id.wlTextureView);
        getVideoPath();
        startVideo();
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
    private void getVideoPath(){
        String url = Environment.getRootDirectory().getAbsolutePath();
        Log.e("YM","源路径："+url);
    }
    private void startVideo(){
        wlMedia = new WlMedia();//创建一个播放实例
        wlMedia.setCodecType(WlCodecType.CODEC_SOFT);
        wlMedia.setPlayModel(WlPlayModel.PLAYMODEL_AUDIO_VIDEO);//同时播放音频视频
        wlTextureView.setWlMedia(wlMedia);//给视频surface设置播放器

        //异步准备完成后开始播放
        wlMedia.setOnPreparedListener(new WlOnPreparedListener() {
            @Override
            public void onPrepared() {
                wlMedia.start();//开始播放
            }
        });
        //surface初始化好了后 开始播放视频（用于一打开activity就播放场景）
        wlTextureView.setOnVideoViewListener(new WlOnVideoViewListener() {
            @Override
            public void initSuccess() {
                String url = Environment.getExternalStorageDirectory().getAbsolutePath()+"/t2c0g13772.mp4";
                wlMedia.setSource(url);//设置数据源
                wlMedia.prepared();//异步开始准备播放
            }

            @Override
            public void moveSlide(double value) {

            }

            @Override
            public void movdFinish(double value) {
                wlMedia.seek(value);//seek
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        wlMedia.setClearLastPicture(true);
        wlMedia.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(wlMedia != null)
        {
            wlMedia.release();
        }
    }
}
