$('document').ready(function(){
	$('table #editclientButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(client, status){
			$('#txtAddressEdit').val(client.address);
			$('#txtCityEdit').val(client.city);
			$('#ddlCountryEdit').val(client.countryid);
			$('#txtDetailsEdit').val(client.details);
			$('#txtEmailEdit').val(client.email);
			$('#txtIdEdit').val(client.id);
			$('#txtMobileEdit').val(client.mobile);
			$('#txtNameEdit').val(client.name);	
			$('#txtPhoneEdit').val(client.phone);			
			$('#ddlStateEdit').val(client.stateid);	
			$('#txtWebsiteEdit').val(client.website);
			
		});
		$('#editclientModal').modal();
	});
	
	
	$('table #deleteclientButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteclientButton').attr('href', href);
		
		$('#deleteclientModal').modal();
	});
});