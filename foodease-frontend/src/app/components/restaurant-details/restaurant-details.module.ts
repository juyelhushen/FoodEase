import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { RestaurantDetailsRoutingModule } from './restaurant-details-routing.module';
import { RestaurantDetailsComponent } from './restaurant-details.component';
import { MAT_RADIO_DEFAULT_OPTIONS } from '@angular/material/radio';
import { ReactiveFormsModule } from '@angular/forms';


@NgModule({
  declarations: [
  ],
  imports: [
    CommonModule,
    RestaurantDetailsRoutingModule,
    ReactiveFormsModule

  ]
})
export class RestaurantDetailsModule {}
