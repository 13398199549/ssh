$(function($) {

	
	
	
	$('#btn06').click(function() {
		var url = "users/page";
		var data = {userName:"小",page:1,rows:5};
		$.ajax({
			   type: "GET",
			   url: url,
			   data:data,
			   success: function(msg){
			    console.log(msg);
			   }
			});
	});
	
	$('#btn05').click(function() {
		var url = "users/小/e";
		$.ajax({
			   type: "GET",
			   url: url,
			   success: function(msg){
			    console.log(msg);
			   }
			});
	});
	
	
	
	$('#btn02').click(function() {
		var url = "users/7";
		var data = {userName:"小吴",loginName:"xw",version:"1",password:"654321"};
		$.ajax({
			   type: "DELETE",
			   url: url,
			   data:data,
			   success: function(msg){
			    console.log(msg);
			   }
			});
	});
	
	$('#btn03').click(function() {
		var url = "users/7";
		var data = {userName:"小吴",loginName:"xw",version:"0",password:"654321"};
		$.ajax({
			   type : "PUT",
			   url: url,
			   data:data,
			   success: function(msg){
			    console.log(msg);
			   }
			});
	});
	
	
	
	$('#btn04').click(function() {

		var url = "users/6";
		$.ajax({
			   type: "GET",
			   url: url,
			   success: function(msg){
			    console.log(msg);
			   }
			});
	});
	
	$('#btn01').click(function() {

		var url = "users/-1";
		var data = {userName:"吴东爵",loginName:"wdj",password:"123456"};
		$.ajax({
			   type: "POST",
			   url: url,
			   data:data,
			   success: function(msg){
			    console.log(msg);
			   }
			});
	});

});