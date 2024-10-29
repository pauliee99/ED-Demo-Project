import { Injectable } from '@angular/core';
import { User } from '@entities/User';
import { Observable, of ,throwError} from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';
import {
  HttpClient,
  HttpErrorResponse,
  HttpEvent,
  HttpHandler,
  HttpHeaders,
  HttpInterceptor,
  HttpRequest, HttpResponse
} from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {
  private Url = 'http://localhost:8080'

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    const url = `${this.Url}/api/users`;
    return this.http.get<User[]>(url)
    .pipe(
      // tap(_ => this.log('fetched users')),   
      catchError(this.handleError<User[]>('getUsers', []))
    );
  }

  addUser(user: User): Observable<User> {
    const url = `${this.Url}/api/users`;
    return this.http.post<User>(url, user, this.httpOptions)
    .pipe(
      catchError(this.handleError('addUser', user))
    );
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
    this.log(`${message} failed: ${message}`);
    // this.messageService.add(`HeroService: ${message}`);
  }
}
