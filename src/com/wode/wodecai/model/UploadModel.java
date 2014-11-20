package com.wode.wodecai.model;

import com.wode.wodecai.service.UploadService;

import android.content.Context;

public class UploadModel extends Model {
	UploadService uploadService;
	public UploadModel(Context context){
		this.context = context;
		uploadService = new UploadService(context);
	}
	
	public void RequestUpload(String name,String content){
		uploadService.upload(name, content);
	}
}
