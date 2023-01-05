

/**
 * 
 */

function validate() {
	
var form = document.getElementById("form");

		
		   
		   var password = form.password.value;
		   
		   if(password==""){
		      alert("Password is required");
		      form.password.focus(); // focus the text box
		      return false;
		      
		   } else if(password.length < 8) { // age range 
		      alert("Password length should be greater than Eigth");
		      form.password.focus(); // focus the text box
		      return false;
	
		   }else if ((password.search(/[0-9]+/) == -1)){
			   alert("Password should contain at least one number");
			   form.password.focus(); // focus the text box
			   return false;
			   
		   } /*else if(illegalChar.test(password)){
				alert("Password contains illegal character");
				form.password.focus();
				return false;
			}*/
			
			
			var email = form.email.value;		
			var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      		

     		if (email == "" || !email.match(mailformat)){
				alert("Wrong Email Format!!!!");
				form.email.focus();
				return false;
		   }
		   
		   return true;
		   // true => form is error free
		   // false => form validation errors
		}