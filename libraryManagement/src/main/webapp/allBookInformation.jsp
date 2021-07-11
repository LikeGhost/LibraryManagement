<%--
  Created by IntelliJ IDEA.
  User: 11540
  Date: 2021/7/8
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有图书</title>
    <script src="static/js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="/libraryManagement/static/layui/css/layui.css" media="all">
    <script src="/libraryManagement/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "book/allBookInformation",
                type: "post",
                data: {
                },
                dataType: "json",
                success: function (resp) {
                    $("#allBookInformationTable>tbody").empty();
                    $.each(resp, function (i, n) {
                        var tr = $("<tr></tr>");
                        $(tr).append("<td>" + n.isbn + "</td>");
                        $(tr).append("<td>" + n.bookName + "</td>");
                        $(tr).append("<td>" + n.author + "</td>");
                        $(tr).append("<td>" + n.clcContent + "</td>");
                        $(tr).append("<td>" + n.quantity + "</td>");


                        var rContent="${role.rContent}";
                        var td= $("<td></td>");
                        if(rContent.indexOf("管理员")!=-1){

                            var change,del,add,allBook;
                            allBook=$("<a class=\"layui-btn \" href=\"/libraryManagement/allBook.jsp?isbn="+n.isbn+"\">查看实体图书</a>");
                            add=$("<a class=\"layui-btn\" href=\"/libraryManagement/addBook.jsp?isbn="+n.isbn+"\">添加实体图书</a>");
                            change =$("<a class=\"layui-btn\" href=\"javascript:void(0);\">修改</a>");
                            if(n.quantity==0)
                                del=$("<a class=\"layui-btn  layui-btn-danger\" href=\"${pageContext.request.contextPath}/book/deleteBookInformation?isbn="+n.isbn+"\">删除</a>");
                            else  del=$("<a class=\"layui-btn layui-btn-danger\" href=\"javascript:void(0); \">删除</a>");
                            td.append(allBook);
                            td.append(add);
                            td.append(change);
                            td.append(del);
                        }
                        else {
                            var borrow;
                            borrow = $("<a class=\"layui-btn\" href=\"/libraryManagement/allBook.jsp?isbn=" + n.isbn + "\">借阅</a>");
                            td.append(borrow);
                        }
                        $(tr).append(td);


                        $("#allBookInformationTable>tbody").append(tr);
                    });
                },
                error: function () {
                    alert("error");
                }
            });
        });

    </script>
</head>
<body>

<table id="allBookInformationTable" border="1" cellspacing="0">
    <thead>
    <tr>
        <th>ISBN</th>
        <th>书名</th>
        <th>作者</th>
        <th>图书种类</th>
        <th>数量</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>


    </tbody>
</table>
</body>
</html>
