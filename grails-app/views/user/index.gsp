<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>User</title>
    <asset:stylesheet href="style.css"/>
</head>
<body>
<content tag="breadcrumb">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="${createLink(uri: '/')}">Home</a></li>
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Users</li>
        </ol>
        <h6 class="font-weight-bolder mb-0">Users</h6>
    </nav>
</content>
<div id="content" role="main">
    <div class="row">
        <div class="col-12">
            <div class="card ">
                <div class="card-header pb-0">
                    <h6 class="text-capitalize">User List</h6>

                    <g:link action="create" class="btn btn-icon btn-3 btn-info" type="button">
                        <span class="btn-inner--icon"><i class="material-icons">add</i></span>
                        <span class="btn-inner--text">Add a new admin user</span>
                    </g:link>

                </div>

                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                            <tr>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">#</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Username</th>
                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Rating</th>
                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Locked at</th>
                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Banned at</th>
                                <th class="text-secondary opacity-7"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${userList}" var="user">
                                <tr>
                                    <th class="text-center" scope="row">
                                        <span class="text-secondary text-xs font-weight-bold">${user.id}</span>
                                    </th>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-sm">${user.username}</h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="align-middle text-center">
                                        <span class="text-secondary text-xs font-weight-bold">0/5</span>
                                    </td>
                                    <td class="align-middle text-center">
                                        <g:if test="user.enabled==false">
                                            <span class="text-secondary text-xs font-weight-bold">
                                                <g:if test="user.locked_at">
                                                    <g:formatDate format="yyyy-MM-dd" date="${user.locked_at}"/>
                                                </g:if>
                                            </span>
                                        </g:if>
                                    </td>
                                    <td class="align-middle text-center">
                                        <g:if test="user.enabled==false">
                                            <span class="text-secondary text-xs font-weight-bold">
                                                <g:if test="user.deleted_at">
                                                    <g:formatDate format="yyyy-MM-dd" date="${user.deleted_at}"/>
                                                </g:if>
                                            </span>
                                        </g:if>
                                    </td>
                                    <td class="align-middle">
                                        <div class="d-flex gap-3">
                                            <div>
                                                <g:link action="show" id="${user.id}" class="btn btn-link text-primary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Show user">
                                                    Show
                                                </g:link>
                                            </div>
                                            <g:if test="${!user.deleted_at}">
                                                <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_SUPER_ADMIN">
                                                    <g:form controller="user" action ="moderateAccount" method="PUT" id="${user.id}">
                                                        <div>
                                                            <g:if test="${user.locked_at}">
                                                                <input type="hidden" value="unlock" name="moderateAction"/>
                                                                <button class="btn btn-link text-success font-weight-bold text-xs" type="submit" onclick="return confirm('Are you sure?');">
                                                                    Unlock Account
                                                                </button>
                                                            </g:if>
                                                            <g:else>
                                                                <input type="hidden" value="lock" name="moderateAction"/>
                                                                <button class="btn btn-link text-warning font-weight-bold text-xs" type="submit" onclick="return confirm('Are you sure?');">
                                                                    Lock Account
                                                                </button>
                                                            </g:else>
                                                        </div>
                                                    </g:form>
                                                </sec:ifAnyGranted>

                                                <sec:ifAnyGranted roles="ROLE_ADMIN,ROLE_SUPER_ADMIN">
                                                    <g:form controller="user" action ="moderateAccount" method="PUT" id="${user.id}">
                                                        <div>
                                                            <input type="hidden" value="ban" name="moderateAction"/>
                                                            <button class="btn btn-link text-danger font-weight-bold text-xs" type="submit" onclick="return confirm('Are you sure?');">
                                                                Ban
                                                            </button>
                                                        </div>
                                                    </g:form>
                                                </sec:ifAnyGranted>
                                            </g:if>
                                        </div>

                                    </td>
                                </tr>
                            </g:each>
                            </tbody>
                        </table>
                        <g:if test="${userCount > params.int('max')}">
                            <div class="pagination">
                                <g:paginate total="${userCount ?: 0}" />
                            </div>
                        </g:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
