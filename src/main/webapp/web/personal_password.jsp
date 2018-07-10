<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<html>
<head lang="en">
<meta charset="UTF-8">
<title>我的订单 - 达内学子商城</title>
<link href="${pageContext.request.contextPath}/css/orders.css" rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/header.css" rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/footer.css" rel="Stylesheet" />
<link href="${pageContext.request.contextPath}/css/personage.css" rel="stylesheet" />
</head>
<body>
	<!-- 页面顶部-->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- nav主导航-->

	<!-- 我的订单导航栏-->
	<div id="nav_order">
		<ul>
			<li><a href="">首页<span>&gt;</span>个人中心
			</a></li>
		</ul>
	</div>
	<!--我的订单内容区域 #container-->
	<div id="container" class="clearfix">
		<!-- 左边栏-->
		<jsp:include page="Left.jsp"></jsp:include>
		<!-- 右边栏-->
		<!--个人信息头部-->
		<div class="rightsidebar_box rt">
			<div class="rs_header">
				<span><a href="${pageContext.request.contextPath}/user/showPersonInfo.do">我的信息</a></span> <span
					class="rs_header_active"><a href="${pageContext.request.contextPath}/user/showPassword.do">安全管理</a></span>
			</div>

			<!--安全管理 -->
			<div class="rs_content">
				<p class="change_password_title">更改密码</p>
				<div class="new_password">
					<span class="word">输入旧密码：</span><input type="password"
						name="oldPwd" id="oldPwd" /><span id="oldPwdSpan"
						class="change_hint"></span>
				</div>
				<div class="new_password">
					<span class="word">输入新密码：</span><input type="password"
						name="newPwd" id="newPwd" /><span id="newPwdSpan"
						class="change_hint"></span>
				</div>
				<div class="confirm_password">
					<span class="word">确认新密码：</span><input id="confirmPwd"
						type="password" /><span id="confirmSpan" class="confirm_hint"></span>
				</div>
				<div class="save_password" onclick="updatePwd()">保存更改</div>
			</div>


		</div>
	</div>

	<!-- 品质保障，私人定制等-->
	<div id="foot_box">
		<div class="icon1 lf">
			<img src="${pageContext.request.contextPath}/images/footer/icon1.png" alt="" />

			<h3>品质保障</h3>
		</div>
		<div class="icon2 lf">
			<img src="${pageContext.request.contextPath}/images/footer/icon2.png" alt="" />

			<h3>私人定制</h3>
		</div>
		<div class="icon3 lf">
			<img src="${pageContext.request.contextPath}/images/footer/icon3.png" alt="" />

			<h3>学员特供</h3>
		</div>
		<div class="icon4 lf">
			<img src="${pageContext.request.contextPath}/images/footer/icon4.png" alt="" />

			<h3>专属特权</h3>
		</div>
	</div>
	<!-- 页面底部-->
	<div class="foot_bj">
		<div id="foot">
			<div class="lf">
				<p class="footer1">
					<img src="${pageContext.request.contextPath}/images/footer/logo.png" alt="" class=" footLogo" />
				</p>
				<p class="footer2">
					<img src="${pageContext.request.contextPath}/images/footer/footerFont.png" alt="" />
				</p>
			</div>
			<div class="foot_left lf">
				<ul>
					<li><a href="#"><h3>买家帮助</h3></a></li>
					<li><a href="#">新手指南</a></li>
					<li><a href="#">服务保障</a></li>
					<li><a href="#">常见问题</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>商家帮助</h3></a></li>
					<li><a href="#">商家入驻</a></li>
					<li><a href="#">商家后台</a></li>
				</ul>
				<ul>
					<li><a href="#"><h3>关于我们</h3></a></li>
					<li><a href="#">关于达内</a></li>
					<li><a href="#">联系我们</a></li>
					<li><img src="${pageContext.request.contextPath}/images/footer/wechat.png" alt="" /> <img
						src="${pageContext.request.contextPath}/images/footer/sinablog.png" alt="" /></li>
				</ul>
			</div>
			<div class="service">
				<p>学子商城客户端</p>
				<img src="${pageContext.request.contextPath}/images/footer/ios.png" class="lf"> <img
					src="${pageContext.request.contextPath}/images/footer/android.png" alt="" class="lf" />
			</div>
			<div class="download">
				<img src="${pageContext.request.contextPath}/images/footer/erweima.png">
			</div>
			<!-- 页面底部-备案号 #footer -->
			<div class="record">&copy;2017 达内集团有限公司 版权所有 京ICP证xxxxxxxxxxx</div>
		</div>

	</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/index.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.page.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/orders.js"></script>
<script type="text/javascript">
	//验证密码格式是否争取
	function checkPwd(pwd) {
		return pwd.length >= 6 && pwd.length <= 9;
	}
	//验证新密码和确认密码是否一致
	function checkEquals() {
		var newValue = $("#newPwd").val();
		var confirmPwdValue = $("#confirmPwd").val();
		if (newValue == confirmPwdValue) {
			return true;
		} else {
			return false;
		}
	}
	//旧密码失去焦点事件
	$("#oldPwd").blur(function() {
		if (checkPwd($("#oldPwd").val())) {
			$("#oldPwdSpan").html("密码格式正确");
			$("#oldPwdSpan").css("color", "green");
		} else {
			$("#oldPwdSpan").html("密码格式不正确");
			$("#oldPwdSpan").css("color", "red");
		}
	});
	$("#newPwd").blur(function() {

		if (checkPwd($("#newPwd").val())) {
			$("#newPwdSpan").html("密码格式正确");
			$("#newPwdSpan").css("color", "green");

		} else {
			$("#newPwdSpan").html("密码格式不正确");
			$("#newPwdSpan").css("color", "red");
		}
	});

	//确定密码和新密码是否相同
	$("#confirmPwd").blur(function() {
		if (checkEquals()) {
			$("#confirmSpan").html("两次密码相同");
			$("#confirmSpan").css("color", "green");

		} else {
			$("#confirmSpan").html("两次密码不相同");
			$("#confirmSpan").css("color", "red");
		}

	});
	//保存修改
	function updatePwd() {
		var oldValue = $("#oldPwd").val();
		var newValue = $("#newPwd").val();
		if (checkPwd(oldValue) && checkPwd(newValue) && checkEquals()) {
			$.ajax({
				url : "${pageContext.request.contextPath}/user/updatePassword.do",
				data : "oldPwd=" + oldValue + "&newPwd=" + newValue,
				type : "post",
				dataType : "json",
				success : function(obj) {
					if (obj.state == 0) {
						alert(obj.state + "," + obj.message);
					} else {
						location = "${pageContext.request.contextPath}/user/showLogin.do"
					}
				}
			});
		} else {
			alert("请填写正确格式");
		}
	}
</script>
//设置左边栏
<script type="text/javascript">
$(function(){
$("#leftsidebar_box dd").hide();
//显示count_managment选择器的列表项
$("#leftsidebar_box .count_managment dd").show();
//设置所有dl图片为myOrder2.png
$("#leftsidebar_box dt img").attr("src","${pageContext.request.contextPath}/images/myOrder/myOrder2.png");
//设置count_managment选择器的dl节点的img节点描述性质为myOrder1.png
$("#leftsidebar_box .count_managment").find('img').attr("src","${pageContext.request.contextPath}/images/myOrder/myOrder1.png");
})

</script>
</html>