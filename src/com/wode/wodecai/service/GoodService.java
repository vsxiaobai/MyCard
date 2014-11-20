package com.wode.wodecai.service;

import com.wode.wodecai.api.BaseAPI;
import com.wode.wodecai.api.GoodInfoAPI;
import com.wode.wodecai.api.GoodListAPI;
import com.wode.wodecai.api.params.GoodInfoParams;
import com.wode.wodecai.api.params.GoodListParams;
import com.wode.wodecai.entity.GoodEntity;
import com.wode.wodecai.entity.GoodListEntity;

import android.content.Context;

public class GoodService extends BaseService {

	public GoodService(Context context) {
		super(context);
	}
	
	public GoodListEntity getGoodList(int page){
		GoodListParams pm = new GoodListParams();
		pm.setPage(Integer.toString(page));
		BaseAPI api = new GoodListAPI(context, pm);
		try {
			if(api.doGet()){
				return (GoodListEntity)api.getHandleResult(); 
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public GoodEntity getGoodInfo(String id){
		GoodInfoParams pm = new GoodInfoParams();
		pm.setId(id);
		BaseAPI api = new GoodInfoAPI(context, pm);
		try {
			if(api.doGet()){
				return (GoodEntity)api.getHandleResult();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

}
