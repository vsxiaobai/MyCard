package com.wode.wodecai.model;

import com.wode.wodecai.entity.SocerListEntity;
import com.wode.wodecai.service.SocerListService;

import android.content.Context;

public class SocerModel extends Model {
	SocerListService socerService;
	public SocerModel(Context context){
		this.context = context;
		socerService = new SocerListService(context);
	}
	
	public SocerListEntity RequestSocerList(){
		return socerService.getSocerList();
	}
}
