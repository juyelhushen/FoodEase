import { Component, Input, input } from '@angular/core';
import { MaterialModule } from '../../../shared/material-module';

@Component({
  selector: 'app-address-card',
  standalone: true,
  imports: [MaterialModule],
  templateUrl: './address-card.component.html',
  styleUrl: './address-card.component.scss',
})
export class AddressCardComponent {
  @Input()
  isNotAddress!: boolean;

  selectAddress = () => {
    console.log('Address');
    
  };
}
