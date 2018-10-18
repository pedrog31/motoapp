import {NgModule} from '@angular/core';
import {ProfileCardComponent} from './profile-card/profile-card';
import {IonicModule} from "ionic-angular";
import {CommonModule} from "@angular/common";
import {NewMotorcycleComponent} from './new-motorcycle/new-motorcycle';

@NgModule({
  declarations: [ProfileCardComponent,
    NewMotorcycleComponent],
  imports: [
    CommonModule,
    IonicModule
  ],
  exports: [ProfileCardComponent,
    NewMotorcycleComponent],
  entryComponents: [
    NewMotorcycleComponent
  ]
})
export class ComponentsModule {
}
