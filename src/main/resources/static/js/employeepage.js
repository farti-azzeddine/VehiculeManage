$('document').ready(function(){
	$('table #editemployeeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(empl, status){
			$('#txtIdEdit').val(empl.id);
			$('#txtAddressEdit').val(empl.address);
			$('#txtCityEdit').val(empl.city);
			$('#ddlNationalityEdit').val(empl.countryid);			
			var dob = empl.dateOfBirth.substr(0,10);
			$('#txtDateOfBirthEdit').val(dob);
			$('#txtEmailEdit').val(empl.email);
			$('#txtFirstnameEdit').val(empl.firstname);
			$('#ddlGenderEdit').val(empl.gender);
			$('#txtInitialsEdit').val(empl.initials);
			$('#txtLastnameEdit').val(empl.lastname);
			$('#ddlMaritalStatusEdit').val(empl.maritalStatus);
			$('#txtMobileEdit').val(empl.mobile);
			$('#txtOthernameEdit').val(empl.othername);		
			$('#txtPhoneEdit').val(empl.phone);			
			$('#fupPhotoEdit').val(empl.photo);			
			$('#txtSSNEdit').val(empl.socialSecurityNumber);			
			$('#ddlStateEdit').val(empl.stateid);	
			$('#ddlTitleEdit').val(empl.title);			
			$('#ddlEmployeeTypeEdit').val(empl.employeetypeid);				
			var hireDate = empl.hireDate.substr(0,10);
			$('#txtHireDateEdit').val(hireDate);
			$('#ddlJobTitleEdit').val(empl.jobtitleid);	
			
		});
		$('#editemployeeModal').modal();
	});
	$('table #detailsemployeeButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(empl, status){
			$('#idDetails').val(empl.id);
			$('#descriptionDetails').val(empl.description);
			$('#detailsDetails').val(empl.details);
			$('#lastModifiedByDetails').val(empl.lastModifiedBy);
			$('#lastModifiedDateDetails').val(empl.lastModifiedDate.substr(0,19).replace("T", " "));
	});
		$('#detailsemployeeModal').modal();
	});
	$('table #deleteemployeeButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteemployeeButton').attr('href', href);
		
		$('#deleteemployeeModal').modal();
	});
	
	$('.table #photoButton').on('click',function(event) {
		   event.preventDefault();
		   var href = $(this).attr('href');
		   $('#photoModal #employeePhoto').attr('src', href);
		   $('#photoModal').modal();		
	});
	
	
});