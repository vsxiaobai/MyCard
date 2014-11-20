package com.wode.wodecai.service;

import java.util.ArrayList;
import java.util.List;


import org.apache.http.NameValuePair;

import com.wode.wodecai.api.BaseAPI;
import com.wode.wodecai.api.PostTmpAPI;


import android.content.Context;

public class PostTmpService extends BaseService {

	public PostTmpService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public void submitinfo(String tmp){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(getValue("tmp", tmp));
		BaseAPI api = new PostTmpAPI(context, params);
		try {
			if(api.doPost()){
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
