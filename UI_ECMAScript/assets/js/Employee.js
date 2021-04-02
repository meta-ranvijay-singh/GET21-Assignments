export class Employee{
    constructor(){
        this.name = "";
        this.gender = "";
        this.email = "";
        this.password = "";
        this.confirmpass = "";
        this.contact = "";
        this.id = "";
        this.registration_id = "";
    }

    setName = (name) => {
        this.name = name;
    }

    setGender = (gender) => {
        this.gender = gender;
    }

    setEmail = (email) => {
        this.email = email;
    }
    setPassword = (password) => {
        this.password = password;
    }

    setContact = (contact) => {
        this.contact = contact;    
    }

    setID = (id) => {
        this.id = id;
    }

    setRegistration = (regis_id) => {
        this.registration_id = regis_id;
    }

    display = () => {
        console.log(this);
    }
}