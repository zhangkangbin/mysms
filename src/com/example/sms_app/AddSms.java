package com.example.sms_app;

import android.app.Activity;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class AddSms extends Activity {
	EditText edt_addressee;
	EditText  edt_content;
	CheckBox check;
	Button addsms;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		// ȡ��������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.add_sms);
		 edt_addressee=(EditText) findViewById(R.id.edt_addressee);
		 edt_content=(EditText) findViewById(R.id.edt_content);
		 check=(CheckBox) findViewById(R.id.checkBox1);
		
		addsms=(Button) findViewById(R.id.btn_add);
		addsms.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
			    /** �õ�������ֻ����� **/
                String number =  edt_addressee.getText().toString();
                /** �õ�����Ķ������� **/
                String text = edt_content.getText().toString();
                boolean sms_state=check.isChecked();


                if("".equals(number)){
                	
                	  Toast.makeText(getApplicationContext(), "�ֻ����벻��Ϊ��", Toast.LENGTH_LONG).show();
                }
                else{
                	if(sms_state){
                		  
                        /**�����͵Ķ��Ų������ݿ�**/
                        ContentValues values = new ContentValues();
                        
                        //����ʱ��
                        values.put("date", System.currentTimeMillis());
                        Log.i("time","ʱ��"+System.currentTimeMillis() );
                        //�Ķ�״̬
                        values.put("read", 0);
                        //1Ϊ�� 2Ϊ��
                        values.put("type", 2);
                        //�ʹ����
                        values.put("address", number);
                        //�ʹ�����
                        values.put("body", text);
                        //������ſ�
                        getContentResolver().insert(Uri.parse("content://sms"),values);
                        Toast.makeText(getApplicationContext(), "�ɹ������ѷ�����", Toast.LENGTH_LONG).show();
             	
                	}
                	else {
                		   /**�����͵Ķ��Ų������ݿ�**/
                        ContentValues values = new ContentValues();
                        //����ʱ��
                        values.put("date", System.currentTimeMillis());
                        Log.i("time","ʱ��"+System.currentTimeMillis() );
                        //�Ķ�״̬
                        values.put("read", 1);
                        //1Ϊ�� 2Ϊ��
                        values.put("type", 1);
                        //�ʹ����
                        values.put("address", number);
                        //�ʹ�����
                        values.put("body", text);
                        //������ſ�
                        getContentResolver().insert(Uri.parse("content://sms"),values);
                        Toast.makeText(getApplicationContext(), "�ɹ����ɽ��ն���", Toast.LENGTH_LONG).show();
                		
                		
                	}
                	
                }

			}
		});
	}



}
