import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user/user';

const endPoint = 'http://127.0.0.1:8081/oauth/token'

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private http: HttpClient) { }

  private user: User

  login(user: User): Observable<any> {
    const credentials = btoa('angular-app' + ':' + 'abcd*')
    const httpHeaders = new HttpHeaders({
      'Content-Type': 'application/x-www-form-urlencoded',
      'Authorization': 'Basic ' + credentials,
    })
    const params = new URLSearchParams()
    params.set('grant_type', 'password')
    params.set('username', user.username)
    params.set('password', user.password)
    return this.http.post<any>(endPoint, params.toString(), { headers: httpHeaders })
  }

  saveUser(accessToken: string): void {
    const payload = this.getPayLoad(accessToken)
    this.user = new User()
    this.user.username = payload.user_name
    this.user.roles = payload.authorities
    sessionStorage.setItem('user', JSON.stringify(this.user))
  }

  getPayLoad(accessToken: string): any {
    if (accessToken !== undefined) {
      return JSON.parse(atob(accessToken.split('.')[1]))
    }
    return null
  }

  saveToken(access_token: string): void {
    sessionStorage.setItem('token', access_token)
  }

  logout() {
    this.user = null
    sessionStorage.clear()
    sessionStorage.removeItem('user')
    sessionStorage.removeItem('token')
  }

  isAuthenticated(): boolean {
    return sessionStorage.getItem('user') != null
  }
}
