/**
 * 
 */
/**
 * Function load page
 */
$(document).ready(function() {
	function todayDate(){
		 // body...
	    var today = new Date();
	    var dd = today.getDate();
	    var mm = today.getMonth()+1; //January is 0!
	    var yyyy = today.getFullYear();

	    if(dd<10){
	        dd='0'+dd;
	    } 
	    if(mm<10){
	        mm='0'+mm;
	    } 

	    today = yyyy+'-'+mm+'-'+dd;            
		 return today;
	 }
	if ($("#flagDate").val() != '1') { 
		document.getElementById('checkinTime').value = todayDate();
		document.getElementById('checkoutTime').value = todayDate();
	}
});

function todayDate1(){
	 // body...
   var today = new Date();
   var dd = today.getDate();
   var mm = today.getMonth()+1; //January is 0!
   var yyyy = today.getFullYear();

   if(dd<10){
       dd='0'+dd;
   } 
   if(mm<10){
       mm='0'+mm;
   } 

   today = yyyy+'-'+mm+'-'+dd;            
	 return today;
}

function isValidDate(date) {
    var temp = date.split('-');
    var d = new Date(temp[0] + '/' + temp[1] + '/' + temp[2]);
    return (d && (d.getMonth() + 1) == temp[1] && d.getDate() == Number(temp[2]) && d.getFullYear() == Number(temp[0]));
}

function isValidDateInput(date) {
	if (!isValidDate(date.value)) {
		 document.getElementById(date.id).value = todayDate1();
	}
}



