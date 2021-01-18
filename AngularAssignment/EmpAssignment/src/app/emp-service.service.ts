import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpServiceService {
  ListOfEmployees = [
    {empid : "101", name : "Divya", address:"Punjab", dob : "1996-04-16"},
    {empid : "102", name : "ahiv", address:"Mumbai", dob : "1997-08-26"},
    {empid : "103", name : "Pradeep", address:"Delhi", dob : "1996-03-10"},
    {empid : "104", name : "Ram", address: " Delhi", dob : "1998-01-18"},
    {empid : "105", name : "Neha", address: "Bihar", dob : "1996-02-03"}
  ];

  constructor() { }

  getEmployees(){
    return this.ListOfEmployees;
  }

  getEmployeeByIndex(index){
    return this.ListOfEmployees[index];
  }

  addEmployee(employee){
    this.ListOfEmployees.push(employee);
    // console.log(this.ListOfEmployees);
  }

  deleteEmployeeByIndex(index){
    this.ListOfEmployees.splice(index, 1);
    // console.log(this.ListOfEmployees);
  }

  updateEmployeeByIndex(index, employee){
    this.ListOfEmployees[index] = employee;
    // console.log(this.ListOfEmployees);
  }
}
