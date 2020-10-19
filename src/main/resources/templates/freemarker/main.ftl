<#macro page>
<#include "security.ftl">
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Quiz</title>
    <!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0 shrink-to-fit=no"/>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/sticky-footer.css">
</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="#">Spring Quizzes</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>

      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="/">Home <span class="sr-only">(current)</span></a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/quiz/add">Add new quiz</a>
          </li>
          <li class="nav-item">
            <a class="nav-link" href="/user">Users</a>
          </li>
        </ul>
        <div class="navbar-text mr-2">You are signed in as ${name}</div>
        <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
        <#if known>
        <#assign signcaption="Sign Out">
        <#else>
        <#assign signcaption="Sign In">
        </#if>
        <input class="btn btn-outline-success my-2 my-sm-0 mr-3" type="submit" value="${signcaption}"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
        <form class="form-inline my-2 my-lg-0">
          <input class="form-control mr-sm-2" name="query" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
      </div>
    </nav>
        <div class="mt-3">
        <#nested>
        </div>
    <footer class="footer bg-dark">
      <div class="container">
      <div class="text-center">
        <span class="text-muted">Powered by DeL00M in 2020.</span>
      </div>
      </div>
    </footer>

    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="/js/jquery-3.5.1.slim.min.js"></script>
    <script src="/js/popper.min.js"></script>
    <script src="/js/bootstrap.min.js"></script>
</body>

</html>
</#macro>