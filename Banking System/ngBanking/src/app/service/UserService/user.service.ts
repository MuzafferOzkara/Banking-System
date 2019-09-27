import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseUrl = 'http://localhost:8080/';  

  constructor(private http:HttpClient) { }

  getUserList(): Observable<any> {  
    return this.http.get(`${this.baseUrl}`+'users');  
    
  }  

  getUser(id: number): Observable<any> {  
    return this.http.get(`${this.baseUrl}/user/${id}`);  
  }  

  transferMoney(id: number,id2:number,amount:number, value: any): Observable<Object> {
    return this.http.put(`${this.baseUrl}/transfer/${id}/${id2}/${amount}`, value, { responseType: 'json' });  
  }

  login(theUser) {
    return this.http.post<any>('http://localhost:8080/login', theUser).pipe(
      map(user => {
           return user;
    }));
  }


}
