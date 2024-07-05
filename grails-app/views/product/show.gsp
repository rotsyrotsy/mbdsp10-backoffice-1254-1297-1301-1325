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
      <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="/Product">Products</a></li>
      <li class="breadcrumb-item text-sm text-dark active" aria-current="page">1</li>
    </ol>
    <h6 class="font-weight-bolder mb-0">Product</h6>
  </nav>
</content>
<div id="content" role="main">
  <div class="card card-body mx-3 mx-md-4 mt-2">
    <div class="row gx-4 mb-2">
      <div class="col-auto">
        <div class="avatar avatar-xl position-relative">
          <asset:image src="img/bruce-mars.jpg" alt="profile_image" class="w-100 border-radius-lg shadow-sm" />
        </div>
      </div>
      <div class="col-auto my-auto">
        <div class="h-100">
          <h5 class="mb-1">
            Huawei  Matebook X PRo
          </h5>
          <p class="mb-1 font-weight-normal text-sm">
            Current owner : User1235
          </p>
          <p class="mb-0 font-weight-normal text-sm">
            <span class="badge badge-sm bg-gradient-success">is exchangeable</span>
          </p>
        </div>
      </div>
    </div>
    <div class="row">
      <div class="row">
        <div class="col-8">
          <div class="card card-plain h-100">
            <div class="card-header pb-0 p-3">
              <h6 class="mb-0">Trade Proposals</h6>
            </div>
            <div class="card-body p-3">
              <div class="table-responsive p-0">
                <table class="table align-items-center mb-0">
                  <thead>
                  <tr>
                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Ref</th>
                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7 ps-2">Proposer</th>
                    <th class="text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Products</th>
                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Datetime</th>
                    <th class="text-center text-uppercase text-secondary text-xxs font-weight-bolder opacity-7">Status</th>
                    <th class="text-secondary opacity-7"></th>
                  </tr>
                  </thead>
                  <tbody>
                  <tr>
                    <td>
                      <span class="text-sm ">PO0125</span>
                    </td>
                    <td>
                      <span class="text-xs ">User123</span>
                    </td>
                    <td class="align-middle text-xs">
                      <ul>
                        <li>Tapis souris</li>
                        <li>Dell XPS 13</li>
                      </ul>
                    </td>
                    <td class="align-middle text-center">
                      <span class="text-secondary text-xs">23/04/18 07:15AM</span>
                    </td>
                    <td class="align-middle text-center text-sm">
                      <span class="badge badge-sm bg-gradient-danger">Rejected</span>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <span class="text-sm ">PO0125</span>
                    </td>
                    <td>
                      <span class="text-xs ">User123</span>
                    </td>
                    <td class="align-middle text-xs">
                      <ul>
                        <li>Tapis souris</li>
                        <li>Dell XPS 13</li>
                      </ul>
                    </td>
                    <td class="align-middle text-center">
                      <span class="text-secondary text-xs">23/04/18 07:15AM</span>
                    </td>
                    <td class="align-middle text-center text-sm">
                      <span class="badge badge-sm bg-gradient-success">Accepted</span>
                    </td>
                  </tr>
                  <tr>
                    <td>
                      <span class="text-sm ">PO0125</span>
                    </td>
                    <td>
                      <span class="text-xs ">User123</span>
                    </td>
                    <td class="align-middle text-xs">
                      <ul>
                        <li>Tapis souris</li>
                        <li>Dell XPS 13</li>
                      </ul>
                    </td>
                    <td class="align-middle text-center">
                      <span class="text-secondary text-xs">23/04/18 07:15AM</span>
                    </td>
                    <td class="align-middle text-center text-sm">
                      <span class="badge badge-sm bg-gradient-warning">Pending transaction</span>
                    </td>
                  </tr>
                  </tbody>
                </table>
              </div>

            </div>
          </div>
        </div>
        <div class="col-4">
          <div class="card card-plain h-100">
            <div class="card-header pb-0 p-3">
              <h6 class="mb-0">Transaction overview</h6>
            </div>
            <div class="card-body p-3">
              <div class="timeline timeline-one-side">
                <div class="timeline-block mb-3">
                  <span class="timeline-step">
                    <i class="material-icons text-success text-gradient">notifications</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">$2400, Design changes</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">22 DEC 7:20 PM</p>
                  </div>
                </div>
                <div class="timeline-block mb-3">
                  <span class="timeline-step">
                    <i class="material-icons text-danger text-gradient">code</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">New order #1832412</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">21 DEC 11 PM</p>
                  </div>
                </div>
                <div class="timeline-block mb-3">
                  <span class="timeline-step">
                    <i class="material-icons text-info text-gradient">shopping_cart</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">Server payments for April</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">21 DEC 9:34 PM</p>
                  </div>
                </div>
                <div class="timeline-block mb-3">
                  <span class="timeline-step">
                    <i class="material-icons text-warning text-gradient">credit_card</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">New card added for order #4395133</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">20 DEC 2:20 AM</p>
                  </div>
                </div>
                <div class="timeline-block mb-3">
                  <span class="timeline-step">
                    <i class="material-icons text-primary text-gradient">key</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">Unlock packages for development</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">18 DEC 4:54 AM</p>
                  </div>
                </div>
                <div class="timeline-block">
                  <span class="timeline-step">
                    <i class="material-icons text-dark text-gradient">payments</i>
                  </span>
                  <div class="timeline-content">
                    <h6 class="text-dark text-sm font-weight-bold mb-0">New order #9583120</h6>
                    <p class="text-secondary font-weight-bold text-xs mt-1 mb-0">17 DEC</p>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
