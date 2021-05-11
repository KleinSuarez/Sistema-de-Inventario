import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class ConnectionParameters {

    public getUrlBase(): string {
        return 'http://127.0.0.1:8081/'
    }

    public getJsonHeader(): any {
        return {
            'Content-Type': 'application/json',
            'Authorization': 'Bearer '.concat(sessionStorage.getItem('token'))
        }
    }

    public getSimpleHeader(): any {
        return {
            'Authorization': 'Bearer '.concat(sessionStorage.getItem('token'))
        }
    }
}
