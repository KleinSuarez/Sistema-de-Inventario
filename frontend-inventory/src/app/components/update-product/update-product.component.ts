import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  
  constructor(private router: Router) {

  }

  ngOnInit(): void {
    if(sessionStorage.getItem('user') == null){
      this.router.navigate(['/login'])
    }
  }

}
