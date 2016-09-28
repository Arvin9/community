package site.nebulas.service;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import site.nebulas.beans.Article;
import site.nebulas.dao.ArticleDao;

@Service
public class ArticleService {
	@Resource
	private ArticleDao articleDao;

    public List<Article> queryByParam(Article article){
    	return articleDao.queryByParam(article);
    }
    /**
	 * 前台显示，状态为审核通过
	 * */
    public List<Article> queryForShow(Article article){
    	return articleDao.queryForShow(article);
    }
    
    
    public void articleLikeIncrease(Article article){
    	articleDao.articleLikeIncrease(article);
    }
    public void articleDisLikeIncrease(Article article){
    	articleDao.articleDisLikeIncrease(article);
    }
    public void articlePageViewIncrease(Article article){
    	articleDao.articlePageViewIncrease(article);
    }
   
}


