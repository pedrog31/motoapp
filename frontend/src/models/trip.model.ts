import { PointModel } from "./point.model";

export class TripModel {
    
    
    _id: string;
    name: string;
    description: string;
    urlPicture: string;
    start: PointModel;
    end: PointModel;
    distance: number;
    score: number;
    uids: string[];
    level: number;
    tripPublic: boolean;
    
    constructor(){
      this.name = "";
      this.description = "";
      this.urlPicture = "";
      this.start = new PointModel;
      this.end = new PointModel;
      this.distance = null;
      this.score = 0;
      this.uids = [];
      this.level= 0;
      this.tripPublic = true;
    }
  }