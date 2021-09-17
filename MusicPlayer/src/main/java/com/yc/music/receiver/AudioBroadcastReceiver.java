package com.yc.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.yc.music.config.MusicConstant;
import com.yc.music.service.PlayAudioService;
import com.yc.videotool.VideoLogUtils;


/**
 * 屏幕亮了，灭了，弹出锁屏页面逻辑
 * 其实这个跟通知处理逻辑一样
 */
public class AudioBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final String action = intent.getAction();
        if(action!=null && action.length()>0){
            switch (action){
                //锁屏时处理的逻辑
                case MusicConstant.LOCK_SCREEN_ACTION:
                    PlayAudioService.startCommand(context, MusicConstant.LOCK_SCREEN_ACTION);
                    VideoLogUtils.e("AudioBroadcastReceiver"+"---LOCK_SCREEN");
                    break;
                //当屏幕灭了
                case Intent.ACTION_SCREEN_OFF:
                    PlayAudioService.startCommand(context,Intent.ACTION_SCREEN_OFF);
                    VideoLogUtils.e("AudioBroadcastReceiver"+"---当屏幕灭了");
                    break;
                //当屏幕亮了
                case Intent.ACTION_SCREEN_ON:
                    PlayAudioService.startCommand(context,Intent.ACTION_SCREEN_ON);
                    VideoLogUtils.e("AudioBroadcastReceiver"+"---当屏幕亮了");
                    break;
                default:
                    break;
            }
        }
    }

}
