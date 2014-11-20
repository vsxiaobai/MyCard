package com.wode.wodecai.api;


import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.wode.wodecai.api.params.SocerListParams;
import com.wode.wodecai.api.params.Urls;
import com.wode.wodecai.entity.SocerListEntity;

import android.content.Context;

public class SocerListAPI extends BaseAPI {

	public SocerListAPI(Context context,SocerListParams pm) {
		super(context,pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.API+ Urls.socerList);
	}

	@Override
	public SocerListEntity handlerResult(JSONObject json) throws JSONException {
		// TODO Auto-generated method stub
		return new Gson().fromJson(json.toString(), SocerListEntity.class);
	}

}
