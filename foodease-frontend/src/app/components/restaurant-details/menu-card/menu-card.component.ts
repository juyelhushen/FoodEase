import { Component } from '@angular/core';
import { MaterialModule } from '../../../shared/material-module';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import {
  MAT_CHECKBOX_DEFAULT_OPTIONS,
  MatCheckboxDefaultOptions,
} from '@angular/material/checkbox';

@Component({
  selector: 'app-menu-card',
  standalone: true,
  providers: [
    { provide: MAT_CHECKBOX_DEFAULT_OPTIONS, useValue: { color: 'primary' } },
  ],
  imports: [MaterialModule, ReactiveFormsModule],
  templateUrl: './menu-card.component.html',
  styleUrl: './menu-card.component.scss',
})
export class MenuCardComponent {
  
  Category = [
    {
      category: 'Nuts & seeds',
      ingredients: ['Cashews'],
    },
    {
      category: 'Protein',
      ingredients: ['Bacon and Strips', 'Bacon strips'],
    },
  ];
  ingredients!: string | number | null;

  constructor(private fb: FormBuilder) { }

  step = 1;

  setStep(index: number) {
    this.step = index;
  }

  handleCheckboxOnChange = (value:any) => {
    alert(value);      
  }
}
