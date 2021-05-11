import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class NavbarserviceService {

  userloged = {
    'username': ''
  }

  constructor() { }
}
