<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/9/18
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>网易福利体检健康主题讲座报名</title>
    <script src="<%=request.getContextPath()%>/static/js/jquery-1.10.2.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrap.min.js"></script>
    <script src="<%=request.getContextPath()%>/static/js/bootstrapValidator.min.js"></script>

    <link href="<%=request.getContextPath()%>/static/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <link href="<%=request.getContextPath()%>/static/css/bootstrapValidator.min.css" rel="stylesheet" type="text/css"/>
    <style>
        /*web background*/
        .container{
            display:table;
            height:100%;
        }
        .row{
            display: table-cell;
            vertical-align: middle;
        }
        /* centered columns styles */
        .row-centered {
            text-align:center;
        }
        .col-centered {
            display:inline-block;
            float:none;
            text-align:left;
            margin-right:-4px;
        }
    </style>
</head>

<body>

<div class="container">
    <div class="row row-centered">
        <div class="well col-md-6 col-centered">
            <h1>网易福利体检健康主题讲座报名</h1>
            <form id="addUserForm" action="<%=request.getContextPath()%>/user/add" method="post">
                <div class="form-group">
                    <label>姓名</label>
                    <input type="text" class="form-control" name="userName"/>
                </div>
                <div class="form-group">
                    <label>手机号</label>
                    <input type="text" class="form-control" name="userPhone"/>
                </div>
                <div class="form-group">
                    <label>部门</label>
                    <input type="text" class="form-control" name="department"/>
                </div>
                <div class="form-group row-centered">
                    <div class="btn-group">
                        <p class="lead text-center" id="error" style="display: none"></p>
                        <button type="submit" name="submit" class="btn btn-primary ">确认报名</button>
                        <button type="button" name="returnButton" id="returnButton" class="btn btn-primary">返回详情</button>
                    </div>
                </div>
            </form>
        </div>
        <script language="javascript">
            $(document).ready(function () {
                $('form').bootstrapValidator({
                    message: '输入值无效的',
                    live: 'submitted',
                    submitButtons: 'button[type="submit"]',
                    feedbackIcons: {
                        valid: 'glyphicon glyphicon-ok',
                        invalid: 'glyphicon glyphicon-remove',
                        validating: 'glyphicon glyphicon-refresh'
                    }, submitHandler: function (validator, form, submitButton) {
                        $.post(form.attr('action'), form.serialize(), function (result) {
                            console.log("result", result);
                            $('#error').html(result.msg).show();
                            if (result.code = 0) {
                            } else {
                                $('#loginForm').bootstrapValidator('disableSubmitButtons', false);
                            }
                        }, 'json');
                    },
                    fields: {
                        userName: {
                            message: '姓名验证失败',
                            validators: {
                                notEmpty: {
                                    message: '姓名不能为空'
                                }
                            }
                        },
                        userPhone: {
                            validators: {
                                notEmpty: {
                                    message: '手机号不能为空'
                                }
                            }
                        }
                    }
                });
                $("#returnButton").click(function () {
                    window.location.href = "<%=request.getContextPath()%>/user/index";
                })
            });
        </script>
</body>
</html>
