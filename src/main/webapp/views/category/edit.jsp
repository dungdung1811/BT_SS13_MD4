<%--
  Created by IntelliJ IDEA.
  User: nguye
  Date: 11/16/2023
  Time: 10:35 PM
  To change this template use File | Settings | File Templates.
--%>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Chỉnh sửa danh mục</h1>
            <form:form action="/category/save/${category.id}" method="post" modelAttribute="category">
                <div class="form-group">
                    <label for="name">Tên danh mục </label>
                    <form:input type="text"  class="form-control" path="name"/>

                </div>
                <div class="form-group">
                    <label> Trạng thái </label>
                    <div class="form-check form-check-inline">
                        <label class="form-check-label">
                            <form:radiobutton class="form-check-input" path="status" value="0" checked="checked"/>hien
                        </label>
                        <label class="form-check-label">
                            <form:radiobutton class="form-check-input" path="status" value="1"/>Ẩn
                        </label>
                    </div>
                </div>

                <button  type="submit" class="btn btn-primary">update</button>
            </form:form>
        </div>
    </div>
</div>
<!-- Optional JavaScript -->
<!-- jQuery first, then Popper.js, then Bootstrap JS -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</body>
</html>
