export class Employee {
    constructor() {
        this.name = "";
        this.gender = "";
        this.email = "";
        this.password = "";
        this.setName = (name) => {
            this.name = name;
        };
        this.setGender = (gender) => {
            this.gender = gender;
        };
        this.setEmail = (email) => {
            this.email = email;
        };
        this.setPassword = (password) => {
            this.password = password;
        };
        this.setContact = (contact) => {
            this.contact = contact;
        };
        this.setID = (id) => {
            this.id = id;
        };
        this.setRegistration = (regis_id) => {
            this.registration_id = regis_id;
        };
        this.display = () => {
            console.log(this);
        };
    }
}
