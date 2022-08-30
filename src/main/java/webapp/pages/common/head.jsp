<%--
  Created by IntelliJ IDEA.
  User: 陈振鹏
  Date: 2022/8/18
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--动态获取base地址-->
<%
    String basePath = request.getScheme()
    + "://"
    +request.getServerName()
    +":"
    +request.getServerPort()
    + request.getContextPath()
    +"/";
    pageContext.setAttribute("basePath", basePath);
%>
<!--写base标签，永远固定相对路径跳转结果-->
<base href="<%=basePath%>">
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
