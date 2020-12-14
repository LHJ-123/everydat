
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <title>修改书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>修改书籍</small>
                </h1>
            </div>
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/book/updateBook" method="post">

        <input type="hidden" name="bookID" value="${qBooks.bookID}">

        <div class="form-group">
            <label for="bookname">书籍名称: </label>
            <input type="text" name="bookName" class="form-control" id="bookname" value="${qBooks.bookName}" required>
        </div>
        <div class="form-group">
            <label for="bookcount">书籍数量: </label>
            <input type="text" name="bookCounts" class="form-control" id="bookcount" value="${qBooks.bookCounts}" required>
        </div>
        <div class="form-group">
            <label for="bookdetail">书籍描述: </label>
            <input type="text" name="detail" class="form-control" id="bookdetail" value="${qBooks.detail}" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="修改">
        </div>
    </form>
</div>


</body>
</html>
