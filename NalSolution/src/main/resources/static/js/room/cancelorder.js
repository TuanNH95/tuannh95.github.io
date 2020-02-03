/**
 * Set tittle for popup
 */
function showPopupOrder(){
	$("#idRoomCancel").val($("#idRoom").html());
	$("#idCustomerCancel").val($("#idCustomer").html());
	$("#checkinCancel").val($("#checkin_time").html());
	setMessagePopup('<h2>Thông báo hủy phòng</h2> ',  'Bạn muốn hủy phòng này', 'Hủy Phòng')
	
	$('#popup-message').modal('show');
}

$(document).on("click","#btn-success-popup",function(event){
	  event.preventDefault();
	  $("#formCancel").submit();
});
