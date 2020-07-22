$('document').ready(function(){
	$('table #editvehiclemodelButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vmodel, status){
			$('#idEdit').val(vmodel.id);
			$('#descriptionEdit').val(vmodel.description);
			$('#detailsEdit').val(vmodel.details);
			
		});
		$('#editvehiclemodelModal').modal();
	});
	$('table #detailsvehiclemodelButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vmodel, status){
			$('#idDetails').val(vmodel.id);
			$('#descriptionDetails').val(vmodel.description);
			$('#detailsDetails').val(vmodel.details);
			$('#createdByDetails').val(vmodel.createdBy);
			$('#createdDateDetails').val(vmodel.createdDate.substr(0,19).replace("T", " "));
			$('#lastModifiedByDetails').val(vmodel.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vmodel.lastModifiedDate.substr(0,19).replace("T", " "));
	
		});
		$('#detailsvehiclemodelModal').modal();
	});
	
	$('table #deletevehiclemodelButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehiclemodelButton').attr('href', href);
		
		$('#deletevehiclemodelModal').modal();
	});
});