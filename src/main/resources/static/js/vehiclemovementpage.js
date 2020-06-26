$('document').ready(function(){
	$('table #editvehiclemovementButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclemovement, status){
			$('#idEdit').val(vehiclemovement.id);
			$('#ddlVehicleEdit').val(vehiclemovement.vehicleid);
			$('#ddlLocation1Edit').val(vehiclemovement.locationid1);
			$('#ddlLocation2Edit').val(vehiclemovement.locationid2);
			
			var date1 = vehiclemovement.date1.substr(0,10);
			var date2 = vehiclemovement.date2.substr(0,10);
			$('#date1Edit').val(date1);
			$('#date2Edit').val(date2);
			$('#remarksEdit').val(vehiclemovement.remarks);
			
		});
		$('#editvehiclemovementModal').modal();
	});
	$('table #detailsvehiclemovementButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(vehiclemovement, status){
			$('#idDetails').val(vehiclemovement.id);
			$('#ddlVehicleDetails').val(vehiclemovement.vehicleid);
			$('#ddlLocation1Details').val(vehiclemovement.locationid1);
			$('#ddlLocation2Details').val(vehiclemovement.locationid2);
			
			var date1 = vehiclemovement.date1.substr(0,10);
			var date2 = vehiclemovement.date2.substr(0,10);
			$('#date1Details').val(date1);
			$('#date2Details').val(date2);
			$('#remarksDetails').val(vehiclemovement.remarks);
		//	$('#lastModifiedByDetails').val(vehiclemovement.lastModifiedBy);
		//	$('#lastModifiedDateDetails').val(vehiclemovement.lastModifiedDate.substr(0,19).replace("T", " "));
	});
		$('#detailsvehiclemovementModal').modal();
	});
	$('table #deletevehiclemovementButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeletevehiclemovementButton').attr('href', href);
		
		$('#deletevehiclemovementModal').modal();
	});
});