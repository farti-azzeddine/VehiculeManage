$('document').ready(function(){
	$('table #editvehiclehireButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclehire, status){
			$('#idEdit').val(vehiclehire.id);
			$('#ddlClientEdit').val(vehiclehire.clientid);			
			
			var dateIn = vehiclehire.dateIn.substr(0,10);
			var dateOut = vehiclehire.dateOut.substr(0,10);
			$('#dateInEdit').val(dateIn);
			$('#dateOutEdit').val(dateOut);
			
			$('#timeInEdit').val(vehiclehire.timeIn);
			$('#timeOutEdit').val(vehiclehire.timeOut);
			
			$('#ddlLocationEdit').val(vehiclehire.locationid);
			$('#priceEdit').val(vehiclehire.price);
			$('#remarksEdit').val(vehiclehire.remarks);
			$('#ddlVehicleEdit').val(vehiclehire.vehicleid);
		});
		$('#editvehiclehireModal').modal();
	});
	$('table #detailsvehiclehireButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclehire, status){
			$('#idDetails').val(vehiclehire.id);
			$('#ddlClientDetails').val(vehiclehire.clientid);
			
			var dateIn = vehiclehire.dateIn.substr(0,10);
			var dateOut = vehiclehire.dateOut.substr(0,10);
			$('#dateInDetails').val(vehiclehire.dateIn);
			$('#dateOutDetails').val(vehiclehire.dateOut);
			$('#ddlLocationDetails').val(vehiclehire.locationid);
			$('#priceDetails').val(vehiclehire.price);
			$('#remarksDetails').val(vehiclehire.remarks);
			$('#ddlVehicleDetails').val(vehiclehire.vehicleid);
			$('#lastModifiedByDetails').val(vehiclehire.lastModifiedBy);
			$('#lastModifiedDateDetails').val(vehiclehire.lastModifiedDate.substr(0,19).replace("T", " "));
	});
		$('#detailsvehiclehireModal').modal();
	});
	$('table #deletevehiclehireButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehiclehireButton').attr('href', href);
		
		$('#deletevehiclehireModal').modal();
	});
});