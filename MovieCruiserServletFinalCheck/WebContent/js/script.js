function validateForm(){
    var title=document.forms["editMovie"]["title"].value;
    if(title == ""){
        alert("title is required");
        return false;
    }
    var titleLength = title.length;
    if(titleLength < 2 || titleLength > 100){
        alert("title should have 2 to 100 characters");
        return false;
    }

    var gross=document.forms["editMovie"]["gross"].value;
     if(isNaN(gross)){
         alert("Boxoffice has to be number");
         return false;
     }
    
    if(gross==""){
        alert("Boxoffice is required");
        return false;
    }

    var dateOfLaunch=document.forms["editMovie"]["dateOfLaunch"].value;
    if(dateOfLaunch == ""){
        alert("Date Of Launch is required");
        return false;

    }

    if(!dateOfLaunch.match(/^(0[1-9]|[12][0-9]|3[01])[\- \/.](?:(0[1-9]|1[012])[\- \/.](19|20)[0-9]{2})$/)){
        alert("Incorrect date format.Expected format (dd/mm/yyyy)");
        return false;
    }

    var Genre =document.forms["editMovie"]["Genre"].value;
    if(Genre==0)
      {
      alert("Please select one genre ");
      return false;
      }


}




