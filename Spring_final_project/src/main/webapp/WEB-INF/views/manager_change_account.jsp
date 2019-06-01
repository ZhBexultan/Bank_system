<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Change Account|Manager</title>
    <link rel="stylesheet" href="resources/manager/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="resources/manager/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="resources/manager/vendors/css/vendor.bundle.addons.css">
    <link rel="stylesheet" href="resources/manager/css/style.css">
    <link rel="shortcut icon" href="resources/manager/images/favicon.png"/>
    <link href="resources/manager/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet" />
    <link href="resources/manager/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <style>
        footer {
            position: fixed;
            left: 0;
            bottom: 0;
            width: 100%;
            background-color: red;
            color: white;
            text-align: center;
        }
    </style>
</head>

<body>
<div class="container-scroller">

    <nav class="navbar default-layout col-lg-12 col-12 p-0 fixed-top d-flex flex-row">
        <div class="text-center navbar-brand-wrapper d-flex align-items-top justify-content-center">
            <a class="navbar-brand brand-logo" href="profile">
                <img src="resources/manager/images/logo-icon.png" style="height: 34px; width: 33px;" alt="logo"/>
            </a>
        </div>

        <div class="navbar-menu-wrapper d-flex align-items-center">
            <ul class="navbar-nav navbar-nav-left header-links d-none d-md-flex">
                <li class="nav-item">
                    <a href="profile" class="nav-link">
                        <i class="mdi mdi-account"></i>Manager Page</a>
                </li>
                <li class="nav-item active">
                    <a href="manager_accounts" class="nav-link">
                        <i class="mdi mdi-account-multiple"></i>Accounts</a>
                </li>
                <li class="nav-item">
                    <a href="manager_transactions" class="nav-link">
                        <i class="mdi mdi-credit-card-multiple"></i>Transactions</a>
                </li>
            </ul>
            <ul class="navbar-nav navbar-nav-right">

                <li class="nav-item dropdown d-none d-xl-inline-block">
                    <a class="nav-link dropdown-toggle" id="UserDropdown" href="#" data-toggle="dropdown"
                       aria-expanded="false">
                        <span class="profile-text">Bank Manager</span>
                        <img class="img-xs rounded-circle" src="resources/manager/images/face1.jpg" alt="Profile image">
                    </a>
                    <div class="dropdown-menu dropdown-menu-right navbar-dropdown" aria-labelledby="UserDropdown">
                        <a class="dropdown-item mt-2">
                            Manager Profile
                        </a>
                        <form action="logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-link" value="LOGOUT">
                        </form>
                    </div>
                </li>
            </ul>
        </div>
    </nav>

    <br><br>
    <div class="content-wrapper">
        <div class="col-12 grid-margin">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Update ${account.first_name} ${account.last_name}</h4>
                    <form class="form-sample" action="update_account" method="post">
                        <p class="card-description">
                            Info to Change
                        </p>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">First Name</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="account_first_name" value="${account.first_name}" class="form-control" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Last Name</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="account_last_name" value="${account.last_name}" class="form-control" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">IIN Number</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="account_iin_number"value="${account.iin_number}" class="form-control" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Blocking</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="account_is_blocked" required>
                                            <option value="true" <c:if test="${account.is_blocked==true}"> selected</c:if>>Blocked</option>
                                            <option value="false" <c:if test="${account.is_blocked==false}"> selected</c:if>>Not Blocked</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="account_id" value="${account.id}">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-success mr-2">UPDATE</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>


<footer class="footer">
    <div class="container-fluid clearfix">
        <center><span class="text-muted d-block text-center text-sm-left d-sm-inline-block">© Bank of Qazaqstan</span>
        </center>
    </div>
</footer>
</div>

<script src="resources/manager/vendors/js/vendor.bundle.base.js"></script>
<script src="resources/manager/vendors/js/vendor.bundle.addons.js"></script>
<script src="resources/manager/js/off-canvas.js"></script>
<script src="resources/manager/js/misc.js"></script>
<script src="resources/manager/js/dashboard.js"></script>
<script src="resources/manager/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>
<script src="resources/manager/plugins/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
</body>
</html>
