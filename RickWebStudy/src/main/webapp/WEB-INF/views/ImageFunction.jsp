<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="<c:url value="/static/resources/jquery/1.6/jquery.js" />"></script>
<link type="text/css" rel="stylesheet" href="<c:url value="/static/css/public.css" />" />

<link type="text/css" rel="stylesheet" href="<c:url value="/static/uploadify/uploadify.css" />" />
<script type="text/javascript" src="<c:url value="/static/uploadify/jquery.uploadify.min.js" />"></script>
<script type="text/javascript" src="<c:url value="/static/uploadify/swfobject.js" />"></script>

<script type="text/javascript">
	function startUpload(){  
		$('#file_upload').uploadify('upload','*');  
	}

	$(document).ready(function(){
		
		$("#submitA").bind("click",function(){
			$("#proposalForm").submit();
		});
		
		$('#file_upload').uploadify({ 
			'swf': '<c:url value="/static/uploadify/uploadify.swf"/>', 'sizeLimit'   : 1024, 
			'uploader':'<c:url value="/image/rick.xhtml" />', 
			'auto'  : false,
			'multi': true,
			'fileSizeLimit' : '1024KB',
			'fileTypeExts': '*.jpg;*.gif;*.jpeg;*.png;*.bmp;*.pdf',
			'onQueueComplete': function (queueData) {
                if(queueData.uploadsSuccessful>=1){
                    alert('Hihi')
                }
            }

		});	
	});

	function imgChange(next) {
		if (next != null)
			document.getElementById(next).style.display = "";
	}

	function validate() {
		var phos = 2;
		for (i = 0; i < 2; i++) {
			if ($("del" + i).checked == true)
				phos--;
		}
		for (i = 0; i < 4; i++) {
			if ($("photoFile" + i).value != "")
				phos++;
		}
		if (phos > 4) {
			alert("Too many pictures, You can not updata more than 4 pictures!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div>This is page of Image Functions</div>
	<div>
		<input type="file" name="uploadify" id="file_upload" />
		<hr>
		<a class="easyui-linkbutton" onclick="startUpload();" href="javascript:void(0);">开始上传</a> 
		<a href="javascript:$('#file_upload').uploadify('cancel', '*')" class="easyui-linkbutton">取消所有上传</a> 
	</div>
	<form id="proposalForm" method="post"
		action="/image/resize.xhtml"  enctype="multipart/form-data">
		<table class="ptd">
			<tr>
				<th colspan="2" class="tit">Please submit your product</th>
			</tr>
			<tr>
				<th>
					<!-- 上传照片-->
					<div>

						<table width="100%" border="0" cellspacing="0" cellpadding="0"
							summary="upload pictures">
							<tr id="tr_photoFile0">


								<td width="499"><input type="file" name="uploadFile"
									id="photoFile0" size="40"
									onChange='return imgChange("tr_photoFile1")' /></td>
							</tr>
							<tr id="tr_photoFile1" style="display: none;">

								<td><input type="file" name="uploadFile" id="photoFile1"
									onChange='return imgChange("tr_photoFile2")' size="40" /></td>
							</tr>
							<tr id="tr_photoFile2" style="display: none;">

								<td><input type="file" name="uploadFile" id="photoFile2"
									onChange='return imgChange("tr_photoFile3")' size="40" /></td>
							</tr>
							<tr id="tr_photoFile3" style="display: none;">

								<td><input type="file" name="uploadFile" id="photoFile3"
									onChange='return imgChange(null)' size="40" /></td>

							</tr>
						</table>
					</div>

				</th>
				<td><p>
						<b>Proposal Submition</b><br /> Concept, sketch, Layout, etc.<br />
						Only PDF and JPG file is allowed.<br /> Max file size is 1MB.</td>
			</tr>

			<tr>
				<td colspan="2" class="btn"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<script type="text/javascript">
			$(document).ready(function(){
				
				$('#photoFile0').uploadify({ 
					'swf': '<c:url value="/static/uploadify/uploadify.swf"/>', 'sizeLimit'   : 1024, 
					'uploader':'<c:url value="/image/resize.xhtml"/>', 
					'auto'  : false,
					'multi': true,
					'fileSizeLimit' : '1024KB',
					'fileTypeExts': '*.jpg;*.gif;*.jpeg;*.png;*.bmp;*.pdf',
					'onQueueComplete': function (queueData) {
	                    if(queueData.uploadsSuccessful>=1){
	                        alert('Hihi')
	                    }
	                }

				});	
				
				
				/* $("#proposalForm").bind("submit", function(){
					var filepath=$("input[name='uploadFile']").val();
					alert($("input[name='uploadFile']").html())
					var extStart=filepath.lastIndexOf("."); 
			        var ext=filepath.substring(extStart,filepath.length).toUpperCase(); 
			        if(ext!=".BMP"&&ext!=".PNG"&&ext!=".GIF"&&ext!=".JPG"&&ext!=".JPEG"){ 
				        alert("图片限于bmp,png,gif,jpeg,jpg格式"); 
				        return false; 
			        } 
			        var fso=new ActiveXObject("Scripting.FileSystemObject");
			        var f=fso.GetFile(document.getElementById("photoFile0").value);//文件的物理路径
			        var fname=fso.GetFileName(filename);//文件名（包括扩展名）
			        var fsize=f.Size; //文件大小（bit）
			        alert(fsize);
			        
			        return false;     
				}); */
			});
		</script>
	</form>
</body>
</html>