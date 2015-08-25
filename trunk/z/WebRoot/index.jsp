<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="css/cached_front.css" media="screen" rel="stylesheet"
			type="text/css">
	</head>

	<body>
<c:forEach items="${topicList}" var="topic">
${topic.title}
 </c:forEach>
		<div id="header">
			<div class="container">
				<div class="left_wrapper">
					<div id="site_name">
						<a href="."><img alt="Logo"
								src="./者也_files/logo.png"> </a>
					</div>
					<div id="add_ask">
						<input type="text" placeholder="搜索问题，话题，会员" autocomplete="off"
							class="ac_input">
						<a href="./topic/add.d">我要提问</a>
					</div>
					<script type="text/javascript">
	Asks.completeAll($("#add_ask input"));
</script>
				</div>
				<div class="sidebar">
					<div id="user_bar">
						<a href="./者也_files/者也.htm">随便看看</a>
						<a href="account/login.jsp">登录</a>
						<a href="account/reg1.d">注册</a>
						<sec:authorize access="isAuthenticated()">
						<a href="j_spring_security_logout">退出</a>
						</sec:authorize>
					</div>
				</div>
			</div>
		</div>
		
		<div id="main">
			<div class="container">
				<div class="left_wrapper">
					<div id="asks">
						<div class="ask" ask-id="4dd26fa5fd503c4868000038">
							<div class="title">
								<a href="http://zheye.org/asks/4dd26fa5fd503c4868000038"
									class="">大家觉得中国适合什么样的问答网站发展？</a>
							</div>
							<div class="info">
								<a href="http://zheye.org/users/shofey" class="user"
									title="电波囧汉">电波囧汉</a> 提出的问题 • 0 个答案
							</div>
							<div class="md_body">
								之乎、者也这样偏专业、技术的问答，还是米饭（
								<a href="http://mifan.me/" rel="nofollow" target="_blank">http://mifan.me</a>)这样的生活化问答？
							</div>
						</div>
						<div class="ask" ask-id="4dd23c20fd503c770100001b">
							<div class="title">
								<a href="http://zheye.org/asks/4dd23c20fd503c770100001b"
									class="">如何改者也第三方网站登陆oauth接口的App Key？</a>
							</div>
							<div class="info">
								<a href="http://zheye.org/users/junke" class="user" title="俊客">俊客</a>
								提出的问题 • 1 个答案
							</div>
							<div class="last_answer answer">
								<div class="attr">
									<span class="votes" rel="tipsyt" original-title="参与投票人数">1</span>
								</div>
								<div class="data">
									<div class="author">
										<a href="http://zheye.org/users/junke" class="user" title="俊客">俊客</a>,PM
										SEO 为了者也，学习ROR中
									</div>
									<div class="md_body">
										config\initializers 下面的omniauth 可以修改第三方的key文件&nbsp;
									</div>
								</div>
							</div>
						</div>


						<div class="ask" ask-id="4dcf3b9afd503c2c8a00006d">
							<div class="title">
								<a href="http://zheye.org/asks/4dcf3b9afd503c2c8a00006d"
									class="">为什么很多人鄙视迅雷？</a>
							</div>
							<div class="info">
								<a href="http://zheye.org/users/apple1039" class="user"
									title="Dasliuzj">Dasliuzj</a> 提出的问题 • 7 个答案
							</div>
							<div class="last_answer answer">
								<div class="attr">
									<span class="votes" rel="tipsyt" title="参与投票人数">0</span>
								</div>
								<div class="data">
									<div class="author">
										<a href="http://zheye.org/users/achenliu" class="user"
											title="achenliu">achenliu</a>
									</div>
									<div class="md_body">
										迅雷本身可以说不提供任何资源，久而久之，就是其无源可下，其离线下载无非是在我国网络带宽比较差的情况下的一种畸形产品而已。
									</div>
								</div>
							</div>
						</div>
						<div class="pagination">
							<a class="page_more" href="#"></a>
						</div>
					</div>
				</div>
				<div class="sidebar">
					<div class="box">
						<ul class="sections">
							<li>
								<a href="./者也_files/者也.htm" class="asks active">所有问题</a>
							</li>
							<li>
								<a href="http://zheye.org/doing" class="logs">者也正在发生</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="footer">
			<div class="container">
				<div class="inner">
					<div class="links">
						<a href="http://zheye.org/about">关于者也</a> •
						<a href="http://zheye.org/asks/4d95f33bfd503c3bf2000011">每天进步一点</a>
						•
						<a href="http://blog.zheye.org/" target="_blank">博客</a> •
						<a href="http://zheye.org/register">如何注册</a> •
						<a href="http://twitter.com/zheyecn" target="_blank">Twitter</a> •
						<a href="mailto:nowazhu@gmail.com">合作联系</a> •
						<a href="mailto:huacnlee@gmail.com">反馈</a>
						<a style="float: right;"
							href="http://zheye.org/?force_format=mobile">手机版</a>
					</div>
					<div class="copyright">
						© 者也 zheye.org - 非营利问答平台，开源项目，
						<a href="http://github.com/huacnlee/quora">代码</a>，内测期间，如有问题还请谅解。蜀ICP备08009187号
					</div>
				</div>
			</div>
		</div>
		<div style="display: none;" id="hidden_new_ask">
			<h2>
				创建新问题
			</h2>
			<form action="http://zheye.org/asks" method="post" id="inner_new_ask">
				<input name="authenticity_token" type="hidden"
					value="xihX546OvnUlwZoxk6Hr1izm5UWILV9rTMO3gMT2bTU=">
				<textarea type="text" name="ask[title]" class="title"
					placeholder="在这里输入问题"></textarea>
				<label>
					可选:
				</label>
				添加更多描述
				<textarea type="text" name="ask[body]"></textarea>
				<button type="submit" class="submit">
					添加问题
				</button>
				<a href="http://zheye.org/#">取消</a>
			</form>
		</div>
		<div style="display: none;" id="loading">
			<div class="logo"></div>
			<div class="text">
				加载中…
			</div>
		</div>
		<div style="width: 0px; height: 0px; overflow: hidden;">
			<img alt="Loading" src="./者也_files/loading.gif">
			<div id="report_page">
				<h2>
					举报内容
				</h2>
				<form id="report_page_form" action="http://zheye.org/report.js"
					onsubmit="App.loading();" method="post" class="simple_form">
					<input name="authenticity_token" type="hidden"
						value="xihX546OvnUlwZoxk6Hr1izm5UWILV9rTMO3gMT2bTU=">
					<div class="row">
						<input type="hidden" name="url" value="http://zheye.org/">
						<label class="string">
							请填写举报原因:
						</label>
						<textarea name="desc" style="width: 400px; height: 80px;"></textarea>
					</div>
					<div class="acitons">
						<button type="submit">
							提交
						</button>
						<a href="http://zheye.org/#" style="margin-left: 5px;">关闭</a>
					</div>
				</form>
			</div>
		</div>
		<script type="text/javascript">
	$("[rel=tipsy]").tipsy( {
		gravity : $.fn.tipsy.autoNS
	});
	$("[rel=tipsyr]").tipsy( {
		gravity : "w"
	});
	$("[rel=tipsyt]").tipsy( {
		gravity : "s"
	});
	var _gaq = _gaq || [];
	_gaq.push( [ '_setAccount', 'UA-22413508-1' ]);
	_gaq.push( [ '_trackPageview' ]);
	( function() {
		var ga = document.createElement('script');
		ga.type = 'text/javascript';
		ga.async = true;
		ga.src = ('https:' == document.location.protocol ? 'https://ssl'
				: 'http://www') + '.google-analytics.com/ga.js';
		var s = document.getElementsByTagName('script')[0];
		s.parentNode.insertBefore(ga, s);
	})();
</script>
		<div
			style="position: absolute; width: 580px; top: 47px; left: 237px; display: none;"
			class="ac_results">
			<ul>
				<li class="ac_default ac_over">
					输入文本开始搜索
				</li>
			</ul>
		</div>
	</body>
</html>