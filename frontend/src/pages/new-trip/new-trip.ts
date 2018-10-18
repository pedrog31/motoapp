import { Component, NgZone, Directive, ElementRef, ViewChild, Input} from '@angular/core';
import { IonicPage, NavController, NavParams, ModalController } from 'ionic-angular';
import { ApiRestProvider } from '../../providers/api-rest/api-rest';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import { TripModel } from '../../models/trip.model';
import {FormControl} from "@angular/forms";
import {MapsAPILoader} from '@agm/core';
import { PointModel } from '../../models/point.model';
import { RoutesPage } from '../routes/routes';


/**
 * Generated class for the NewTripPage page.
 *
 * See https://ionicframework.com/docs/components/#navigation for more info on
 * Ionic pages and navigation.
 */

@IonicPage()
@Component({
  selector: 'page-new-trip',
  templateUrl: 'new-trip.html',
})
export class NewTripPage {
  formTrip: FormGroup;
  trip: TripModel;
  public map;
  GoogleAutocomplete;
  autocomplete;
  private steps: PointModel[];
  step: Array<PointModel> = [];
  prieba: PointModel;
  count: number;
  private autocompleteItems: String[][];
  markers: any;
  geocoder: any;
  actualSearchlist: String;

  verif: boolean;




  constructor(public navCtrl: NavController, public navParams: NavParams, public apiRestProvider: ApiRestProvider, private fb: FormBuilder, public zone: NgZone, private ModalCtrl:ModalController,  private mapsApiLoader: MapsAPILoader  ) {
    this.createForm();
    this.trip= new TripModel;
    this.map = document.getElementById('map');
    this.GoogleAutocomplete = new google.maps.places.AutocompleteService();
    this.autocomplete = { input: '' };
    this.autocompleteItems=[];
    this.autocompleteItems=[];
    this.count=0;
    this.markers = [];
    this.geocoder= new google.maps.Geocoder;
    this.actualSearchlist='';
    this.verif=false;
    this.steps=[];

  }

  ionViewDidLoad() {

    this.map = new google.maps.Map(document.getElementById('map'), {
      center: { lat: -34.9011, lng: -56.1645 },
      zoom: 15
    });

  }

  updateSearchResults(point: string) {
    if (this.formTrip.get(point).value == '') {
      this.autocompleteItems[point]=[];
      return;
    }
    this.GoogleAutocomplete.getPlacePredictions({ input: this.formTrip.get(point).value },
    (predictions, status) => {
      this.autocompleteItems[point]=[];
      if(!this.verif){
        this.zone.run(() => {
          predictions.forEach((prediction) => {
            this.autocompleteItems[point].push(prediction);
          });
        });
      }else{
        this.verif=false;
      }
    });
  }

  

  addTrip(){
    console.log(this.trip);
    this.trip.name=this.formTrip.get('tripName').value;
    this.trip.description=this.formTrip.get('tripDescription').value;
    this.trip.level=this.formTrip.get('tripLevel').value;
    this.trip.start =this.steps[0];
    this.trip.end =this.steps[1];
    this.trip.tripPublic=true;
    console.log(this.trip);

    this.apiRestProvider.addTrip(this.trip).then((res: any) =>{
      this.navCtrl.push(RoutesPage);
    }, error =>{
      console.log(error);
    });
    
  }

  addIntermediatePoint(){
    this.step.push(new PointModel());
  }
  setIntermediatePoint(){
    
  }

  toLatLng(item: any){
    var point = new PointModel();
    this.geocoder.geocode({'placeId': item.place_id}, function(results, status) {
      if (status === 'OK') {
        if (results[0]) {   
            point.latitude=results[0].geometry.location.lat();
            point.longitude=results[0].geometry.location.lng();
            point.name=item.description;
        }}});
        return point;
  }

  createForm(){
    this.formTrip = this.fb.group({
      tripName: [undefined, Validators.required],
      tripDescription: [undefined, Validators.required],
      tripLevel: [undefined, Validators.required],
      startPoint: [undefined, Validators.required],
      finalPoint: [undefined, Validators.required],
      inter: [undefined, Validators.required]
    })
  }

  selectSearchResult(item, point: string){
    switch (point) {
      case 'startPoint':
        this.formTrip.patchValue({startPoint: item.description});
        this.steps[0]=this.toLatLng(item);
        break;

      case 'finalPoint':
        this.formTrip.patchValue({finalPoint: item.description});
        this.steps[1]=this.toLatLng(item);
        break;
    
      default:
        break;
    }
    this.formTrip.patchValue({point: item.description});
    this.autocompleteItems[point] = [];
    this.verif=true;
    this.geocoder.geocode({'placeId': item.place_id}, (results, status) => {
      if(status === 'OK' && results[0]){
        let position = {
            lat: results[0].geometry.location.lat,
            lng: results[0].geometry.location.lng
        };
        let marker = new google.maps.Marker({
          position: results[0].geometry.location,
          map: this.map,
        });
        this.markers.push(marker);
        this.map.setCenter(results[0].geometry.location);
      }
    })

  }

  clearMarkers(){
    for (var i = 0; i < this.markers.length; i++) {
      console.log(this.markers[i])
      this.markers[i].setMap(null);
    }
    this.markers = [];
  }

}

