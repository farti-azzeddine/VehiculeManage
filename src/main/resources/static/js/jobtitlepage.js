$('document').ready(function(){
	$('table #editjobtitleButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(jtitle, status){
			$('#idEdit').val(jtitle.id);
			$('#descriptionEdit').val(jtitle.description);
			$('#detailsEdit').val(jtitle.details);
			
		});
		$('#editjobtitleModal').modal();
	});
	$('table #detailsjobtitleButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(jtitle, status){
			$('#idDetails').val(jtitle.id);
			$('#descriptionDetails').val(jtitle.description);
			$('#detailsDetails').val(jtitle.details);
			$('#addressDetails').val(jtitle.address);
			$('#lastModifiedByDetails').val(jtitle.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailsjobtitleModal').modal();
	});
	
	$('table #deletejobtitleButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletejobtitleButton').attr('href', href);
		
		$('#deletejobtitleModal').modal();
	});
});