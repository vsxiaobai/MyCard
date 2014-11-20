package com.wode.wodecai.service;

import java.util.LinkedHashMap;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.wode.wodecai.dao.DaoMaster;
import com.wode.wodecai.dao.DaoSession;
import com.wode.wodecai.dao.UserDao;
import com.wode.wodecai.entity.UserEntity;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.identityscope.IdentityScopeType;

public class BaseService {
	SharedPreferences prefs;
	protected Context context;
	private DaoSession daoSession;
	protected Gson gson;
	private BaseService() {

	}
	

	/**
	 * 获取当前登录用户信息
	 * 
	 * @return 如果没有登录用户信息，返回NULL，否则返回 UserEntity
	 */
	public UserEntity getloggedUser() {
		return ((UserDao) openSession().getDao(UserEntity.class)).getloggedUser();
	}

	/**
	 * 修改当前登录用户信息
	 * @param user
	 */
	public void updateLoggedUser(UserEntity user) {
		((UserDao) openSession().getDao(UserEntity.class)).update(user);
	}
	
	public void delLoggedUser(){
		((UserDao) openSession().getDao(UserEntity.class)).deleteAll();
	}
	
	public NameValuePair getValue(String key,String value){
		return new BasicNameValuePair(key, value);
	}
	
	public AbstractDao getDao(Class entity){
		return openSession().getDao(entity);
	}
	
	protected BaseService(Context context) {
		this.context = context;
		gson = new Gson();
		prefs = PreferenceManager.getDefaultSharedPreferences(context);
	}

	/**
	 * 打开session
	 * 
	 * @param type
	 */
	public DaoSession openSession(IdentityScopeType type) {
		daoSession = DaoMaster.getInstance(context).newSession(type);
		return daoSession;
	}

	/**
	 * 打开session
	 * 
	 * @param typeId
	 */
	public DaoSession openSession() {
		return openSession(IdentityScopeType.None);
	}

	public void closeSession() {
		if (daoSession != null) {
			if (daoSession.getDatabase() != null && daoSession.getDatabase().isOpen()) {
				daoSession.getDatabase().close();
			}
		}
		DaoMaster.clear();
	}
	private LinkedHashMap<String, String> getCookies(){
		String cookies[] = prefs.getString("cookies", "").split("Set_Cookies");
		LinkedHashMap<String, String> cookie = new LinkedHashMap<String, String>();
		for(int i = 0;i < cookies.length;i++){
			cookie.put("Set-Cookie", cookies[i]);
		}
		return cookie;
	}
}
