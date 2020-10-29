<#import "main.ftl" as main>
<@main.page>

<div class="container">
<p style="color:#ff0000">${message?ifExists}</p>
<form method="post" enctype="multipart/form-data">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  <div class="form-group">
    <label for="title">Quiz title</label>
    <input type="text" name="title" class="form-control" id="title">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Quiz description</label>
    <input type="text" name="description" class="form-control" id="description">
  </div>
  <div class="form-group">
      <input type="file" name="img" id="img">
  </div>
  <button type="submit" class="btn btn-primary">Create new quiz</button>
</form>
</div>

</@main.page>