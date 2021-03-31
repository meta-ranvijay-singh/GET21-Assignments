//variables for employee information
let name, gender, email, password, confirmpass, contact, error;
name = gender = email = password = confirmpass = contact = error = null;

//Employee inputs field
var name_input = document.querySelector("#enter_name");
var email_input = document.querySelector("#enter_email");
var password_input = document.querySelector("#enter_password");
var cpassword_input = document.querySelector("#enter_cpassword");
var gender_input = document.querySelector(".enter_gender_div");
var contact_input = document.querySelector("#enter_contact");
var error_div = document.querySelector("#error");
var alert_div = document.querySelector(".alert");

/* Regex for validations */
var emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
var passRegex = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z!#$%&? "])[a-zA-Z0-9!#$%&?]{8,}$/;
var nameRegex = /^([a-zA-Z ]){2,}$/;
var contactRegex = /^([0-9]){10}$/;

//event listner for employee name inputs on pressing enter key
name_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    name = document.querySelector("#enter_name").value;
    if (nameRegex.test(name)) {
      document.querySelector("#emp_name").innerHTML =
        "Hi, " + name + "! Can I know your gender";
      document.querySelector(".display_emp_name").classList.add("show");
      name_input.classList.add("hide");
      gender_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Please enter name of min length 2";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//function to get gender value from radio button
function getGender(radio){
  gender = radio.value;
  document.querySelector("#emp_gender").innerHTML =
    " " + gender + ", Can I know your email";
  document.querySelector(".display_emp_gender").classList.add("show");
  gender_input.classList.remove("show");
  email_input.classList.add("show");
  email_input.focus();
}

//event listner for employee email inputs on pressing enter key
email_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    email = email_input.value;
    if (emailRegex.test(email)) {
      document.querySelector("#emp_email").innerHTML =
        " " + email + ", Please enter your password";
      email_input.classList.remove("show");
      document.querySelector(".display_emp_email").classList.add("show");
      password_input.focus();
      password_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Invalid email";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//checking strong password
function check(input) {
  if (input.value.length < 9) {
    input.classList.add("border-danger");
  } else if (input.value.length < 12) {
    input.classList.remove("border-danger");
    input.classList.add("border-warning");
  } else {
    input.classList.remove("border-warning");
    input.classList.add("border-success");
  }
}

//event listner for employee password inputs on pressing enter key
password_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    password = password_input.value;
    if (passRegex.test(password)) {
      document.querySelector("#emp_password").innerHTML =
        "Verified , Please confirm password";
      password_input.classList.remove("show");
      document.querySelector(".display_emp_password").classList.add("show");
      cpassword_input.focus();
      cpassword_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error =
        "Invalid Passowrd (Must contain Uppercase, Lowercase, Numeric, Alphanumeric, and length minimum 8)";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//event listner for employee confirm password inputs on pressing enter key
cpassword_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    confirmpass = cpassword_input.value;
    if (confirmpass == password) {
      document.querySelector("#emp_cpassword").innerHTML =
        "Matched , Please enter your contact number";
      cpassword_input.classList.remove("show");
      document.querySelector(".display_emp_cpassword").classList.add("show");
      contact_input.focus();
      contact_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "confirm password not matched";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//event listner for employee contact inputs on pressing enter key
contact_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    contact = contact_input.value;
    if (contactRegex.test(contact)) {
      document.querySelector("#emp_contact").innerHTML = " " + contact;
      contact_input.classList.remove("show");
      document.querySelector(".display_emp_contact").classList.add("show");
      document.querySelector("#emp_submit").classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Invalid contact number";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//function for add employee in parking
var addEmployee = function () {
  let empId = Math.floor(Math.random() * Math.floor(1000));
  let emp_div = document.querySelector(".registration_id");
  emp_div.innerHTML = "Registration ID : " + empId;
  document.querySelector("#addEmployee").classList.add("hide");
  emp_div.classList.add("show");
  document.querySelector(".employee").classList.add("hide");
  document.querySelector(".vehicle").classList.add("show");
};


//variables for vehicle information
var vehicle_name_input = document.querySelector("#enter_vehicle_name");
var vehicle_number_input = document.querySelector("#enter_vehicle_number");
var vehicle_emp_id_input = document.querySelector("#enter_emp_id_vehicle");
var vehicle_ident_input = document.querySelector(
  "#enter_vehicle_identification"
);
var vehicle_type_input = document.querySelector(".enter_type_div");

//pricing list for different vehicles
var cycle_daily_price = 5;
var cycle_monthly_price = 100;
var cycle_yearly_price = 500;

var motorcycle_daily_price = 10;
var motorcycle_monthly_price = 200;
var motorcycle_yearly_price = 1000;

var fourwheeler_daily_price = 20;
var fourwheeler_monthly_price = 500;
var fourwheeler_yearly_price = 3500;

var daily_price_div = document.querySelector("#daily_price");
var monthly_price_div = document.querySelector("#monthly_price");
var yearly_price_div = document.querySelector("#yearly_price");

var vehicle_name, type, vehicle_number, vehicle_empid, identification;

//event listner for vehicle name inputs on pressing enter key
vehicle_name_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    vehicle_name = document.querySelector("#enter_vehicle_name").value;
    if (vehicle_name != "") {
      document.querySelector("#vehicle_name").innerHTML =
        vehicle_name + "! Can I know Vehicle type";
      document.querySelector(".display_vehicle_name").classList.add("show");
      vehicle_name_input.classList.add("hide");
      vehicle_type_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Please enter name of vehicle";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//function to get vehicle type from radio button
function getType(radio) {
  type = radio.value;
  document.querySelector("#vehicle_type").innerHTML =
    " " + type + ", Can I know your vehicle number";
  document.querySelector(".display_vehicle_type").classList.add("show");
  vehicle_type_input.classList.remove("show");
  vehicle_number_input.classList.add("show");
}

//event listner for vehicle number inputs on pressing enter key
vehicle_number_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    vehicle_number = document.querySelector("#enter_vehicle_number").value;
    if (vehicle_number != "") {
      document.querySelector("#vehicle_number").innerHTML =
        vehicle_number + "! Can I know your employee id";
      document.querySelector(".display_vehicle_number").classList.add("show");
      vehicle_number_input.classList.add("hide");
      vehicle_emp_id_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Please enter vehicle number";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//event listner for employee id inputs on pressing enter key
vehicle_emp_id_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    vehicle_empid = document.querySelector("#enter_emp_id_vehicle").value;
    if (vehicle_empid != "") {
      document.querySelector("#emp_id_vehicle").innerHTML =
        vehicle_empid + "! Can I know identification of vehicle";
      document.querySelector(".display_emp_id_vehicle").classList.add("show");
      vehicle_emp_id_input.classList.add("hide");
      vehicle_ident_input.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Please enter vehicle number";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

//event listner for employee name inputs on pressing enter key
vehicle_ident_input.addEventListener("keypress", function (e) {
  if (e.key === "Enter") {
    identification = document.querySelector("#enter_vehicle_identification")
      .value;
    if (identification != "") {
      document.querySelector(
        "#vehicle_identification"
      ).innerHTML = identification;
      document
        .querySelector(".display_vehicle_identification")
        .classList.add("show");
      vehicle_ident_input.classList.add("hide");
      switch (type) {
        case "Cycle":
          daily_price_div.innerHTML = cycle_daily_price;
          monthly_price_div.innerHTML = cycle_monthly_price;
          yearly_price_div.innerHTML = cycle_yearly_price;
          break;

        case "MotorCycle":
          daily_price_div.innerHTML = motorcycle_daily_price;
          monthly_price_div.innerHTML = motorcycle_monthly_price;
          yearly_price_div.innerHTML = motorcycle_yearly_price;
          break;

        case "FourWheeler":
          daily_price_div.innerHTML = fourwheeler_daily_price;
          monthly_price_div.innerHTML = fourwheeler_monthly_price;
          yearly_price_div.innerHTML = fourwheeler_yearly_price;
          break;
      }

      document.querySelector(".card-price").classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Please enter vehicle identification";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

function convertToUSD() {
  switch (type) {
    case "Cycle":
      daily_price_div.innerHTML = cycle_daily_price * 0.014;
      monthly_price_div.innerHTML = cycle_monthly_price * 0.014;
      yearly_price_div.innerHTML = cycle_yearly_price * 0.014;
      break;

    case "MotorCycle":
      daily_price_div.innerHTML = motorcycle_daily_price * 0.014;
      monthly_price_div.innerHTML = motorcycle_monthly_price * 0.014;
      yearly_price_div.innerHTML = motorcycle_yearly_price * 0.014;
      break;

    case "FourWheeler":
      daily_price_div.innerHTML = fourwheeler_daily_price * 0.014;
      monthly_price_div.innerHTML = fourwheeler_monthly_price * 0.014;
      yearly_price_div.innerHTML = fourwheeler_yearly_price * 0.014;
      break;
  }
}

function convertToYEN() {
  switch (type) {
    case "Cycle":
      daily_price_div.innerHTML = cycle_daily_price * 1.51;
      monthly_price_div.innerHTML = cycle_monthly_price * 1.51;
      yearly_price_div.innerHTML = cycle_yearly_price * 1.51;
      break;

    case "MotorCycle":
      daily_price_div.innerHTML = motorcycle_daily_price * 1.51;
      monthly_price_div.innerHTML = motorcycle_monthly_price * 1.51;
      yearly_price_div.innerHTML = motorcycle_yearly_price * 1.51;
      break;

    case "FourWheeler":
      daily_price_div.innerHTML = fourwheeler_daily_price * 1.51;
      monthly_price_div.innerHTML = fourwheeler_monthly_price * 1.51;
      yearly_price_div.innerHTML = fourwheeler_yearly_price * 1.51;
      break;
  }
}

function resetPrice() {
  switch (type) {
    case "Cycle":
      daily_price_div.innerHTML = cycle_daily_price;
      monthly_price_div.innerHTML = cycle_monthly_price;
      yearly_price_div.innerHTML = cycle_yearly_price;
      break;

    case "MotorCycle":
      daily_price_div.innerHTML = motorcycle_daily_price;
      monthly_price_div.innerHTML = motorcycle_monthly_price;
      yearly_price_div.innerHTML = motorcycle_yearly_price;
      break;

    case "FourWheeler":
      daily_price_div.innerHTML = fourwheeler_daily_price;
      monthly_price_div.innerHTML = fourwheeler_monthly_price;
      yearly_price_div.innerHTML = fourwheeler_yearly_price;
      break;
  }
}

var pass_type_div = document.querySelector("#pass_type");
var pass_price_div = document.querySelector("#pass_price");
var pass_price;
function getPass(pass_type) {
  switch (type) {
    case "Cycle":
      pass_type_div.innerHTML = type;
      switch (pass_type) {
        case "daily":
          pass_price_div.innerHTML = cycle_daily_price;
          pass_price = cycle_daily_price * 0.014;
          break;
        case "monthly":
          pass_price = cycle_monthly_price * 0.014;
          pass_price_div.innerHTML = cycle_monthly_price;
          break;
        case "yearly":
          pass_price = cycle_yearly_price * 0.014;
          pass_price_div.innerHTML = cycle_yearly_price;
          break;
      }
      break;

    case "MotorCycle":
      pass_type_div.innerHTML = type;
      switch (pass_type) {
        case "daily":
          pass_price = motorcycle_daily_price * 0.014;
          pass_price_div.innerHTML = motorcycle_daily_price;
          break;
        case "monthly":
          pass_price = motorcycle_monthly_price * 0.014;
          pass_price_div.innerHTML = motorcycle_monthly_price;
          break;
        case "yearly":
          pass_price = motorcycle_yearly_price * 0.014;
          pass_price_div.innerHTML = motorcycle_yearly_price;
          break;
      }
      break;

    case "FourWheeler":
      pass_type_div.innerHTML = type;
      switch (pass_type) {
        case "daily":
          pass_price = fourwheeler_daily_price * 0.014;
          pass_price_div.innerHTML = fourwheeler_daily_price;
          break;
        case "monthly":
          pass_price = fourwheeler_monthly_price * 0.014;
          pass_price_div.innerHTML = fourwheeler_monthly_price;
          break;
        case "yearly":
          pass_price = fourwheeler_yearly_price * 0.014;
          pass_price_div.innerHTML = fourwheeler_yearly_price;
          break;
      }
      break;
  }

  document.querySelector(".card-price").classList.remove("show");
  document.querySelector(".vehicle").classList.remove("show");
  document.querySelector(".display_pass").classList.add("show");
}
