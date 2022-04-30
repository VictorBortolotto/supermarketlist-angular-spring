import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Signup } from 'src/app/model/SignupModel';
import { MatSnackBar } from '@angular/material/snack-bar';
import { SignupService } from 'src/app/services/signup.service';

@Component({
  selector: 'app-registry',
  templateUrl: './registry.component.html',
  styleUrls: ['./registry.component.css']
})
export class RegistryComponent implements OnInit {

  registry: Signup = {
    nickname: '',
    email: '',
    password: '',
    confirmPassword: ''
  }

  constructor(private router: Router, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  submit(): void {

    if(this.registry.nickname == '' || this.registry.email == '' || this.registry.password == '' || this.registry.confirmPassword == ''){
      this.showMessage("Please, fill all the fields!", 400);
      return;
    }

    if(!(this.registry.password === this.registry.confirmPassword)){
      this.showMessage("Passwords are diferent!", 400);
      return;
    }

    if(this.registry.email.search('@') == -1){
      this.showMessage("Use a valid E-mail!", 400);
      return;
    }

    SignupService(this.registry.nickname, this.registry.email, this.registry.password).then((data) => {
      this.showMessage(data.message, data.statusCode);
      return;     
    });
  }
  
  cancel(){
    document.location.reload();
  }

  showMessage(msg: string, statusCode: number): void{
    this.snackBar.open(msg, '', {
      duration: 3000,
      horizontalPosition: 'center',
      verticalPosition: 'bottom',
      panelClass: statusCode >= 200 && statusCode <= 299 ? ['msg-success'] : ['msg-error'] 
    })
  }

}
