<#import "main.ftl" as main>
<@main.page>
<div class="container">
<div class="row">
<#list quizzes as quiz>
      <div class="col s2 center">
        <div class="card">
          <div class="card-image waves-effect waves-block waves-light">
            <img class="activator" src=${quiz.img}>
          </div>
          <div class="card-content">
            <span class="card-title activator grey-text text-darken-4">${quiz.title}<i class="material-icons right">more_vert</i></span>
            <p><a href="#">Begin test</a></p>
          </div>
          <div class="card-reveal">
            <span class="card-title grey-text text-darken-4">${quiz.title}<i class="material-icons right">close</i></span>
            <p>${quiz.description}</p>
         </div>
        </div>
      </div>
    </#list>
</div>
</div>
</@main.page>