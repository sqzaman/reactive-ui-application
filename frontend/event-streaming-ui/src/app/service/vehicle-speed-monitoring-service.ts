import { Injectable, NgZone } from '@angular/core';
import { Observable, BehaviorSubject } from 'rxjs';
import { environment } from 'src/environments/environment';
import { VehicleSpeed } from '../model/vehicle-speed';

@Injectable({
  providedIn: 'root',
})
export class VehicleSpeedMonitoringService {

    private backendUrl: string;
    private eventSource: EventSource;
    private dataSource: BehaviorSubject<Array<VehicleSpeed>> = new BehaviorSubject([]);

    speedData = this.dataSource.asObservable();  

    constructor(private zone: NgZone) {
      this.backendUrl = environment.backendUrl;
    } 

    public startSpeedInfoEventSource(): void {
        let url = [this.backendUrl, "monitor/speed"].join("/");
  
        this.eventSource = new EventSource(url);
        this.eventSource.onmessage = (event) => {  
          console.log('got event data', event['data']);
          const newArrays = [JSON.parse(event['data']), ...this.dataSource.value];
          this.zone.run(() => {
            this.dataSource.next(newArrays);
          })
  
        }
  
        this.eventSource.onerror = (error) => {
  
          this.zone.run( () => {
            if(this.eventSource.readyState === 0) {
              this.eventSource.close();
              this.dataSource.complete();
            } else {
              this.dataSource.error('EventSource error: ' + error);
            }
          });
        }
    }

    public onClose() {
        this.eventSource.close();
        this.dataSource.complete();
  
      }

}