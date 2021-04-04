//variables for employee information
let confirmpass, error;
confirmpass = error = null;

import { Employee } from './classes/Employee.js';
import { Vehicle } from './classes/Vehicle.js';
let employee = new Employee();

declare global {
    interface Window { getGender: any; }
    interface Window { getPass: any; }
    interface Window { resetPrice: any; }
    interface Window { convertToYEN: any; }
    interface Window { convertToUSD: any; }
    interface Window { getType: any; }
    interface Window { addEmployee: any; }
    interface Window { check: any; }
}

//Employee inputs field
const name_input = document.querySelector("#enter_name") as HTMLInputElement;
const email_input = document.querySelector("#enter_email") as HTMLInputElement;
const password_input = document.querySelector("#enter_password") as HTMLInputElement;
const cpassword_input = document.querySelector("#enter_cpassword") as HTMLInputElement;
const gender_input = document.querySelector(".enter_gender_div")!;
const contact_input = document.querySelector("#enter_contact") as HTMLInputElement;
const error_div = document.querySelector("#error")!;
const alert_div = document.querySelector(".alert")!;

/* Regex for validations */
const emailRegex = /^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
const passRegex = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[a-zA-Z!#$%&? "])[a-zA-Z0-9!#$%&?]{8,}$/;
const nameRegex = /^([a-zA-Z ]){2,}$/;
const contactRegex = /^([0-9]){10}$/;

//event listner for employee name inputs on pressing enter key
name_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    employee.setName(name_input.value);
    if (nameRegex.test(employee.name)) {
      document.querySelector("#emp_name")!.innerHTML =
        "Hi, " + employee.name + "! Can I know your gender";
      document.querySelector(".display_emp_name")!.classList.add("show");
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
const getGender = (radio:HTMLInputElement) => {
  employee.setGender(radio.value);
  document.querySelector("#emp_gender")!.innerHTML =
    " " + employee.gender + ", Can I know your email";
  document.querySelector(".display_emp_gender")!.classList.add("show");
  gender_input.classList.remove("show");
  email_input.classList.add("show");
  email_input.focus();
}


window.getGender = getGender;

//event listner for employee email inputs on pressing enter key
email_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    employee.setEmail( email_input.value);
    if (emailRegex.test(employee.email)) {
      document.querySelector("#emp_email")!.innerHTML =
        " " + employee.email + ", Please enter your password";
      email_input.classList.remove("show");
      document.querySelector(".display_emp_email")!.classList.add("show");
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
const check = (input:HTMLInputElement) => {
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
window.check = check;

//event listner for employee password inputs on pressing enter key
password_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    employee.setPassword( password_input.value);
    if (passRegex.test(employee.password)) {
      document.querySelector("#emp_password")!.innerHTML =
        "Verified , Please confirm password";
      password_input.classList.remove("show");
      document.querySelector(".display_emp_password")!.classList.add("show");
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
cpassword_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    confirmpass = cpassword_input.value;
    if (confirmpass == employee.password) {
      document.querySelector("#emp_cpassword")!.innerHTML =
        "Matched , Please enter your contact number";
      cpassword_input.classList.remove("show");
      document.querySelector(".display_emp_cpassword")!.classList.add("show");
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
contact_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    employee.setContact( Number(contact_input.value));
    if (contactRegex.test(employee.contact.toString())) {
      document.querySelector("#emp_contact")!.innerHTML = " " + employee.contact;
      contact_input.classList.remove("show");
      document.querySelector(".display_emp_contact")!.classList.add("show");
      document.querySelector("#emp_submit")!.classList.add("show");

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
const addEmployee = () => {
  employee.setRegistration( Math.floor(Math.random() * Math.floor(1000)));
  let emp_div = document.querySelector(".registration_id")!;
  emp_div.innerHTML = "Registration ID : " + employee.registration_id;
  document.querySelector("#addEmployee")!.classList.add("hide");
  emp_div.classList.add("show");
  document.querySelector(".employee")!.classList.add("hide");
  document.querySelector(".vehicle")!.classList.add("show");
};
window.addEmployee = addEmployee;


//variables for vehicle information
const vehicle_name_input = document.querySelector("#enter_vehicle_name") as HTMLInputElement;
const vehicle_number_input = document.querySelector("#enter_vehicle_number") as HTMLInputElement;
const vehicle_emp_id_input = document.querySelector("#enter_emp_id_vehicle") as HTMLInputElement;
const vehicle_ident_input = document.querySelector(
  "#enter_vehicle_identification"
) as HTMLInputElement;
const vehicle_type_input = document.querySelector(".enter_type_div")!;

//pricing list for different vehicles
const cycle_daily_price = 5;
const cycle_monthly_price = 100;
const cycle_yearly_price = 500;

const motorcycle_daily_price = 10;
const motorcycle_monthly_price = 200;
const motorcycle_yearly_price = 1000;

const fourwheeler_daily_price = 20;
const fourwheeler_monthly_price = 500;
const fourwheeler_yearly_price = 3500;

const daily_price_div = document.querySelector("#daily_price")!;
const monthly_price_div = document.querySelector("#monthly_price")!;
const yearly_price_div = document.querySelector("#yearly_price")!;



let vehicle = new Vehicle();
//event listner for vehicle name inputs on pressing enter key
vehicle_name_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    vehicle.setVehicleName( vehicle_name_input.value);
    if (vehicle.vehicle_name != "") {
      document.querySelector("#vehicle_name")!.innerHTML =
      vehicle.vehicle_name + "! Can I know Vehicle type";
      document.querySelector(".display_vehicle_name")!.classList.add("show");
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
const getType = (radio:HTMLInputElement) => {
  vehicle.setType( radio.value);
  document.querySelector("#vehicle_type")!.innerHTML =
    " " + vehicle.type + ", Can I know your vehicle number";
  document.querySelector(".display_vehicle_type")!.classList.add("show");
  vehicle_type_input.classList.remove("show");
  vehicle_number_input.classList.add("show");
}
window.getType = getType;

//event listner for vehicle number inputs on pressing enter key
vehicle_number_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    vehicle.setVehicleNumber( Number(vehicle_number_input.value));
    if (vehicle.vehicle_number != undefined) {
      document.querySelector("#vehicle_number")!.innerHTML =
      vehicle.vehicle_number + "! Can I know your employee id";
      document.querySelector(".display_vehicle_number")!.classList.add("show");
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
vehicle_emp_id_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    vehicle.setVehicleEmpId(Number(vehicle_emp_id_input.value));
    employee.setID(vehicle.vehicle_empid)
    if (vehicle.vehicle_empid != undefined) {
      document.querySelector("#emp_id_vehicle")!.innerHTML =
      vehicle.vehicle_empid + "! Can I know identification of vehicle";
      document.querySelector(".display_emp_id_vehicle")!.classList.add("show");
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
vehicle_ident_input.addEventListener("keypress", (e) => {
  if (e.key === "Enter") {
    vehicle.setIdentification( vehicle_ident_input.value);
    if (vehicle.identification != "") {
      document.querySelector(
        "#vehicle_identification"
      )!.innerHTML = vehicle.identification;
      document
        .querySelector(".display_vehicle_identification")!
        .classList.add("show");
      vehicle_ident_input.classList.add("hide");
      switch (vehicle.type) {
        case "Cycle":
          daily_price_div.innerHTML = cycle_daily_price.toString();
          monthly_price_div.innerHTML = cycle_monthly_price.toString();
          yearly_price_div.innerHTML = cycle_yearly_price.toString();
          break;

        case "MotorCycle":
          daily_price_div.innerHTML = motorcycle_daily_price.toString();
          monthly_price_div.innerHTML = motorcycle_monthly_price.toString();
          yearly_price_div.innerHTML = motorcycle_yearly_price.toString();
          break;

        case "FourWheeler":
          daily_price_div.innerHTML = fourwheeler_daily_price.toString();
          monthly_price_div.innerHTML = fourwheeler_monthly_price.toString();
          yearly_price_div.innerHTML = fourwheeler_yearly_price.toString();
          break;
      }

      document.querySelector(".card-price")!.classList.add("show");

      error = "";
      alert_div.classList.remove("show");
    } else {
      error = "Please enter vehicle identification";
      error_div.innerHTML = error;
      alert_div.classList.add("show");
    }
  }
});

const convertToUSD = () => {
  switch (vehicle.type) {
    case "Cycle":
      daily_price_div.innerHTML = (cycle_daily_price * 0.014).toString();
      monthly_price_div.innerHTML = (cycle_monthly_price * 0.014).toString();
      yearly_price_div.innerHTML = (cycle_yearly_price * 0.014).toString();
      break;

    case "MotorCycle":
      daily_price_div.innerHTML = (motorcycle_daily_price * 0.014).toString();
      monthly_price_div.innerHTML = (motorcycle_monthly_price * 0.014).toString();
      yearly_price_div.innerHTML = (motorcycle_yearly_price * 0.014).toString();
      break;

    case "FourWheeler":
      daily_price_div.innerHTML = (fourwheeler_daily_price * 0.014).toString();
      monthly_price_div.innerHTML = (fourwheeler_monthly_price * 0.014).toString();
      yearly_price_div.innerHTML = (fourwheeler_yearly_price * 0.014).toString();
      break;
  }
}
window.convertToUSD = convertToUSD;

const convertToYEN = () => {
  switch (vehicle.type) {
    case "Cycle":
      daily_price_div.innerHTML = (cycle_daily_price * 1.51).toString();
      monthly_price_div.innerHTML = (cycle_monthly_price * 1.51).toString();
      yearly_price_div.innerHTML = (cycle_yearly_price * 1.51).toString();
      break;

    case "MotorCycle":
      daily_price_div.innerHTML = (motorcycle_daily_price * 1.51).toString();
      monthly_price_div.innerHTML = (motorcycle_monthly_price * 1.51).toString();
      yearly_price_div.innerHTML = (motorcycle_yearly_price * 1.51).toString();
      break;

    case "FourWheeler":
      daily_price_div.innerHTML = (fourwheeler_daily_price * 1.51).toString();
      monthly_price_div.innerHTML = (fourwheeler_monthly_price * 1.51).toString();
      yearly_price_div.innerHTML = (fourwheeler_yearly_price * 1.51).toString();
      break;
  }
}
window.convertToYEN = convertToYEN;

const resetPrice = () => {
  switch (vehicle.type) {
    case "Cycle":
      daily_price_div.innerHTML = cycle_daily_price.toString();
      monthly_price_div.innerHTML = cycle_monthly_price.toString();
      yearly_price_div.innerHTML = cycle_yearly_price.toString();
      break;

    case "MotorCycle":
      daily_price_div.innerHTML = motorcycle_daily_price.toString();
      monthly_price_div.innerHTML = motorcycle_monthly_price.toString();
      yearly_price_div.innerHTML = motorcycle_yearly_price.toString();
      break;

    case "FourWheeler":
      daily_price_div.innerHTML = fourwheeler_daily_price.toString();
      monthly_price_div.innerHTML = fourwheeler_monthly_price.toString();
      yearly_price_div.innerHTML = fourwheeler_yearly_price.toString();
      break;
  }
}
window.resetPrice = resetPrice;

const pass_type_div = document.querySelector("#pass_type")!;
const pass_price_div = document.querySelector("#pass_price")!;
let pass_price;

const getPass = (pass_type:string) => {
  pass_type_div.innerHTML = vehicle.type;
  vehicle.setPassType(pass_type);
  switch (vehicle.type) {
    case "Cycle":
      switch (vehicle.pass_type) {
        case "daily":
          pass_price_div.innerHTML = cycle_daily_price.toString();
          vehicle.setPassPrice( cycle_daily_price * 0.014);
          break;
        case "monthly":
          vehicle.setPassPrice(cycle_monthly_price * 0.014);
          pass_price_div.innerHTML = cycle_monthly_price.toString();
          break;
        case "yearly":
          vehicle.setPassPrice(cycle_yearly_price * 0.014);
          pass_price_div.innerHTML = cycle_yearly_price.toString();
          break;
      }
      break;

    case "MotorCycle":
      switch (vehicle.pass_type) {
        case "daily":
          vehicle.setPassPrice(motorcycle_daily_price * 0.014);
          pass_price_div.innerHTML = motorcycle_daily_price.toString();
          break;
        case "monthly":
          vehicle.setPassPrice(motorcycle_monthly_price * 0.014);
          pass_price_div.innerHTML = motorcycle_monthly_price.toString();
          break;
        case "yearly":
          vehicle.setPassPrice(motorcycle_yearly_price * 0.014);
          pass_price_div.innerHTML = motorcycle_yearly_price.toString();
          break;
      }
      break;

    case "FourWheeler":
      switch (vehicle.pass_type) {
        case "daily":
          vehicle.setPassPrice(fourwheeler_daily_price * 0.014);
          pass_price_div.innerHTML = fourwheeler_daily_price.toString();
          break;
        case "monthly":
          vehicle.setPassPrice(fourwheeler_monthly_price * 0.014);
          pass_price_div.innerHTML = fourwheeler_monthly_price.toString();
          break;
        case "yearly":
          vehicle.setPassPrice(fourwheeler_yearly_price * 0.014);
          pass_price_div.innerHTML = fourwheeler_yearly_price.toString();
          break;
      }
      break;
  }

  document.querySelector(".card-price")!.classList.remove("show");
  document.querySelector(".vehicle")!.classList.remove("show");
  let display_pass = document.querySelector(".display_pass")!;
  display_pass.classList.add("show");
  vehicle.display();
  employee.display();
}
window.getPass = getPass;