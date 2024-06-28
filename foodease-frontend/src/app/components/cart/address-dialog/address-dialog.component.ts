import { Component, EventEmitter, Inject, Output } from '@angular/core';
import { MaterialModule } from '../../../shared/material-module';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  ReactiveFormsModule,
  Validators,
} from '@angular/forms';
import { Address } from '../../../shared/models/address';

export interface DialogData {
  animal: 'panda' | 'unicorn' | 'lion';
}

@Component({
  selector: 'app-address-dialog',
  standalone: true,
  imports: [MaterialModule, ReactiveFormsModule, FormsModule],
  templateUrl: './address-dialog.component.html',
  styleUrl: './address-dialog.component.scss',
})
export class AddressDialogComponent {
  @Output() onAddAddress: EventEmitter<any> = new EventEmitter();
  @Output() onEdditAddress: EventEmitter<any> = new EventEmitter();

  addressForm!: FormGroup;
  dialogAction: string = 'Add';

  constructor(
    public dialogRef: MatDialogRef<AddressDialogComponent>,
    @Inject(MAT_DIALOG_DATA) public data: DialogData,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.validateForm();
  }

  validateForm(): void {
    this.addressForm = this.fb.group({
      streetAddress: [null, Validators.required],
      city: [null, Validators.required],
      state: [null, Validators.required],
      pin: [null, [Validators.required, Validators.pattern('^[0-9]{6}$')]],
    });
  }

  submitForm(): void {
    if (this.addressForm.valid) {
      console.log('Form Submitted');
    }
  }

  addAddress(): void {
    const formData = this.addressForm.value;
    console.log(formData.city);
    this.dialogRef.close();
    this.onAddAddress.emit();
  }
  
}
