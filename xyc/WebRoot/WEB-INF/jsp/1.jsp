<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
		<meta charset="UTF-8">
		<title>异步上传文件</title>
	</head>
	<body>
	
	<input type="button" value="点击"/>
	
	<form action="${ctx}/hello/word" method="post" enctype="multipart/form-data">
		<button id="btn">请选择</button>
	</form>
	</body>
	<script type="text/javascript" src="${ctx}/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript">
		$("#btn").click(function(){
			var file = $("<input type='file' name='file'>");
			file.click();
			file.change(function(e){
				var f = this.files[0];
				var formData = new FormData();
				formData.append("file",f);
				var ajax = $.ajax({
					url:'${pageContext.request.contextPath}/hello/word',
					method:'post',
					dataType:'json',
					/* xhr:function(){
						
					}, */
					data:formData,
					/**
	                    *必须false才会自动加上正确的Content-Type
	                    	表示不是普通数据
	                    */
					processData:false,
					 /**
	                    * 必须false才会避开jQuery对 formdata 的默认处理
	                    * XMLHttpRequest会对 formdata 进行正确的处理
	                    */
					contentType:false,
					success:function(e){
						alert("成功了");
					},error:function(){
						alert("服务器异常");
					}
				}); 
				
				ajax.done(function(response,status,xhr){
					console.log(xhr);
				});
			});
			return false;
		});
	</script>
</html>

