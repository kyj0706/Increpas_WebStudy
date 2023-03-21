<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="//cdn.ckeditor.com/4.11.2/full/ckeditor.js"></script>

</head>
<body>
<textarea name="content" id="content" rows="" cols=""></textarea>
<script>
	// Replace the <textarea id="editor1"> with a CKEditor
	// instance, using default configuration.
	CKEDITOR.replace( 'content', {
	filebrowserUploadUrl: '${pageContext.request.contextPath}/ckeditorImageUpload.do',
	enterMode:CKEDITOR.ENTER_BR,
	shiftEnterMode:CKEDITOR.ENTER_P,
	toolbarGroups : [
		{ name: 'document', groups: [ 'mode', 'document', 'doctools' ] },
		/*
		{ name: 'clipboard', groups: [ 'clipboard', 'undo' ] },
		{ name: 'editing', groups: [ 'find', 'selection', 'spellchecker' ] },
		{ name: 'forms' },*/
		'/',
		{ name: 'basicstyles', groups: [ 'basicstyles', 'cleanup' ] },
		{ name: 'paragraph', groups: [ 'list', 'indent', 'blocks', 'align', 'bidi' ] },
		{ name: 'links' },
		{ name: 'insert' },
		'/',
		{ name: 'styles' },
		{ name: 'colors' },
		{ name: 'tools' },
		{ name: 'others' },
		{ name: 'about' }
		]
	});
	
		
	CKEDITOR.on('dialogDefinition', function( ev ){
           var dialogName = ev.data.name;
           var dialogDefinition = ev.data.definition;
         
           switch (dialogName) {
               case 'image': //Image Properties dialog
                   //dialogDefinition.removeContents('info');
                   dialogDefinition.removeContents('Link');
                   dialogDefinition.removeContents('advanced');
                   break;
           }
       });
</script>

  
</body>
</html>