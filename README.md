# community
---
## To Do
* CMS
* 留言板，下拉式分页
* 留言板的文本分析，wordcloud
* tomcat域名解析
* 富文本
* 图片放大镜功能
* 忘记密码
* 邮件
* 排行榜 !!!!

## Notice
* 用户名必须唯一
* login样式不支持360浏览器兼容模式
* 请求连接直接写，不需要加路径
* button事件会刷新页面
* $.parseJSON()函数用于将格式完好的JSON字符串转为与之对应的JavaScript对象。
* 在返回的json数据中不要使用status
* bootstrap的Glyphicons字体图标需要在resource下建立fonts


## 20160810
* 改动jsp页面的布局，top.jsp专门放head有关的东西，之后只要参照index.jsp直接进行修改就行
* 修复登陆页面的css问题，需先加载css,在加载js
* 开始着手exercises.jsp页面

## 20160811
* 通过隐藏块来解决登陆过程中from表单提交时password未MD5加密
* 登陆成功日志
* exercises.jsp可以向controller传用户账号，controller可以返回json信息给exercises.jsp
* 题目通过ajax请求，用用户账号区别

## 20160813
* 答题验证与插入记录
* 登陆成功loginState为1，密码错误为2
* 每日一句页面，喜欢不喜欢功能。喜欢为1，不喜欢为2

## 20160814
* 使用jieba分词，wordcloud将sentence作出词云，并上传服务器将URL存入数据库
* 答题的提示、错误提示

## 20160818
* 使用bootstrap的徽章来显示sentence的like和dislike数值
* 用户点击like或者dislike会记录
* jquery.validate验证注册信息，异步验证用户名

## 20160819
* 注册功能实现