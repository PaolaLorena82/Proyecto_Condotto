export class Proyecto {
    id?: number;
    tituloP: string;
    descripcionP: string;
    imgP: string;


    constructor(tituloP: string, descripcionP: string, imgP: string){
        this.tituloP = tituloP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }
}

