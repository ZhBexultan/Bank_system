<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Accounts|Manager</title>
    <link rel="stylesheet" href="resources/manager/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="resources/manager/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="resources/manager/vendors/css/vendor.bundle.addons.css">
    <link rel="stylesheet" href="resources/manager/css/style.css">
    <link rel="shortcut icon" href="resources/manager/images/favicon.png"/>
    <link href="resources/manager/plugins/bootstrap-material-datetimepicker/css/bootstrap-material-datetimepicker.css" rel="stylesheet" />
    <link href="resources/manager/plugins/bootstrap-datepicker/css/bootstrap-datepicker.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#ssearch").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#stable tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
                });
            });
        });
    </script>
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
                    <h4 class="card-title">Create New Account</h4>
                    <form class="form-sample" action="add_account" method="post">
                        <p class="card-description">
                            Personal info
                        </p>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">First Name</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="account_first_name" class="form-control" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Last Name</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="account_last_name" class="form-control" required/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">IIN Number</label>
                                    <div class="col-sm-9">
                                        <input type="text" name="account_iin_number" class="form-control" required/>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Date of Birth</label>
                                    <div class="col-sm-9">
                                        <input type="date" class="form-control" name="account_birth_date" required>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Currency</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="account_currency" <c:if test="${currencies==null}">disabled</c:if> required>
                                            <c:if test="${currencies!=null}">
                                                <c:forEach items="${currencies}" var="currency">
                                            <option value="${currency.id}">${currency.name}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-success mr-2">Create</button>
                    </form>
                </div>
            </div>
        </div>

        <div class="col-12 grid-margin">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Accounts</h4>
                    <div class="row" style="margin-left: 15px">
                        <i class="mdi mdi-account-search icon-md"></i>
                        <input type="text" id="ssearch" class="form-control col-md-3" placeholder="Username"
                               aria-label="Username" aria-describedby="basic-addon1">
                    </div>
                    <div class="table-responsive">
                        <table class="table database">
                            <thead>
                            <tr>
                                <th>IBAN</th>
                                <th>Full Name</th>
                                <th>IIN Number</th>
                                <th>Amount</th>
                                <th>Currency</th>
                                <th>Created Date</th>
                                <th>Blocked</th>
                                <th>EDIT</th>
                            </tr>
                            </thead>
                            <c:if test="${accounts!=null}">
                                <c:forEach items="${accounts}" var="account">
                            <tbody id="stable">
                            <tr>
                                <td>${account.name}</td>
                                <td>${account.first_name} ${account.last_name}</td>
                                <td>${account.iin_number}</td>
                                <td>${account.amount}</td>
                                <td>${account.currencies.short_name}</td>
                                <td>${account.created_date}</td>
                                <td>${account.is_blocked}</td>
                                <td><a href="manager_change_account?id=${account.id}">EDIT</a></td>
                            </tr>
                            </tbody>
                                </c:forEach>
                            </c:if>
                        </table>
                    </div>
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
