import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { Login } from 'src/app/model/LoginModel';
import { SigninService } from 'src/app/services/login.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  signin: Login = {
    email: '',
    password: ''
  }

  constructor(private snackBar: MatSnackBar, private router: Router) { }

  ngOnInit(): void {
  }

  login(){

    if(this.signin.email == '' || this.signin.password == ''){
      this.showMessage("Please, fill all the fields!", 400);
      return;
    }

    if(this.signin.email.search('@') == -1){
      this.showMessage("Use a valid E-mail!", 400);
      return;
    }

    SigninService(this.signin.email, this.signin.password).then((data) => {
      if(data.statusCode == 200){
        this.router.navigateByUrl('/home')
      }else{
        this.showMessage(data.message, data.statusCode);
      }
    });
  }

  signup(){
    this.router.navigateByUrl('/registry')
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
