<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<html lang="en" ng-app="labApp">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Wat Duangdee</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/normalize.css">
    <link rel="stylesheet" href="bower_components/html5-boilerplate/css/main.css">
    <link rel="stylesheet" href="app.css">
    <link rel="stylesheet" href="bower_components/bootstrap/dist/css/bootstrap.css">
    <script src="bower_components/html5-boilerplate/js/vendor/modernizr-2.6.2.min.js"></script>
    <script src="bower_components/angular/angular.js"></script>
    <script src="bower_components/angular-route/angular-route.js"></script>
    <script src="bower_components/angular-resource/angular-resource.js"></script>
    <script src="bower_components/jquery/dist/jquery.min.js"></script>
    <script src="bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
    <script src="bower_components/ng-flow/dist/ng-flow-standalone.js"></script>
    <script src="bower_components/angular-cookies/angular-cookies.js"></script>
    <script src="app.js"></script>
    <script src="js/productController.js"></script>
    <script src="js/productService.js"></script>
    <script src="js/SecurityController.js"></script>
    <script src="js/accountController.js"></script>
    <script src="js/accountService.js"></script>
    <script src="js/qandaController.js"></script>
    <script src="js/qandaService.js"></script>
    <script src="js/galleryController.js"></script>
    <script src="js/galleryService.js"></script>


    <!-- add i18n script -->
    <script src="bower_components/angular-translate/angular-translate.js"></script>
    <script src="bower_components/angular-translate-loader-url/angular-translate-loader-url.js"></script>
    <script src="js/languageServices.js"></script>
    <script src="js/languageControllers.js"></script>
    <script src="js/shoppingCartController.js"></script>
    <script src="js/shoppingCartService.js"></script>


</head>
<body>
<br>


<div class="boxContent" ng-controller="languageController">

    <div class="form-group col-lg-12">
        <div class="col-sm-5">
            <img src="images/waticon.png">
            <img src="images/font1.png">
        </div>
        <div class="ng-scope col-md-4 " ng-controller="loginController" style="float: right; overflow: hidden;">
            <form class="form-inline " ng-hide="user">

                <div>
                    <label for="username" class="col-sm-4  control-label">User Name:</label>

                    <div class="  col-sm-5"><input id="username" ng-model="username" type="text" size="30"
                                                 class="form-control"/></div>
                </div>
                <div>
                    <label for="password" class="col-sm-4 control-label">Password :</label>

                    <div class=" col-sm-3"><input id="password" ng-model="password" type="password" size="30"
                                                 class="form-control"/></div>
                </div>


                <div style="margin-top: 20px;">
                    <div class="col-sm-offset-6 col-sm-7">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" ng-model="rememberMe"> Remember me
                            </label>
                        </div>
                    </div>
                </div>

                <div style="margin-top: 20px;">
                    <div class="col-sm-offset-6 col-sm-7">
                        <div class="checkbox">
                            <label>
                                <input type="submit" value="LOG IN" class="btn btn-primary" ng-click="login()"/>
                            </label>
                            <label>
                                <a href="#/register">Register</a>
                            </label>
                        </div>
                    </div>
                </div>
            </form>
            <form ng-show="user">
                <div class="H6 col-sm-5 col-sm-offset-3 text-right">
                    Hello !!! {{user.name}}
                </div>
                <div class="form-group">
                    <div class="col-sm-3">
                        <input type="submit" value="Log Out" class="btn btn-primary" ng-click="logout()"/>
                    </div>
                </div>
            </form>
        </div>


    </div>

    <div class="collapse navbar-collapse" ng-controller="languageController">

        <ul class="nav navbar-inverse nav-pills navbar-left col-md-offset-11   " >
            <li ng-class="{'active':currentLocale== 'en'}"><a href="" ng-click="changeLanguage('en')">EN </a></li>
            <li ng-class="{'active':currentLocale== 'th'}"><a href="" ng-click="changeLanguage('th')">TH</a></li>
        </ul>

                </form>

                    <%--</div>--%>
                <%--<div class="collapse navbar-collapse" ng-controller="languageController"></div>--%>
                <%--<ul class="nav navbar-nav navbar-right" ng-show="hasRole('foreign user')">--%>
                    <%--<li ng-class="{'active':currentLocale== 'en'}"><a href="" ng-click="changeLanguage('en')">EN </a></li>--%>
                    <%--<li ng-class="{'active':currentLocale== 'th'}"><a href="" ng-click="changeLanguage('th')">TH</a></li>--%>
                <%--</ul>--%>
            <%--</div>--%>

    </div>
</div>


<div class="container ng-hide" ng-show="initialized">
    <div class="alert alert-danger" ng-show="error">{{error}}</div>
</div>


<div class="col-md-12">
    <!-- Fixed left nav column -->
    <div ng-include src="'template/leftnav.html'"></div>
</div>


<div class="container-fluid">
    <div class="row">

        <div class="col-md-10">
            <!-- Breadcrumbs
           ================================================== -->


            <ng-view>Loading...</ng-view>

        </div>
    </div>
</div>


<!-- In production use:
<script src="//ajax.googleapis.com/ajax/libs/angularjs/x.x.x/angular.min.js"></script>
-->

</body>
</html>
