# community
---
## To Do
* CMS
* 留言板
* 留言板的文本分析
* tomcat域名解析
* 答题表的设计、已答题和未答题的逻辑关系

## Notice
* 用户名必须唯一
* login样式不支持360浏览器兼容模式


## 20160810
* 改动jsp页面的布局，top.jsp专门放head有关的东西，之后只要参照index.jsp直接进行修改就行
* 修复登陆页面的css问题，需先加载css,在加载js
* 开始着手exercises.jsp页面

## 20160811
* 通过隐藏块来解决登陆过程中from表单提交时password未MD5加密
* 登陆成功日志
* exercises.jsp可以向controller传用户账号，controller可以返回json信息给exercises.jsp
* 题目通过ajax请求，用用户账号区别