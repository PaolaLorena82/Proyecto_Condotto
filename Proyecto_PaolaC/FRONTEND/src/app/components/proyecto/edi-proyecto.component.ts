import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Proyecto } from 'src/app/model/proyecto';
import { ProyectoService } from 'src/app/service/proyecto-service';

@Component({
  selector: 'app-edi-proyecto',
  templateUrl: './edi-proyecto.component.html',
  styleUrls: ['./edi-proyecto.component.css']
})
export class EdiProyectoComponent implements OnInit {

  proyect: Proyecto = null;


    constructor(private sProyecto : ProyectoService , 
                private activatedRouter: ActivatedRoute,
                 private router: Router) { }

  ngOnInit(): void {
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyecto.detail(id).subscribe(
      data =>{
        this.proyect = data;
      }, err =>{
        alert("Error al modificar el proyecto");
        this.router.navigate(['']);
      }
    )
  }

  onUpdate(): void{
    const id = this.activatedRouter.snapshot.params['id'];
    this.sProyecto.update(id, this.proyect).subscribe(
      data => {
        this.router.navigate(['']);
      }, err =>{
         alert("Error al modificar el proyecto");
         this.router.navigate(['']);
      }
    )
  }

}
