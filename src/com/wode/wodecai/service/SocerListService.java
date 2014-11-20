package com.wode.wodecai.service;

import com.wode.wodecai.api.BaseAPI;
import com.wode.wodecai.api.SocerListAPI;
import com.wode.wodecai.api.params.SocerListParams;
import com.wode.wodecai.entity.SocerListEntity;

import android.content.Context;

public class SocerListService extends BaseService {

	public SocerListService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	
	public SocerListEntity getSocerList(){
		SocerListParams pm = new SocerListParams();
		BaseAPI api = new SocerListAPI(context, pm);
		try {
			if(api.doGet()){
				return (SocerListEntity)api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
