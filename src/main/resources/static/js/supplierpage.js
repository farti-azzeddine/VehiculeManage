$('document').ready(function(){
	$('table #editsupplierButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(supplier, status){
			$('#txtAddressEdit').val(supplier.address);
			$('#txtCityEdit').val(supplier.city);
			$('#ddlCountryEdit').val(supplier.countryid);
			$('#txtDetailsEdit').val(supplier.details);
			$('#txtEmailEdit').val(supplier.email);
			$('#txtIdEdit').val(supplier.id);
			$('#txtMobileEdit').val(supplier.mobile);
			$('#txtNameEdit').val(supplier.name);	
			$('#txtPhoneEdit').val(supplier.phone);			
			$('#ddlStateEdit').val(supplier.stateid);	
			$('#txtWebsiteEdit').val(supplier.website);
			
		});
		$('#editsupplierModal').modal();
	});
	$('table #detailsinvoiceButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(supplier, status){
			$('#idDetails').val(suuplier.id);
			$('#descriptionDetails').val(suuplier.description);
			$('#codeDetails').val(suuplier.code);
			$('#lastModifiedByDetails').val(suuplier.lastModifiedBy);
			$('#lastModifiedDateDetails').val(suuplier.lastModifiedDate.substr(0,19).replace("T", " "));
			
		});
		$('#detailssupplierModal').modal();
	});
	
	$('table #deletesupplierButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletesupplierButton').attr('href', href);
		
		$('#deletesupplierModal').modal();
	});
});