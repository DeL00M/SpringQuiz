<#import "main.ftl" as main>
<@main.page>
<div class="container">
Users
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Role</th>
        <th></th>
    </tr>
    </thead>
<#list users as user>
    <tr>
    <td>${user.username}</td>
    <td><#list user.roles as role>${role}<#sep>, </#list></td>
    <td><a href="/user/${user.id}">edit</a></td>
    </tr>
</#list>
</table>
</div>
</@main.page>