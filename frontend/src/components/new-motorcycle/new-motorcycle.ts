import { Component } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {MotorcycleModel} from "../../models/motorcycle.model";
import {NavController} from "ionic-angular";
import {UserMotorcycleModel} from "../../models/usermotorcycle.model";
import {ApiRestProvider} from "../../providers/api-rest/api-rest";

@Component({
  selector: 'new-motorcycle',
  templateUrl: 'new-motorcycle.html'
})
export class NewMotorcycleComponent {

  formMoto: FormGroup;
  moto: UserMotorcycleModel;
  private autocompleteMotos: MotorcycleModel[];

  constructor(private fb: FormBuilder, private navController: NavController, private apiRest: ApiRestProvider) {
    this.formMoto = this.fb.group({
      soat: [undefined],
      tm: [undefined],
      color: [undefined],
      km: [undefined],
      moto: [undefined],
      name: [undefined],
    });
  }

  addNewMotorcycle() {
    this.navController.pop();
  }

  updateSearchResults() {
    const query = this.formMoto.get('moto').value;
    if (query  == '') {
      this.autocompleteMotos = [];
      return;
    }
    this.apiRest.searchMotos(query).then(response => {

    }, error => {
      
    })
  }
}
