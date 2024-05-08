import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import path from 'path';
import { RestaurantDetailsComponent } from './restaurant-details.component';

const routes: Routes = [
  {
    path: '',
    component: RestaurantDetailsComponent,
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class RestaurantDetailsRoutingModule {}
