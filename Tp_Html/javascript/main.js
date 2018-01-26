$(function(){
	/*alert("Hey Billy");*/
	$('#billy').on('click', function(){
		$('body').addClass('window-opened');
	});
	
	$('#backdrop').on('click', function(){
		$('body').removeClass('window-opened');
	});
});