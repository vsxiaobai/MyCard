package com.wode.wodecai.model;

import java.util.List;

import com.wode.wodecai.entity.NewsEntity;
import com.wode.wodecai.entity.NewsListEntity;
import com.wode.wodecai.service.NewsService;

import android.content.Context;

public class NewsModel extends Model {
	NewsService newsService;
	
	public NewsModel(Context context){
		newsService = new NewsService(context);
	}
	
	public NewsListEntity RequestList(String page){
		return newsService.getList(page);
	}
	
	public List<NewsEntity> getList(){
		return newsService.getDaoList();
	}
}
