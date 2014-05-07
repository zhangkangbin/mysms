package com.example.sms_app;





import java.util.Calendar;
import java.util.Date;

import com.example.engine.SmsInfoservice;
import com.example.service.DeleteSmsService;
import com.example.service.backupSmsService;

import android.os.Bundle;
import android.os.Environment;
import android.os.Looper;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class home extends Activity implements OnClickListener {

	private Button sms_back;
	private Button sms_restore;
	private Button add_sms;
	private Button sms_show;
	private Button sms_locating;
	private Button sms_delete;
	private Button btn_about;
	
	private Button sms_settings;
	
	private SmsInfoservice smsInfoService;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main);
		sms_back=(Button) findViewById(R.id.sms_back);
		sms_restore=(Button) findViewById(R.id.sms_restore);
	    add_sms=(Button) findViewById(R.id.add_sms);
	    sms_show=(Button) findViewById(R.id.sms_show);
		sms_locating=(Button) findViewById(R.id.btn_locating);
		sms_delete=(Button) findViewById(R.id.delete_button);
		sms_settings=(Button) findViewById(R.id.sms_settings);
		btn_about=(Button) findViewById(R.id.btn_about);
		
		
		sms_delete.setOnClickListener(this);
		sms_back.setOnClickListener(this);
		sms_restore.setOnClickListener(this);
		add_sms.setOnClickListener(this);
		sms_locating.setOnClickListener(this);
		sms_show.setOnClickListener(this);
		btn_about.setOnClickListener(this);
		sms_settings.setOnClickListener(this);

	}




	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.sms_back:
			 Calendar c1=Calendar.getInstance(); 
			String date=c1.get(c1.YEAR)+"��"+(c1.get(c1.MONTH)+1)+ 
					  "��"+c1.get(c1.DAY_OF_MONTH)+"��"+c1.get(c1.HOUR)+"ʱ"+c1.get(c1.MINUTE)+"��"; 
			AlertDialog.Builder a=new AlertDialog.Builder(this) ;
			a.setTitle("�������ļ�ȡ����") ; 
			a.setIcon(android.R.drawable.ic_btn_speak_now)  ;
			final EditText e	=new EditText(this);
			e.setText(date);
			a.setView(e) ; 
			a.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface arg0, int arg1) {
					// TODO Auto-generated method stu
					if(checkSdcrd()){
					//	showMessage("����sd����");
					String FileName=e.getText().toString();
				    BackSms(FileName);}
					else{
						showMessage("û��sd����");
					}
				}
			}) ; 
			a.setNegativeButton("ȡ��", null) ; 
			a.show();  
			
			//Toast.makeText(getApplicationContext(), "------�ɹ�--------", 0).show();
			break;

		case R.id.sms_restore  :
//			final ProgressDialog pd = new ProgressDialog(this);
//
//			pd.setCancelable(false);
//			pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//			pd.setMessage("restoreing  Sms....");
//			pd.show();
//			smsInfoService=new SmsInfoservice(this);
//			new Thread(){
//
//				public void run(){
//
//					try {
//						smsInfoService.restoreSms("/sdcard/FileName.xml", pd);
//						pd.dismiss();
//						Looper.prepare();
//						Toast.makeText(getApplicationContext(), "��ԭ�ɹ�", 0).show();
//						Looper.loop();
//
//					} catch (Exception e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//						pd.dismiss();
//						Looper.prepare();
//						Toast.makeText(getApplicationContext(), "��ԭʧ��", 0).show();
//						Looper.loop();
//					}
//
//
//				}
//
//
//
//			}.start();
			Intent re=new Intent(this,Smsrestore.class);
			
			

			startActivity(re);

			break;
		case R.id.add_sms  :
			Intent add=new Intent(this,AddSms.class);
			startActivity(add);
			
			break;
		case R.id.btn_locating:
			Intent timer=new Intent(this,TimerSms.class);
			startActivity(timer);
			
			break;
		case R.id.sms_show:
			Intent smsshow=new Intent(this,SmsShow.class);
			startActivity(smsshow);
			
			break;
		case R.id.delete_button:
			Intent delete=new Intent(this,DeleteSms.class);
			startActivity(delete);
			
			break;
		case R.id.sms_settings:
			Intent settings=new Intent(this,settings.class);
			startActivity(settings);
			
			break;
		case R.id.btn_about:
			about();
			
			break;
		default:
			break;
		}


	}
	public void onBackPressed() {
//		// TODO Auto-generated method stub
//		Toast toast=Toast.makeText(this, "�˼������ˡ�����\n���Աߵİɣ�", 3000);
//		toast.setGravity(Gravity.CENTER, 0, 0);
//		toast.show();
		AlertDialog.Builder   builder=	new AlertDialog.Builder(this);   
		
		  builder.setTitle("��ȷ��Ҫ�뿪��");  

	       builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {  

	           public void onClick(DialogInterface dialog, int whichButton) {  

	               //������ӵ��ȷ������߼�  

	              finish();

	           }  

	       });  

	       builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {  

	           public void onClick(DialogInterface dialog, int whichButton) {  

	               //������ӵ��ȷ������߼�  

	              

	           }  

	       });  

	       builder.create().show();  

	
	
		
	}
	public void BackSms(String name){
		
		Intent i=new Intent(this,backupSmsService.class);
		Bundle bundle = new Bundle(); 
		bundle.putString("FileName", name); 
		i.putExtras(bundle); 

		startService(i);
	}
	public boolean checkSdcrd(){
		if(!Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)){
			showMessage("�����sd��");
			return false;
			
		}
		return true;
		
	}
	public void showMessage(String message){
		Toast toast = Toast.makeText(getApplicationContext(),
			     message, Toast.LENGTH_LONG);
			   toast.setGravity(Gravity.CENTER, 0, 0);
			   toast.show();
		
		
		
	}
	
	public void about(){
		
		
		AlertDialog.Builder   builder=	new AlertDialog.Builder(this);   
		
		  builder.setTitle("����"); 
		  builder.setMessage("���ߣ�zhang");

	       builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {  

	           public void onClick(DialogInterface dialog, int whichButton) {  

	               //������ӵ��ȷ������߼�  

	            

	           }  

	       });  
	       builder.create().show();  
	}
}
