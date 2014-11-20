package com.wode.wodecai.api;



import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.wode.wodecai.api.params.ListParams;
import com.wode.wodecai.api.params.Urls;
import com.wode.wodecai.entity.NewsListEntity;

import android.content.Context;

public class ListAPI extends BaseAPI {

	public ListAPI(Context context, ListParams pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.API+ Urls.list + "?page=" + pm.getPage());
	}

	@Override
	public NewsListEntity handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), NewsListEntity.class);
	}
}
