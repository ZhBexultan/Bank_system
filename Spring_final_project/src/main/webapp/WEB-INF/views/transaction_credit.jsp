<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Transactions|Manager</title>
    <link rel="stylesheet" href="resources/manager/vendors/iconfonts/mdi/css/materialdesignicons.min.css">
    <link rel="stylesheet" href="resources/manager/vendors/css/vendor.bundle.base.css">
    <link rel="stylesheet" href="resources/manager/vendors/css/vendor.bundle.addons.css">
    <link rel="stylesheet" href="resources/manager/css/style.css">
    <link rel="shortcut icon" href="resources/manager/images/favicon.png"/>

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
                <li class="nav-item">
                    <a href="manager_accounts" class="nav-link">
                        <i class="mdi mdi-account-multiple"></i>Accounts</a>
                </li>
                <li class="nav-item active">
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
                    <h4 class="card-title">Transaction</h4>
                    <div class="row">
                        <div class="col-md-3"><a href="manager_transactions_transfer">Transfer</a></div>
                        <div class="col-md-3"><a href="manager_transactions_exchange">Exchange</a></div>
                        <div class="col-md-3"><a href="manager_transactions_debet">Debet</a></div>
                        <div class="col-md-3"><a href="manager_transactions_credit">Credit</a></div>
                    </div>
                    <form class="form-sample" id="transaction" action="add_transaction_credit" method="post">
                        <div class="row">
                            <div class="col-md-6 col-md-offset-2">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-form-label">Sender</label>
                                    <div class="col-sm-9">
                                        <select class="form-control" name="sender">
                                            <c:if test="${accounts!=null}">
                                                <c:forEach items="${accounts}" var="account">
                                                    <option value="${account.id}">${account.first_name} ${account.last_name}</option>
                                                </c:forEach>
                                            </c:if>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-6">
                                <div class="form-group row">
                                    <label class="col-sm-3 col-md-offset-2 col-form-label">Amount</label>
                                    <div class="col-sm-9">
                                        <input class="form-control" name="amount"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                        <button type="submit" class="btn btn-success mr-2">Submit</button>
                    </form>
                </div>
            </div>
        </div>
        <br>

        <div class="col-md-12 grid-margin">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">My Transactions</h4>
                    <div class="table-responsive">
                        <table class="table table-bordered">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>Sender</th>
                                <th>Receiver</th>
                                <th>Operation</th>
                                <th>Currency</th>
                                <th>Amount</th>
                                <th>Time</th>
                            </tr>
                            </thead>
                            <c:if test="${manager_transactions!=null}">
                                <c:forEach items="${manager_transactions}" var="transaction">
                                    <tbody>
                                    <tr>
                                        <td class="font-weight-medium">${transaction.id}</td>
                                        <td>${transaction.sender_account_id.first_name} ${transaction.sender_account_id.last_name}</td>
                                        <td>${transaction.receiver_account_id.first_name} ${transaction.receiver_account_id.last_name}</td>
                                        <td>${transaction.operations.name}</td>
                                        <td>${transaction.currencies.name}</td>
                                        <td>${transaction.amount}</td>
                                        <td>${transaction.operation_time}</td>
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

    <footer class="footer">
        <div class="container-fluid clearfix">
            <center><span
                    class="text-muted d-block text-center text-sm-left d-sm-inline-block">© Bank of Qazaqstan</span>
            </center>
        </div>
    </footer>
</div>

<script src="resources/manager/vendors/js/vendor.bundle.base.js"></script>
<script src="resources/manager/vendors/js/vendor.bundle.addons.js"></script>
<script src="resources/manager/js/off-canvas.js"></script>
<script src="resources/manager/js/misc.js"></script>
<script src="resources/manager/js/dashboard.js"></script>
</body>
</html>