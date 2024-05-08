import { Component } from '@angular/core';
import { MaterialModule } from '../../shared/material-module';
import { FormsModule } from '@angular/forms';
import { MAT_RADIO_DEFAULT_OPTIONS } from '@angular/material/radio';
import { MenuCardComponent } from './menu-card/menu-card.component';

@Component({
    selector: 'app-restaurant-details',
    standalone: true,
    providers: [
        {
            provide: MAT_RADIO_DEFAULT_OPTIONS,
            useValue: { color: 'primary' },
        },
    ],
    templateUrl: './restaurant-details.component.html',
    styleUrl: './restaurant-details.component.scss',
    imports: [MaterialModule, FormsModule,MenuCardComponent]
})
export class RestaurantDetailsComponent {

  menucard = [1,1,1];

  favoriteSeason!: string;
  isActive: boolean = true;
  categoryType = [
    { lebel: 'All', value: 'all' },
    { lebel: 'Vegeterian_only', value: 'vegeterian' },
    { lebel: 'NonVegeterian_only', value: 'nonvegterian' },
    { lebel: 'Seasonal', value: 'seasonal' },
  ];

  filterOnChange = () => {
    this.isActive = !this.isActive;
  };

  categories: string[] = [
    'pizza',
    'burger',
    'biriyani',
    'chicken',
    'burger',
    'rice',
  ];
}
