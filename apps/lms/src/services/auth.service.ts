import { Injectable } from '@angular/core';
import { ApiService } from './api.service';
import { JwtService } from './jwt.service';
import { BehaviorSubject, Observable } from 'rxjs';
import User from '../models/user.model';
import { distinctUntilChanged, tap } from 'rxjs/operators';
import { FORGOTPWD_API, RESETPWD_API, SIGNIN_API, SIGNUP_API } from './AuthenticationApiPath';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private currentUser$ = new BehaviorSubject<User>({id: 0});
  public currentUser = this.currentUser$.asObservable()
    .pipe(distinctUntilChanged());

  private isAuthenticated$ = new BehaviorSubject<boolean>(false);
  public isAuthenticated = this.isAuthenticated$.asObservable();

  public forgotAccount!: {email: string};

  constructor(private readonly apiService: ApiService,
              private readonly jwtService: JwtService) { }

  setAuth(user: User): void {
    this.jwtService.saveCurrentUserId(user);
    this.currentUser$.next(user);
    console.log(user);
    this.isAuthenticated$.next(true);
  }

  getCurrentUser(): User | undefined {
    return this.currentUser$.value;
  }

  purgeAuth(): void {
    this.jwtService.destroyToken();
    this.currentUser$.next({id: 0});
    this.isAuthenticated$.next(false);
  }

  attemptAuth(credentials: {username: string, password: string}): Observable<User> {
    return this.apiService.post(SIGNIN_API, credentials)
      .pipe(tap((user: User) => {
        this.setAuth(user);
    }));
  }

  forgotPassword(data: {email: string}): Observable<any> {
    return this.apiService.post(FORGOTPWD_API, data);
  }

  resetPassword(data: {email: string, verifyCode: string, newPwd: string}): Observable<User> {
    return this.apiService.post(RESETPWD_API, data).pipe(tap((user: User)=> {
      this.setAuth(user);
    }));
  }

  signup(data: any): Observable<User> {
    return this.apiService.post(SIGNUP_API, data);
  }
}
