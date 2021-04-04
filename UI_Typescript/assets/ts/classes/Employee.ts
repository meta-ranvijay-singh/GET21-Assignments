
export class Employee{
    name:string = "";
    gender:string = "";
    email:string = "";
    password:string = "";
    contact:Number;
    id:Number;
    registration_id:Number;
    constructor(){   }

    setName = (name:string) => {
        this.name = name;
    }

    setGender = (gender:string) => {
        this.gender = gender;
    }

    setEmail = (email:string) => {
        this.email = email;
    }
    setPassword = (password:string) => {
        this.password = password;
    }

    setContact = (contact:Number) => {
        this.contact = contact;    
    }

    setID = (id:Number) => {
        this.id = id;
    }

    setRegistration = (regis_id:Number) => {
        this.registration_id = regis_id;
    }

    display = () => {
        console.log(this);
    }
}