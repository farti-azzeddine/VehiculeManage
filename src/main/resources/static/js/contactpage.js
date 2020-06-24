$('document').ready(function(){
	$('table #editcontactButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(contact, status){
			$('#txtEmailEdit').val(contact.email);
			$('#txtFirstnameEdit').val(contact.firstname);
			$('#txtIdEdit').val(contact.id);
			$('#txtLastnameEdit').val(contact.lastname);	
			$('#txtMobileEdit').val(contact.mobile);
			$('#txtPhoneEdit').val(contact.phone);			
			$('#txtRemarksEdit').val(contact.remarks);
			
		});
		$('#editcontactModal').modal();
	});
	
	
	$('table #deletecontactButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletecontactButton').attr('href', href);
		
		$('#deletecontactModal').modal();
	});
});