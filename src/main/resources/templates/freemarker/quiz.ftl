<#import "main.ftl" as main>
<@main.page>

<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title></title>
    <link href="/css/card-horizontal.css" rel="stylesheet">
  </head>

<div class="col-md-10 mx-auto">
    <div class="row">
    <#list quizzes as quiz>
        <div class="col-md-4 mt-3">
            <div class="card flex-row flex-wrap border-0">
                <div class="card-header border-0" style="background-color: #FFFFFF;">
                    <#if quiz.img != "">
                    <#assign imgName=imgDir + imgUploadDir + "/" + quiz.img>
                    <#else>
                    <#assign imgName=imgDir + "/" + defaultImgName>
                    </#if>
                    <img src="${imgName}" width="80px" height="80px" alt="Card image cap">
                </div>
                <div class="card-body">
                    <h4 class="card-title text-wrap" style="width: 20rem;">${quiz.title}</h4>
                    <p class="card-text text-wrap" style="width: 20rem;">${quiz.description}</p>
                    <a href="#" class="btn btn-primary">Begin test</a>
                    <div class="mt-2">
                    <small class="text-muted">Created by: ${quiz.authorName}</small>
                    </div>
                </div>
            </div>
        </div>
    </#list>
    </div>
</div>

</@main.page>