export class Hys {
    id?: number;
    nombreHys: string;
    imgHys: string;
    capacidadesHys: number;

    constructor(nombreHys: string, imgHys: string, capacidadesHys: number) {  
     this.nombreHys = nombreHys;
     this.imgHys = imgHys;    
     this.capacidadesHys = capacidadesHys;
}
}