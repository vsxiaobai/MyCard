package com.wode.wodecai.api;


import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.wode.wodecai.api.params.BaseHttpParam;
import com.wode.wodecai.api.params.GoodInfoParams;
import com.wode.wodecai.api.params.Urls;
import com.wode.wodecai.entity.GoodEntity;

import android.content.Context;

public class GoodInfoAPI extends BaseAPI {

	public GoodInfoAPI(Context context, GoodInfoParams pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH 
				+ Urls.EC + Urls.GOODSINFO 
				+ "?id=" + pm.getId());
	}

	@Override
	public GoodEntity handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), GoodEntity.class);
	}
}
