function validateMenuItemForm(){
    var title=document.forms["menuItemForm"]["name"].value;
    if(title == ""){
        alert("title is required");
        return false;
    }
    var titleLength = title.length;
    if(titleLength < 2 || titleLength > 65){
        alert("title should have 2 to 65 characters");
        return false;
    }

    var price=document.forms["menuItemForm"]["price"].value;
     if(isNaN(price)){
         alert("price has to be number");
         return false;
     }
    
    if(price==""){
        alert("price is required");
        return false;
    }

    var dateOfLaunch=document.forms["menuItemForm"]["dateOfLaunch"].value;
    if(dateOfLaunch == ""){
        alert("Date Of Launch is required");
        return false;

    }

    if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/)){
        alert("Incorrect date format.Expected format (dd/mm/yyyy)");
        return false;
    }
	
	var Category =document.forms["menuItemForm"]["Category"].value;
    if(Category==0)
      {
      alert("Please select one category ");
      return false;
      }


}


