import { Component, OnInit } from '@angular/core';
import { UserService } from '../service/UserService/user.service';
import { Observable } from 'rxjs';
import { User } from '../model/user/user';
import { HttpClientModule } from '@angular/common/http'; 
import { ActivatedRoute, Router } from '@angular/router';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users:Observable<User[]>;  
  amount;

  cuser:User;
  c1user:Observable<User[]>;  
  tuser:User;

  

  constructor(private userService:UserService
    ) { }

  ngOnInit() {

    this.userService.getUserList().subscribe(data =>{  
      this.users =data;      

      this.cuser=JSON.parse(localStorage.getItem('currentUser'));
      console.log(this.cuser.balance)      
      }) 


      // console.log(this.getOne(JSON.parse(localStorage.getItem('currentUserId'))));

      this.getOne(JSON.parse(localStorage.getItem('currentUserId')));
      console.log(this.c1user);



     


  }

  transfer(user){
    this.tuser=user;

    this.userService.transferMoney(this.cuser.id,this.tuser.id,this.amount,this.cuser) 

    .subscribe(data => console.log(data), error => console.log(error));  

    console.log(user)
   this.reStudentList();


    this.userService.getUser(this.cuser.id).subscribe(data =>{  
    this.c1user =data  
            })  

      

  }


  reStudentList(){

    this.userService.getUserList().subscribe(data =>{  
      this.users =data;   
    })    

  }



  getOne(id){
    this.userService.getUser(id).subscribe(data =>{  
      this.c1user =data  
              })  
  }


}
