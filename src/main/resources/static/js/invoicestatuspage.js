$('document').ready(function(){
	$('table #editinvoicestatusButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(istatus, status){
			$('#idEdit').val(istatus.id);
			$('#descriptionEdit').val(istatus.description);
			$('#detailsEdit').val(istatus.details);
			
		});
		$('#editinvoicestatusModal').modal();
	});
	$('table #detailsinvoicestatusButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(istatus, status){
			$('#idDetails').val(istatus.id);
			$('#descriptionDetails').val(istatus.description);
			$('#detailsDetails').val(istatus.details);
			$('#addressDetails').val(istatus.address);
			$('#lastModifiedByDetails').val(istatus.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailsinvoicestatusModal').modal();
	});
	
	$('table #deleteinvoicestatusButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteinvoicestatusButton').attr('href', href);
		
		$('#deleteinvoicestatusModal').modal();
	});
});