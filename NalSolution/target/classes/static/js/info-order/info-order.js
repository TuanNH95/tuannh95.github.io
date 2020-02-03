var checkout_time;

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
	checkout_time = [d.getFullYear(), d.getMonth()+1, d.getDate()].join('/')+' '+
              [d.getHours(), d.getMinutes(), d.getSeconds()].join(':');

	$("#info-checkout").html(checkout_time);
	var hour_pay = Math.floor((new Date(checkout_time) - new Date($("#checkin_time").html()))/3600000)
	$("#hour_pay").html(hour_pay);
	setMessagePopup('<h2>Bạn muốn thanh toán phòng</h2> ',  ''
			+ '<h5 style="display: inline;">Giờ checkin  là:</h5> '+ $("#checkin_time").html()
			+ '<br></br><h5 style="display: inline;">Giờ checkout là:</h5> '+ checkout_time
			+ '<br></br><h5 style="display: inline;">Tổng số giờ thuê:</h5> '+ hour_pay +' giờ'
			+ '<br></br><h5 style="display: inline;">Giá một giờ:</h5> '+ $('#price').html() +' ₫'
			+ '<br></br><h5 style="display: inline;">Giá tiền:</h5> '+ ($('#price_hide').html() * hour_pay).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}), 'Thanh toán')
	$('#popup-message').modal('show');
	$('#btn-success-popup').removeAttr('disabled');
}

$(document).on("click","#btn-success-popup",function(event){
	  event.preventDefault();
	  //$("#formOrder").submit();
	  payRoom();
	  //$('#btn-success-popup').attr('disabled','disabled');
});

/**
 * Function set list file name
 */
function payRoom() {

    // Turn on loading

    $.ajax({
        type : "POST",
        async: false,
        url : "/pay-room",
        data: {
            "idRoom"      : $("#idRoom").html(),
            "idCustomer" : $("#idCustomer").html(),
            "checkout" : $("#info-checkout").html(),
            "hours" : $("#hour_pay").html()
        },
        success : function(data) {
                // If data status = success
                if (data.status == "success") {
                   $("#message-content-popup").html("Thanh toán thành công");
                   $("#btn-success-popup").attr("disabled","disabled");
                }
            },error: function(data){
            }
    });
}