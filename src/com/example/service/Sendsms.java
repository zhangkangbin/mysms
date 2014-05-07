package com.example.service;


import com.example.sms_app.R;
import com.example.sms_app.home;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.util.Log;

public class Sendsms  extends Service{


	public IBinder onBind(Intent arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		Log.i("ta", "...................");
		super.onStart(intent, startId);
		addNotificaction();
	}
	/*
	 * Delete all SMS one by one
	 */
	private void addNotificaction() {  
		NotificationManager manager = (NotificationManager) this  
				.getSystemService(Context.NOTIFICATION_SERVICE);  
		// ����һ��Notification  
		Notification notification = new Notification();  
		// ������ʾ���ֻ����ϱߵ�״̬����ͼ��  
		notification.icon = R.drawable.ic_launcher1; 
		// ����ǰ��notification���ŵ�״̬���ϵ�ʱ����ʾ����  
		notification.tickerText = "���ŷ��ͳɹ�..";  

		/*** 
		 * notification.contentIntent:һ��PendingIntent���󣬵��û������״̬���ϵ�ͼ��ʱ����Intent�ᱻ���� 
		 * notification.contentView:���ǿ��Բ���״̬����ͼ����Ƿ�һ��view 
		 * notification.deleteIntent ����ǰnotification���Ƴ�ʱִ�е�intent 
		 * notification.vibrate ���ֻ���ʱ������������ 
		 */  
		// ���������ʾ  
		notification.defaults=Notification.DEFAULT_SOUND;  
		// audioStreamType��ֵ����AudioManager�е�ֵ�������������ģʽ  
		notification.audioStreamType= android.media.AudioManager.ADJUST_LOWER;  

		//�±ߵ�������ʽ�����������  
		//notification.sound = Uri.parse("file:///sdcard/notification/ringer.mp3");   
		//notification.sound = Uri.withAppendedPath(Audio.Media.INTERNAL_CONTENT_URI, "6");   
		Intent intent = new Intent(this, home.class);  
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);  
		// ���״̬����ͼ����ֵ���ʾ��Ϣ����  
		notification.setLatestEventInfo(this, "������ʾ��", "�������������", pendingIntent);  
		manager.notify(1, notification);  

	}  

}
