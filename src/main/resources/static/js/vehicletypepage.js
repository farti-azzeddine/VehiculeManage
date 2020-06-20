$('document').ready(function(){
	$('table #editvehicletypeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vtype, status){
			$('#idEdit').val(vtype.id);
			$('#descriptionEdit').val(vtype.description);
			$('#detailsEdit').val(vtype.details);
			
		});
		$('#editvehicletypeModal').modal();
	});
	$('table #detailsvehicletypeButton').on('click',function(event){
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
		$('#detailsvehicletypeModal').modal();
	});
	
	$('table #deletevehicletypeButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehicletypeButton').attr('href', href);
		
		$('#deletevehicletypeModal').modal();
	});
});