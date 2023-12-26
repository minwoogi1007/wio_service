<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<html lang="UTF-8">

<head>
    <title>WIO Service</title>
    <!-- HTML5 Shim and Respond.js IE10 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 10]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <!-- Meta -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="description" content="" />
    <meta name="keywords" content=""/>
    <meta name="author" content="CodedThemes"/>

    <!-- Favicon icon -->
    <link rel="icon" href="/assets/images/favicon.ico" type="image/x-icon">
    <!-- fontawesome icon -->
    <link rel="stylesheet" href="/assets/fonts/fontawesome/css/fontawesome-all.min.css">
    <!-- animation css -->
    <link rel="stylesheet" href="/assets/plugins/animation/css/animate.min.css">
    <!-- vendor css -->
    <link rel="stylesheet" href="/assets/css/style.css">

</head>

<body>
<div class="auth-wrapper">
    <div class="auth-content">
        <div class="auth-bg">
            <span class="r"></span>
            <span class="r s"></span>
            <span class="r s"></span>
            <span class="r"></span>
        </div>
        <div class="card">
            <div class="card-body text-center">
                <div class="mb-4">
                    <i class="feather icon-unlock auth-icon"></i>
                </div>
                <h3 class="mb-4">로그인</h3>
                <form action="/login" method="post">
                    <div class="input-group mb-3">
                        <input type="ID" class="form-control" placeholder="ID">
                    </div>
                    <div class="input-group mb-4">
                        <input type="password" class="form-control" placeholder="password">
                    </div>
                    <div class="form-group text-left">
                        <div class="checkbox checkbox-fill d-inline">
                            <input type="checkbox" name="checkbox-fill-1" id="checkbox-fill-a1" checked="">
                            <label for="checkbox-fill-a1" class="cr"> ID 저장</label>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary shadow-2 mb-4">Login</button><br>
                </form>
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#pop"  data-whatever="@mdo">업체 가입</button>
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal">직원 신청</button>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="pop" tabindex="-1" role="dialog" aria-labelledby="companyLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="companyLabel">아이디 신청</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="form-group">
                        <label for="company" class="col-form-label">업체명</label>
                        <input type="text" class="form-control" id="company">
                    </div>
                    <div class="form-group">
                        <label for="ID" class="col-form-label">ID</label>
                        <input type="text" class="form-control" id="ID">
                    </div>
                    <div class="form-group">
                        <label for="pass1" class="col-form-label">pass</label>
                        <input type="password" class="form-control" id="pass1">
                    </div>
                    <div class="form-group">
                        <label for="pass2" class="col-form-label">pass 확인</label>
                        <input type="password" class="form-control" id="pass2">
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-primary">신청</button>
            </div>
        </div>
    </div>
</div>
<!-- Required Js -->
<script src="/assets/js/vendor-all.min.js"></script>
<script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
