$('document').ready(function(){
	$('table #editstateButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(state, status){
			$('#idEdit').val(state.id);
			$('#capitalEdit').val(state.capital);
			$('#codeEdit').val(state.code);
			$('#ddcountryidEdit').val(state.countryid);
			$('#detailsEdit').val(state.details);
			$('#nameEdit').val(state.name);
			
		});
		$('#editstateModal').modal();
	});
	$('table #detailsstateButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(state, status){
			$('#idDetails').val(state.id);
			$('#ddCountryDetails').val(state.countryid);
			$('#nameDetails').val(state.name);
			$('#detailsDetails').val(state.details);
			$('#lastModifiedByDetails').val(state.lastModifiedBy);
			//$('#lastModifiedDateDetails').val(state.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailsstateModal').modal();
	});
	
	$('table #deletestateButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletestateButton').attr('href', href);
		
		$('#deletestateModal').modal();
	});
});