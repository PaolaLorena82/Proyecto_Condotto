import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Hys } from 'src/app/model/hys';
import { HysService } from 'src/app/service/hys-service';
import { TokenService } from 'src/app/service/token.service';

@Component({
  selector: 'app-new-hys',
  templateUrl: './new-hys.component.html',
  styleUrls: ['./new-hys.component.css']
})
export class NewHysComponent implements OnInit {
  isLogged = false;
  nombreHys: string;
  capacidadesHys: number;
  imgHys: string;

  constructor(  private sHys : HysService,
    private tokenService: TokenService, private router: Router)  { }

    ngOnInit(): void {
      if(this.tokenService.getToken()){
        this.isLogged = true;
      }else{
        this.isLogged = false;
      }
    }
  
  
    onCreate(): void {
      const hys = new Hys (this.nombreHys, this.imgHys,this.capacidadesHys);  
      this.sHys.save(hys).subscribe(
        data => {
          alert(" Hard & Soft Skills añadida");
          this.router.navigate(['']);
        }, err => {
          alert("Falló");
          this.router.navigate(['']);
        }
      )
      }
    }