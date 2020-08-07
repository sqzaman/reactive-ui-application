import { Vehicle } from './vehicle';

export interface VehicleSpeed {
    vehicle: Vehicle;
    speed: number;
    time: string;
    overSpeed: boolean;
}