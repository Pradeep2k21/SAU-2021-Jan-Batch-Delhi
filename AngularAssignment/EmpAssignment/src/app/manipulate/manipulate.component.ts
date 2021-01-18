import { Component, OnInit } from '@angular/core';
import { EmpServiceService } from '../emp-service.service';


@Component({
  selector: 'app-list-employee',
  templateUrl: './manipulate.component.html',
  styleUrls: ['./manipulate.component.scss']
})
export class ManipulateComponent implements OnInit {

  employees = [];

  constructor(private empsvc : EmpServiceService) { }

  ngOnInit(): void {
    this.employees = this.empsvc.getEmployees();
    // console.log('oninit', this.employees);
  }

  deleteEmployee = (index) => {
    let deletedEmp = this.empsvc.getEmployeeByIndex(index);
    this.empsvc.deleteEmployeeByIndex(index);
    alert("Employee deleted: \n" + JSON.stringify(deletedEmp));
  }

}