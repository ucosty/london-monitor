import { Observable } from 'rxjs/Rx';
import { MonitorService } from './services/monitor.service';
import { ApplicationRef, Component, OnInit } from '@angular/core';

import Stomp from 'stompjs';
import SockJS from 'sockjs-client';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css'],
    providers: [MonitorService]
})
export class AppComponent implements OnInit {
    public status: any;
    public state: Observable<string>;
    private stompClient;
    public updated: number;
    
    constructor(private monitor: MonitorService) {
        this.initializeWebSocketConnection();
    }
    
    initializeWebSocketConnection() {
        let self = this;
        let ws = new SockJS('/ws');
        this.stompClient = Stomp.over(ws);
        let that = this;
        this.stompClient.connect({}, (frame) => {
            that.stompClient.subscribe("/topic/update", (message) => {
                if(message.body) {
                    this.updated = Number(message.body);
                }
            });
        });
    }
    
    
    ngOnInit() {
        this.monitor.getNetworkStatus().subscribe(result => this.status = result);
        
    }
}
