package com.tools.notification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.tools.MainActivity;
import com.tools.R;
import com.tools.ToolsApplication;

import java.util.ArrayList;
import java.util.List;

/** 通知工具类
 * 示例代码如下：
 * NotificationUtil.showDefaultNotification(message);
 *
 * */
public class NotificationUtil{

    /**
     * momoren默认的通知消息
     * @param content 消息内容
     */
    public static void showDefaultNotification(String content){
        NotificationUtil notificationUtil = new NotificationUtil();
        NotificationUtil.NotificationUtilBuild notificationUtilBuild = notificationUtil.createBuild();
        notificationUtilBuild.context = ToolsApplication.getInstance();
        notificationUtilBuild.title = "斗圈";
        notificationUtilBuild.content = content;
//        过滤器，根据情况对通知进行拦截，判断通知是否显示
//        notificationUtilBuild.addNotificationFilter(new DefaultNotificationFilter());
        notificationUtil.showNotification(notificationUtilBuild);
    }

    public void showNotification(NotificationUtilBuild build) {
        if (null == build){
            throw new RuntimeException("NotificationUtilBuild 不能为空");
        }

        for (NotificationFilter filter : build.filterList){
            if (filter.filter()){
                return;
            }
        }

        NotificationManager notificationManager =
                (NotificationManager) build.context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;//5.0以上会显示横幅
            //注意Name和description不能为null或者""
            NotificationChannel mChannel = new NotificationChannel(build.channelId, build.channelName, importance);
            // 配置通知渠道的属性
            mChannel.setDescription(build.description);
            notificationManager.createNotificationChannel(mChannel);
        }

        Intent notifyIntent = new Intent(build.context, MainActivity.class);
        PendingIntent notifyPendingIntent =
                PendingIntent.getActivity(
                        build.context,
                        1,
                        notifyIntent,
                        PendingIntent.FLAG_CANCEL_CURRENT
                );

        NotificationCompat.Builder notificationCompatBuilder = new NotificationCompat.Builder( build.context, build.channelId);
        notificationCompatBuilder.setAutoCancel(true);
        notificationCompatBuilder.setContentTitle(build.title);
        notificationCompatBuilder.setContentText(build.content);
        notificationCompatBuilder.setSmallIcon(R.mipmap.ic_launcher);
        notificationCompatBuilder.setContentIntent(notifyPendingIntent);
        notificationCompatBuilder.setPriority(NotificationManagerCompat.IMPORTANCE_HIGH);
        notificationCompatBuilder.setVisibility(NotificationCompat.VISIBILITY_PUBLIC);
        Notification notification = notificationCompatBuilder.build();
        notificationManager.notify(build.notificationId, notification);
    }

    public NotificationUtilBuild createBuild(){
        return new NotificationUtilBuild();
    }

    /** 通知工具类的Build */
    public class NotificationUtilBuild{
        public int notificationId = 1;
        public String notificationTag = "chat";
        public Context context;
        public String title = "";
        public String content = "";
        public String time = "";
        public String channelId = "chat";
        public String channelName = "聊天";
        public String description = "聊天通知";
//        public NotificationFilter filter = new DefaultNotificationFilter();//拦截器
        private List<NotificationFilter> filterList = new ArrayList<>();//拦截器集合
        public void addNotificationFilter(NotificationFilter filter){
            filterList.add(filter);
        }

    }

}