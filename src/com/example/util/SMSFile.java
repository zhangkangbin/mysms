package com.example.util;

import java.io.File;

import android.util.Log;

public class SMSFile {
	
	
	public boolean delete(String path){
	Log.i("file", path);
		File f=new File(path);
		if(	f.exists())
		{
			f.delete();
			
			Log.i("file", "�ļ�delete�ɹ�");
			return true;
		}
		else{
			
			Log.i("file", "û������ļ�");
			return false;
		}
	
		
		
		
		
		
	}

}
