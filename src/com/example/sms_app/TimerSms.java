/**
 * 
 */
package com.example.sms_app;

import java.util.Calendar;

import com.example.service.AlarmReceiver;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * @author xiao
 *
 */
public class TimerSms extends Activity{
	private Button btn=null;
	private Button btn_quxiao=null;
	private static  AlarmManager alarmManager=null;
	Calendar cal=Calendar.getInstance();
	final int DIALOG_TIME = 0;    //���öԻ���id
	String address;
	String body;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);

		alarmManager=(AlarmManager)getSystemService(Context.ALARM_SERVICE);
		btn=(Button)findViewById(R.id.btn_add);
		btn_quxiao=(Button)findViewById(R.id.quxiao);
		btn_quxiao.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				cancelUpdateBroadcast(getApplicationContext());
			}
		});
		btn.setOnClickListener(new View.OnClickListener(){
			public void onClick(View view) {
				
			Intent sub=new Intent(TimerSms.this,TimeSubmit.class);
		startActivity(sub);
			}
		});

	}

	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog=null;
		switch (id) {
		case DIALOG_TIME:
			dialog=new TimePickerDialog(
					this, 
					new TimePickerDialog.OnTimeSetListener(){
						public void onTimeSet(TimePicker timePicker, int hourOfDay,int minute) {
							Calendar c=Calendar.getInstance();//��ȡ���ڶ���    
							c.setTimeInMillis(System.currentTimeMillis());        //����Calendar����
							c.set(Calendar.HOUR_OF_DAY, hourOfDay);
							// c.set(Calendar.HOUR, hourOfDay);        //��������Сʱ��
							c.set(Calendar.MINUTE, minute);            //�������ӵķ�����
							c.set(Calendar.SECOND, 0);                //�������ӵ�����
							c.set(Calendar.MILLISECOND, 0);            //�������ӵĺ�����
							Intent intent = new Intent(TimerSms.this, AlarmReceiver.class);    //����Intent����
							PendingIntent pi = PendingIntent.getBroadcast(TimerSms.this, 0, intent, 0);    //����PendingIntent
							alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),c.getTimeInMillis(), pi);        //��������
							//	alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), pi);        //�������ӣ���ǰʱ��ͻ���
							Toast.makeText(TimerSms.this, "�������óɹ�", Toast.LENGTH_LONG).show();//��ʾ�û�
						}
					}, 
					cal.get(Calendar.HOUR_OF_DAY), 
					cal.get(Calendar.MINUTE),
					false);

			break;
		}
		return dialog;
	}

	/**
	 * ȡ����ʱִ��(�������ӵ�ȡ��)
	 * 
	 * @param ctx
	 */       
	public static void cancelUpdateBroadcast(Context ctx){
		//   AlarmManager am = getAlarmManager(ctx);
		// ȡ��ʱע��UpdateReceiver.class����������ʱһ��,������Ҫ��ȷȡ��
		Intent i = new Intent(ctx, AlarmReceiver.class);  
		PendingIntent pendingIntent = PendingIntent.getBroadcast(ctx, 0, i, 0);
		//  am.cancel(pendingIntent);
		alarmManager.cancel(pendingIntent);
		Toast.makeText(ctx, "ȡ�����ӳɹ�", Toast.LENGTH_LONG).show();//��ʾ�û�
	}


	public void  showaddsms(){

         
		LayoutInflater inflater = getLayoutInflater();

		View layout = inflater.inflate(R.layout.dialog,(ViewGroup) findViewById(R.id.dialog));
		
		 EditText edt_address=(EditText) findViewById(R.id.edt_addressee);

        EditText edt_body=(EditText) findViewById(R.id.edt_content);
		//address=edt_address.getText().toString();
		//body=edt_body.getText().toString();

		new AlertDialog.Builder(this).setTitle("��ʱ����").setView(layout)
		

		.setPositiveButton("ȷ��",new DialogInterface.OnClickListener() {
			
		
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
			
				
				
			}
		} )

		.setNegativeButton("ȡ��", null).show();
	

	}


}