var checkin_time;

/**
 * Function load page
 */
$(document).ready(function() {
});

/**
 * Set tittle for popup
 */
function showPopupOrder(tittle, content, nameButton){
	var d = new Date;
	checkin_time = [d.getFullYear(), d.getMonth()+1, d.getDate()].join('/')+' '+
              [d.getHours(), d.getMinutes(), d.getSeconds()].join(':');
	setMessagePopup('Thông báo đặt phòng', 'Hãy xác nhận đặt phòng <br></br>'
			+'Giờ checkin  là: '+ checkin_time, 'Đặt phòng')
	$('#popup-message').modal('show');
	$('#btn-success-popup').removeAttr('disabled');
}

$(document).on("click","#btn-success-popup",function(event){
	  event.preventDefault();
	  //$("#formOrder").submit();
	  addInfoRoom();
	  //$('#btn-success-popup').attr('disabled','disabled');
});

/**
 * Function set list file name
 */
function addInfoRoom() {
    // Condition search page no
    var infoRoom = {
            "idRoom"             : $("#idRoom").val(),
            "nameCustomer"                 : $("#nameCustomer").val(),
            "idCustomer": '',
            "nameRoom"               : $("#nameRoom").html(),
            "age"            : $('#age').val(),
            "checkin"         : checkin_time,
            "checkout"           : '',
            "price"                 : $("#pricehide").html(),
            "cmnd"                 : $("#cmnd").val(),
            "sex"                 : $("#sex").val()
        };

    // Turn on loading

    $.ajax({
        type : "POST",
        async: false,
        url : "/order-room",
        data: JSON.stringify(infoRoom),
        dataType : 'json',
        contentType: 'application/json',
        mimeType: 'application/json',
        success : function(data) {
                // If data status = success
                if (data.status == "success") {
                   $("#idRoomSuccess").val(data.result[0].idRoom)
                   $("#idCusTomerSuccess").val(data.result[0].idCustomer)
                   $("#formOrderSuccess").submit();
                }
            },error: function(data){
            }
    });
}

$("#btn-orderroom-popup" ).click(function() {
	if($("#nameCustomer").val() == '' 
		|| $("#cmnd").val() == ''
			|| $("#age").val() == '') {
		$("#messageError").html("Hãy nhập đầy đủ thông tin");
		return;
	} else if ($("#age").val().length > 3){
		$("#messageError").html("Tuổi giới hạn 3 chữ số");
		return;
	} else if ($("#age").val() <= 0){
		$("#messageError").html("Age không thể bé hơn hoặc bằng 0");
		return;
	} 
	else {
		showPopupOrder();
	}
});
