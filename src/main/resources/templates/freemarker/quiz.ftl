<#import "main.ftl" as main>
<@main.page>

<div class="container">
<div class="card-deck">
<#list quizzes as quiz>
  <div class="card">
    <#if quiz.img != "">
        <#assign imgPath=imgUploadDir + "/" + quiz.img>
    <#else>
        <#assign imgPath=imgDir + "/" + defaultImgName>
    </#if>
    <img class="card-img-top" style="width: 7rem; height: 10vh;" src=${imgPath} alt="Card image cap">
    <div class="card-body">
      <h5 class="card-title">${quiz.title}</h5>
      <p class="card-text">${quiz.description}</p>
      <a href="#" class="btn btn-primary">Begin test</a>
    </div>
  </div>
</#list>
</div>
</div>
</@main.page>