import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Hys } from 'src/app/model/hys';
import { HysService } from 'src/app/service/hys-service';

@Component({
  selector: 'app-edit-hys',
  templateUrl: './edit-hys.component.html',
  styleUrls: ['./edit-hys.component.css']
})
export class EditHysComponent implements OnInit {

  hys: Hys = null;


  constructor(private sHys : HysService , 
              private activatedRouter: ActivatedRoute,
               private router: Router) { }

ngOnInit(): void {
  const id = this.activatedRouter.snapshot.params['id'];
  this.sHys.detail(id).subscribe(
    data =>{
      this.hys = data;
    }, err =>{
      alert("Error al modificar ");
      this.router.navigate(['']);
    }
  )
}

onUpdate(): void{
  const id = this.activatedRouter.snapshot.params['id'];
  this.sHys.update(id, this.hys).subscribe(
    data => {
      this.router.navigate(['']);
    }, err =>{
       alert("Error al modificar");
       this.router.navigate(['']);
    }
  )
}

}



