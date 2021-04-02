
export class Vehicle{
    constructor(){
        this.vehicle_name = "";
        this.type = "";
        this.vehicle_number = "";
        this.vehicle_empid = "";
        this.identification = "";
        this.pass_type = "";
        this.pass_price = "";
    }

    setVehicleName = (name) => {
        this.vehicle_name = name;
    }

    setType = (type) => {
        this.type = type;
    }

    setVehicleNumber = (num) => {
        this.vehicle_number = num;
    }
    setVehicleEmpId = (id) => {
        this.vehicle_empid = id;
    }

    setIdentification = (text) => {
        this.identification = text;    
    }

    setPassType = (type) => {
        this.pass_type = type;
    }

    setPassPrice = (price) => {
        this.pass_price = price;
    }

    display = () => {
        console.log(this);
    }
}