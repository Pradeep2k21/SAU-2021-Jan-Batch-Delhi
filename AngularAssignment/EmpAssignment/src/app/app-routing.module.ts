import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FormEmpComponent } from './form-emp/form-emp.component';
import { ManipulateComponent } from './manipulate/manipulate.component';

const routes: Routes = [
  {
    path:'showEmployee',component:ManipulateComponent
  },
  {
    path:'employeeForm/:index',component:FormEmpComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
