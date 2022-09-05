export class Proyecto {
    id?: number;
    nombreP: string;
    descripcionP: string;
    imgP: string;


    constructor(nombreP: string, descripcionP: string, imgP: string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }
}

