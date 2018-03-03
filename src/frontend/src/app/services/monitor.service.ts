import { Observable } from 'rxjs/Rx';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable()
export class MonitorService {
    
    constructor(private http: HttpClient) { }
    
    getNetworkStatus(): Observable<any> {
        return this.http.get("/api/test");
    }
}
