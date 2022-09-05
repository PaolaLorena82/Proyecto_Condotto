import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto-service';

@Component({
  selector: 'app-new-proyecto',
  templateUrl: './new-proyecto.component.html',
  styleUrls: ['./new-proyecto.component.css']
})
export class NewProyectoComponent implements OnInit {
    tituloP: string;
    descripcionP: string;
    imgP: string;

  constructor( private sProyecto : ProyectoService, private router: Router ) { }

  ngOnInit(): void {
  }

  onCreate(): void{
    const proyecto = new Proyecto(this.tituloP, this.descripcionP,this.imgP);
    this.sProyecto.save(proyecto).subscribe(
      data =>{
        alert("Proyecto añadido correctamente");
        this.router.navigate(['']);
      }, err =>{
        alert("falló");
        this.router.navigate(['']);
      }
    )
  }


}
