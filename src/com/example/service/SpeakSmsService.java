package com.example.service;

import java.util.Locale;

import com.example.sms_app.R;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.IBinder;
import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.Toast;

public class SpeakSmsService extends Service {

    private TextToSpeech mSpeech;
    private WindowManager wManager;
    private String a;
    private  String b;
    private  View view ;
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
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
	
		
		 a=intent.getStringExtra("address");
		 b=intent.getStringExtra("body");
		
		  mSpeech = new TextToSpeech(this, new OnInitListener() {

	            @Override
	            public void onInit(int status) {
	                // TODO Auto-generated method stub
	                if (status == TextToSpeech.SUCCESS) {
	                    int result = mSpeech.setLanguage(Locale.ENGLISH);
	                    if (result == TextToSpeech.LANG_MISSING_DATA
	                            || result == TextToSpeech.LANG_NOT_SUPPORTED) {
	                        Log.e("lanageTag", "û����������");
	                    } else {
	                      
//	                        mSpeech.speak("i love you", TextToSpeech.QUEUE_FLUSH,
//	                                null);
	                    	windows();
	                    	 mSpeech.speak("������"+a+"��Ϣ����"+b,
	                                 TextToSpeech.QUEUE_FLUSH, null);
	                    	 Log.i("test", a+b);
	                    	// wManager.removeView(view);
	                    }
	                }
	            }
	        });
	}

	
	public void windows(){
		

		//���ȣ��õ�WindoeManager����
	 wManager = (WindowManager) getApplicationContext().getSystemService( Context.WINDOW_SERVICE);

	//	��Σ��õ�WindowManager.LayoutParams����Ϊ����������ز�����׼����
		WindowManager.LayoutParams wmParams=new WindowManager.LayoutParams();

		//���ţ�������صĴ��ڲ��ֲ�����Ҫʵ����������Ч������Ҫ��Ҫ���õĲ����У�
		wmParams.type = LayoutParams.TYPE_PHONE; // ����window type
		wmParams.format = PixelFormat.RGBA_8888; // ����ͼƬ��ʽ��Ч��Ϊ����͸��

		/*
		 * �����flags���Ե�Ч����ͬ���������� ���������ɴ������������κ��¼�,ͬʱ��Ӱ�������¼���Ӧ��
		 */
		//wmParams.flags=LayoutParams.FLAG_NOT_TOUCH_MODAL |LayoutParams.FLAG_NOT_FOCUSABLE | LayoutParams.FLAG_NOT_TOUCHABLE;
		wmParams.gravity = Gravity.CENTER| Gravity. CENTER_VERTICAL; // ���������������Ҳ��м�
		// ����Ļ���Ͻ�Ϊԭ�㣬����x��y��ʼֵ
		wmParams.x = 0;
		wmParams.y = 0;

		// �����������ڳ�������
		wmParams.width = WindowManager.LayoutParams.WRAP_CONTENT;;
		wmParams.height =WindowManager.LayoutParams.WRAP_CONTENT;;

	//	Ȼ�󣬾Ϳ��Խ���Ҫ�ӵ����������е�View���뵽�������ˣ�
		
		LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	 view = inflater.inflate(R.layout.windows, null);
		Button btn1=(Button) view.findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				wManager.removeView(view);
				Toast.makeText(getApplicationContext(), "stop...",0).show();
				Intent i=new Intent(SpeakSmsService.this,SpeakSmsService.class);
				stopService(i);
				 
				System.exit(0);
		
			}
		});
		
		
	
		
			wManager.addView(view,wmParams);


		
	}
	
}
