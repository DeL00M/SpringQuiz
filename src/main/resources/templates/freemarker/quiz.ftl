<#import "main.ftl" as main>
<@main.page>

<div class="container">
<div class="row">
<#list quizzes as quiz>
<div class="col-sm-3 mt-3">
  <div class="card">
    <#if quiz.img != "">
        <#assign imgName=imgUploadDir + "/" + quiz.img>
    <#else>
        <#assign imgName=imgDir + "/" + defaultImgName>
    </#if>
    <img class="card-img-top" style="width: 6rem; height: 10vh;" src=${imgName} alt="">
    <div class="card-body">
      <h5 class="card-title">${quiz.title}</h5>
      <p class="card-text">${quiz.description}</p>
      <a href="#" class="btn btn-primary">Begin test</a>
    </div>
  </div>
  </div>
</#list>
</div>
</div>

</@main.page>