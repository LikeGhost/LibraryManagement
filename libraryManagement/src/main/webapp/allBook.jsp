<%--
  Created by IntelliJ IDEA.
  User: 11540
  Date: 2021/7/8
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有图书实体</title>

    <script src="/libraryManagement/static/js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="/libraryManagement/static/layui/css/layui.css" media="all">
    <script src="/libraryManagement/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "book/queryAllBookByISBN",
                type: "post",
                data: {
                    "isbn":${param.isbn}
                },
                dataType: "json",
                success: function (resp) {
                    $("#allBookTable>tbody").empty();
                    $.each(resp.books, function (i, n) {
                        var tr = $("<tr></tr>");
                        $(tr).append("<td>" + n.bId + "</td>");
                        $(tr).append("<td>" + n.library.lName + "</td>");

                        $(tr).append("<td>" + n.borrowType.btContent + "</td>");
                        $(tr).append("<td>" + n.bPutTime + "</td>");
                        $(tr).append("<td>" + n.borrowStatus + "</td>");

                        var rContent="${role.rContent}";
                        var borrow;
                        if(rContent.indexOf("管理员")!=-1){
                            if (n.borrowStatus === "borrowed") {
                                borrow = $("<td><a class=\"borrowButton layui-btn layui-btn-danger\" href=\"javascript:void(0);\">删除</a></td>");
                            } else {
                                borrow = $("<td><a class=\"borrowButton layui-btn layui-btn-danger\" href=\"${pageContext.request.contextPath}/book/deleteBook?isbn="+n.isbn+"&bId="+n.bId+"\">删除</a></td>");
                            }
                            $(tr).append(borrow);
                        }
                        else{
                            if (n.borrowStatus === "borrowed") {
                                borrow = $("<td><a class=\"borrowButton layui-btn\" href=\"javascript:void(0);\">借阅</a></td>");
                            } else {
                                borrow = $("<td><a class=\"borrowButton layui-btn\" href=\"${pageContext.request.contextPath}/borrow/borrowBook?uId=${user.uId}&bId="+n.bId+"\">借阅</a></td>");
                            }
                            $(tr).append(borrow);
                        }


                        $("#allBookTable>tbody").append(tr);
                    });
                },
                error: function () {
                    alert("暂时没有实体书可以借阅");
                }
            });

        });
    </script>
</head>
<body>
<table id="allBookTable" border="1" cellspacing="0">
    <thead>
    <tr>
        <th>实体图书ID</th>
        <th>图书馆名称</th>
        <th>借阅种类</th>
        <th>上架时间</th>
        <th>借出状态</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>


    </tbody>
    <a class="layui-btn" href="/libraryManagement/allBookInformation.jsp">返回</a>
</table>
</body>
</html>
