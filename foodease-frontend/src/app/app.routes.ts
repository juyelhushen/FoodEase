import { Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { RestaurantDetailsComponent } from './components/restaurant-details/restaurant-details.component';
import { CartComponent } from './components/cart/cart.component';
import { DashboardComponent } from './components/dashboard/dashboard.component';
import path from 'path';
import { OrdersComponent } from './components/dashboard/orders/orders.component';
import { FavoritesComponent } from './components/dashboard/favorites/favorites.component';
import { PaymentsComponent } from './components/dashboard/payments/payments.component';
import { AddressComponent } from './components/dashboard/address/address.component';
import { EventsComponent } from './components/dashboard/events/events.component';

export const routes: Routes = [
  {
    path: '',
    component: DashboardComponent,
    children: [
      {
        path: 'orders',
        component: OrdersComponent,
      },
      {
        path: 'favorites',
        component: FavoritesComponent,
      },
      {
        path: 'payments',
        component: PaymentsComponent,
      },
      {
        path: 'address',
        component: AddressComponent,
      },
      {
        path: 'events',
        component: EventsComponent,
      },
    ],
  },
  // {
  //   path: 'dashboard',
  //   loadChildren: () =>
  //     import('./components/dashboard/dashboard-routing.module').then(
  //       (m) => m.DashboardRoutingModule
  // },
];
