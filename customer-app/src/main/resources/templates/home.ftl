<#import "/spring.ftl" as spring />
<#assign xhtmlCompliant = true in spring>
<!DOCTYPE html>
<html>
<head>
    <title>${serviceName}</title>
</head>
<body>

<header>
    <a href="http://localhost:9095/portal4customer">home</a>
    <br>
    <a href="${productServiceUrl}">Products</a>
    
</header>

<h1>${serviceName}</h1>

<ul>
    <li><a href="<@spring.url '/customers' />">Pristup NoSql bazi</a></li>
    <li><a href="<@spring.url '/sqlCustomers' />">Pristup Sql bazi</a></li>
    <li><a href="<@spring.url '/admin' />">Customer Admin Page</a></li>
</ul>
</body>
</html>
