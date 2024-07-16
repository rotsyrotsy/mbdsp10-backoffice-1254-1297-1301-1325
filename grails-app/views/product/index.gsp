<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Dashboard</title>
    <asset:stylesheet href="style.css"/>
</head>
<body>
<content tag="breadcrumb">
    <nav aria-label="breadcrumb">
        <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
            <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Home</a></li>
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Products</li>
        </ol>
        <h6 class="font-weight-bolder mb-0">Products</h6>
    </nav>
</content>
<div id="content" role="main">
    <div class="row">
        <div class="col-12">
            <div class="card ">
                <div class="card-header pb-0">
                    <h6 class="text-capitalize">Product List</h6>
                    <form role="form">
                        <div class="row">
                            <div class="col">
                                <div class="input-group input-group-outline my-3">
                                    <label class="form-label">Keyword</label>
                                    <input type="text" class="form-control">
                                </div>
                            </div>
                            <div class="col">
                                <div class="input-group input-group-outline my-3">
                                    <select class="form-control" id="exampleFormControlSelect1">
                                        <option selected>State</option>
                                        <option>Is exchangeable</option>
                                        <option>Pending transaction</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col">
                                <button class="btn btn-primary my-3" type="submit">Search</button>
                            </div>
                        </div>
                    </form>
                </div>

                <div class="card-body px-0 pb-2">
                    <div class="table-responsive p-0">
                        <table class="table align-items-center mb-0">
                            <thead>
                            <tr>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Product</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Current owner</th>
                                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">First owner</th>
                                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Is exchangeable</th>
                                <th class="text-secondary opacity-7"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <g:each in="${productList}" var="product">
                                <tr>
                                    <td>
                                        <div class="d-flex px-2 py-1">
                                            <div>
                                                <asset:image src="uploads/${product.productImage}" alt="${product.productName}" class="avatar avatar-sm me-3 border-radius-lg" />
                                            </div>
                                            <div class="d-flex flex-column justify-content-center">
                                                <h6 class="mb-0 text-sm">${product.productName}</h6>
                                            </div>
                                        </div>
                                    </td>
                                    <td>
                                        <span class="text-xs font-weight-bold mb-0">${product.actualOwner.username}</span>
                                    </td>
                                    <td class="align-middle">
                                        <span class="text-xs font-weight-bold mb-0">${product.firstOwner.username}</span>
                                    </td>
                                    <td class="align-middle text-center text-sm">
                                        <span class="badge badge-sm ${product.isExchangeable ? "bg-gradient-success" : "bg-gradient-danger"}">${product.isExchangeable ? "TRUE" : "FALSE"}</span>
                                    </td>
                                    <td class="align-middle">
                                        <g:link action="show" id="${product.id}" class="text-secondary font-weight-bold text-xs" data-toggle="tooltip" data-original-title="Edit user">
                                            Show
                                        </g:link>
                                    </td>
                                </tr>
                            </g:each>
                            </tbody>
                        </table>
                        <g:if test="${productCount > params.int('max')}">
                            <div class="pagination pagination-primary">
                                <g:paginate total="${productCount ?: 0}"/>
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
