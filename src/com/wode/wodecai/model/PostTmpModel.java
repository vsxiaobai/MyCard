package com.wode.wodecai.model;

import com.wode.wodecai.service.PostTmpService;

import android.content.Context;

public class PostTmpModel extends Model {
	PostTmpService pService;
	
	public PostTmpModel(Context context){
		this.context = context;
		pService = new PostTmpService(context);
	}
	public void RequestPost(String tmp){
		pService.submitinfo(tmp);
	}
	
}
