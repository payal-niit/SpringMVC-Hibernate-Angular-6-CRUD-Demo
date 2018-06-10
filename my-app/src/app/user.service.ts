import { Injectable } from '@angular/core';
import {Observable, of} from 'rxjs'
import { HttpClient , HttpClientModule, HttpHeaders} from '@angular/common/http';
import { catchError, map , tap } from 'rxjs/operators'

import { User , USERS } from './user'
import { MessageService } from './message.service'

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http:HttpClient , private messageService: MessageService) { }

  private userUrl = 'http://localhost:8080/SpringRestDemo/';

  
  
  //method to return the user list through a service
  getUsers():Observable<User[]> {
    //this.messageService.add('UserService: fetched users');
    //return of (USERS);
    return this.http.get<User[]>(this.userUrl).pipe(tap(User => this.log('fetched users')),catchError(this.handleError('getUsers', [])));
  }

  //method to return a user through a service
  getUserById(userId: number): Observable<User> {
    const url = `${this.userUrl}/${userId}`;
    return this.http.get<User>(url).pipe(
      tap(_ => this.log(`fetched hero id=${userId}`)),
      catchError(this.handleError<User>(`getHero id=${userId}`))
    );
  }

  //method to update the user through a service
  updateUser(user:User):Observable<any> {
    
    return this.http.put<User>(this.userUrl,user,httpOptions);
  }

  private log(message: string):void {
    this.messageService.add('UserService: '+message)
  }

  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
   
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
   
      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);
   
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }
}
const httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};