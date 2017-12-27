<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>网易福利体检健康主题讲座报名</title>
    <style>
        div {border:#000 1px solid; text-align:center; padding-top:50px;}
    </style>
</head>
<script>
    $(document).ready(function(){
        if(navigator.userAgent.match(/MicroMessenger/i)) {
            var weixinShareLogo = '<%=request.getContextPath()%>/static/img/logo.png';
            $('body').prepend('' +
                    '<div style=" overflow:hidden; width:0px; height:0; margin:0 auto; position:absolute; top:-800px;">' +
                    '<img src="' + weixinShareLogo + '"></div>');
        }
    });
</script>
<body>
<div>
    <img src="<%=request.getContextPath()%>/static/img/baoming.jpg" usemap="#mymap">
    <map name="mymap">
        <area shape="rect" coords="600,1800,100,400" href="<%=request.getContextPath()%>/user/info" title="讲座">
    </map>
</div>
</body>
</html>
