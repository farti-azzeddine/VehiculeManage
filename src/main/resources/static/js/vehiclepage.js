$('document').ready(function(){
	$('table #editvehicleButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehicle, status){
			var acDate = vehicle.acquisitionDate.substr(0,10);
			$('#txtAcquisitionDateEdit').val(acDate);
			
			$('#txtDescriptionEdit').val(vehicle.description);
			$('#ddlEmployeeEdit').val(vehicle.employeeid);
			$('#txtFuelCapacityEdit').val(vehicle.fuelCapacity);
			$('#txtIdEdit').val(vehicle.id);
			$('#ddlLocationEdit').val(vehicle.locationid);
			$('#txtNameEdit').val(vehicle.name);
			$('#txtNetWeightEdit').val(vehicle.netWeight);
			$('#txtPowerEdit').val(vehicle.power);
			
			var regDate = vehicle.registrationDate.substr(0,10);
			$('#txtRegistrationDateEdit').val(regDate);
			
			$('#txtRemarksEdit').val(vehicle.remarks);
			$('#ddlVehicleMakeEdit').val(vehicle.vehiclemakeid);		
			$('#ddlVehicleModelEdit').val(vehicle.vehiclemodelid);			
			$('#txtVehicleNumberEdit').val(vehicle.vehicleNumber);			
			$('#ddlVehicleStatusEdit').val(vehicle.vehiclestatusid);			
			$('#ddlVehicleTypeEdit').val(vehicle.vehicletypeid);	
			
		});
		$('#editvehicleModal').modal();
	});
	$('table #detailsvehicleButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehicle, status){
			$('#idDetails').val(vehicle.id);
			$('#descriptionDetails').val(vehicle.description);
			$('#detailsDetails').val(vehicle.details);
			$('#lastModifiedByDetails').val(vehicle.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehicle.lastModifiedDate.substr(0,19).replace("T", " "));
	});
		$('#detailsvehicleModal').modal();
	});
	$('table #deletevehicleButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehicleButton').attr('href', href);
		
		$('#deletevehicleModal').modal();
	});
	
	$('.table #photoButton').on('click',function(event) {
		   event.preventDefault();
		   var href = $(this).attr('href');
		   $('#photoModal #vehiclePhoto').attr('src', href);
		   $('#photoModal').modal();		
	});
	
});