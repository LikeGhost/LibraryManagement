<%--
  Created by IntelliJ IDEA.
  User: 11540
  Date: 2021/7/8
  Time: 23:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>借阅记录</title>
    <script src="/libraryManagement/static/js/jquery-3.6.0.js"></script>
    <link rel="stylesheet" href="/libraryManagement/static/layui/css/layui.css" media="all">
    <script src="/libraryManagement/static/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript">
        $(function () {
            $.ajax({
                url: "borrow/borrowRecord",
                type: "post",
                data: {
                    "uId":"${user.uId}"
                },
                dataType: "json",
                success: function (resp) {
                    $("#allBorrowRecordTable>tbody").empty();
                    var rContent = "${role.rContent}";
                    $.each(resp.list, function (i, n) {
                        var tr = $("<tr></tr>");
                        $(tr).append("<td>" + n.brId + "</td>");
                        $(tr).append("<td>"+n.uId+"</td>");
                        $(tr).append("<td>" + n.book.bookInformation.bookName + "</td>");
                        $(tr).append("<td>" + n.borrowTime + "</td>");
                        $(tr).append("<td>" + n.returnTime + "</td>");
                        $(tr).append("<td>" + n.book.library.lName + "</td>");
                        $(tr).append("<td>" + n.recordStatus + "</td>");
                        if (rContent.indexOf("管理员") != -1) {
                            var change, recall;

                            var td = $("<td></td>");
                            if (n.recordStatus != "stop") {
                                change = $("<a class=\"layui-btn \" href=\"/libraryManagement/changeBorrowRecord.jsp?brId="+n.brId+"\">修改</a>");
                                recall = $("<a class=\"layui-btn layui-btn-danger\" href=\"javascript:void(0);\">催还</a>");
                            }
                            td.append(change);
                            td.append(recall);
                            $(tr).append(td);

                        } else {
                            var borrow;
                            if (n.recordStatus === "stop") {
                                borrow=$("<td></td>");
                            } else if (n.recordStatus === "outTime") {
                                borrow = $("<td><a class=\"borrowButton layui-btn\" href=\"/libraryManagement/payFine.jsp?finePrice="+n.finePrice+"&brId="+n.brId+"&bId="+n.bId+"\">还书</a></td>");
                            } else if (n.recordStatus === "running"&&n.book.library.lId===${library.lId}) {
                                borrow = $("<td><a class=\"borrowButton layui-btn\" href=\"${pageContext.request.contextPath}/borrow/returnBook?uId=${user.uId}&bId=" + n.bId + "\">还书</a></td>");
                            }
                            else{
                                borrow = $("<td><a class=\"borrowButton layui-btn\" href=\"javascript:void(0);\">还书</a></td>");
                            }
                            $(tr).append(borrow);
                        }


                        $("#allBorrowRecordTable>tbody").append(tr);
                    });
                },
                error: function () {
                    alert("123123123");
                }
            });

        });
    </script>
</head>
<body>
<table id="allBorrowRecordTable" border="1" cellspacing="0">
    <thead>
    <tr>
        <th>流水号</th>
        <th>用户ID</th>
        <th>书名</th>
        <th>借书时间</th>
        <th>还书时间</th>
        <th>应还图书馆</th>
        <th>借阅状态</th>
        <th>操作</th>
    </tr>
    </thead>

    <tbody>


    </tbody>
</table>
</body>
</html>
