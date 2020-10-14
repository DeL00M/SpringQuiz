<#import "main.ftl" as main>
<@main.page>

<head>
    <meta name="description" content="">
    <meta name="author" content="">
    <title></title>
    <link href="/css/card-horizontal.css" rel="stylesheet">
  </head>

<div class="container-fluid">
    <div class="row">
    <#list quizzes as quiz>
        <div class="col-md-3 mt-3">
            <div class="card flex-row flex-wrap border-0">
                <div class="card-header border-0" style="background-color: #FFFFFF;">
                    <#if quiz.img != "">
                    <#assign imgName=imgDir + imgUploadDir + "/" + quiz.img>
                    <#else>
                    <#assign imgName=imgDir + "/" + defaultImgName>
                    </#if>
                    <img src="${imgName}" alt="Card image cap">
                </div>
                <div class="card-body">
                    <h4 class="card-title text-wrap" style="width: 20rem;">${quiz.title}</h4>
                    <p class="card-text text-wrap" style="width: 20rem;">${quiz.description}</p>
                    <a href="#" class="btn btn-primary">Begin test</a>
                </div>
                <!--<div class="card-footer w-100 text-muted">
                    <small class="text-muted">Last updated 3 mins ago</small>
                </div>-->
            </div>
        </div>
    </#list>
    </div>
    </div>

</@main.page>