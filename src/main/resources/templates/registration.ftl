<#import "parts/common.ftl" as c>
<#import "parts/login.ftl" as l>
<@c.page>
    <h5 class="mb-1">Add new user</h5>
    <div class="text-danger">${message?ifExists}</div>
    <@l.login "/registration" true/>
</@c.page>