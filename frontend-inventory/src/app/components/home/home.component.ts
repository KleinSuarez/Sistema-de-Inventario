import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
    console.log(JSON.parse(sessionStorage.getItem('user')))
    if(sessionStorage.getItem('user') == null){
      this.router.navigate(['/login'])
    }
  }

}
