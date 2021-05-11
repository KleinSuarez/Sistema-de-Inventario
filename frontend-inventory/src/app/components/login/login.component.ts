import { Component, OnInit} from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/model/user/user';
import { LoginService } from 'src/app/services/login/login.service';
import { NavbarserviceService } from 'src/app/services/navbar/navbarservice.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user = new User();

  constructor(private loginService: LoginService, private router: Router, private navService : NavbarserviceService) { }

  ngOnInit(): void {
  }


  login() {

    if (this.user.username === undefined || this.user.password === undefined) {
      Swal.fire({
        icon: 'error',
        title: 'Oops...',
        text: 'you must enter the credentials to start',
        footer: '<a href="mailto:yahir.kleins@gmail.com">Did you forget your username or password</a>'
      })
    } else {
      this.loginService.login(this.user).subscribe(
        res => {
          this.loginService.saveUser(res.access_token)
          this.loginService.saveToken(res.access_token)
          this.navService.userloged = JSON.parse(sessionStorage.getItem('user'))
          this.router.navigate(['/home'])
        },
        _ => {
          Swal.fire({
            icon: 'error',
            title: 'Oops...',
            text: 'Your username or password are incorrect',
            footer: '<a href="mailto:yahir.kleins@gmail.com">Did you forget your username or password</a>'
          })
        }
      )
    }
  }
}
