package com.example.engine;


import com.example.sms_app.R;
import com.example.sms_app.home;

import android.app.Activity;  
import android.app.AlertDialog;  
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;  
import android.content.DialogInterface.OnClickListener;  
import android.content.Intent;
import android.os.Bundle;  


public class AlarmActivity extends Activity {  

	@Override  
	public void onCreate(Bundle savedInstanceState) {  
		super.onCreate(savedInstanceState); 
	

        //��ʾ�Ի���  
        new AlertDialog.Builder(AlarmActivity.this).  
            setTitle("��ʱ����").//���ñ���  
            setMessage("���ŷ��ͳɹ���").//��������  
            setPositiveButton("֪����", new OnClickListener(){//���ð�ť  
                public void onClick(DialogInterface dialog, int which) {  
                    AlarmActivity.this.finish();//�ر�Activity  
                }  
            }).create().show();  
 
	
	}


	
}  









