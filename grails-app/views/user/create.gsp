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
            <li class="breadcrumb-item text-sm"><a class="opacity-5 text-dark" href="/User">Users</a></li>
            <li class="breadcrumb-item text-sm text-dark active" aria-current="page">Create</li>
        </ol>
        <h6 class="font-weight-bolder mb-0">Users</h6>
    </nav>
</content>
<div id="content" role="main">
    <div class="row">
        <div class="col-12">
            <div class="card ">
                <div class="card-header pb-0">
                    <h6 class="text-capitalize">Administrator User Creation</h6>
                </div>

                <div class="card-body pb-2">
                    <form>
                        <div class="input-group input-group-outline mb-4">
                            <label class="form-label">Email</label>
                            <input type="email" class="form-control">
                        </div>
                        <div class="input-group input-group-outline mb-4">
                            <label class="form-label">Password</label>
                            <input type="password" class="form-control">
                        </div>
                        <div class="input-group input-group-outline mb-4">
                            <select class="form-control">
                                <option selected>Role</option>
                                <option>Admin</option>
                                <option>Super Admin</option>
                                <option>User</option>
                            </select>
                        </div>
                        <button type="submit" id="submit" class="btn bg-gradient-primary mb-4">Save</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
