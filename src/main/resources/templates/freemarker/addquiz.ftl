<#import "main.ftl" as main>
<@main.page>

<form method="post" enctype="multipart/form-data">
  <div class="form-group">
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    <label for="title">Quiz title</label>
    <input type="text" name="title" class="form-control" id="title">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Quiz description</label>
    <input type="text" name="description" class="form-control" id="description">
  </div>
  <div class="form-group">
      <label for="img">Quiz image</label>
      <input type="file" name="img" class="form-control-file" id="img">
    </div>
  <button type="submit" class="btn btn-primary">Create new quiz</button>
</form>

</@main.page>