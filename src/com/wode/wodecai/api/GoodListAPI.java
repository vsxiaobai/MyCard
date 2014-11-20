package com.wode.wodecai.api;



import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.google.gson.Gson;
import com.wode.wodecai.api.params.GoodListParams;
import com.wode.wodecai.api.params.Urls;
import com.wode.wodecai.entity.GoodListEntity;

public class GoodListAPI extends BaseAPI {

	public GoodListAPI(Context context, GoodListParams pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.EC 
				+ Urls.goodsList + "?page=" + pm.getPage());
	}

	@Override
	public GoodListEntity handlerResult(JSONObject json) throws JSONException {
		return new Gson().fromJson(json.toString(), GoodListEntity.class);
	}

}
