
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-lg-6">
            <h1 class="text-center text-danger">Thêm mới danh mục</h1>
            <form:form action="/product/create" method="post" modelAttribute="product" enctype="multipart/form-data">

                <div class="form-group">
                    <label for="name">Tên sản phẩm </label>
                    <form:input type="text" class="form-control" id="name" path="productName"/>
                </div>
                <div class="form-group">
                    <label for="price">gia </label>
                    <form:input type="text" class="form-control" id="price" path="price"/>
                </div>
                <div class="form-group">
                    <label> Danh Mục</label>
                    <form:select class="form-control" path="category.id">
                        <c:forEach items="${category}" var="item">
                            <option value="${item.id}">${item.name}</option>
                        </c:forEach>
                    </form:select>
                </div>
                <div class="form-group">
                    <label>Thêm Ảnh</label>
                     <input type="file" name="file_upload" src="" alt="" id=""/>
                </div>
                <button  type="submit" class="btn btn-primary">Add New</button>
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
