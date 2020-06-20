$('document').ready(function(){
	$('table #editvehiclemakeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vmake, status){
			$('#idEdit').val(vmake.id);
			$('#descriptionEdit').val(vmake.description);
			$('#detailsEdit').val(vmake.details);
			
		});
		$('#editvehiclemakeModal').modal();
	});
	$('table #detailsvehiclemakeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vmake, status){
			$('#idDetails').val(vmake.id);
			$('#descriptionDetails').val(vmake.description);
			$('#detailsDetails').val(vmake.details);
			$('#addressDetails').val(vmake.address);
			$('#lastModifiedByDetails').val(vmake.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailsvehiclemakeModal').modal();
	});
	
	$('table #deletevehiclemakeButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehiclemakeButton').attr('href', href);
		
		$('#deletevehiclemakeModal').modal();
	});
});