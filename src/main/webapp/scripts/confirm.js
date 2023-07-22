/**
 * 
 *
 *@author Cayro de Macêdo Mendes
 */
 
 function confirmation(id) {
	let deleteResponse = confirm("Are you sure?")
	if(deleteResponse === true) {
		window.location.href= "delete?id=" + id
	} else {
		
	}
}