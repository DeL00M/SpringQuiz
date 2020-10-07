<#import "main.ftl" as main>
<@main.page>
<div>
    <form method="post" enctype="multipart/form-data">
    <input type="text" name="title" placeholder="Enter test title">
    <input type="text" name="description" placeholder="Enter test description">
    <input type="file" name="img">
    <button type="submit">Add</button>
    </form>
</div>
</@main.page>