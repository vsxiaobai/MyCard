package com.wode.wodecai.api;

import java.util.List;


import org.apache.http.NameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import com.wode.wodecai.api.params.Urls;

import android.content.Context;

public class UploadAPI extends BaseAPI {

	public UploadAPI(Context context, List<NameValuePair> pm,
			List<NameValuePair> fileList) {
		super(context, pm, fileList);
		setMethod(Urls.WEB_SERVER_PATH + Urls.API+ Urls.upload);
	}

	@Override
	public Object handlerResult(JSONObject json) throws JSONException {
		return null;
	}

}
