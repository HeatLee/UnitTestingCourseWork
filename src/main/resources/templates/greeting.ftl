<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <#if isAdmin><h5>Hello, admin</h5>
    <#elseif name == ""><h5>Hello, guest</h5>
    <#elseif name != "admin"><h5>Hello, ${name}</h5></#if>
</@c.page>