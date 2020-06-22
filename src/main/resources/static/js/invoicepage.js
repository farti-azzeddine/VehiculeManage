$('document').ready(function(){
	$('table #editinvoiceButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(invoice, status){
			$('#idEdit').val(invoice.id);
			$('#ddlClientEdit').val(invoice.clientid);
			var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateEdit').val(invoiceDate);
			$('#ddlInvoiceStatusEdit').val(invoice.invoicestatusid);
			$('#remarksEdit').val(invoice.remarks);
			
		});
		$('#editinvoiceModal').modal();
	});
	$('table #detailsinvoiceButton').on('click',function(event){
		event.preventDefault();
		
		var href = $(this).attr('href');
		
		$.get(href, function(invoice, status){
			$('#idDetails').val(invoice.id);
			$('#ddlClientDetails').val(invoice.clientid);			
			
			var invoiceDate = invoice.invoiceDate.substr(0,10);
			$('#invoiceDateDetails').val(invoiceDate);
			$('#ddlStatusDetails').val(invoice.invoicestatusid);
			$('#remarksDetails').val(invoice.remarks);
			$('#lastModifiedByDetails').val(invoice.lastModifiedBy);
			$('#lastModifiedDateDetails').val(invoice.lastModifiedDate.substr(0,19).replace("T", " "));
			
			
		});
		$('#detailsinvoiceModal').modal();
	});
	
	$('table #deleteinvoiceButton').on('click', function(event){
		event.preventDefault();
		
		var href= $(this).attr('href');
		
		$('#confirmDeleteinvoiceButton').attr('href', href);
		
		$('#deleteinvoiceModal').modal();
	});
});