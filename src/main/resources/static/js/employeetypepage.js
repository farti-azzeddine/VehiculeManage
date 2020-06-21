$('document').ready(function(){
	$('table #editemployeetypeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(etype, status){
			$('#idEdit').val(etype.id);
			$('#descriptionEdit').val(etype.description);
			$('#detailsEdit').val(etype.details);
			
		});
		$('#editemployeetypeModal').modal();
	});
	$('table #detailsemployeetypeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(etype, status){
			$('#idDetails').val(etype.id);
			$('#descriptionDetails').val(etype.description);
			$('#detailsDetails').val(etype.details);
			$('#addressDetails').val(etype.address);
			$('#lastModifiedByDetails').val(etype.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailsemployeetypeModal').modal();
	});
	
	$('table #deleteemployeetypeButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteemployeetypeButton').attr('href', href);
		
		$('#deleteemployeetypeModal').modal();
	});
});