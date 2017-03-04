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
<a href="${pageContext.request.contextPath }/analyze/analyze">按小时统计信息入库(统计一次就够了)</a>
    <table border="1">
        <tr>
            <td align="center">id</td>
            <td align="center">日期</td>
            <td align="center">小时值</td>
            <td align="center">request次数</td>
            <td align="center">response次数</td>
            <td align="center">Service次数</td>
        </tr>
        
        <c:forEach items="${ListCount}" var="v" >
            <tr>
                <td align="center">${v.id}</td>
                <td align="center">${v.date}</td>
                <td align="center">${v.hour}</td>
                <td align="center">${v.requestXMLTimes}</td>
                <td align="center">${v.responseXMLTimes}</td>
                <td align="center">${v.requestServiceTimes}</td>
            </tr>
        </c:forEach>
    </table>
    </form>
</body>
</html>