$('document').ready(function(){
	$('table #editvehiclestatusButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vstatus, status){
			$('#idEdit').val(vstatus.id);
			$('#descriptionEdit').val(vstatus.description);
			$('#detailsEdit').val(vstatus.details);
			
		});
		$('#editvehiclestatusModal').modal();
	});
	$('table #detailsvehiclestatusButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vstatus, status){
			$('#idDetails').val(vstatus.id);
			$('#descriptionDetails').val(vstatus.description);
			$('#detailsDetails').val(vstatus.details);
			$('#addressDetails').val(vstatus.address);
			$('#lastModifiedByDetails').val(vstatus.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailsvehiclestatusModal').modal();
	});
	
	$('table #deletevehiclestatusButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehiclestatusButton').attr('href', href);
		
		$('#deletevehiclestatusModal').modal();
	});
});