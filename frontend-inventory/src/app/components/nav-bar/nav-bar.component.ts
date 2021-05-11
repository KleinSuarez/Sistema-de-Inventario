import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login/login.service';
import { NavbarserviceService } from 'src/app/services/navbar/navbarservice.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nav-bar',
  templateUrl: './nav-bar.component.html',
  styleUrls: ['./nav-bar.component.css']
})
export class NavBarComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router, public navServices: NavbarserviceService) { }

  ngOnInit(): void {
  }

  logout(){
    this.loginService.logout()
    this.navServices.userloged.username = ''
    Swal.fire('session closed')
    this.router.navigate(['/login'])
  }

  isAuthenticated(): boolean {
    return this.loginService.isAuthenticated()
  }
}
