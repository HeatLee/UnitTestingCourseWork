<#import "parts/common.ftl" as c>
<@c.page>
    <h5>User Editor</h5>
    <form action="/user" method="post">
        <input class="form-control" type="text" name="username" value="${user.username}"/>
        <#list roles as role>
                    <div class="input-group-text">
                        <label><input type="checkbox"
                                      name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}>${role}
                        </label>
                    </div>
        </#list>
        <input type="hidden" value="${user.id}" name="userId">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit" class="btn btn-primary">Save</button>
    </form>
</@c.page>