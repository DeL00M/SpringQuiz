<#import "main.ftl" as main>
<@main.page>
  <head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Please sign in</title>
    <link href="/css/signin.css" rel="stylesheet">
  </head>


  <div class="text-center">
    <form class="form-signin" action="/register" method="post">
      <!--<img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt="" width="72" height="72"> -->
      <h1 class="h3 font-weight-normal">Registration</h1>
      <label for="inputEmail" class="sr-only">User name</label>
      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
      <input type="text" name="username" id="inputEmail" class="form-control" placeholder="User name" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password" name="password" id="inputPassword" class="form-control mt-2" placeholder="Password" required>
      <!--<div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Remember me
        </label>
      </div>-->
      <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
      <!-- <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p> -->
    </form>
  </div>

</@main.page>