$(document).on("click",".btn-detail",function(event){

	var d = new Date;
	checkout_time = [d.getFullYear(), d.getMonth()+1, d.getDate()].join('/')+' '+
              [d.getHours(), d.getMinutes(), d.getSeconds()].join(':');
	
	var idDetail = [];
	idDetail = this.id.split('-');
	var idRoom = idDetail[1];
	var idCustomer = idDetail[2];
});