<#import "main.ftl" as main>
<@main.page>
<div>
    <form method="post">
    <input type="text" name="title" placeholder="Enter test title">
    <input type="text" name="description" placeholder="Enter test description">
    <button type="submit">Add</button>
    </form>
</div>
</@main.page>