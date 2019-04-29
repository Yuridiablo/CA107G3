<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
	<script>
		var timer;
		$(function(){
			$('#question').on('keyup', function(){
				$('#answer').text('Waiting for you to stop typing...');
				$('#image').attr('src', '').css('display', 'none');
				var question = $(this).val();
				_debounce(function(){ 
					return getAnswer(question); 
				}, 500);
			});
		});
		
		function getAnswer(question){
			if(question.indexOf('?') === -1){
				$('#answer').text('Questions usually contain a question mark. ;-)');
				return;
			}
			$('#answer').text('Thinking...');
			$.ajax({
// 				url: 'https://yesno.wtf/api',
				url: 'ajaxHomework.do',
				type: "get",
				data: { action: 'ask', question: $('#question').val() },
				dataType: 'json',
				success: function(res){
					console.log(res);
					$('#answer').text(res.answer);
					$('#image').attr('src', res.image).css('display', 'block');
				},
				error: function(res){
					$('#answer').text('Error! Could not reach the API. ');
				}
			});
		}
		
		function _debounce(callback, time){
			if(timer)
				 clearTimeout(timer);
			timer = setTimeout(function(){
				callback();
			}, time);
		}
	</script>
</head>
<body>
	<p>Ask a yes/no question: <input type="text" id="question"></p>
	<p id="answer">I cannot give you an answer until you ask a question!</p>
	<img id="image" src="" style="display: none;"></img>
</body>
</html>