export class persona{
    id?: number;
    nombre: string;
    apellido: string;
    img: string;
    banner:string;
    profesion:string;
    acercaDeMi:string;




    constructor(nombre: string,apellido: string, img: string, banner:string,
         profesion:string, acercaDeMi:string){   
            
        this.nombre = nombre;
        this.apellido = apellido;
        this.img = img;
        this.banner = banner;
        this.profesion = profesion;
        this.acercaDeMi = acercaDeMi;
    }
}