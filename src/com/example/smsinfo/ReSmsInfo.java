package com.example.smsinfo;




/**
 * type 1 .������ǽ��� 2.������
 * 
 * @author xiaobao
 * 
 */
public class ReSmsInfo {
	private String name;
	private long size;
	private String date;
	

	public ReSmsInfo() {
	}

	public ReSmsInfo(String name, long size, String date) {
		this.name = name;
		this.size = size;
		this.date = date;
	
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public long getsize() {
		return size;
	}

	public void setsize(long size) {
		this.size = size;
	}

	public String getdate() {
		return date;
	}

	public void setdate(String date) {
		this.date = date;
	}

	


}
