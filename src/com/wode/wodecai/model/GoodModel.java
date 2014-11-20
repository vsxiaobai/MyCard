package com.wode.wodecai.model;

import com.wode.wodecai.entity.GoodEntity;
import com.wode.wodecai.entity.GoodListEntity;
import com.wode.wodecai.service.GoodService;

import android.content.Context;

public class GoodModel extends Model {
	
	GoodService goodService;
	
	public GoodModel(Context context){
		this.context = context;
		goodService = new GoodService(context);
	}
	
	
	public GoodListEntity RequestGoodList(int page){
		return goodService.getGoodList(page);
	}
	
	public GoodEntity RequestGoodInfo(String id){
		return goodService.getGoodInfo(id);
	}
	
}
