<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.rtl.min.css" integrity="sha384-T5m5WERuXcjgzF8DAb7tRkByEZQGcpraRTinjpywg37AO96WoYN9+hrhDVoM6CaT" crossorigin="anonymous">

  <title>Hello World!</title>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <nav class="navbar navbar-expand-lg bg-body-tertiary">
      <div class="container-fluid">
        <a class="navbar-brand" href="#">Navbar</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
          <div class="navbar-nav">
            <a class="nav-link active" aria-current="page" href="#">Home</a>
            <a class="nav-link" href="#">Features</a>
            <a class="nav-link" href="#">Pricing</a>
            <a class="nav-link disabled">Disabled</a>
          </div>
        </div>
      </div>
    </nav>
  </div>
  <div class="row content">
    <div class="col">
      <div class="card">
        <div class="card-header">
          Featured
        </div>
        <div class="card-body">
          <form action="/todo/modify" method="post">
          <div  class="input-group mb-3">
            <span class="input-troup-text">TNO</span>
            <input type="text" name="tno" class="form-control" value='<c:out value="${dto.tno}"/>' readonly/>
          </div>
          <div  class="input-group mb-3">
            <span class="input-troup-text">Title</span>
            <input type="text" name="title" class="form-control" value='<c:out value="${dto.title}"/>'/>
          </div>
          <div  class="input-group mb-3">
            <span class="input-troup-text">DueDate</span>
            <input type="text" name="dueDate" class="form-control" value='<c:out value="${dto.dueDate}"/>'/>
          </div>
          <div  class="input-group mb-3">
            <span class="input-troup-text">Writer</span>
            <input type="text" name="writer" class="form-control" value='<c:out value="${dto.writer}"/>' readonly/>
          </div>
          <div class="form-check">
            <label class="form-check-label">
              Finished &nbsp;
            </label>
            <input class="form-check-input" type="checkbox" name="finished" ${dto.finished?"checked":""}disabled/>
          </div>
          <div class="my-4">
            <div class="float-end">
              <button type="button" class="btn btn-danger">Remove</button>
              <button type="button" class="btn btn-primary">Modify</button>
              <button type="button" class="btn btn-secondary">List</button>
            </div>
          </div>
          </form>

          <script>
            const serverValidResult = {}

            <c:forEach items="${errors}" var="error">
            serverValidResult['${error.getField()}'] = '${error.defaultMessage}'
            </c:forEach>

            console.log(serverValidResult)

            const formObj = document.querySelector("form")

            document.querySelector(".btn-danger").addEventListener("click",function(e){
              e.preventDefault()
              e.stopPropagation()
              formObj.action=`/todo/remove?${pageRequestDTO.link}`
              formObj.method="post"

              formObj.submit()
            },false);

            document.querySelector(".btn-primary").addEventListener("click",function (e){
              e.preventDefault()
              e.stopPropagation()

              formObj.action="/todo/modify"
              formObj.method="post"

              formObj.submit();
            },false)

            document.querySelector(".btn-secondary").addEventListener("click",function(e){
              e.preventDefault()
              e.stopPropagation()

              self.location = `/todo/list?${pageRequestDTO.link}`
            },false)
          </script>
        </div>
      </div>
    </div>
  </div>
  <div class="row footer">
    <div class ="row fixed-bottom" style="z-index : -100">
      <footer class="py-1 my-1">
        <p class="text-center text-muted">Footer</p>
      </footer>
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>

</body>
</html>