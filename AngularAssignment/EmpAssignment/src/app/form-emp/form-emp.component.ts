import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { EmpServiceService } from '../emp-service.service';

@Component({
  selector: 'app-form-emp',
  templateUrl: './form-emp.component.html',
  styleUrls: ['./form-emp.component.scss']
})
export class FormEmpComponent implements OnInit {

  editmode = false;

  EmpFormGroup = new FormGroup({
    empid : new FormControl('', Validators.required),
    name : new FormControl('', Validators.required),
    address : new FormControl('', Validators.required),
    dob: new FormControl('', Validators.required)
  });


  constructor(
    private empsvc:EmpServiceService,
    private router: Router,
    private route: ActivatedRoute,
    
    ) { }

  ngOnInit(): void {

    let index = this.route.snapshot.params['index'];
    this.editmode = index == '' ? false:true;

    if(this.editmode){
      let oldEmployee = this.empsvc.getEmployeeByIndex(index);
     
      this.fillForm(oldEmployee);
      
    }

  }

  submitEmployee = () => {
    // console.log(JSON.stringify(this.EmpFormGroup.value));
    let employeeObj = this.EmpFormGroup.value;
    if(!this.editmode){
      this.empsvc.addEmployee(employeeObj);
      alert('Employee Added: ' + JSON.stringify(employeeObj));
      this.router.navigate(['']);
    }
    else{
      let index = this.route.snapshot.params['index'];
      this.empsvc.updateEmployeeByIndex(index, employeeObj);
      alert('Employee Update: ' + JSON.stringify(employeeObj));
      this.router.navigate(['showEmployee']);
    }
  }

  fillForm = (data) => {
    this.EmpFormGroup.setValue({
      name: data.name,
      empid: data.empid,
      address: data.address,
      dob: data.dob
    });
  }

}
