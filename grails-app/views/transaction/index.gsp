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
                <div class="input-group input-group-outline my-3">
                  <label class="form-label">Start date</label>
                  <input type="date" class="form-control">
                </div>
              </div>
              <div class="col">
                <div class="input-group input-group-outline my-3">
                  <label class="form-label">End date</label>
                  <input type="date" class="form-control">
                </div>
              </div>
              <div class="col">
                <button class="btn btn-primary my-3" type="submit">Search</button>
              </div>
            </div>
          </form>
          <div>
            <button class="btn btn-icon btn-3 btn-info" type="button">
              <span class="btn-inner--icon"><i class="material-icons">download</i></span>
              <span class="btn-inner--text">Export CSV</span>
            </button>
          </div>
        </div>

        <div class="card-body px-0 pb-2">
          <div class="table-responsive p-0">
            <table class="table align-items-center mb-0">
              <thead>
              <tr>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Ref</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Products Owner</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Products Proposer</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Owner</th>
                <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Proposer</th>
                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Date</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">TRANS123</span>
                </td>
                <td class="align-middle text-xs">
                  <ul>
                    <li>Matebook X PRo</li>
                    <li>Souris</li>
                  </ul>
                </td>
                <td class="align-middle text-xs">
                  <ul>
                    <li>Clavier</li>
                    <li>Dell XPS 13 neuf</li>
                  </ul>
                </td>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">Owner</span>
                </td>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">Proposer1</span>
                </td>
                <td class="align-middle text-center text-sm">
                  <span class="badge badge-sm bg-gradient-warning">Pending</span>
                </td>
                <td class="align-middle text-center">
                  <span class="text-secondary text-xs font-weight-bold">23/04/18</span>
                </td>
              </tr>
              <tr>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">TRANS123</span>
                </td>
                <td class="align-middle text-xs">
                  <ul>
                    <li>Matebook X PRo</li>
                    <li>Souris</li>
                  </ul>
                </td>
                <td class="align-middle text-xs">
                  <ul>
                    <li>Clavier</li>
                    <li>Dell XPS 13 neuf</li>
                  </ul>
                </td>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">Owner</span>
                </td>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">Proposer1</span>
                </td>
                <td class="align-middle text-center text-sm">
                  <span class="badge badge-sm bg-gradient-success">Accepted</span>
                </td>
                <td class="align-middle text-center">
                  <span class="text-secondary text-xs font-weight-bold">23/04/18</span>
                </td>
              </tr>
              <tr>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">TRANS123</span>
                </td>
                <td class="align-middle text-xs">
                  <ul>
                    <li>Matebook X PRo</li>
                    <li>Souris</li>
                  </ul>
                </td>
                <td class="align-middle text-xs">
                  <ul>
                    <li>Clavier</li>
                    <li>Dell XPS 13 neuf</li>
                  </ul>
                </td>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">Owner</span>
                </td>
                <td>
                  <span class="text-secondary text-xs font-weight-bold">Proposer1</span>
                </td>
                <td class="align-middle text-center text-sm">
                  <span class="badge badge-sm bg-gradient-danger">Rejected</span>
                </td>
                <td class="align-middle text-center">
                  <span class="text-secondary text-xs font-weight-bold">23/04/18</span>
                </td>
              </tr>

              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
