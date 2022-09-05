import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NewExperienciaComponent } from './components/experiencia-laboral/new-experiencia.component';
import { EditExperienciaComponent } from './components/experiencia-laboral/edit-experiencia.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { EditeducacionComponent } from './components/educacion/editeducacion.component';
import { NeweducacionComponent } from './components/educacion/neweducacion.component';
import { NewProyectoComponent } from './components/proyecto/new-proyecto.component';
import { EdiProyectoComponent } from './components/proyecto/edi-proyecto.component';
import { NewHysComponent } from './components/hys/new-hys.component';
import { EditHysComponent } from './components/hys/edit-hys.component';



const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'nuevaexp', component: NewExperienciaComponent},
  { path:'editexpe/:id', component: EditExperienciaComponent},
  {path:'nuevaedu',component: NeweducacionComponent},
  {path:'editedu/:id', component: EditeducacionComponent},
  {path:'nuevoproyec',component:NewProyectoComponent},
  { path:'ediproyect/:id', component: EdiProyectoComponent},
  { path:'nuevahys',component:NewHysComponent},
  { path:'edithys/id',component:EditHysComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }