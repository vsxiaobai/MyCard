package com.wode.wodecai.service;

import java.util.ArrayList;
import java.util.List;


import org.apache.http.NameValuePair;

import com.wode.wodecai.api.BaseAPI;
import com.wode.wodecai.api.UploadAPI;
import com.wode.wodecai.dao.UserDao;
import com.wode.wodecai.entity.UserEntity;

import android.content.Context;

public class UploadService extends BaseService {

	public UploadService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void upload(String name,String content){
		
		List<NameValuePair> pm = new ArrayList<NameValuePair>();
		pm.add(getValue("name", name));
		pm.add(getValue("content", content));
		
		List<NameValuePair> fileList = new ArrayList<NameValuePair>();
		fileList.add(getValue("f1", "/mnt/sdcard/DCIM/100MEDIA/IMAG0001.jpg"));
		fileList.add(getValue("f2", "/mnt/sdcard/DCIM/100MEDIA/IMAG0002.jpg"));
		fileList.add(getValue("f3", "/mnt/sdcard/DCIM/100MEDIA/IMAG0003.jpg"));
		BaseAPI api = new UploadAPI(context, pm, fileList);
		try {
			if(api.doUpload()){
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
