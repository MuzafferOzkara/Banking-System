import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from '../service/UserService/user.service';
import { MatSnackBar } from '@angular/material';
import { NgForm } from '@angular/forms';
import { User } from '../model/user/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  currentid:User;

  @ViewChild('loginForm',  { static: true }) loginForm: NgForm;
  
  constructor(private router:Router,private userService:UserService,private snackBar:MatSnackBar) { }

  ngOnInit() {
  }


  onSubmit(){
    const value = this.loginForm.value;
    
    let doctor = {
      email: value.email,
      password: value.password,
    }
   
    if(value.email && value.password){
      this.userService.login(doctor).subscribe(
        (response) => {
          if(response !== null){
             localStorage.setItem('currentUser', JSON.stringify(response));
            sessionStorage.setItem('email', doctor.email);

            this.currentid=response;

            localStorage.setItem('currentUserId', JSON.stringify(this.currentid.id));

            
            this.router.navigate(['view-user']);
            
            console.log(value.email)
          } else {
            this.snackBar.open('Email or password is incorrect !!', 'Ok', {
              panelClass: ['snackbar']
            });
          }
          
        }
      );
    } else {
      this.snackBar.open('Email or password is incorrect !!', 'Ok', {
       
        panelClass: ['snackbar']
      });
    }
  }



}
