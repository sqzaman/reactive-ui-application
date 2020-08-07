import { Component, OnInit, OnDestroy, HostListener } from '@angular/core';
import { VehicleSpeed } from './model/vehicle-speed';
import { Observable } from 'rxjs';
import { VehicleSpeedMonitoringService } from './service/vehicle-speed-monitoring-service';
import { TextMessageEvent } from './model/text-message-event';
import { TextMessageEventService } from './service/text-message-event-service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit, OnDestroy {

  speedInfo$: Observable<VehicleSpeed[]>;
  textMessage$: Observable<TextMessageEvent[]>;


  constructor(
    private vehicleSpeedMonitoringService: VehicleSpeedMonitoringService,
    private textMessageService: TextMessageEventService,
    ) { 

    }
  
  ngOnInit() {
    this.vehicleSpeedMonitoringService.startSpeedInfoEventSource();
    console.log(this.vehicleSpeedMonitoringService.speedData);
    this.speedInfo$ = this.vehicleSpeedMonitoringService.speedData;

    this.textMessageService.startTextMessageEventSource();
    console.log(this.textMessageService.textEventData);
    this.textMessage$ = this.textMessageService.textEventData;
    
  }

  getClass(speed){
    let cssClass;
    if (speed >= 45 && speed <= 70) {
      cssClass = 'alert alert-success';
    } else if(speed >= 71 && speed <= 90) {
      cssClass = 'alert alert-warning';
    } else if(speed > 90) {
      cssClass = 'alert alert-danger';
    } else {
      cssClass = 'alert alert-primary';
    }

   return cssClass;
 
 }

 getClassForIcon(speed){
  let cssClass;
  if (speed >= 45 && speed <= 70) {
    cssClass = 'bar-status green';
  } else if(speed >= 71 && speed <= 90) {
    cssClass = 'bar-status yellow';
  } else if(speed > 90) {
    cssClass = 'bar-status red';
  } else {
    cssClass = 'bar-status sky';
  }

 return cssClass;

}
  ngOnDestroy() {
    this.vehicleSpeedMonitoringService.onClose();
  }

  @HostListener('window:beforeunload', [ '$event' ])
  unloadHandler(event) {
    console.log('unloadHandler');
    this.vehicleSpeedMonitoringService.onClose();
  }
  
}
