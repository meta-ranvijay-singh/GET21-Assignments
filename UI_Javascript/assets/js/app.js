let name,gender,email,password,confirmpass,contact,error;
name=gender=email=password=confirmpass=contact=error=null;

var name_input = document.querySelector('#enter_name');
var email_input = document.querySelector('#enter_email');
var password_input = document.querySelector('#enter_password');
var cpassword_input = document.querySelector('#enter_cpassword');
var gender_input = document.querySelector(".enter_gender_div");
var contact_input = document.querySelector('#enter_contact');
var error_div = document.querySelector("#error");
alert_div = document.querySelector(".alert");




var emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
var passRegex = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z!#$%&? "])[a-zA-Z0-9!#$%&?]{8,}$/;
var nameRegex = /^([a-zA-Z ]){2,}$/;
var contactRegex = /^([0-9]){10}$/;

name_input.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
      name = document.querySelector("#enter_name").value;
      if(nameRegex.test(name)){
        document.querySelector("#emp_name").innerHTML = "Hi, "+name+"! Can I know your gender";
      document.querySelector(".display_emp_name").classList.add("show");
      name_input.classList.add("hide");
      gender_input.classList.add("show");

      error="";
      alert_div.classList.remove("show");

      }
      else{
        error="Please enter name of min length 2";
        error_div.innerHTML = error;
        alert_div.classList.add("show");
      }
      
    }
});

function getGender(radio) {
    gender = radio.value;
    document.querySelector("#emp_gender").innerHTML = " "+gender+", Can I know your email";
      document.querySelector(".display_emp_gender").classList.add("show");
      gender_input.classList.remove("show");
      email_input.classList.add("show");
      email_input.focus();
    }

  email_input.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
      email = email_input.value;
      if(emailRegex.test(email)){
        document.querySelector("#emp_email").innerHTML = " "+email+", Please enter your password";
        email_input.classList.remove("show");
        document.querySelector(".display_emp_email").classList.add("show");
        password_input.focus();
        password_input.classList.add("show");

        error="";
        alert_div.classList.remove("show");
      }
      else{
        error="Invalid email";
        error_div.innerHTML = error;
        alert_div.classList.add("show");
      }

    }

});

password_input.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
      password = password_input.value;
      if(passRegex.test(password)){
        document.querySelector("#emp_password").innerHTML = "Verified , Please confirm password";
        password_input.classList.remove("show");
        document.querySelector(".display_emp_password").classList.add("show");
        cpassword_input.focus();
        cpassword_input.classList.add("show");

        error="";
        alert_div.classList.remove("show");
      }
      else{
        error="Invalid Passowrd (Must contain Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8)";
        error_div.innerHTML = error;
        alert_div.classList.add("show");
      }

    }
    
});

cpassword_input.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
      confirmpass = cpassword_input.value;
      if(confirmpass == password){
        document.querySelector("#emp_cpassword").innerHTML = "Matched , Please enter your contact number";
        cpassword_input.classList.remove("show");
        document.querySelector(".display_emp_cpassword").classList.add("show");
        contact_input.focus();
        contact_input.classList.add("show");

        error="";
        alert_div.classList.remove("show");
      }
      else{
        error="confirm password not matched";
        error_div.innerHTML = error;
        alert_div.classList.add("show");
      }

    }
    
});

contact_input.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
      contact = contact_input.value;
      if(contactRegex.test(contact)){
        document.querySelector("#emp_contact").innerHTML = " "+contact;
        contact_input.classList.remove("show");
        document.querySelector(".display_emp_contact").classList.add("show");
        document.querySelector("#emp_submit").classList.add("show");

        error="";
        alert_div.classList.remove("show");
      }
      else{
        error="Invalid contact number";
        error_div.innerHTML = error;
        alert_div.classList.add("show");
      }

    }
    
});

var addEmployee = function(){
    console.log("submitted");
    let empId = Math.floor(Math.random() * Math.floor(1000))
    let emp_div = document.querySelector(".emp_id");
    emp_div.innerHTML = "Employee ID : "+empId;
    document.querySelector("#addEmployee").classList.add("hide");
    emp_div.classList.add("show");
    document.querySelector(".vehicle").classList.add("show");
}

//vehicle
var vehicle_name_input = document.querySelector("#enter_vehicle_name");
var vehicle_number_input = document.querySelector("#enter_vehicle_number");
var vehicle_emp_id_input = document.querySelector("#enter_emp_id_vehicle");
var vehicle_ident = document.querySelector("#enter_vehicle_identification");
var vehicle_type = document.querySelector(".enter_type_div");

var vehicle_name ,vehicle_type;
vehicle_name_input.addEventListener('keypress', function (e) {
    if (e.key === 'Enter') {
      vehicle_name = document.querySelector("#enter_vehicle_name").value;
      if(vehicle_name != ""){
        document.querySelector("#vehicle_name").innerHTML = vehicle_name+"! Can I know Vehicle type";
      document.querySelector(".display_vehicle_name").classList.add("show");
      vehicle_name_input.classList.add("hide");
      vehicle_type.classList.add("show");

      error="";
      alert_div.classList.remove("show");

      }
      else{
        error="Please enter name of vehicle";
        error_div.innerHTML = error;
        alert_div.classList.add("show");
      }
      
    }
});
function getType(radio) {
    vehicle_type = radio.value;
    document.querySelector("#vehicle_type").innerHTML = " "+vehicle_type+", Can I know your vehicle number";
      document.querySelector(".display_vehicle_type").classList.add("show");
      vehicle_type.classList.remove("show");
      vehicle_number_input.classList.add("show");

    }

var addVehicle = function(){
    console.log("submitted");
    let empId = Math.floor(Math.random() * Math.floor(1000))
    let emp_div = document.querySelector(".emp_id");
    emp_div.innerHTML = "Employee ID : "+empId;
    document.querySelector("#addEmployee").classList.add("hide");
    emp_div.classList.add("show");
    document.querySelector(".vehicle").classList.add("show");
}

