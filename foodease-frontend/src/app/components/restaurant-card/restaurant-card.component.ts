import { Component, Input } from '@angular/core';
import { MaterialModule } from '../../shared/material-module';
import {
  CdkDragDrop,
  moveItemInArray,
  CdkDrag,
  CdkDropList,
} from '@angular/cdk/drag-drop';
import { MatIcon } from '@angular/material/icon';

@Component({
  selector: 'app-restaurant-card',
  standalone: true,
  imports: [MaterialModule, CdkDrag, MatIcon],
  templateUrl: './restaurant-card.component.html',
  styleUrl: './restaurant-card.component.scss',
})
export class RestaurantCardComponent {
  @Input()
  status!: string;

  @Input()
  name!: string;

  @Input()
  image!: string;
}
