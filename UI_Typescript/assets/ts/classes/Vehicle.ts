
export class Vehicle{
    
    vehicle_name:string = "";
    type:string = "";
    vehicle_number:Number;
    vehicle_empid:Number;
    identification:string = "";
    pass_type:string = "";
    pass_price:Number;

    constructor(){
    }

    setVehicleName = (name:string) => {
        this.vehicle_name = name;
    }

    setType = (type:string) => {
        this.type = type;
    }

    setVehicleNumber = (num:Number) => {
        this.vehicle_number = num;
    }
    setVehicleEmpId = (id:Number) => {
        this.vehicle_empid = id;
    }

    setIdentification = (text:string) => {
        this.identification = text;    
    }

    setPassType = (type:string) => {
        this.pass_type = type;
    }

    setPassPrice = (price:Number) => {
        this.pass_price = price;
    }

    display = () => {
        console.log(this);
    }
}