package com.wode.wodecai.api;

import java.util.List;


import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.wode.wodecai.api.params.Urls;

import android.content.Context;

public class PostTmpAPI extends BaseAPI {

	public PostTmpAPI(Context context, List<NameValuePair> pm) {
		super(context, pm);
		setMethod(Urls.WEB_SERVER_PATH + Urls.API+ Urls.postTmp);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		return null;
	}

}
