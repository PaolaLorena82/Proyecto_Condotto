export class Proyecto {
    id?: number;
    nombreP: string;
    descripcionP: string;
    img: string;


    constructor(nombreP: string, descripcionP: string, img: string){
        this.nombreP = nombreP;
        this.descripcionP = descripcionP;
        this.img = img;
    }
}

