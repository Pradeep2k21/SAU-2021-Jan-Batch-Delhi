function ValidateEmail()
{

    var mailformat = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    var inputText = document.getElementById('email').value;
    
    
    if(inputText.match(mailformat))
    {
        return 1;
    }
    else
    {
        return 0;
    }
}

function results(){

    var Fname = document.getElementById('text1');
    console.log(Fname);
    var Lname = document.getElementById('text2');
    var Emailaddress=document.getElementById('email');
    console.log(Emailaddress);
    var city=document.getElementById('CITY');
    
    if(document.getElementById('male').checked)
    {
        Sgender = document.getElementById('male').value; 
    } else if(document.getElementById('female').checked)
    {
        Sgender = document.getElementById('female').value; 
    }else if (document.getElementById('other').checked)
    {
        Sgender= document.getElementById('other').value;
    }
    else{
        Sgender=0;
    }

    var msg="";
    
    if(Fname&&Fname.value&&Lname&&Lname.value&&city&&city.value&&Emailaddress&&Emailaddress.value&&Sgender){

        let Emailcheck = ValidateEmail();
        // let lname = getElementById('text2');
        if(Emailcheck){    
        msg +=  "Intern Details:"
        document.getElementById('opFname').innerHTML = 'Name: ' + Fname.value + ' ' +Lname.value;
        document.getElementById('opCity').innerHTML = 'City: ' + city.value;;
        document.getElementById('opEmail').innerHTML = "Email : "+ Emailaddress.value;
        document.getElementById('opGender').innerHTML = "Gender  : "+ Sgender;
        
        }
        else{
            msg = "Invalid Email Id!";    
        }
    }
    else{
        msg = 'Please Enter all details';
    }
    document.getElementById('status').innerHTML = msg;

}