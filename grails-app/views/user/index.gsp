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
                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Products</th>
                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Rating</th>
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
                                        <span class="text-secondary text-xs font-weight-bold">${user.actualProducts.size()}</span>
                                    </td>
                                    <td class="align-middle text-center">
                                        <span class="text-secondary text-xs font-weight-bold">0/5</span>
                                    </td>
                                    <td class="align-middle">
                                        <div class="d-flex gap-3">
                                            <div>
                                                <g:link action="show" id="${user.id}" class="text-primary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Show user">
                                                    Show
                                                </g:link>
                                            </div>
                                            <div>
                                                <a href="javascript:;" class="text-warning font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Suspend user">
                                                    Suspend Account
                                                </a>
                                            </div>
                                            <div>
                                                <a href="javascript:;" class="text-danger font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Ban user">
                                                    Ban
                                                </a>
                                            </div>
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
