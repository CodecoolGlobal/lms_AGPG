<!DOCTYPE html>
<html lang="en" dir="ltr">
<head>
    <meta charset="utf-8">
    <title>Add new text page!</title>
</head>
<body>
<div class="navbar">
    <jsp:include page='header-mentor.jsp'>
        <jsp:param name="" value=""/>
    </jsp:include>
</div>
<h1>Logged in with: ${email} </h1>
<h1>Add new text page</h1>
<form class="" action="addtextpage" method="post">
    <input type="text" name="textpage_title" value="" placeholder="What's the title of this text page?">
    <br>
    <br>
    <textarea rows="5" cols="80" id="textpage" placeholder="Write your things here!" name="textpage_value"></textarea>
    <br>
    <select name="published" size="2">
        <option value="true">published</option>
        <option value="false">unpublished</option>
    </select>
    <input type="submit" name="submit" value="Submit">
</form>
</body>
</html>