package com.wode.wodecai.service;

import java.util.List;

import com.wode.wodecai.api.BaseAPI;
import com.wode.wodecai.api.ListAPI;
import com.wode.wodecai.api.params.ListParams;
import com.wode.wodecai.dao.NewsDao;
import com.wode.wodecai.entity.NewsEntity;
import com.wode.wodecai.entity.NewsListEntity;

import android.content.Context;

public class NewsService extends BaseService {

	public NewsService(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public NewsListEntity getList(String page){
		NewsListEntity newsListEntity = new NewsListEntity();
		ListParams pm = new ListParams();
		pm.setPage(page);
		BaseAPI api = new ListAPI(context, pm);
		try {
			if(api.doGet()){
				newsListEntity = (NewsListEntity)api.getHandleResult();
				if(newsListEntity != null 
						&& newsListEntity.getAlist() != null){
					if(page.equals("1")){
						((NewsDao)getDao(NewsEntity.class)).deleteAll();
					}
					((NewsDao)getDao(NewsEntity.class)).insertInTx(newsListEntity.getAlist());
				}
				return newsListEntity;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public List<NewsEntity> getDaoList() {
		return ((NewsDao)getDao(NewsEntity.class)).getAllList();
	}

}
