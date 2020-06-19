$('document').ready(function(){
	$('table #editlocationButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(location, status){
			$('#idEdit').val(location.id);
			$('#descriptionEdit').val(location.description);
			$('#detailsEdit').val(location.details);
			$('#countryidEdit').val(location.countryid);
			$('#stateidEdit').val(location.stateid);
			$('#cityEdit').val(location.city);
			$('#addressEdit').val(location.address);
			
		});
		$('#editlocationModal').modal();
	});
	$('table #detailslocationButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(location, status){
			$('#idDetails').val(location.id);
			$('#descriptionDetails').val(location.description);
			$('#detailsDetails').val(location.details);
			$('#countryidDetails').val(location.countryid);
			$('#stateidDetails').val(location.stateid);
			$('#cityDetails').val(location.city);
			$('#addressDetails').val(location.address);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailslocationModal').modal();
	});
	
	$('table #deletelocationButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletelocationButton').attr('href', href);
		
		$('#deletelocationModal').modal();
	});
});