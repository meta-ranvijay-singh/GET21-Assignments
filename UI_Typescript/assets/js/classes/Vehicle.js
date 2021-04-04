export class Vehicle {
    constructor() {
        this.vehicle_name = "";
        this.type = "";
        this.identification = "";
        this.pass_type = "";
        this.setVehicleName = (name) => {
            this.vehicle_name = name;
        };
        this.setType = (type) => {
            this.type = type;
        };
        this.setVehicleNumber = (num) => {
            this.vehicle_number = num;
        };
        this.setVehicleEmpId = (id) => {
            this.vehicle_empid = id;
        };
        this.setIdentification = (text) => {
            this.identification = text;
        };
        this.setPassType = (type) => {
            this.pass_type = type;
        };
        this.setPassPrice = (price) => {
            this.pass_price = price;
        };
        this.display = () => {
            console.log(this);
        };
    }
}
