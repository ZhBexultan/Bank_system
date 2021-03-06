<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" type="image/png" sizes="16x16" href="resources/admin/assets/images/favicon.png">
    <title>Transactions|ADMIN</title>
    <link href="resources/admin/assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/admin/css/style.css" rel="stylesheet">
    <link href="resources/admin/css/colors/blue.css" id="theme" rel="stylesheet">
</head>

<body class="fix-header fix-sidebar card-no-border">
<div id="main-wrapper">
    <!--HEADER-->
    <header class="topbar">
        <nav class="navbar top-navbar navbar-toggleable-sm navbar-light">
            <!--LOGO-->
            <div class="navbar-header">
                <a class="navbar-brand" href="profile">
                    <b>
                        <img src="resources/admin/assets/images/logo-icon.png" style="height: 34px; width: 33px;"
                             alt="logo-icon" class="dark-logo"/>
                    </b>
                    <span>
                                <img src="resources/admin/assets/images/logo-text.png" alt="logo-text"
                                     class="dark-logo"/>
                            </span>
                </a>
            </div>

            <!--NAV ITEMS-->
            <div class="navbar-collapse">
                <ul class="navbar-nav mr-auto mt-md-0 ">
                    <li class="nav-item"><a class="nav-link nav-toggler hidden-md-up text-muted waves-effect waves-dark"
                                            href="javascript:void(0)"><i class="ti-menu"></i></a></li>
                    <li class="nav-item hidden-sm-down">
                        <form class="app-search p-l-20">
                            <input type="text" class="form-control" placeholder="Search for..."> <a class="srh-btn"><i
                                class="ti-search"></i></a>
                        </form>
                    </li>
                </ul>
                <ul class="navbar-nav my-lg-0">
                    <li class="nav-item dropdown">
                        <form action="logout" method="post">
                            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            <input type="submit" class="btn btn-link" value="LOGOUT">
                        </form>
                    </li>
                </ul>
            </div>
        </nav>
    </header>

    <!--LEFT SIDEBAR-->
    <aside class="left-sidebar">
        <div class="scroll-sidebar">
            <nav class="sidebar-nav">
                <ul id="sidebarnav">
                    <li>
                        <a href="profile" class="waves-effect"><i class="fa fa-home m-r-10" aria-hidden="true"></i>Main</a>
                    </li>
                    <li>
                        <a href="admin_managers" class="waves-effect"><i class="fa fa-user m-r-10"
                                                                         aria-hidden="true"></i>Managers</a>
                    </li>
                    <li>
                        <a href="admin_transactions" class="waves-effect"><i class="fa fa-exchange m-r-10"
                                                                             aria-hidden="true"></i>Transactions</a>
                    </li>
                    <li>
                        <a href="admin_currencies" class="waves-effect"><i class="fa fa-money m-r-10"
                                                                           aria-hidden="true"></i>Currencies</a>
                    </li>
                </ul>
            </nav>
        </div>
    </aside>

    <!--MAIN CONTENT-->
    <div class="page-wrapper">
        <div class="container-fluid">
            <div class="row page-titles">
                <div class="col-md-6 col-8 align-self-center">
                    <h3 class="text-themecolor m-b-0 m-t-0">Transactions</h3>
                </div>
            </div>

            <div class="row">
                <div class="col-sm-12">
                    <div class="card">
                        <div class="card-block">
                            <h4 class="card-title">Bank Transactions</h4>
                            <div class="table-responsive">
                                <table class="table">
                                    <thead>
                                    <tr>
                                        <th>#</th>
                                        <th>Manager</th>
                                        <th>Sender</th>
                                        <th>Receiver</th>
                                        <th>Operation</th>
                                        <th>Amount</th>
                                        <th>Currency</th>
                                    </tr>
                                    </thead>
                                    <c:if test="${transactions!=null}">
                                        <c:forEach items="${transactions}" var="transaction">
                                    <tbody>
                                    <tr>
                                        <td>${transaction.id}</td>
                                        <td>${transaction.manager_id.full_name}</td>
                                        <td>${transaction.sender_account_id.first_name} ${transaction.sender_account_id.last_name}</td>
                                        <td>${transaction.receiver_account_id.first_name} ${transaction.receiver_account_id.last_name}</td>
                                        <td>${transaction.operations.name}</td>
                                        <td>${transaction.amount}</td>
                                        <td><i class="fa fa-dollar m-r-10" aria-hidden="true"></i></td>
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

        <!--FOOTER-->
        <footer class="footer text-center">
            ©
            <small> Bank of Qazaqstan™</small>
        </footer>
    </div>
</div>

<script src="resources/admin/assets/plugins/jquery/jquery.min.js"></script>
<script src="resources/admin/assets/plugins/bootstrap/js/tether.min.js"></script>
<script src="resources/admin/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="resources/admin/js/jquery.slimscroll.js"></script>
->
<script src="resources/admin/js/waves.js"></script>
<script src="resources/admin/js/sidebarmenu.js"></script>
<script src="resources/admin/assets/plugins/sticky-kit-master/dist/sticky-kit.min.js"></script>
<script src="resources/admin/js/custom.min.js"></script>
<script src="resources/admin/assets/plugins/styleswitcher/jQuery.style.switcher.js"></script>
</body>

</html>
