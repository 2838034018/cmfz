<%@page isELIgnored="false" contentType="text/html; utf-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="app" value="${pageContext.request.contextPath}"></c:set>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>

    <link rel="icon" href="../img/favicon.ico">
    <%--引入bootstrap的css--%>
    <link rel="stylesheet" href="${app}/boot/css/bootstrap.min.css">
    <%--引入bootstrap和jqgrid的核心css--%>
    <link rel="stylesheet" href="${app}/jqgrid/css/trirand/ui.jqgrid-bootstrap.css">
    <%--引入jquery的css--%>
    <script src="${app}/boot/js/jquery-2.2.1.min.js"></script>
    <%--引入bootstrap的js--%>
    <script src="${app}/boot/js/bootstrap.min.js"></script>
    <script src="${app}/boot/js/ajaxfileupload.js"></script>
    <%--引入jqgrid的核心js--%>
    <script src="${app}/jqgrid/js/trirand/src/jquery.jqGrid.js"></script>
    <%--引入jqgridg国际化js--%>
    <script src="${app}/jqgrid/js/trirand/i18n/grid.locale-cn.js"></script>

    <script src="${app}/kindeditor/kindeditor-all-min.js"></script>
    <script src="${app}/kindeditor/lang/zh-CN.js"></script>
    <script src="../echarts/echarts.min.js"></script>
    <script src="../echarts/china.js"></script>


</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">持名法州管理系统</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#">欢迎:<span class="text-primary">${sessionScope.userName}</span>登录</a></li>
                <li><a href="#">退出登陆<span class="glyphicon glyphicon-log-out"></span></a></li>
            </ul>
        </div>


    </div><!-- /.container-fluid -->
</nav>
<div class="container-fluid">
    <div class="row">
        <!--左侧手风琴-->
        <div class="col-sm-2">
            <div class="panel-group" id="accordion">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseOne">
                                用户管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseOne" class="panel-collapse collapse ">
                        <div class="panel-body">
                            <a href="javascript:$('#lay-right').load('echartsMap.jsp')">用户分布</a>
                            <br><br>
                            <a href="javascript:$('#lay-right').load('echarts.jsp')">用户注册走势</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseTwo">
                                上师管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseTwo" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a href="javascript:$('#lay-right').load('${app}/')">上师列表</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseThree">
                                文章管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseThree" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a href="javascript:$('#lay-right').load('article.jsp')">文章列表</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseFour">
                                专辑管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFour" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a href="javascript:$('#lay-right').load('album.jsp')">专辑列表</a>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a data-toggle="collapse" data-parent="#accordion"
                               href="#collapseFive">
                                轮播图管理
                            </a>
                        </h4>
                    </div>
                    <div id="collapseFive" class="panel-collapse collapse">
                        <div class="panel-body">
                            <a href="javascript:$('#lay-right').load('banner.jsp')">轮播图列表</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-10" id="lay-right">
            <div class="jumbotron">
                <h4>欢迎来到持明法州后台管理系统</h4>
            </div>
            <img src="${app}/img/shouye.jpg">
        </div>
        <!--模态框-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                        <h4 class="modal-title">Modal title</h4>
                    </div>
                    <div class="modal-body">
                        <p>One fine body&hellip;</p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<nav class="navbar navbar-default navbar-fixed-bottom">
    <div class="panel panel-default">
        <div style="text-align: center" class="panel-body">
            百知教育@zpark.com.cn
        </div>
    </div>
</nav>
</body>
</html>