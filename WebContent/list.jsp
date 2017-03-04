<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
    <a href ="${pageContext.request.contextPath }/analyze/listcount">跳转到按小时的统计信息页面</a><br/>
    <a href="${pageContext.request.contextPath }/info/infoToData">解析日志信息入库(解析一次就够了)</a>
    <form action="${pageContext.request.contextPath }/info/dateToPage">
        <font color="red">输入时间格式：yyyy-MM-dd HH:mm:ss</font></br> 
        开始时间：<input type="text"   name="start"> 
        截止时间：<input type="text" name="end">
        <input type="submit" value="提交">
    </form>
    <table border="1">
        <tr>
            <td align="center">id</td>
            <td align="center">日期</td>
            <td align="center">小时值</td>
            <td align="center">请求</td>
            <td align="center">调用的接口</td>
        </tr>
      <c:if test="${InfoList !=null  }">
        <c:forEach items="${InfoList}" var="v" >
            <tr>
                <td align="center">${v.id}</td>
                <td align="center">${v.date}</td>
                <td align="center">${v.hour}</td>
                <td align="center">${v.operate}</td>
                <td align="center">${v.inter}</td>
            </tr>
        </c:forEach>
       </c:if> 
        <c:if test="${DateList !=null  }">
        <c:forEach items="${DateList}" var="v" >
            <tr>
                <td><input  type="checkbox"  name="userid" value="${v.id}"></td> 
                <td align="center">${v.id}</td>
                <td align="center">${v.date}</td>
                <td align="center">${v.hour}</td>
                <td align="center">${v.operate}</td>
                <td align="center">${v.inter}</td>
            </tr>
        </c:forEach>
       </c:if> 
        
    </table>
    </form>
    <c:if test="${InfoList !=null  }">
    <a href = "${pageContext.request.contextPath }/info/infoByPage?page=1" >首页</a>
    <a href = "${pageContext.request.contextPath }/info/infoByPage?page=${pagenow-1}">上一页</a>
    
    <a href = "${pageContext.request.contextPath }/info/infoByPage?page=${pagenow+1}">下一页</a> 
    </c:if>
    
     <c:if test="${DateList !=null  }">
    <a href = "${pageContext.request.contextPath }/info/dateToPage?page=1" >首页</a>
    <a href = "${pageContext.request.contextPath }/info/dateToPage?page=${pagenow-1}">上一页</a>
    
    <a href = "${pageContext.request.contextPath }/info/dateToPage?page=${pagenow+1}">下一页</a> 
    </c:if>
    
</body>
</html>