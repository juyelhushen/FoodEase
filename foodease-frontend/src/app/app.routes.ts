import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RestaurantDetailsComponent } from './components/restaurant-details/restaurant-details.component';

export const routes: Routes = [
  {
    path: '',
    component: RestaurantDetailsComponent,
  },
  // {
  //   path: 'restaurant',
  //   loadChildren: () =>
  //     import('./components/restaurant-details/restaurant-details.module').then(
  //       (m) => m.RestaurantDetailsModule
  //     ),
  // },
];
