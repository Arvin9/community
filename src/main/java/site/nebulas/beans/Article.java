package site.nebulas.beans;

public class Article {
	private Integer articleId;//文章ID
	private String articleCaption;//文章标题
	private String articleDigest;//文章摘要
	private String articleAuthor;//文章作者
	private String userAccount;//编辑人
	private String articleCreateTime;//创建时间
	private String articleUpdateTime;//最近修改时间
	private String articleContent;//文章内容（HTML格式）
	private String articleRemark;//文章备注
	private Integer articlePageView;//文章浏览数
	private Integer articleLike;//点赞数
	private Integer articleDislike;//不喜欢数
	private Integer articleStates;//0未审核，1审核通过，2审核未通过，3删除
	
	public Integer getArticleId() {
		return articleId;
	}
	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}
	public String getArticleCaption() {
		return articleCaption;
	}
	public void setArticleCaption(String articleCaption) {
		this.articleCaption = articleCaption;
	}
	public String getArticleDigest() {
		return articleDigest;
	}
	public void setArticleDigest(String articleDigest) {
		this.articleDigest = articleDigest;
	}
	public String getArticleAuthor() {
		return articleAuthor;
	}
	public void setArticleAuthor(String articleAuthor) {
		this.articleAuthor = articleAuthor;
	}
	public String getUserAccount() {
		return userAccount;
	}
	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}
	public String getArticleCreateTime() {
		return articleCreateTime;
	}
	public void setArticleCreateTime(String articleCreateTime) {
		this.articleCreateTime = articleCreateTime;
	}
	public String getArticleUpdateTime() {
		return articleUpdateTime;
	}
	public void setArticleUpdateTime(String articleUpdateTime) {
		this.articleUpdateTime = articleUpdateTime;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getArticleRemark() {
		return articleRemark;
	}
	public void setArticleRemark(String articleRemark) {
		this.articleRemark = articleRemark;
	}
	public Integer getArticlePageView() {
		return articlePageView;
	}
	public void setArticlePageView(Integer articlePageView) {
		this.articlePageView = articlePageView;
	}
	public Integer getArticleLike() {
		return articleLike;
	}
	public void setArticleLike(Integer articleLike) {
		this.articleLike = articleLike;
	}
	public Integer getArticleDislike() {
		return articleDislike;
	}
	public void setArticleDislike(Integer articleDislike) {
		this.articleDislike = articleDislike;
	}
	public Integer getArticleStates() {
		return articleStates;
	}
	public void setArticleStates(Integer articleStates) {
		this.articleStates = articleStates;
	}
	
}
