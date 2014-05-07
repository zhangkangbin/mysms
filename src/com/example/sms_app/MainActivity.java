package com.example.sms_app;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView gifView;// GIF�����ؼ�
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// ȡ��������
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);


		gifView = (ImageView) findViewById(R.id.activity_logo_gif);
		final AnimationDrawable anim = (AnimationDrawable) getResources()
				.getDrawable(R.anim.activity_droidman);
		gifView.setBackgroundDrawable(anim);
		gifView.getViewTreeObserver().addOnPreDrawListener(
				new OnPreDrawListener() {

					@Override
					public boolean onPreDraw() {
						// TODO Auto-generated method stub
						anim.start();
						return true;// ����true����������ʾ����Ч��
					}
				});
	



		// ��ɴ����ȫ����ʾ // ȡ����״̬��
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
				WindowManager.LayoutParams.FLAG_FULLSCREEN);
		new Thread(){

			@Override
			public void run() {
				super.run();
				try {
					sleep(1000);
				
					home();
					finish();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}.start();
	}

	
public void home(){
	Intent i=new Intent(this,home.class);
	startActivity(i);
}
}
