<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">
<@c.page>
    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="/catalog" class="form-inline">
                <input type="text" name="filter" class="form-control" value="${filter?ifExists}"
                       placeholder="Find By Name">
                <button type="submit" class="btn btn-primary ml-2">Find By Name</button>
            </form>
        </div>
    </div>

    <#if isAdmin>
        <div class="form-row">
            <a class="btn btn-primary" data-toggle="collapse" href="#addCollapse" role="button" aria-expanded="false"
               aria-controls="collapseExample">
                Add new ticket
            </a>
            <div class="collapse md-5" id="addCollapse">
                <div class="form-group m-3">
                    <form method="post" enctype="multipart/form-data">
                        <input class="form-control" type="text" name="name" placeholder="Name"/>
                        <input class="form-control" type="text" name="genre" placeholder="Genre"/>
                        <input class="form-control" type="text" name="rating" placeholder="Rating"/>
                        <input class="form-control" type="text" name="duration" placeholder="Duration"/>
                        <input class="form-control" type="text" name="beginsAt" placeholder="Time of start"/>
                        <input class="form-control" type="text" name="date" placeholder="Data"/>
                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-primary">Add</button>
                    </form>
                </div>
            </div>
            <div class="text-danger">
                ${addMessage?ifExists}
                ${exception?ifExists}
            </div>
        </div>
        <div class="form-row">
            <div class="form-group mt-2">
                <form method="get" action="/catalog" class="form-inline">
                    <input type="text" name="deleteTag" class="form-control" value="${deleteTag?ifExists}"
                           placeholder="Delete By Name"/>
                    <button type="submit" class="btn btn-primary ml-2">Delete By Name</button>
                </form>
            </div>
        </div>
    </#if>
    <h5>Tickets</h5>
    <div class="card-columns">
    <#list tickets as ticket>
        <div class="card my-3">
            <div class="card-header mb-1 text-primary">
                Film title: ${ticket.name}
            </div>
            <ul class="list-group list-group-flush">
                <li class="list-group-item">Genre: ${ticket.genre}</li>
                <li class="list-group-item">Rating: ${ticket.rating}</li>
                <li class="list-group-item">Show day: ${ticket.date}</li>
                <li class="list-group-item">Show time: ${ticket.beginsAt}</li>
                <li class="list-group-item">Duration: ${ticket.duration}</li>
            </ul>
        </div>
    <#else>
        <div class="p-3 mb-2 bg-info text-white">
            There are no tickets here.
        </div>
    </#list>
    </div>
</@c.page>