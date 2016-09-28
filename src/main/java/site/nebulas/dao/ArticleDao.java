package site.nebulas.dao;

import java.util.List;

import site.nebulas.beans.Article;

/**
 * @author Honghui
 * @date 20160924
 */
public interface ArticleDao {

	public List<Article> queryByParam(Article article);
	/**
	 * 前台显示，状态为审核通过
	 * */
	public List<Article> queryForShow(Article article);
	
    public void articleLikeIncrease(Article article);
    public void articleDisLikeIncrease(Article article);
    public void articlePageViewIncrease(Article article);

}

