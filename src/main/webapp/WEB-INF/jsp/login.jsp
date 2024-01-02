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
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
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
                        <input type="ID" class="form-control" placeholder="ID" name="username">
                    </div>
                    <div class="input-group mb-4">
                        <input type="password" class="form-control" placeholder="password" name="password" >
                    </div>
                    <div class="form-group text-left">
                        <div class="checkbox checkbox-fill d-inline">
                            <input type="checkbox" name="checkbox-fill-1" id="checkbox-fill-a1" checked="">
                            <label for="checkbox-fill-a1" class="cr"> ID 저장</label>
                        </div>
                    </div>
                    <button type="submit"  value="Login" class="btn btn-primary shadow-2 mb-4">Login</button><br>
                </form>
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#pop"  data-whatever="@mdo">업체 가입</button>
                <button type="button" class="btn btn-link" data-toggle="modal" data-target="#exampleModal">직원 신청</button>
            </div>
        </div>
    </div>
</div>
<script>
    $(document).ready(function() {
        $("#ID").keyup(function() {
            var userId = $(this).val();

            // AJAX 요청
            $.ajax({
                url: "/checkUserId", // 서버의 URL (변경 가능)
                type: "GET",
                data: {
                    userId: userId
                },
                success: function(response) {
                    if(response.exists) {
                        // ID가 이미 존재하는 경우
                        alert("이미 존재하는 ID입니다.");
                    } else {
                        // 사용 가능한 ID인 경우
                        // 추가적인 처리 (예: 사용 가능 메시지 표시)
                    }
                },
                error: function(xhr) {
                    // 오류 처리
                }
            });
        });
    });
</script>


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
                <form action="/registerCompany" method="post">
                    <div class="form-group">
                        <label for="company" class="col-form-label">업체명:</label>
                        <input type="text" class="form-control" name="companyName" id="company">
                    </div>
                    <div class="form-group">
                        <label for="ID" class="col-form-label">ID:</label>
                        <input type="text" class="form-control" name="userId" id="ID">
                    </div>
                    <div class="form-group">
                        <label for="pass1" class="col-form-label">Password:</label>
                        <input type="password" class="form-control" name="password" id="pass1">
                    </div>
                    <div class="form-group">
                        <label for="pass2" class="col-form-label">Password 확인:</label>
                        <input type="password" class="form-control" id="pass2">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">닫기</button>
                        <button type="submit" class="btn btn-primary">신청</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- 로그인 실패 모달 -->
<div class="modal fade" id="loginErrorModal" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true" style="display: none;">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">로그인 에러</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <p>사용자 이름 또는 비밀번호가 잘못되었습니다.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap과 jQuery 스크립트 -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"></script>

<script>
    $(document).ready(function() {
        // 로그인 실패시 모달 표시
        <% if (request.getAttribute("loginError") != null) { %>
        $('#loginErrorModal').modal('show');
        <% } %>
    });
</script>
<!-- Required Js -->
<script src="/assets/js/vendor-all.min.js"></script>
<script src="/assets/plugins/bootstrap/js/bootstrap.min.js"></script>

</body>
</html>
