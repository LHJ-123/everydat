
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <title>添加书籍</title>
</head>
<body>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <div class="page-header">
                <h1>
                    <small>新增书籍</small>
                </h1>
        </div>
    </div>
</div>
    <form action="${pageContext.request.contextPath}/book/addBook" method="post">
        <div class="form-group">
            <label for="bookname">书籍名称: </label>
            <input type="text" name="bookName" class="form-control" id="bookname" required>
        </div>
        <div class="form-group">
            <label for="bookcount">书籍数量: </label>
            <input type="text" name="bookCounts" class="form-control" id="bookcount" required>
        </div>
        <div class="form-group">
            <label for="bookdetail">书籍描述: </label>
            <input type="text" name="detail" class="form-control" id="bookdetail" required>
        </div>
        <div class="form-group">
            <input type="submit" class="form-control" value="添加">
        </div>
    </form>
</div>

</body>
</html>
