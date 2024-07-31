<!DOCTYPE html>
<html>
<head>
  <meta name="layout" content="main"/>
  <title>Transaction</title>
  <asset:stylesheet href="style.css"/>
</head>
<body>
<content tag="breadcrumb">
  <nav aria-label="breadcrumb">
    <ol class="breadcrumb bg-transparent mb-0 pb-0 pt-1 px-0 me-sm-6 me-5">
      <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="javascript:;">Home</a></li>
      <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Transactions</li>
    </ol>
    <h6 class="font-weight-bolder mb-0">Transactions</h6>
  </nav>
</content>
<div id="content" role="main">
  <div class="row">
    <div class="col-12">
      <div class="card ">
        <div class="card-header pb-0">
          <h6 class="text-capitalize">Log Transactions</h6>
          <g:form action="search"  method="GET" >
            <div class="row">
              <div class="col">
                <div class="input-group input-group-outline my-3">
                  <g:textField name="keyword"  class="form-control" id="keyword" placeholder="Username"
                               value="${params.keyword ?: ''}"/>
                </div>
              </div>
              <div class="col">
                <div class="input-group input-group-outline my-3">
                  <select id="exampleFormControlSelect1" class="form-control" name="state">
                    <option value="" ${params.state == '' || params.state == null ? 'selected' : ''}>All</option>
                    <option value="pending" ${params.state == 'pending' ? 'selected' : ''}>PENDING</option>
                    <option value="accepted" ${params.state == 'accepted' ? 'selected' : ''}>ACCEPTED</option>
                    <option value="rejected" ${params.state == 'rejected' ? 'selected' : ''}>REJECTED</option>
                  </select>
                </div>
              </div>
              <div class="col">
                <div class="input-group input-group-static  mb-3" style="margin-top: -0.5rem !important; ">
                  <label>Start date</label>
                  <input name="startDate"  type="datetime-local" class="form-control">
                </div>
              </div>
              <div class="col">
                <div class="input-group input-group-static mb-3" style="margin-top: -0.5rem !important; ">
                  <label>End date</label>
                  <input name="endDate"  type="datetime-local" class="form-control">
                </div>
              </div>
              <div class="col">
                <button class="btn btn-primary my-3" type="submit">Search</button>
              </div>
            </div>
          </g:form>
          <div >
          <g:form action="exportCsv"  method="POST" >
            <button class="btn btn-icon btn-3 btn-info" type="submit">
              <span class="btn-inner--icon"><i class="material-icons">download</i></span>
              <span class="btn-inner--text">Export CSV</span>
            </button>
          </g:form>
          </div>
        </div>

        <div class="card-body px-0 pb-2">
          <div class="table-responsive p-0">
            <table class="table align-items-center mb-0">
              <thead>
              <tr>
                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7"></th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Proposer</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Proposer products</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Taker</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Taker products</th>
                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Datetime</th>
                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                <th class="text-secondary opacity-7"></th>
              </tr>
              </thead>
              <tbody>
              <g:each in="${transactionList}" var="transaction" >
                <tr>
                  <td class="align-middle text-center">
                    <span class="text-sm "></span>
                  </td>
                  <td>
                    <span class="text-xs ">${transaction.exchange.ownerProposition.user.username}</span>
                  </td>
                  <td class=" align-middle text-xs">
                    <ul>
                      <g:each in="${transaction.exchange.ownerProposition.getProducts()}" var="product">
                        <li>${product.productName}</li>
                      </g:each>
                    </ul>
                  </td>
                  <td>
                    <span class="text-xs ">${transaction.exchange.takerProposition.user.username}</span>
                  </td>
                  <td class="align-middle text-xs">
                    <ul>
                      <g:each in="${transaction.exchange.takerProposition.getProducts()}" var="product">
                        <li>${product.productName}</li>
                      </g:each>
                    </ul>
                  </td>
                  <td class="align-middle text-center">
                    <span class="text-secondary text-xs">
                      ${transaction.formattedCreationDate}
                    </span>
                  </td>
                  <td class="align-middle text-center text-sm">
                    <span class="badge badge-sm bg-gradient-${transaction.status == 'ACCEPTED' ? 'success' : transaction.status == 'REJECTED' ? 'danger' : 'warning'}">
                      ${transaction.status}
                    </span>
                  </td>
                </tr>
              </g:each>
              </tbody>
            </table>

            <g:if test="${transactionCount > params.int('max')}">
              <div class="pagination pagination-primary">
                <g:paginate total="${transactionCount ?: 0}"/>
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
